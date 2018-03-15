package com.toxin.bot;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Test {
    public static void main(String[] args) throws IOException {
        System.out.println("TEST");

        loadImage();
    }

    public static void testHyiFunc() throws IOException  {
        BufferedReader reader = new BufferedReader(new FileReader("res/words.txt"));
        String str;

        while ((str = reader.readLine()) != null) {
            System.out.println(Hyi.getHyiString(str));
        }

        reader.close();
    }

    public static void loadImage() throws IOException {
        int count = 0;
        String str;

        BufferedReader reader = new BufferedReader(new FileReader("res/links.txt"));

        while (reader.readLine() != null) {
            count++;
        }

        System.out.println("COUNT = " + count);

        try(InputStream in = new URL("https://pp.userapi.com/c834101/v834101880/cd8e1/zstWThP-1DE.jpg").openStream()){
            Files.copy(in, Paths.get("res/photo.jpg"));
        }
    }
}
