package com.toxin.bot;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            Config.load();
            ApiContextInitializer.init();
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
            telegramBotsApi.registerBot(new Bot());
        } catch(TelegramApiException e) {
            System.out.println("BOT ERROR");
        } catch (IOException e) {
            System.out.println("PROP ERROR");
        }
    }
}
