package com.toxin.bot.ability.features;


import com.toxin.bot.other.Util;

public class Prediction {

    public static final String KEY_WORD = "вероятность";

    public static String getForecast(String text) {
        StringBuilder forecast = new StringBuilder();

        String event = text.substring(text.indexOf(KEY_WORD) + KEY_WORD.length() + 1, text.length());
        int percent = Util.rand.nextInt(100) + 1;

        forecast.append("Вероятность ");
        if (event.contains("я")) event = event.replaceFirst("я", "ты");
        if (event.contains("мне")) event = event.replaceFirst("мне", "тебе");
        if (event.contains("мы")) event = event.replaceFirst("мы", "вы");
        if (!event.contains("что")) forecast.append("того что ");
        forecast.append(event).append(" = ").append(percent).append("%");

        return forecast.toString();
    }

}
