package com.toxin.bot.handler;

import com.toxin.bot.ability.features.AbstractFeature;
import com.toxin.bot.transfer.FeatureTransf;


public class FeatureHendler extends AbstractHandler<FeatureTransf> {

    public FeatureHendler() {
        super(FeatureTransf.class);
    }

    @Override
    public void handleTransf(FeatureTransf transf) {
        AbstractFeature ability = (AbstractFeature)transf.getAbility();//TODO Hmmm

        ability.processTransf(transf);

        super.transmitter.pushOut(transf);
    }

}
