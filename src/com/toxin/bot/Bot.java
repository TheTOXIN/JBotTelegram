package com.toxin.bot;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Chat;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.Arrays;
import java.util.Random;

public class Bot extends TelegramLongPollingBot {
    private static String[] pidors = {"Влад", "Игорь", "Паша", "Серега", "Костик", "Олег", "Артём", "мой создатель", "АНИМЕ"};
    private Random random = new Random();

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
        Chat chat = message.getChat();
        logger(chat.getUserName(), message.getText());

        if (message.hasText()) {
            String str = message.getText();
            if (str.equals("/help")) {
                sendText(message, "Ацтань, я занят!");
            } else if (str.equals("/action")) {
                sendText(message, "Команда отвалилась, приходите потом");
            } else if (str.matches("[Кк]то [а-яA-Я ]+\\?")) {
                String call = str.substring(4, str.indexOf("?"));
                sendText(message, "По моим данным " + " - " + pidors[random.nextInt(pidors.length)] + " " + call);
            } else if (str.trim().toLowerCase().startsWith("бот")) {
                sendText(message, "Сам ты - " + str.substring(3));
            } else {
                sendText(message, Hyi.getHyiString(str));
            }
        }

        if (message.getText() == null) {
            sendText(message, "Похоже на мамку Игоря ;)");
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
