package com.toxin.bot.contexter;


import com.toxin.bot.ability.AbstractAbility;
import com.toxin.bot.transfer.AbstractTransf;
import lombok.Getter;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.ArrayList;
import java.util.List;


public abstract class AbstractContexter<A extends AbstractAbility> {

    @Getter
    private int score;

    protected A ability;

    public AbstractContexter(A ability) {
        this.ability = ability;
    }

    public abstract void computeScore(Update update);
    public abstract AbstractTransf<A> generateTransf(Update update);

    protected void addScore() { this.score++; }
    protected void delScore() { if (this.score > 0) this.score--; }

    public void clearScore() { this.score = 0; }
    public boolean haveScore() { return this.score > 0; }

}
