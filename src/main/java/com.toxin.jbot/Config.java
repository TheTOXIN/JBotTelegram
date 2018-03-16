package com.toxin.jbot;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    public static String BOT_NAME;
    public static String BOT_TOKEN;

    public static void load() throws IOException {
        Properties propBot = new Properties();

        try (InputStream in = new FileInputStream("src/main/resources/bot.properties")) {
            propBot.load(in);
            BOT_NAME = propBot.getProperty("name");
            BOT_TOKEN = propBot.getProperty("token");
        }
    }
}
