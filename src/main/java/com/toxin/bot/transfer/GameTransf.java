package com.toxin.bot.transfer;

import com.toxin.bot.ability.games.AbstractGame;
import com.toxin.bot.requester.AbstractRequest;
import com.toxin.bot.requester.GameRequest;
import org.telegram.telegrambots.meta.api.objects.Update;


public class GameTransf <A extends AbstractGame> extends AbstractTransf<A> {

    public GameTransf(Update update) {
        super(update);
    }

    @Override
    public A getAbility() {
        return null;
    }

    @Override
    public AbstractRequest<GameTransf> getRequest() {
        return new GameRequest();
    }

}
