package com.toxin.bot.ability.games;

import com.toxin.bot.other.Util;
import com.toxin.bot.other.Consts;
import com.toxin.bot.other.Emoji;

import java.util.List;

public class GameBC extends AbstractGame {

    public static final String KEY_WORD = "bc";

    private boolean work;
    private int counter;
    private String numbers = "";
    private final int size = 4;

    public static final GameBC instance = new GameBC();

    private GameBC() {}

    public String processGame(String mes) {
        String ans;

        if (mes.contains(KEY_WORD)) {
            ans = startGame();
        } else if (mes.length() == 4 && Util.isNumber(mes)) {
            ans = checkGame(mes);
        } else if (mes.contains(Consts.STOP_GAME)) {
            ans = stopGame();
        } else {
            ans = "Я жду 4 значное число...";
        }

        return ans;
    }

    private String startGame() {
        this.work = true;
        this.counter = 0;

        updateNumbers();

        return "Будеи играть в сучек и рогатых\n" +
                "Я загадал 4 значное число\n" +
                Emoji.BULL + " - на своих местах\n" +
                Emoji.COW + " - НЕ на своих местах\n";
    }

    private String stopGame() {
        String res = "У тебя ушло попыток" + this.counter + "\nБывало и хуже...";

        this.work = false;
        this.counter = 0;
        this.numbers = "";

        return res;
    }

    private String checkGame(String mes) {
        String res = "";

        this.counter++;

        int bulls = 0;
        int cows = 0;

        for (int i = 0; i < this.size; i++) {
            if (mes.charAt(i) == this.numbers.charAt(i)) bulls++;
            for (int j = 0; j < this.size; j++)
                if (mes.charAt(i) == this.numbers.charAt(j) && i != j)
                    cows++;
        }

        res += Emoji.BULL + " = " + bulls + "\n";
        res += Emoji.COW + " = " + cows + "\n";

        if (bulls == this.size) {
            res += "ТЫ УГАДАЛ (число = " + numbers + ")";
            stopGame();
        }

        return res;
    }

    private void updateNumbers() {
        for (int i = 0; i < size; i++) {
            this.numbers += String.valueOf(Util.rand.nextInt(10));
        }
    }

    public boolean isWork() {
        return work;
    }

    @Override
    public List<String> getKeyWords() {
        return null;
    }

    @Override
    public String getId() {
        return null;
    }

}
