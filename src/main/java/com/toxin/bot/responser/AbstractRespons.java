package com.toxin.bot.responser;

import com.toxin.bot.transfer.AbstractTransf;


public abstract class AbstractRespons<T extends AbstractTransf> {

    public abstract void sendTransf(T transf);

}
