package com.toxin.bot.handler;

import com.toxin.bot.responser.AbstractRespons;
import com.toxin.bot.responser.SpeakerRespons;
import com.toxin.bot.transfer.SpeakerTransf;


public class SpeakerHendler extends AbstractHandler<SpeakerTransf> {

    @Override
    public void prepareTransf(SpeakerTransf transf) {

    }

    @Override
    public AbstractRespons<SpeakerTransf> getRespons() {
        return new SpeakerRespons();
    }

}
