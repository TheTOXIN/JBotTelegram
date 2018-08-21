package com.toxin.bot.performer;

import com.toxin.bot.handler.AbstractHandler;
import com.toxin.bot.handler.GameHendler;
import com.toxin.bot.transfer.GameTransf;

public class GamePerform extends AbstractPerform<GameTransf> {

    public GamePerform() {
        super(GameTransf.class);
    }

    @Override
    public AbstractHandler<GameTransf> getHandler() {
        return new GameHendler();
    }

}
