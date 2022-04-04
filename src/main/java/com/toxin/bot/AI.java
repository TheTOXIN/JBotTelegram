package com.toxin.bot;

public class AI {

    public static String getAnswer(String text) {
        String answer = "";
        text = refactor(text);

        if (text.isEmpty()) return answer;
        answer = "Я сосал меня ебали";

        return answer;
    }

    private static String refactor(String str) {
        return str.replaceFirst("бот", "").trim();
    }
}
