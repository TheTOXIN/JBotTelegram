package com.toxin.bot;

import java.io.*;

public class Test {
    public static void main(String[] args) throws IOException {
        System.out.println("TEST");

        BufferedReader reader = new BufferedReader(new FileReader("E:/DEVELOPER/JAVA/JBotTelegram/res/words.txt"));
        String str = "";
        while ((str = reader.readLine()) != null) {
            System.out.println(Hyi.getHyiString(str));
        }
    }
}
