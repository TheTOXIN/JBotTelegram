package com.toxin.bot.performer;

import com.toxin.bot.handler.AbstractHandler;
import com.toxin.bot.transfer.AbstractTransf;


public abstract class AbstractPerform<T extends AbstractTransf> { //use for process transf

    private Class<T> clazz;
    private AbstractHandler<T> handler;

    public AbstractPerform(Class<T> clazz) {
        this.clazz = clazz;
        this.handler = this.getHandler();
    }

    public void performTransf(T transf) {
        getHandler().handleTransf(transf);
    }

    public abstract AbstractHandler<T> getHandler();

}
