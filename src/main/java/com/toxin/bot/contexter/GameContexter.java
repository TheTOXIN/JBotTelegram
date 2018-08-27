package com.toxin.bot.contexter;

import com.toxin.bot.ability.games.AbstractGame;
import com.toxin.bot.transfer.AbstractTransf;
import com.toxin.bot.transfer.GameTransf;
import org.telegram.telegrambots.meta.api.objects.Update;

public class GameContexter<A extends AbstractGame> extends AbstractContexter<A> {

    public GameContexter(A ability) {
        super(ability);
    }

    @Override
    public void computeScore(Update update) {

    }

    @Override
    public AbstractTransf<A> generateTransf(Update update) {
        return new GameTransf<>(update, super.ability);
    }

}
