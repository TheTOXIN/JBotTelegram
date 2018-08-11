package com.toxin.bot.transfer;

import com.toxin.bot.ability.speakers.AbstractSpeaker;
import com.toxin.bot.requester.EventerRequest;
import org.telegram.telegrambots.meta.api.objects.Update;


public class SpeakerTransf <A extends AbstractSpeaker> extends AbstractTransf<A> {

    public SpeakerTransf(Update update) {
        super(update);
    }

    @Override
    public EventerRequest<EventerTransf> generateRequest() {
        return new EventerRequest<>();
    }

}
