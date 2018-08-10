package com.toxin.bot.transfer;

import com.toxin.bot.ability.games.AbstractGame;
import org.telegram.telegrambots.meta.api.objects.Update;


public class GameTransf <A extends AbstractGame> extends AbstractTransf<A> {

    public GameTransf(Update update) {
        super(update);
    }

}
