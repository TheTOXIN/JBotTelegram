package com.toxin.bot.basic;

import com.toxin.bot.other.Config;
import org.apache.log4j.Logger;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.ApiContext;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

import java.io.IOException;
import java.net.Authenticator;
import java.net.PasswordAuthentication;

public class Initializer {
    private final Logger log = Logger.getLogger(Initializer.class);

    private static final String CONFIG_NOT_FOUND = "CONFIG NOT FOUND";
    private static final String BOT_NOT_REGISTER = "BOT NOT REGISTER";

    public static Bot BOT;

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
            if (Config.PROXY_WORK) {
                authenticate();
                BOT = new Bot(getOptions());
            } else {
                BOT = new Bot();
            }
            botsApi.registerBot(BOT);
        } catch (TelegramApiRequestException e) {
            log.error(BOT_NOT_REGISTER);
        }
    }

    private DefaultBotOptions getOptions() {
        DefaultBotOptions options = ApiContext.getInstance(DefaultBotOptions.class);

        options.setProxyHost(Config.PROXY_HOST);
        options.setProxyPort(Integer.parseInt(Config.PROXY_PORT));
        options.setProxyType(DefaultBotOptions.ProxyType.SOCKS5);

        return options;
    }

    private void authenticate() {
        Authenticator.setDefault(new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(
                    Config.PROXY_LOGIN,
                    Config.PROXY_PASSWORD.toCharArray()
                );
            }
        });
    }

}
