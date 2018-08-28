package com.toxin.bot.ability;

import java.util.List;

public abstract class AbstractAbility {

    public abstract List<String> getKeyWords();

    public abstract String getId();

    //TODO вынести сюда контекстер?

}
