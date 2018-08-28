package com.toxin.bot.ability.eventers;


import java.util.List;

public class Remeber extends AbstractEventer {

    public static final Remeber instance = new Remeber();

    private Remeber() {}

    @Override
    public List<String> getKeyWords() {
        return null;
    }

    @Override
    public String getId() {
        return "";
    }

}
