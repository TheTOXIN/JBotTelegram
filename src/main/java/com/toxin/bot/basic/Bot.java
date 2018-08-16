package com.toxin.bot.basic;

import com.toxin.bot.other.Config;
import lombok.NoArgsConstructor;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.*;


@NoArgsConstructor
public class Bot extends TelegramLongPollingBot {

    private Collector collector = new Collector();

    public Bot(DefaultBotOptions options) {
        super(options);
    }

    @Override
    public void onUpdateReceived(Update update) {
        this.collector.processUpdate(update);
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
