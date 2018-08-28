package com.toxin.bot.contexter;


import com.toxin.bot.ability.features.AbstractFeature;
import com.toxin.bot.transfer.AbstractTransf;
import com.toxin.bot.transfer.FeatureTransf;
import org.telegram.telegrambots.meta.api.objects.PhotoSize;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;


public class FeatureContexter<A extends AbstractFeature> extends AbstractContexter<A> {

    public FeatureContexter(A ability) {
        super(ability);
    }

    @Override
    public void computeScore(Update update) {
        if (update.hasMessage()) {
            String text = update.getMessage().getText();

            List<PhotoSize> photo = update.getMessage().getPhoto();

            if (!photo.isEmpty()) super.addScore();

            ability.getKeyWords()
                .stream()
                .filter(text::contains)
                .forEach(word -> super.addScore());
        }
    }

    @Override
    public AbstractTransf<A> generateTransf(Update update) {
        return new FeatureTransf<>(update, super.ability);
    }

}
