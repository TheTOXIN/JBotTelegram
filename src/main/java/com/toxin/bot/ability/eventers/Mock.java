package com.toxin.bot.ability.eventers;


import java.util.List;

public class Mock extends AbstractEventer {

    private static Mock instance = new Mock();

    private Mock() {}

    @Override
    public List<String> getKeyWords() {
        return null;
    }

    @Override
    public String getId() {
        return "";
    }

}
