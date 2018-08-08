package com.toxin.bot;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardRemove;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class GameKN {

    public static final String KEY_WORD = "kn";

    private ReplyKeyboardMarkup keyboard = new ReplyKeyboardMarkup();

    private boolean work;
    private int counterUser;
    private int counterBot;
    private final String temp = "x:y=";
    private final int size = 3;
    private int[][] kn = new int[size][size];

    public String processGame(String mes) {
        String ans = "";

        if (mes.contains(KEY_WORD)) {
            ans = startGame();
        } else if (mes.contains(Consts.STOP_GAME)) {
            ans = stopGame();
        } else if (mes.contains(this.temp)) {
            ans = checkGame(mes);
        }

        return ans;
    }

    private String startGame() {
        this.work = true;
        this.counterUser = 0;
        this.counterBot = 0;

        updateKeyboard();
        matrixUpdate();

        return "Щас я тебя сделаю! Играй этим - " + Emoji.KRESTIK.toString()  + "\n" + matrixToString();
    }

    private String stopGame() {
        String res = "Было весело " + Emoji.ROCK.toString() + "\n" + "СЧЁТ=" + counterBot + ":" + counterUser;

        this.work = false;
        this.counterUser = 0;
        this.counterBot = 0;

        return res;
    }

    private String checkGame(String mes) {
        String res;

        int x = Integer.parseInt(mes.split("[:=]")[2]) - 1;
        int y = Integer.parseInt(mes.split("[:=]")[3]) - 1;

        matrixSet(x, y);
        res = matrixToString();

        if (matrixCheck(1)) {
            res += "\n ТЫ ПОБЕДИЛ";
            this.counterUser++;
            matrixUpdate();
        } else if (matrixCheck(2)) {
            res += "\n ТЫ ПРОИГРАЛ";
            this.counterBot++;
            matrixUpdate();
        }

        return res;
    }

    private ReplyKeyboard updateKeyboard() {
        if (!this.isWork()) return new ReplyKeyboardRemove();

        List<KeyboardRow> list = new ArrayList<>();

        for (int i = 1; i <= this.size; i++) {
            KeyboardRow row = new KeyboardRow();
            for (int j = 1; j <= this.size; j++) {
                row.add(this.temp + j + ":" + i);
            }
            list.add(row);
        }

        KeyboardRow stop = new KeyboardRow();
        stop.add(Consts.STOP_GAME);
        list.add(stop);

        this.keyboard.setKeyboard(list);

        return this.keyboard;
    }

    private boolean matrixCheck(int n) {
        for (int i = 0; i < this.size; i++) {
            if (kn[0][i] == n && kn[1][i] == n && kn[2][i] == n)
                return true;
        }

        for (int i = 0; i < this.size; i++) {
            if (kn[i][0] == n && kn[i][1] == n && kn[i][2] == n)
                return true;
        }

        if (kn[1][1] == n && kn[2][2] == n && kn[0][0] == n)
            return true;

        if (kn[0][2] == n && kn[1][1] == n && kn[2][0] == n)
            return true;

        return false;
    }

    private String matrixToString() {
        String matrix = "";

        matrix += "\n-----------------\n";
        for (int i = 0; i < this.size; i++) {
            matrix += "|";
            for (int j = 0; j < this.size; j++) {
                if (kn[i][j] == 0)
                    matrix += "     ";
                else if (kn[i][j] == 1) {
                    matrix += Emoji.KRESTIK.toString();
                } else if (kn[i][j] == 2) {
                    matrix += Emoji.NOLIK.toString();
                }

                matrix += "|";
            }
            matrix += "\n-----------------\n";
        }

        return matrix;
    }

    private void matrixUpdate() {
        for (int i = 0; i < this.size; i++)
            for (int j = 0; j < this.size; j++)
                kn[i][j] = 0;
    }

    private void matrixSet(int x, int y) {
        if (x <= this.size - 1 && x > -1 && y <= this.size - 1 && y > -1) {
            if (kn[y][x] == 0) kn[y][x] = 1;
            else return;
        } else return;

        int x_bot;
        int y_bot;

        int[] x_step = new int[this.size * this.size];
        int[] y_step = new int[this.size * this.size];

        int count = 0;
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                if (kn[i][j] == 0) {
                    x_step[count] = j;
                    y_step[count] = i;
                    count++;
                }
            }
        }

        x_bot = x_step[Util.rand.nextInt(count)];
        y_bot = y_step[Util.rand.nextInt(count)];

        kn[y_bot][x_bot] = 2;
    }

    public ReplyKeyboardMarkup getKeyboard() {
        return this.keyboard;
    }

    public boolean isWork() {
        return this.work;
    }

}
