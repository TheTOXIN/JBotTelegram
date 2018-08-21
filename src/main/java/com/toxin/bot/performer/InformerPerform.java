package com.toxin.bot.performer;

import com.toxin.bot.handler.AbstractHandler;
import com.toxin.bot.handler.InformerHendler;
import com.toxin.bot.transfer.InformerTransf;

public class InformerPerform extends AbstractPerform<InformerTransf> {

    public InformerPerform() {
        super(InformerTransf.class);
    }

    @Override
    public AbstractHandler<InformerTransf> getHandler() {
        return new InformerHendler();
    }

}
