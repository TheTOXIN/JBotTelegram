package com.toxin.bot;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    public static String BOT_NAME;
    public static String BOT_ID;

    public static void load() throws IOException {
        Properties propBot = new Properties();

        try (InputStream in = new FileInputStream("E:/DEVELOPER/JAVA/JBotTelegram/res/bot.properties")) {
            propBot.load(in);
            BOT_NAME = propBot.getProperty("name");
            BOT_ID = propBot.getProperty("id");
        }
    }
}
