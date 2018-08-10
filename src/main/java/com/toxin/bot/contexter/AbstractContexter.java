package com.toxin.bot.contexter;


import java.util.*;

public abstract class AbstractContexter {

    private Set<String> context = new HashSet<>();

    public AbstractContexter() {
        fillContext();
    }

    public abstract Set<String> getContext();

    private void fillContext() {
        this.context = getContext();
    }

}
