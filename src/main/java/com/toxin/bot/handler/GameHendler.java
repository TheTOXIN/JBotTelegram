package com.toxin.bot.handler;

import com.toxin.bot.responser.AbstractRespons;
import com.toxin.bot.responser.GameRespons;
import com.toxin.bot.transfer.GameTransf;


public class GameHendler extends AbstractHandler<GameTransf> {

    @Override
    public void prepareTransf(GameTransf transf) {

    }

    @Override
    public AbstractRespons<GameTransf> getRespons() {
        return new GameRespons();
    }

}
