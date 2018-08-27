package com.toxin.bot.contexter;

import com.toxin.bot.ability.eventers.AbstractEventer;
import com.toxin.bot.transfer.AbstractTransf;
import com.toxin.bot.transfer.EventerTransf;
import org.telegram.telegrambots.meta.api.objects.Update;

public class EventerContexter<A extends AbstractEventer> extends AbstractContexter<A> {

    public EventerContexter(A ability) {
        super(ability);
    }

    @Override
    public void computeScore(Update update) {

    }

    @Override
    public AbstractTransf<A> generateTransf(Update update) {
        return new EventerTransf<>(update, super.ability);
    }

}
