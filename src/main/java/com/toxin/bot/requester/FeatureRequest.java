package com.toxin.bot.requester;

import com.toxin.bot.handler.AbstractHandler;
import com.toxin.bot.handler.FeatureHendler;
import com.toxin.bot.transfer.FeatureTransf;

public class FeatureRequest extends AbstractRequest<FeatureTransf> {

    public FeatureRequest() {
        super(FeatureTransf.class);
    }

    @Override
    public void accpetTranf(FeatureTransf transf) {

    }

    @Override
    public AbstractHandler<FeatureTransf> getHandler() {
        return new FeatureHendler();
    }

}
