package com.toxin.bot.performer;

import com.toxin.bot.handler.AbstractHandler;
import com.toxin.bot.handler.EventerHendler;
import com.toxin.bot.transfer.EventerTransf;

public class EventerPerform extends AbstractPerform<EventerTransf> {

    public EventerPerform() {
        super(EventerTransf.class);
    }

    @Override
    public AbstractHandler<EventerTransf> getHandler() {
        return new EventerHendler();
    }

}
