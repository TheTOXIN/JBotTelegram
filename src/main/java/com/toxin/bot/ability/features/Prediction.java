package com.toxin.bot.ability.features;

import com.toxin.bot.basic.IDS;
import com.toxin.bot.other.Util;
import com.toxin.bot.transfer.FeatureTransf;

import java.util.Arrays;
import java.util.List;

public class Prediction extends AbstractFeature {

    public static final String KEY_WORD = "вероятность";

    public static final Prediction instance = new Prediction();

    private Prediction() {}

    @Override
    public void processTransf(FeatureTransf transf) {

    }

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

    @Override
    public List<String> getKeyWords() {
        return Arrays.asList(
            "вероятность"
        );
    }

    @Override
    public String getId() {
        return IDS.PRD;
    }

}
