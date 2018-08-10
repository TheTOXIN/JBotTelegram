package com.toxin.bot.ability.informers;

public abstract class AbstractInformer {

    private String id;

    public AbstractInformer() {
        this.id = initId();
    }

    protected abstract String initId();

}
