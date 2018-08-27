package com.toxin.bot.contexter;

import com.toxin.bot.ability.speakers.AbstractSpeaker;
import com.toxin.bot.other.Util;
import com.toxin.bot.transfer.AbstractTransf;
import com.toxin.bot.transfer.SpeakerTransf;
import org.telegram.telegrambots.meta.api.objects.Update;

public class SpeakerContexter<A extends AbstractSpeaker> extends AbstractContexter<A> {

    public SpeakerContexter(A ability) {
        super(ability);
    }

    @Override
    public void computeScore(Update update) {
        if (Util.rand.nextBoolean()) return;
        if (update.hasMessage()) {
            String text = update.getMessage().getText();
            ability.getKeyWords()
                .stream()
                .filter(text::contains)
                .forEach(word -> super.addScore());
        }
    }

    @Override
    public AbstractTransf<A> generateTransf(Update update) {
        return new SpeakerTransf<>(update, super.ability);
    }

}
