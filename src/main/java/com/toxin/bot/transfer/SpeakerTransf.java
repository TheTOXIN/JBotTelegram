package com.toxin.bot.transfer;

import com.toxin.bot.ability.speakers.AbstractSpeaker;
import org.telegram.telegrambots.meta.api.objects.Update;


public class SpeakerTransf <A extends AbstractSpeaker> extends AbstractTransf<A> {

    public SpeakerTransf(Update update) {
        super(update);
    }

    @Override
    public A getAbility() {
        return null;
    }

}
