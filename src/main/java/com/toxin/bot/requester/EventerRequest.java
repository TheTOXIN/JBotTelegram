package com.toxin.bot.requester;

import com.toxin.bot.handler.AbstractHandler;
import com.toxin.bot.handler.EventerHendler;
import com.toxin.bot.transfer.EventerTransf;

public class EventerRequest extends AbstractRequest<EventerTransf> {

    public EventerRequest() {
        super(EventerTransf.class);
    }

    @Override
    public void accpetTranf(EventerTransf transf) {

    }

    @Override
    public AbstractHandler<EventerTransf> getHandler() {
        return new EventerHendler();
    }

}
