package com.toxin.bot.contexter;


import com.toxin.bot.ability.informers.AbstractInformer;
import com.toxin.bot.transfer.InformerTransf;
import org.telegram.telegrambots.meta.api.objects.Update;


public class InformerContexter<A extends AbstractInformer> extends AbstractContexter<A> {

    @Override
    public boolean itsMe(Update update) {
        return true;
    }

    @Override
    public InformerTransf<A> generateTransf() {
        return new InformerTransf<>();
    }

}
