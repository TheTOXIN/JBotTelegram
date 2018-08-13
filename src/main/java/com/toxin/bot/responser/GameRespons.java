package com.toxin.bot.responser;

import com.toxin.bot.transfer.GameTransf;


public class GameRespons extends AbstractRespons<GameTransf> {

    public GameRespons() {
        super(GameTransf.class);
    }

    @Override
    public void sendTransf(GameTransf transf) {

    }

}
