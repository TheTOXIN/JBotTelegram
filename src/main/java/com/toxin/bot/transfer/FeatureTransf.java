package com.toxin.bot.transfer;

import com.toxin.bot.ability.features.AbstractFeature;
import lombok.Getter;
import lombok.Setter;
import org.telegram.telegrambots.meta.api.objects.File;
import org.telegram.telegrambots.meta.api.objects.Update;

public class FeatureTransf<A extends AbstractFeature> extends AbstractTransf<A> {

    @Getter
    @Setter
    private File answerPhoto;

    @Getter
    @Setter
    private String answerText;

    public FeatureTransf(Update update, A ability) {
        super(update, ability);
    }

}
