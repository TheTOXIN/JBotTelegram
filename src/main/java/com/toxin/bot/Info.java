package com.toxin.bot;

public class Info {

    private final static StringBuilder sb = new StringBuilder()
            .append("Хувствуйсте, я - БотХуиБот ")
            .append(Emoji.MOON)
            .append("\nВот чё я умею:")
            .append("\n= Подержить разговор")
            .append("\n= Обрабатывать фотки")
            .append("\n= Предсказывать вероятность событий")
            .append("\n= Скидывать отборные мемасы - /" + Memator.KEY_WORD)
            .append("\n= Загадывать числа - /" + GameMOL.KEY_WORD)
            .append("\n= Играть в 'Быки и коровы' - /" + GameBC.KEY_WORD)
            .append("\n= Сделать тебя в 'Крестики-Нолики' - /" + GameKN.KEY_WORD)
            .append("\n= Камень ножницы бумага - /" + GameKNB.KEY_WORD)
            .append("\nОстановить игру - /" + Consts.STOP_GAME)
            .append("\nМой папочка - " + Consts.CREATOR);

    public static String getInfo() {
        return sb.toString();
    }
}
