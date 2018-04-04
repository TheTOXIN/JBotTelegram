package com.toxin.jbot;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class Util {

    public static final Random rand = new Random();

    public final static String RES = "src/main/resources/img/";

    public static void downloadImage(String url, String name) {
        try {

            String path = RES + name;
            Files.deleteIfExists(Paths.get(path));
            try(InputStream in = new URL(url).openStream()) {
                Files.copy(in, Paths.get(path));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
