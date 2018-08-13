package com.toxin.bot.requester;

import com.toxin.bot.handler.AbstractHandler;
import com.toxin.bot.transfer.AbstractTransf;


public abstract class AbstractRequest<T extends AbstractTransf> {

    private Class<T> clazz;
    private AbstractHandler<T> handle;

    public AbstractRequest(Class<T> clazz) {
        this.clazz = clazz;
        this.handle = this.getHandler();
    }

    public abstract void accpetTranf(T transf);
    public abstract AbstractHandler<T> getHandler();

}
