package com.toxin.bot.transfer;

import com.toxin.bot.ability.games.AbstractGame;
import com.toxin.bot.requester.EventerRequest;
import org.telegram.telegrambots.meta.api.objects.Update;


public class GameTransf <A extends AbstractGame> extends AbstractTransf<A> {

    public GameTransf(Update update) {
        super(update);
    }

    @Override
    public EventerRequest<EventerTransf> generateRequest() {
        return new EventerRequest<>();
    }

}
