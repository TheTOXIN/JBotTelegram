package com.toxin.bot.performer;

import com.toxin.bot.handler.AbstractHandler;
import com.toxin.bot.handler.SpeakerHendler;
import com.toxin.bot.transfer.SpeakerTransf;

public class SpeakerPerform extends AbstractPerform<SpeakerTransf> {

    public SpeakerPerform() {
        super(SpeakerTransf.class);
    }

    @Override
    public AbstractHandler<SpeakerTransf> getHandler() {
        return new SpeakerHendler();
    }

}
