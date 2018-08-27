package com.toxin.bot.contexter;


import com.toxin.bot.ability.features.AbstractFeature;
import com.toxin.bot.transfer.AbstractTransf;
import com.toxin.bot.transfer.FeatureTransf;
import org.telegram.telegrambots.meta.api.objects.Update;


public class FeatureContexter<A extends AbstractFeature> extends AbstractContexter<A> {

    public FeatureContexter(A ability) {
        super(ability);
    }

    @Override
    public void computeScore(Update update) {

    }

    @Override
    public AbstractTransf<A> generateTransf(Update update) {
        return new FeatureTransf<>(update, super.ability);
    }

}
