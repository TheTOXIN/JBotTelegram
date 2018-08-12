package com.toxin.bot.transfer;

import com.toxin.bot.ability.eventers.AbstractEventer;
import org.telegram.telegrambots.meta.api.objects.Update;


public class EventerTransf<A extends AbstractEventer> extends AbstractTransf<A> {

    public EventerTransf(Update update) {
        super(update);
    }

    @Override
    public A getAbility() {
        return null;
    }

}
