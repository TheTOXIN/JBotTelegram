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

        BOT_NAME = "BotHyiBot";
        BOT_ID = "425333637:AAHvD5BCGZ-6-P_5ydKualKbhABWT9BLMFc";

//        try (InputStream in = new FileInputStream("E:/DEVELOPER/JAVA/JBotTelegram/res/bot.properties")) {
//            propBot.load(in);
//            BOT_NAME = propBot.getProperty("name");
//            BOT_ID = propBot.getProperty("id");
//        }
    }
}
