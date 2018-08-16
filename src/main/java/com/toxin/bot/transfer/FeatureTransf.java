package com.toxin.bot.transfer;

import com.toxin.bot.ability.features.AbstractFeature;
import org.telegram.telegrambots.meta.api.objects.Update;

public class FeatureTransf<A extends AbstractFeature> extends AbstractTransf<A> {

    public FeatureTransf(Update update, A ability) {
        super(update, ability);
    }

}
