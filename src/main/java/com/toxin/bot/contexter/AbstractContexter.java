package com.toxin.bot.contexter;


import com.toxin.bot.ability.AbstractAbility;
import com.toxin.bot.transfer.AbstractTransf;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.*;

public abstract class AbstractContexter<A extends AbstractAbility> {

    protected HashMap<A, List<String>> context = new HashMap<>();
    protected A ability;

    public AbstractContexter(A ability) {
        this.ability = ability;
    }

    public abstract boolean itsMe(Update update);
    public abstract AbstractTransf<A> generateTransf(Update update);

    public void pushContext(A ability, String text) {
        this.context.get(ability).add(text);
    }
    public List<String> pullContext(A ability) {
        return this.context.get(ability);
    }

}
