package com.toxin.bot;

import org.apache.log4j.Logger;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

public class Memator {

    private static final String SOURCE = "http://www.1001mem.ru";
    private static final String KEY_WORDS = "img.1001mem.ru/posts/";
    private static final String NAME = "mem.jpg";

    private static final Random RANDOM = new Random();

    private static final Logger log = Logger.getLogger(Memator.class);

    public static File getMem() {
        String path = SOURCE + "/new/" + RANDOM.nextInt(1000);
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

            link = parseToLink(links.get(RANDOM.nextInt(links.size())));
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

}
