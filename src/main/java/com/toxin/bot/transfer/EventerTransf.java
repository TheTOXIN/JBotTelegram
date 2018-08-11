package com.toxin.bot.transfer;

import com.toxin.bot.ability.eventers.AbstractEventer;
import com.toxin.bot.requester.AbstractRequest;
import com.toxin.bot.requester.EventerRequest;
import lombok.NoArgsConstructor;
import org.telegram.telegrambots.meta.api.objects.Update;


public class EventerTransf<A extends AbstractEventer> extends AbstractTransf<A> {

    public EventerTransf(Update update) {
        super(update);
    }

    @Override
    public EventerRequest<EventerTransf> generateRequest() {
        return new EventerRequest<>();
    }

}
