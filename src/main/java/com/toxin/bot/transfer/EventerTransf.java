package com.toxin.bot.transfer;

import com.toxin.bot.ability.eventers.AbstractEventer;
import com.toxin.bot.requester.AbstractRequest;
import com.toxin.bot.requester.EventerRequest;
import org.telegram.telegrambots.meta.api.objects.Update;


public class EventerTransf<A extends AbstractEventer> extends AbstractTransf<A> {

    public EventerTransf(Update update, A ability) {
        super(update, ability);
    }

    @Override
    public AbstractRequest<EventerTransf> getRequest() {
        return new EventerRequest();
    }

}
