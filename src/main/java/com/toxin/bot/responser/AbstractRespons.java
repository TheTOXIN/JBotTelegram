package com.toxin.bot.responser;

import com.toxin.bot.transfer.AbstractTransf;


public abstract class AbstractRespons<T extends AbstractTransf> {

    private Class<T> clazz;

    public AbstractRespons(Class<T> clazz) {
        this.clazz = clazz;
    }

    public abstract void sendTransf(T transf);

}
