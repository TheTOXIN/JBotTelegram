package com.toxin.bot.basic;

import com.toxin.bot.other.Config;
import org.apache.log4j.Logger;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.*;


public class Bot extends TelegramLongPollingBot {
    private static final Logger log = Logger.getLogger(Bot.class);

    public Bot() {

    }

    public Bot(DefaultBotOptions options) {
        super(options);
    }

    @Override
    public void onUpdateReceived(Update update) {

    }

    @Override
    public String getBotUsername() {
        return Config.BOT_NAME;
    }

    @Override
    public String getBotToken() {
        return Config.BOT_TOKEN;
    }

}
