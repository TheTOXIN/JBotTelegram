package com.toxin.jbot;

import org.apache.log4j.Logger;
import org.telegram.telegrambots.api.methods.GetFile;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.methods.send.SendPhoto;
import org.telegram.telegrambots.api.objects.Document;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.PhotoSize;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.io.File;
import java.util.List;


public class Bot extends TelegramLongPollingBot {
    private static final Logger log = Logger.getLogger(Bot.class);

    public final static Bot INSTANCE = new Bot();

    private KeyBoard keyBoard;
    private Settings set;

    private Bot() {
        this.keyBoard = new KeyBoard();
        this.set = new Settings();
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            process(update.getMessage());
        } else if (update.hasCallbackQuery()) {
            System.out.println(update.getCallbackQuery());
        }
    }

    private void process(Message message) {
        String chatID = message.getChatId().toString();

        String text = message.getText();
        if (text != null && !text.equals("") && !text.isEmpty()) {
            log.info("GETTER: ID=" + chatID + " TEXT=" + text);
            processText(chatID, text);
        }

        Document doc = message.getDocument();
        if (doc != null) {
            log.info("GETTER: ID=" + chatID + " DOC=" + doc.getFileName() + "id=" + doc.getFileId());
            processFile(chatID, doc.getFileId());
        }

        List<PhotoSize> photoList = message.getPhoto();
        if (photoList != null) {
            PhotoSize photo = photoList.get(0);
            log.info("GETTER: ID=" + chatID + " PHOTO=" + photo.getFilePath() + " id=" + photo.getFileId());
            processFile(chatID, photo.getFileId());
        }
    }

    private void processText(String chatID, String text) {
        text = text.toLowerCase();

        if (text.contains("off")) {
            set.removeChat(chatID);
            sendMessage(chatID, "Еще увидимся...");
            return;
        } else if (text.contains("on")) {
            set.addChat(chatID);
            sendMessage(chatID, "Я вернулся сучки!!!");
            return;
        }

        if (set.isChatMock(chatID)) return;

        if (text.contains("мем") || text.contains("mem")) {
            sendPhoto(chatID, Memator.getMem());
        } else if (text.startsWith("бот")) {
            sendMessage(chatID, AI.getAnswer(text));
        } else {
            String answer = Util.rand.nextInt(2) == 1 ? Hyi.getHyiString(text) : Bla.getBlaString(text);
            sendMessage(chatID, answer);
        }
    }

    private void processFile(String chatID, String fileId) {
        try {
            GetFile file = new GetFile().setFileId(fileId);
            String url = super.getFile(file).getFileUrl(getBotToken());
            Util.downloadImage(url, Render.NAME);
            File render = Render.render(new File(Util.RES + Render.NAME));
            sendPhoto(chatID, render);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void sendMessage(String chatID, String text) {
        SendMessage sendMessage = new SendMessage();

        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatID);
        sendMessage.setText(text);

        try {
            sendMessage(sendMessage);
        } catch (TelegramApiException e) {
            log.error(ErrorCode.MESSAGE_NOT_SEND);
        }
    }

    private void sendPhoto(String chatID, File file) {
        SendPhoto sendPhoto = new SendPhoto();

        sendPhoto.setChatId(chatID);
        sendPhoto.setNewPhoto(file);

        try {
            sendPhoto(sendPhoto);
        } catch (TelegramApiException e) {
            log.error(ErrorCode.PHOTO_NOT_SEND);
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
