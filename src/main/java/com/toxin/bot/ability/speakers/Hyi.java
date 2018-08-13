package com.toxin.bot.ability.speakers;

import java.util.List;
import java.util.stream.IntStream;

public class Hyi extends AbstractSpeaker {

    private static final String HU = "Ху";
    private static final String SYMBOLS = "йуеыаоэяиюё";

    private static Hyi instance = new Hyi();

    private Hyi() {}

    public static String getHyiString(String orig) {
        String word = convertToWord(orig);

        if (word.length() <= 2 || !isWord(word))
            return HU + word;

        if (isGlas(word.charAt(0))) {
            word = word.charAt(0) + word;
        } else {
            word = deleteFirst(word);
        }

        while (!isGlas(word.charAt(0))) {
            word = deleteFirst(word);
        }

        char tmp = word.charAt(0);
        word = deleteFirst(word);

        if (isGlas(word.charAt(0))) {
            word = deleteFirst(word);
        }

        String hyi = getHyi(tmp);
        word = hyi + word;

        return word;
    }

    private static boolean isWord(String word) {
        return IntStream.range(0, word.length()).anyMatch(i -> SYMBOLS.contains("" + word.charAt(i)));
    }

    private static String convertToWord(String str) {
        String[] words = str.split(" ");
        String word = words[words.length - 1];

        word = word.replaceAll("\\d", "");
        word = word.replaceAll("[A-Za-z]", "");
        word = word.toLowerCase();

        return word;
    }

    private static String deleteFirst(String str) {
        return str.substring(1, str.length());
    }

    private static boolean isGlas(char c) {
        for (int i = 0; i < SYMBOLS.length(); i++) {
            if (SYMBOLS.charAt(i) == c) {
                return true;
            }
        }

        return false;
    }

    private static String getHyi(char tmp) {
        String hu = HU;

        if (tmp == 'а' || tmp == 'я') {
            hu += 'я';
        } else if (tmp == 'у' || tmp == 'ю') {
            hu += 'ю';
        } else if (tmp == 'ё' || tmp == 'о') {
            hu += 'ё';
        } else if (tmp == 'ы' || tmp == 'и') {
            hu += 'и';
        } else if (tmp == 'е' || tmp == 'э') {
            hu += 'е';
        } else if (tmp == 'й') {
            hu += 'й';
        }

        return hu;
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
