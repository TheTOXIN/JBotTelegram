package com.toxin.bot.ability.games;


import com.toxin.bot.other.Util;

public class GameMOL {

    public static final String KEY_WORD = "mol";
    public static final String KEY_WORD_START = "загадай число";
    public static final String KEY_WORD_ANSWER = "число = ";

    private boolean start = false;
    private int secret = 0;
    private int attempt = 0;

    public String processGame(String text) {
        String answer = "";

        if (text.contains(KEY_WORD_START)) answer = startGame();
        if (text.contains(KEY_WORD_ANSWER)) answer = checkGame(Integer.parseInt(text.split("=")[1].trim()));

        return answer;
    }

    private String startGame() {
        if (start) return "Я уже загадал";

        start = true;
        secret = Util.rand.nextInt(100) + 1;

        return "Загадал =)";
    }

    private String checkGame(int number) {
        String res = "";

        attempt++;

        if (secret < number) res = "МЕНЬШЕ <";
        else if (secret > number) res = "БОЛЬШЕ >";
        else res = stopGame();

        return res;
    }

    private String stopGame() {
        String res = "УГАДАЛ!!! Моё число = " + secret + "\n (c " + attempt + " попытки...)";

        start = false;
        secret = 0;
        attempt = 0;

        return res;
    }

}
