package com.toxin.jbot;

public class Bla {

    public static String getBlaString(String str) {

        StringBuilder bla = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (isMagick(str)) {
                bla.append(convertToBla(str.charAt(i)));
            } else {
                bla.append(str.charAt(i));
            }
        }

        return bla.toString();
    }

    private static char convertToBla(char c) {
        char res;

        switch (c)
        {
            case 'й': res = 'и'; break;
            case 'ц': res = 'с'; break;
            case 'у': res = 'ю'; break;
            case 'к': res = 'г'; break;
            case 'е': res = 'э'; break;
            case 'н': res = 'м'; break;
            case 'г': res = 'к'; break;
            case 'ш': res = 'с'; break;
            case 'щ': res = 'щ'; break;
            case 'з': res = 'с'; break;
            case 'х': res = 'к'; break;
            case 'ъ': res = 'ь'; break;
            case 'ф': res = 'в'; break;
            case 'ы': res = 'ъ'; break;
            case 'в': res = 'ф'; break;
            case 'а': res = 'о'; break;
            case 'п': res = 'б'; break;
            case 'р': res = 'л'; break;
            case 'о': res = 'а'; break;
            case 'л': res = 'р'; break;
            case 'д': res = 'т'; break;
            case 'ж': res = 'з'; break;
            case 'э': res = 'е'; break;
            case 'я': res = 'а'; break;
            case 'ч': res = 'щ'; break;
            case 'с': res = 'ц'; break;
            case 'м': res = 'н'; break;
            case 'и': res = 'е'; break;
            case 'т': res = 'д'; break;
            case 'ь': res = 'ъ'; break;
            case 'б': res = 'п'; break;
            case 'ю': res = 'у'; break;
            default: res = ' ';
        }

        return res;
    }

    private static boolean isMagick(String str) {
        return Util.rand.nextInt(str.length()) > str.length() / 2;
    }
}
