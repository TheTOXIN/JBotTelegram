package com.toxin.bot.ability.features;

import com.toxin.bot.ability.AbstractAbility;
import com.toxin.bot.transfer.FeatureTransf;

public abstract class AbstractFeature extends AbstractAbility {

    public abstract void processTransf(FeatureTransf transf);

}
