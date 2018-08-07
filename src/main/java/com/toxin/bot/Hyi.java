package com.toxin.bot;

public class Hyi {

    private static final String HU = "Ху";

    public static String getHyiString(String orig) {
        String word = convertToWord(orig);

        if (word.length() <= 2)
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

    private static String convertToWord(String str) {
        String word = str.split(" ")[str.split(" ").length - 1];

        word = word.replaceAll("\\d", "");
        word = word.replaceAll("[^\\w]", "");
        word = word.toLowerCase();

        return word;
    }

    private static String deleteFirst(String str) {
        return str.substring(1, str.length());
    }

    private static boolean isGlas(char c) {
        String SYMBOLS = "йуеыаоэяиюё";
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

}
