package com.toxin.bot.other;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    public static String BOT_NAME;
    public static String BOT_TOKEN;
    public static String BOT_AI;
    public static boolean PROXY_WORK;
    public static String PROXY_HOST;
    public static String PROXY_PORT;
    public static String PROXY_LOGIN;
    public static String PROXY_PASSWORD;

    public static void load() throws IOException {
        Properties propBot = new Properties();

        try (InputStream in = new FileInputStream("src/main/resources/bot.properties")) {
            propBot.load(in);
            BOT_NAME = propBot.getProperty("bot.name");
            BOT_TOKEN = propBot.getProperty("bot.token");
            BOT_AI = propBot.getProperty("bot.ai");
            PROXY_WORK = Boolean.valueOf(propBot.getProperty("proxy.work"));
            if (PROXY_WORK) {
                PROXY_HOST = propBot.getProperty("proxy.host");
                PROXY_PORT = propBot.getProperty("proxy.port");
                PROXY_LOGIN = propBot.getProperty("proxy.login");
                PROXY_PASSWORD = propBot.getProperty("proxy.password");
            }
        }
    }
}
