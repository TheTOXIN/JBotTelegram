package com.toxin.jbot;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Util {

    public final static String RES = "src/main/resources/img/";

    public static void loadImage(String url, String name) {
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
