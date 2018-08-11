package com.toxin.bot.contexter;


import com.toxin.bot.ability.eventers.AbstractEventer;
import com.toxin.bot.transfer.AbstractTransf;
import org.telegram.telegrambots.meta.api.objects.Update;


public class EventerContexter<A extends AbstractEventer> extends AbstractContexter<A> {

    @Override
    public boolean itsMe(Update update) {
        return false;
    }

    @Override
    public AbstractTransf<A> generateTransf() {
        return null;
    }

}
