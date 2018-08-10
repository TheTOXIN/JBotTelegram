package com.toxin.bot.contexter;


import com.toxin.bot.ability.Ability;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.*;

public abstract class AbstractContexter<A extends Ability> {

    private HashMap<A, List<String>> context = new HashMap<>();

    public abstract void pushContext(A ability, String context);
    public abstract List<String> pullContext(A ability);

    public abstract boolean itsMe(Update update);
    public abstract List<String> getKeyWords();

}
