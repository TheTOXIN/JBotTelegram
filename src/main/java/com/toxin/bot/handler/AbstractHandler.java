package com.toxin.bot.handler;

import com.toxin.bot.responser.AbstractRespons;
import com.toxin.bot.transfer.AbstractTransf;


public abstract class AbstractHandler<T extends AbstractTransf> {

    private AbstractRespons<T> respons;

    public abstract void prepareTransf(T transf);
    public abstract AbstractRespons<T> getRespons();

}
