package com.toxin.jbot;

import org.apache.log4j.Logger;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;

import java.io.IOException;

public class Initializer {
    private final Logger log = Logger.getLogger(Initializer.class);

    private final static String CONFIG_NOT_FOUND = "CONFIG NOT FOUND";
    private final static String BOT_NOT_REGISTER = "BOT NOT REGISTER";

    public void init() {
        loadConfig();
        runBot();
    }

    private void loadConfig() {
        try {
            Config.load();
        } catch (IOException e) {
            log.error(CONFIG_NOT_FOUND);
        }
    }

    private void runBot() {
        ApiContextInitializer.init();
        TelegramBotsApi botsApi = new TelegramBotsApi();

        try {
            botsApi.registerBot(Bot.INSTANCE);
        } catch (TelegramApiRequestException e) {
            log.error(BOT_NOT_REGISTER);
        }
    }

}
