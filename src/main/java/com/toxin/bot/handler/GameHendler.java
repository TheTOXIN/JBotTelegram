package com.toxin.bot.handler;

import com.toxin.bot.transfer.GameTransf;


public class GameHendler extends AbstractHandler<GameTransf> {

    public GameHendler() {
        super(GameTransf.class);
    }

    @Override
    public void handleTransf(GameTransf transf) {

    }

}
