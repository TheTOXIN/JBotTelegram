package com.toxin.bot;

public enum Emoji {
    MOON('\uD83C', '\uDF1A'),
    ROCK('\uD83E', '\uDEA8'),
    SCISSORS('\u2702', '\uFE0F'),
    PAPER('\uD83D', '\uDCC4'),
    KRESTIK(null, '\u274C'),
    NOLIK('\uD83D', '\uDD35'),
    BULL('\uD83D', '\uDC02'),
    COW('\uD83D', '\uDC04'),
    NULL(' ', ' ');

    Character firstChar;
    Character secondChar;

    Emoji(Character firstChar, Character secondChar) {
        this.firstChar = firstChar;
        this.secondChar = secondChar;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (this.firstChar != null) {
            sb.append(this.firstChar);
        }
        if (this.secondChar != null) {
            sb.append(this.secondChar);
        }

        return sb.toString();
    }

    public static Emoji pasrse(String str) {
        if (str.length() > 2) return NULL;

        for (Emoji emoji : Emoji.values()) {
            if (emoji.firstChar.equals(str.charAt(0)) && emoji.secondChar.equals(str.charAt(1))) {
                return emoji;
            }
        }

        return NULL;
    }
}
