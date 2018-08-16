package com.toxin.bot.responser;

import com.toxin.bot.basic.Transmitter;
import com.toxin.bot.transfer.AbstractTransf;


public abstract class AbstractRespons<T extends AbstractTransf> {

    private Class<T> clazz;

    protected final Transmitter transmitter = Transmitter.INSTANCE;

    public AbstractRespons(Class<T> clazz) {
        this.clazz = clazz;
    }

    public abstract void sendTransf(T transf);

}
