package com.toxin.bot.contexter;

import com.toxin.bot.ability.informers.AbstractInformer;
import com.toxin.bot.transfer.InformerTransf;
import org.telegram.telegrambots.meta.api.objects.Update;

public class InformerContexter<A extends AbstractInformer> extends AbstractContexter<A> {

    public InformerContexter(A ability) {
        super(ability);
    }

    @Override
    public boolean itsMe(Update update) {
        return true;
    }

    @Override
    public InformerTransf<A> generateTransf(Update update) {
        return new InformerTransf<>(update, super.ability);
    }

}
