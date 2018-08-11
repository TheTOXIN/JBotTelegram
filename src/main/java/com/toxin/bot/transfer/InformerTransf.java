package com.toxin.bot.transfer;

import com.toxin.bot.ability.informers.AbstractInformer;
import com.toxin.bot.requester.EventerRequest;
import org.telegram.telegrambots.meta.api.objects.Update;


public class InformerTransf <A extends AbstractInformer> extends AbstractTransf<A> {

    public InformerTransf(Update update) {
        super(update);
    }

    @Override
    public EventerRequest<EventerTransf> generateRequest() {
        return new EventerRequest<>();
    }

}
