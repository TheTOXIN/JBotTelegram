package com.toxin.bot.handler;

import com.toxin.bot.responser.AbstractRespons;
import com.toxin.bot.responser.InformerRespons;
import com.toxin.bot.transfer.InformerTransf;


public class InformerHendler extends AbstractHandler<InformerTransf> {

    @Override
    public void prepareTransf(InformerTransf transf) {

    }

    @Override
    public AbstractRespons<InformerTransf> getRespons() {
        return new InformerRespons();
    }

}
