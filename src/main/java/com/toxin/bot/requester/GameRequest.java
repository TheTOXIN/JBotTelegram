package com.toxin.bot.requester;

import com.toxin.bot.handler.AbstractHandler;
import com.toxin.bot.handler.GameHendler;
import com.toxin.bot.transfer.GameTransf;

public class GameRequest extends AbstractRequest<GameTransf> {

    @Override
    public void accpetTranf(GameTransf transf) {

    }

    @Override
    public AbstractHandler<GameTransf> getHandler() {
        return new GameHendler();
    }

}
