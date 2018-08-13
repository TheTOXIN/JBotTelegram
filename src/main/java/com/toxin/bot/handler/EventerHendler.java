package com.toxin.bot.handler;

import com.toxin.bot.responser.AbstractRespons;
import com.toxin.bot.responser.EventerRespons;
import com.toxin.bot.transfer.EventerTransf;


public class EventerHendler extends AbstractHandler<EventerTransf> {

    public EventerHendler() {
        super(EventerTransf.class);
    }

    @Override
    public void prepareTransf(EventerTransf transf) {

    }

    @Override
    public AbstractRespons<EventerTransf> getRespons() {
        return new EventerRespons();
    }

}
