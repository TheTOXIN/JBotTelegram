package com.toxin.bot;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class Util {

    private static final Logger log = Logger.getLogger(Util.class);

    public static final Random rand = new Random();

    public static final  String RES = "src/main/resources/img/";

    public static void downloadImage(String url, String name) {
        try {

            String path = RES + name;
            Files.deleteIfExists(Paths.get(path));
            try(InputStream in = new URL(url).openStream()) {
                Files.copy(in, Paths.get(path));
            }

        } catch (IOException e) {
            log.error("LOAD - url: " + url + " name:" + name + " - error download");
        }
    }

    public static boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
