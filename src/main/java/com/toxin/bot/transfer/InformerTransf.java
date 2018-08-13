package com.toxin.bot.transfer;

import com.toxin.bot.ability.informers.AbstractInformer;
import com.toxin.bot.ability.informers.Info;
import com.toxin.bot.requester.AbstractRequest;
import com.toxin.bot.requester.InformerRequest;
import org.telegram.telegrambots.meta.api.objects.Update;


public class InformerTransf <A extends AbstractInformer> extends AbstractTransf<A> {

    public InformerTransf(Update update, A ability) {
        super(update, ability);
    }

    @Override
    public AbstractRequest<InformerTransf> getRequest() {
        return new InformerRequest();
    }

}
