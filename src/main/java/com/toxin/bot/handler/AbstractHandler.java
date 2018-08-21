package com.toxin.bot.handler;

import com.toxin.bot.basic.Transmitter;
import com.toxin.bot.transfer.AbstractTransf;


public abstract class AbstractHandler<T extends AbstractTransf> {

    private Class<T> clazz;

    protected final Transmitter transmitter = Transmitter.INSTANCE;

    public AbstractHandler(Class<T> clazz) {
        this.clazz = clazz;
    }

    public abstract void handleTransf(T transf);

}
