package com.toxin.bot;

import org.apache.log4j.Logger;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.IOException;

public class Initializer {
    private final Logger log = Logger.getLogger(Initializer.class);

    private static final String CONFIG_NOT_FOUND = "CONFIG NOT FOUND";
    private static final String BOT_NOT_REGISTER = "BOT NOT REGISTER";

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
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            Bot bot = new Bot(getOptions());

            botsApi.registerBot(bot);
        } catch (TelegramApiException e) {
            log.error(BOT_NOT_REGISTER);
        }
    }

    private DefaultBotOptions getOptions() {
        DefaultBotOptions options = new DefaultBotOptions();

        if (Config.PROXY_WORK) {
            options.setProxyHost(Config.PROXY_HOST);
            options.setProxyPort(Integer.parseInt(Config.PROXY_PORT));
            options.setProxyType(DefaultBotOptions.ProxyType.SOCKS5);
        }

        return options;
    }
}
