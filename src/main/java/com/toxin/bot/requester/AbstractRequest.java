package com.toxin.bot.requester;

import com.toxin.bot.handler.AbstractHandler;
import com.toxin.bot.transfer.AbstractTransf;


public abstract class AbstractRequest<T extends AbstractTransf> {

    private AbstractHandler<T> handler;

    public abstract void accpetTranf(T transf);
    public abstract AbstractHandler<T> getHandler();

}
