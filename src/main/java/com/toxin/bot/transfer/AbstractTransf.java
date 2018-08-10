package com.toxin.bot.transfer;

import com.toxin.bot.ability.Ability;
import org.telegram.telegrambots.meta.api.objects.Update;


public abstract class AbstractTransf<A extends Ability> {

    private Update update;

    public AbstractTransf(Update update) {
        this.update = update;
    }

    public Update getUpdate() {
        return update;
    }

    public void setUpdate(Update update) {
        this.update = update;
    }

}
