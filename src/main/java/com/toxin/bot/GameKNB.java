package com.toxin.bot;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardRemove;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.Arrays;
import java.util.Random;

public class GameKNB {

    public static final String KEY_WORD = "knb";

    private Random rand = new Random();
    private ReplyKeyboardMarkup keyboard = new ReplyKeyboardMarkup();

    private boolean work;
    private int counterUser;
    private int counterBot;

    private KNB choose;

    public enum KNB {
        K(Emoji.ROCK), N(Emoji.SCISSORS), B(Emoji.PAPER);

        Emoji emoji;

        KNB(Emoji emoji) {
            this.emoji = emoji;
        }

        public static KNB find(Emoji emoji) {
            for (KNB knb : KNB.values())
                if (knb.emoji == emoji)
                    return knb;
            return null;
        }
    }

    public String processGame(String mes) {
        String ans = "";

        if (mes.contains(KEY_WORD)) {
            ans = startGame();
        } else if (mes.contains(Consts.STOP_GAME)) {
            ans = stopGame();
        } else if (KNB.find(Emoji.pasrse(mes)) != null) {
            ans = checkGame(KNB.find(Emoji.pasrse(mes)));
        }

        this.updateChoose();
        this.updateKeyboard();

        return ans;
    }

    private String startGame() {
        this.work = true;
        this.counterUser = 0;
        this.counterBot = 0;

        updateChoose();

        return "Обажаю - булыжники затычки туалетку";
    }

    private String stopGame() {
        this.work = false;
        this.counterUser = 0;
        this.counterBot = 0;
        this.choose = null;

        return "Ну и ладно, пойду играть с мусором";
    }

    private String checkGame(KNB player) {
        String res = "Я загадал: " + choose.emoji.toString() + "\n";

        boolean win;

        if (choose == KNB.K && player != KNB.K) {
            win = player == KNB.B;
        } else if (choose == KNB.N && player != KNB.N) {
            win = player == KNB.K;
        } else if (choose == KNB.B && player != KNB.B) {
            win = player == KNB.N;
        } else {
            return res + "НИЧЬЯ o_O";
        }

        if (win) {
            res += "Тебе повезло...";
            this.counterUser++;
        } else {
            res += "Я выиграл!";
            this.counterBot++;
        }

        return res;
    }

    private void updateChoose() {
        this.choose = KNB.values()[(rand.nextInt(KNB.values().length))];
    }

    private ReplyKeyboard updateKeyboard() {
        if (!this.isWork()) return new ReplyKeyboardRemove();

        KeyboardRow row1 = new KeyboardRow();
        KeyboardRow row2 = new KeyboardRow();
        KeyboardRow row3 = new KeyboardRow();

        row1.add("USER - " + counterUser + " : " + counterBot + " - BOT");

        row2.add(Emoji.ROCK.toString());
        row2.add(Emoji.SCISSORS.toString());
        row2.add(Emoji.PAPER.toString());

        row3.add("STOP GAME");

        this.keyboard.setKeyboard(Arrays.asList(row1, row2, row3));

        return this.keyboard;
    }

    public ReplyKeyboardMarkup getKeyboard() {
        return keyboard;
    }

    public boolean isWork() {
        return work;
    }
}
