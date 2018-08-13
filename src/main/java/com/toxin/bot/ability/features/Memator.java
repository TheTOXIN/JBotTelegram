package com.toxin.bot.ability.features;

import com.toxin.bot.other.Util;
import org.apache.log4j.Logger;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Memator extends AbstractFeature {

    public static final String KEY_WORD = "mem";

    private static final String SOURCE = "http://www.1001mem.ru";
    private static final String KEY_WORDS = "img.1001mem.ru/posts/";
    private static final String NAME = "mem.jpg";

    private static final Logger log = Logger.getLogger(Memator.class);

    private static Memator instance = new Memator();

    private Memator() {}

    public static File getMem() {
        String path = SOURCE + "/new/" + Util.rand.nextInt(1000);
        String link;
        String parse;

        try {
            URL url = new URL(path);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.connect();

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            ArrayList<String> links = new ArrayList<>();

            while (reader.ready()) {
                parse = reader.readLine();
                if (parse.contains(KEY_WORDS)) {
                    links.add(parse);
                }
            }

            link = parseToLink(links.get(Util.rand.nextInt(links.size())));
            Util.downloadImage(link, NAME);

            connection.disconnect();
            reader.close();
        } catch (IOException e) {
            log.error("URL - " + path + " : error http connection");
        }

        return new File(Util.RES + NAME);
    }

    private static String parseToLink(String str) {
        int from = str.indexOf('\"') + 1;
        int to = str.indexOf('\"', from);

        return str.substring(from, to);
    }

    @Override
    public List<String> getKeyWords() {
        return null;
    }

    @Override
    public String getId() {
        return null;
    }

}
