package com.toxin.bot.contexter;


import com.toxin.bot.ability.features.AbstractFeature;
import com.toxin.bot.transfer.AbstractTransf;
import org.telegram.telegrambots.meta.api.objects.Update;


public class FeatureContexter<A extends AbstractFeature> extends AbstractContexter<A> {

    @Override
    public boolean itsMe(Update update) {
        return false;
    }

    @Override
    public AbstractTransf<A> generateTransf() {
        return null;
    }

}
