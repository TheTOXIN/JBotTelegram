package com.toxin.bot;


public class Prediction {

    public static final String KEY_WORD = "вероятность";

    public static String getForecast(String text) {
        StringBuilder forecast = new StringBuilder();

        String event = text.substring(text.indexOf(KEY_WORD) + KEY_WORD.length() + 1, text.length());
        int percent = (int) (Math.random() * 100);

        forecast.append("Вероятность ");
        if (event.contains("я")) event = event.replaceFirst("я", "ты");
        if (!event.contains("что")) forecast.append("того что ");
        forecast.append(event).append(" = ").append(percent).append("%");

        return forecast.toString();
    }

}
