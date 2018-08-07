package com.toxin.bot;

import org.apache.log4j.Logger;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.GetFile;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.*;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

public class Bot extends TelegramLongPollingBot { //TODO MVC???
    private static final Logger log = Logger.getLogger(Bot.class);

    private Settings set;

    private MoLGame mol;
    private KNBGame knb;

    public Bot() {
        init();
    }

    public Bot(DefaultBotOptions options) {
        super(options);
        init();
    }

    private void init() {
        this.set = new Settings();
        this.mol = new MoLGame();
        this.knb = new KNBGame();
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            process(update.getMessage());
        } else if (update.hasCallbackQuery()) {
           log.info(update.getCallbackQuery());
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
        text = text.replaceAll("\\s+", " ");

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
        } else if (text.contains(Prediction.KEY_WORD)) {
            sendMessage(chatID, Prediction.getForecast(text));
        } else if (text.contains(MoLGame.KEY_WORD_START) || text.contains(MoLGame.KEY_WORD_ANSWER)) {
            sendMessage(chatID, this.mol.processGame(text));
        } else if (text.contains(KNBGame.KEY_WORD) || knb.isWork()) {
            sendKeyboard(chatID, knb.processGame(text), knb.getKeyboard());
        } else {
            String answer = Util.rand.nextInt(2) == 1 ? Hyi.getHyiString(text) : Bla.getBlaString(text);
            sendMessage(chatID, answer);
        }
    }

    private void processFile(String chatID, String fileId) {
        try {
            GetFile getFile = new GetFile().setFileId(fileId);
            File file = execute(getFile);
            Util.downloadImage(file.getFilePath(), Render.NAME);
            java.io.File render = Render.render(Util.RES + Render.NAME);
            sendPhoto(chatID, render);
        } catch (TelegramApiException e) {
            log.error(ErrorCode.PHOTO_NOT_LOAD);
        }
    }

    private void sendMessage(String chatID, String text) {
        SendMessage sendMessage = new SendMessage();

        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatID);
        sendMessage.setText(text);

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            log.error(ErrorCode.MESSAGE_NOT_SEND);
        }
    }

    private void sendPhoto(String chatID, java.io.File file) {
        SendPhoto sendPhoto = new SendPhoto();

        sendPhoto.setChatId(chatID);
        sendPhoto.setPhoto(file);

        try {
            execute(sendPhoto);
        } catch (TelegramApiException e) {
            log.error(ErrorCode.PHOTO_NOT_SEND);
        }
    }

    private void sendKeyboard(String chatID, String text, ReplyKeyboard keyboard) {
        SendMessage sendKeyboard = new SendMessage();

        sendKeyboard.setText(text);
        sendKeyboard.setChatId(chatID);
        sendKeyboard.setReplyMarkup(keyboard);

        try {
            execute(sendKeyboard);
        } catch (TelegramApiException e) {
            log.error(ErrorCode.MESSAGE_NOT_SEND);
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
