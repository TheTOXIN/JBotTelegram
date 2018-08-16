package com.toxin.bot.transfer;

import com.toxin.bot.ability.informers.AbstractInformer;
import lombok.Getter;
import lombok.Setter;
import org.telegram.telegrambots.meta.api.objects.Update;


public class InformerTransf <A extends AbstractInformer> extends AbstractTransf<A> {

    @Getter
    @Setter
    public String information;

    public InformerTransf(Update update, A ability) {
        super(update, ability);
    }

}
