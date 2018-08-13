package com.toxin.bot.requester;

import com.toxin.bot.handler.AbstractHandler;
import com.toxin.bot.handler.SpeakerHendler;
import com.toxin.bot.transfer.SpeakerTransf;

public class SpeakerRequest extends AbstractRequest<SpeakerTransf> {

    public SpeakerRequest() {
        super(SpeakerTransf.class);
    }

    @Override
    public void accpetTranf(SpeakerTransf transf) {

    }

    @Override
    public AbstractHandler<SpeakerTransf> getHandler() {
        return new SpeakerHendler();
    }

}
