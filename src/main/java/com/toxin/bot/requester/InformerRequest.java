package com.toxin.bot.requester;

import com.toxin.bot.handler.AbstractHandler;
import com.toxin.bot.handler.InformerHendler;
import com.toxin.bot.transfer.InformerTransf;

public class InformerRequest extends AbstractRequest<InformerTransf> {

    @Override
    public void accpetTranf(InformerTransf transf) {

    }

    @Override
    public AbstractHandler<InformerTransf> getHandler() {
        return new InformerHendler();
    }

}
