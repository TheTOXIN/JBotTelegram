package com.toxin.bot;

import org.apache.log4j.Logger;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;


public class Bot extends TelegramLongPollingBot {
    private static final Logger log = Logger.getLogger(Bot.class);

    private final static String MESSAGE_NOT_SEND = "MESSAGE NOT SEND";

    public final static Bot INSTANCE = new Bot();

    private KeyBoard keyBoard;

    private Bot() {
        this.keyBoard = new KeyBoard();
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            String text = update.getMessage().getText();
            String chatID = update.getMessage().getChatId().toString();

            log.info("GETTER: ID=" + chatID + " TEXT=" + text);
            send(chatID, text);

        } else if (update.hasCallbackQuery()) {
            System.out.println(update.getCallbackQuery());
        }
    }

    private void send(String chatID, String text) {
        SendMessage sendMessage = new SendMessage();

        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatID);
        sendMessage.setText(Hyi.getHyiString(text));

        try {
            sendMessage(sendMessage);
        } catch (TelegramApiException e) {
            log.error(MESSAGE_NOT_SEND);
        }
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
