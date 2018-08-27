package com.toxin.bot.transfer;

import com.toxin.bot.ability.speakers.AbstractSpeaker;
import lombok.Getter;
import lombok.Setter;
import org.telegram.telegrambots.meta.api.objects.Update;


public class SpeakerTransf <A extends AbstractSpeaker> extends AbstractTransf<A> {

    @Getter
    @Setter
    public String answer;

    public SpeakerTransf(Update update, A ability) {
        super(update, ability);
    }

}
