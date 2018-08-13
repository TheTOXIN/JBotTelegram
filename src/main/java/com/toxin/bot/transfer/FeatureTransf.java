package com.toxin.bot.transfer;

import com.toxin.bot.ability.features.AbstractFeature;
import com.toxin.bot.requester.AbstractRequest;
import com.toxin.bot.requester.EventerRequest;
import com.toxin.bot.requester.FeatureRequest;
import org.telegram.telegrambots.meta.api.objects.Update;

public class FeatureTransf<A extends AbstractFeature> extends AbstractTransf<A> {

    public FeatureTransf(Update update) {
        super(update);
    }

    @Override
    public A getAbility() {
        return null;
    }

    @Override
    public AbstractRequest<FeatureTransf> getRequest() {
        return new FeatureRequest();
    }

}
