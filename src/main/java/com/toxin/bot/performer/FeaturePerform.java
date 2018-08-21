package com.toxin.bot.performer;

import com.toxin.bot.handler.AbstractHandler;
import com.toxin.bot.handler.FeatureHendler;
import com.toxin.bot.transfer.FeatureTransf;

public class FeaturePerform extends AbstractPerform<FeatureTransf> {

    public FeaturePerform() {
        super(FeatureTransf.class);
    }

    @Override
    public AbstractHandler<FeatureTransf> getHandler() {
        return new FeatureHendler();
    }

}
