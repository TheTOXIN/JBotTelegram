package com.toxin.bot.contexter;


import com.toxin.bot.ability.features.AbstractFeature;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

public class FeatureContexter<A extends AbstractFeature> extends AbstractContexter<A> {

    @Override
    public void pushContext(A ability, String context) {

    }

    @Override
    public List<String> pullContext(A ability) {
        return null;
    }

    @Override
    public boolean itsMe(Update update) {
        return false;
    }

    @Override
    public List<String> getKeyWords() {
        return null;
    }

}
