package com.toxin.bot;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.methods.send.SendPhoto;
import org.telegram.telegrambots.api.objects.Chat;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.io.File;
import java.util.Arrays;
import java.util.Random;

public class Bot extends TelegramLongPollingBot {
    private static String[] pidors = {"Влад", "Игорь", "Паша", "Серега", "Костик", "Олег", "Артём", "мой создатель", "АНИМЕ"};
    private Random random = new Random();
    private int secret = 0;
    private int count = 0;
    private int zaeb = 0;

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

        zaeb++;
        if (zaeb == 20) {
            sendText(message, "Как вы меня долбоебы заебали...");
            zaeb = 0;
        }

        if (message.hasText()) {
            String str = message.getText();
            if (str.equals("/help")) {
                sendText(message, "Ацтань, я занят!");
            } else if (str.equals("/action")) {
                sendText(message, "Команда отвалилась, приходите потом");
            } else if (str.toLowerCase().trim().equals("покажи ")) {
                sendPhoto(message);
            } else if (str.matches("[Кк]то [а-яA-Я ]+\\?")) {
                String call = str.substring(4, str.indexOf("?"));
                sendText(message, "По моим данным " + " - " + pidors[random.nextInt(pidors.length)] + " " + call);
            } else if (str.trim().toLowerCase().startsWith("бот")) {
                sendText(message, "Сам ты - " + str.substring(3));
            } else if (str.trim().toLowerCase().startsWith("вероятность ")) {
                sendText(message, "Вероятность этого события = " + random.nextInt(100) + "%");
            } else if (str.toLowerCase().trim().equals("загадай число")) {
                if (secret == 0) {
                    secret = random.nextInt(100) + 1;
                    sendText(message, "Загадал =)");
                }
            } else if (str.toLowerCase().trim().startsWith("число = ")) {
                if (secret == 0) {
                    sendText(message, "Че ты от меня хочешь?");
                    return;
                }

                int number = Integer.parseInt(str.split("=")[1].trim());

                if (secret < number)
                    sendText(message, "МЕНЬШЕ <");
                else if (secret > number)
                    sendText(message, "БОЛЬШЕ >");
                else if (secret == number) {
                    sendText(message,"УГАДАЛ (c " + count + " попытки...");
                    sendText(message,"Твой приз - глолый (" + pidors[random.nextInt(pidors.length)] + ")");
                    count = 0;
                    secret = 0;
                }

                count++;

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

    public void sendPhoto(Message message) {
        File file = new File("res/photo.png");
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(message.getChatId().toString());
        sendPhoto.setNewPhoto(file);

        try {
            sendPhoto(sendPhoto);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void logger(String name, String text) {
        System.out.println(name + " := " + text);
    }
}
