package com.toxin.bot;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    public static String BOT_NAME;
    public static String BOT_TOKEN;
    public static String BOT_AI;
    public static String PROXY_HOST;
    public static String PROXY_PORT;

    public static void load() throws IOException {
        Properties propBot = new Properties();

        try (InputStream in = new FileInputStream("src/main/resources/bot.properties")) {
            propBot.load(in);
            BOT_NAME = propBot.getProperty("bot.name");
            BOT_TOKEN = propBot.getProperty("bot.token");
            BOT_AI = propBot.getProperty("bot.ai");
            PROXY_HOST = propBot.getProperty("proxy.host");
            PROXY_PORT = propBot.getProperty("proxy.port");
        }
    }
}
