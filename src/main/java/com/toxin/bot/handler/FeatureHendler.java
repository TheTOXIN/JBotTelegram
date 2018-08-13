package com.toxin.bot.handler;

import com.toxin.bot.responser.AbstractRespons;
import com.toxin.bot.responser.FeatureRespons;
import com.toxin.bot.transfer.FeatureTransf;


public class FeatureHendler extends AbstractHandler<FeatureTransf> {

    public FeatureHendler() {
        super(FeatureTransf.class);
    }

    @Override
    public void prepareTransf(FeatureTransf transf) {

    }

    @Override
    public AbstractRespons<FeatureTransf> getRespons() {
        return new FeatureRespons();
    }

}
