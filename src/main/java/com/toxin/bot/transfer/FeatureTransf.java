package com.toxin.bot.transfer;

import com.toxin.bot.ability.features.AbstractFeature;
import com.toxin.bot.requester.EventerRequest;
import org.telegram.telegrambots.meta.api.objects.Update;

public class FeatureTransf<A extends AbstractFeature> extends AbstractTransf<A> {

    public FeatureTransf(Update update) {
        super(update);
    }

    @Override
    public EventerRequest<EventerTransf> generateRequest() {
        return new EventerRequest<>();
    }

}
