package com.toxin.bot.executor;

import com.toxin.bot.transfer.AbstractTransf;

public abstract class AbstractExecutor<T extends AbstractTransf> {

    public abstract void executeTransf(T transf);

}
