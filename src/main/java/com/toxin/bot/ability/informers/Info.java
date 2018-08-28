package com.toxin.bot.ability.informers;

import com.toxin.bot.ability.features.Memator;
import com.toxin.bot.ability.games.GameBC;
import com.toxin.bot.ability.games.GameKN;
import com.toxin.bot.ability.games.GameKNB;
import com.toxin.bot.ability.games.GameMOL;
import com.toxin.bot.basic.IDS;
import com.toxin.bot.other.Consts;
import com.toxin.bot.other.Emoji;

import java.util.Arrays;
import java.util.List;

public class Info extends AbstractInformer {

    private static final StringBuilder information = new StringBuilder()
        .append("Хувствуйсте, я - БотХуиБот ")
        .append(Emoji.ROCK.toString())
        .append("\nВот чё я умею:")
        .append("\n= Подержить разговор")
        .append("\n= Обрабатывать фотки")
        .append("\n= Предсказывать вероятность событий")
        .append("\n= Скидывать отборные мемасы - /" + Memator.KEY_WORD)
        .append("\n= Загадывать числа - /" + GameMOL.KEY_WORD)
        .append("\n= Играть в 'Быки и коровы' - /" + GameBC.KEY_WORD)
        .append("\n= Сделать тебя в 'Крестики-Нолики' - /" + GameKN.KEY_WORD)
        .append("\n= Камень ножницы бумага - /" + GameKNB.KEY_WORD)
        .append("\n(Остановить игру - /" + Consts.STOP_GAME + ")")
        .append("\nМой папочка - " + Consts.CREATOR);

    public static final Info instance = new Info();

    private Info() {
    }

    @Override
    public String getInfo() {
        return information.toString();
    }

    @Override
    public List<String> getKeyWords() {
        return Arrays.asList(
            "help",
            "info"
        );
    }

    @Override
    public String getId() {
        return IDS.INF;
    }

}
