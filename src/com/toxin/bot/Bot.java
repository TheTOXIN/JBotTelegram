package com.toxin.bot;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {
    @Override
    public String getBotToken() {
        return Config.BOT_ID;
    }

    @Override
    public String getBotUsername() {
        return Config.BOT_NAME;
    }

    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        logger(message.getChat().getUserName(), message.getText());

        if (message.hasText()) {
            if (message.getText().equals("/help")) {
                sendText(message, "Ацтань, я занят!");
            } else {
                sendText(message, Hyi.getHyiString(message.getText()));
            }
        }

        if (message.hasPhoto()) {
            sendText(message, "Ну и зачем мне твои картиночки?");
        }
    }

    public void sendText(Message message, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setText(text);

        try {
            sendMessage(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void logger(String name, String text) {
        System.out.println(name + " := " + text);
    }
}
