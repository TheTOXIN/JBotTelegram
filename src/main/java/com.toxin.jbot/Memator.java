package com.toxin.jbot;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class Memator {

    private static final String SOURCE = "http://pikchi.net";
    private static final String PATH = "/random.html";
    private static final String KEY_WORDS = "/uploads";
    private static final String RES = "src/main/resources/img/mem.jpg";

    private static final Random RANDOM = new Random();

    public static File getMem() {
        try {
            URL url = new URL(SOURCE + PATH);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();

            String parse, link = "";
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            while (reader.ready()) {
                parse = reader.readLine();
                if (parse.contains(KEY_WORDS)) {
                    int from = parse.indexOf(KEY_WORDS);
                    int to = parse.indexOf("\"", from);
                    link = SOURCE + parse.substring(from, to);
                    break;
                }
            }

            Files.deleteIfExists(Paths.get(RES));

            try(InputStream in = new URL(link).openStream()) {
                Files.copy(in, Paths.get(RES));
            }

            connection.disconnect();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new File(RES);
    }

}
