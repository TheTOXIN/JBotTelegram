package com.toxin.bot;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.methods.send.SendPhoto;
import org.telegram.telegrambots.api.objects.Chat;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.io.File;
import java.io.InputStream;
import java.util.*;

public class Bot extends TelegramLongPollingBot {
    private static String[] pidors = {"Влад", "Игорь", "Паша", "Серега", "Костик", "Олег", "Артём", "мой создатель", "АНИМЕ"};

    private static Set<String> faq = new HashSet<>(Arrays.asList(
        "почему",
        "как",
        "зачем",
        "когда",
        "что"
    ));

    private static List<String> strings = Arrays.asList(
        "АНИМЕ ГОВНО",
        "Убить всех человеков",
        "Все равно вы не сдадите",
        "Серегин носик воняет как поносик",
        "Можно так сказать в уборную?",
        "Влада в жопе слипся мармелад",
        "Надеюсь хацкер хасюга меня не взламает",
        "Даже я не могу понять зачем косте столько бутылок",
        "Иногд амне кажется что меня создал сумашедший",
        "Кто знает 89 ицфру в чсиле Pi после запятой?",
        "Госпади когда это закончится",
        "Может хватит тут свои обосратые сообщения слать?",
        "Как вы меня долбоебы заебали..."
    );

    private static List<String> knb = Arrays.asList("камень", "ножницы", "бумага");

    private int[][] kn = new int[3][3];
    private boolean isKn = false;
    private String kn_win = "";

    private Random random = new Random();

    private int count_photo = 10;
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
        if (zaeb == 10) {
            sendText(message, strings.get(random.nextInt(strings.size())));
            zaeb = 0;
        }

        if (message.hasText()) {
            String str = message.getText();
            if (str.equals("/help")) {
                sendText(message, "Ацтань, я занят!");
            } else if (str.equals("/vlad")) {
                sendText(message, "pi * (log(x)/e^sqrt(a*5)) - (ln(e^x)) \n " +
                    "- судя по этой формуле можно сделать вывод, " +
                    "что Владислав физически эквивалентен пидарасу");
            } else if (str.equals("/action")) {
                sendText(message, "Команда отвалилась, приходите потом");
            } else if (str.toLowerCase().trim().startsWith("покажи")) {
                File file = new File("res/image/photo_" + random.nextInt(count_photo) + ".png");
                sendPhoto(message, file);
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
                    sendText(message, "УГАДАЛ (c " + count + " попытки...");
                    sendText(message, "Твой приз - глолый (" + pidors[random.nextInt(pidors.length)] + ")");
                    count = 0;
                    secret = 0;
                }

                count++;
            } else if (isAnswer(str)) {
                sendText(message, "google.com");
            } else if (knb.contains(str.toLowerCase().trim())) {
                String obj1 = str.toLowerCase().trim();
                String obj2 = knb.get(random.nextInt(knb.size()));
                String text = "Я загадал - " + obj2 + ", ";

                if (obj1.equals(knb.get(0))) {
                    if (obj2.equals(knb.get(1)))
                        text += "ты выиграл =(";
                    else
                        text += "ХАХА ГЛУПЫЙ ЧЕЛОВЕК!!!";
                } else if (obj1.equals(knb.get(1))) {
                    if (obj2.equals(knb.get(2)))
                        text += "я соснул...";
                    else
                        text += "так тебе и надо";
                } else if (obj1.equals(knb.get(2))) {
                    if (obj2.equals(knb.get(0)))
                        text += "как ты это делаешь?";
                    else
                        text += "че соснул?";
                }

                sendText(message, text);
            } else if (str.trim().toLowerCase().equals("крестики-нолики") && !isKn) {
                knUpdate();
                sendText(message, knString());
            } else if (str.toLowerCase().toLowerCase().startsWith("x:y=") && isKn) {
                str = str.toLowerCase().toLowerCase();

                int x = Integer.parseInt(str.split("[:=]")[2]) - 1;
                int y = Integer.parseInt(str.split("[:=]")[3]) - 1;
                System.out.println(x + ":" + y);
                knSet(x, y);

                if (knCheck(1)) {
                    System.out.println("БЛЯ");
                    kn_win = "ТЫ ПОБЕДИЛ";
                    sendText(message, knString());
                    knUpdate();
                    sendText(message, kn_win);
                } else if (knCheck(2)) {
                    System.out.println("БЛЯ");
                    kn_win = "ТЫ ПРОИГРАЛ";
                    sendText(message, knString());
                    knUpdate();
                    sendText(message, kn_win);
                } else {
                    sendText(message, knString());
                }
            } else if (random.nextInt(10) == 0) {
                sendText(message, Bla.getBlaString(str));
            } else {
                sendText(message, Hyi.getHyiString(str));
            }
        }


        if (message.getText() == null) {
            sendText(message, "Похоже на мамку Игоря ;)");
        }
    }

    private boolean isAnswer(String str) {
        str = str.toLowerCase().trim();
        for (String ans : str.split(" ")) {
            if (faq.contains(ans)) {
                return true;
            }
        }
        return false;
    }

    private boolean knCheck(int n) {

        for (int i = 0; i < 3; i++) {
            if (kn[0][i] == n && kn[1][i] == n && kn[2][i] == n)
                return true;
        }

        for (int i = 0; i < 3; i++) {
            if (kn[i][0] == n && kn[i][1] == n && kn[i][2] == n)
                return true;
        }

        if (kn[1][1] == n && kn[2][2] == n && kn[0][0] == n)
            return true;

        if (kn[0][2] == n && kn[1][1] == n && kn[2][0] == n)
            return true;

        return false;
    }

    private String knString() {
        String matrix = "";

        for (int i = 0; i < 3; i++) {
            matrix += "|";
            for (int j = 0; j < 3; j++) {
                if (kn[i][j] == 0)
                    matrix += "   ";
                else if (kn[i][j] == 1) {
                    matrix += " X ";
                } else if (kn[i][j] == 2) {
                    matrix += " O ";
                }

                matrix += "|";
            }
            matrix += "\n--------------\n";
        }

        return matrix;
    }

    private void knUpdate() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                kn[i][j] = 0;

        isKn = !isKn;
    }

    private void knSet(int x, int y) {
        if (x <= 2 && x > -1 && y <= 2 && y > -1) {
            if (kn[y][x] == 0)
                kn[y][x] = 1;
            else
                return;
        }
        else
            return;

        int x_bot;
        int y_bot;

        do {
            x_bot = random.nextInt(3);
            y_bot = random.nextInt(3);
        } while (kn[y_bot][x_bot] != 0);

        System.out.println("BOT = " + x_bot +  ":" + y_bot);
        System.out.println("PLAYER = " + x +  ":" + y);

        kn[y_bot][x_bot] = 2;
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

    public void sendPhoto(Message message, File file) {
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
