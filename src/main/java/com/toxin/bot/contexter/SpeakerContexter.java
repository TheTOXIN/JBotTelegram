package com.toxin.bot.contexter;

import com.toxin.bot.ability.speakers.AbstractSpeaker;
import com.toxin.bot.transfer.AbstractTransf;
import com.toxin.bot.transfer.SpeakerTransf;
import org.telegram.telegrambots.meta.api.objects.Update;

public class SpeakerContexter<A extends AbstractSpeaker> extends AbstractContexter<A> {

    public SpeakerContexter(A ability) {
        super(ability);
    }

    @Override
    public boolean itsMe(Update update) {
        return false;
    }

    @Override
    public AbstractTransf<A> generateTransf(Update update) {
        return new SpeakerTransf<>(update, super.ability);
    }

}
