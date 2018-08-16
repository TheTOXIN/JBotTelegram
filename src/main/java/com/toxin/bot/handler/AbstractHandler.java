package com.toxin.bot.handler;

import com.toxin.bot.responser.AbstractRespons;
import com.toxin.bot.transfer.AbstractTransf;


public abstract class AbstractHandler<T extends AbstractTransf> {

    private Class<T> clazz;
    private AbstractRespons<T> respons;

    public AbstractHandler(Class<T> clazz) {
        this.clazz = clazz;
        this.respons = this.getRespons();
    }

    public abstract void performTransf(T transf);
    public abstract AbstractRespons<T> getRespons();

}
