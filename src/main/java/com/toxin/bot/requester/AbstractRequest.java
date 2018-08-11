package com.toxin.bot.requester;

import com.toxin.bot.transfer.AbstractTransf;

public abstract class AbstractRequest<T extends AbstractTransf> {

    public abstract void accpetTranf(T transf);

}
