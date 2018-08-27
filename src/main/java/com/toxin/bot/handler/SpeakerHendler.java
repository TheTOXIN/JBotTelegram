package com.toxin.bot.handler;

import com.toxin.bot.ability.speakers.AbstractSpeaker;
import com.toxin.bot.transfer.SpeakerTransf;


public class SpeakerHendler extends AbstractHandler<SpeakerTransf> {

    public SpeakerHendler() {
        super(SpeakerTransf.class);
    }

    @Override
    public void handleTransf(SpeakerTransf transf) {
        AbstractSpeaker ability = (AbstractSpeaker) transf.getAbility();//TODO Hmmm

        if (transf.getUpdate().hasMessage()) {
            transf.setAnswer(ability.getAnswer(transf.getUpdate().getMessage().getText()));
        }

        super.transmitter.pushOut(transf);
    }

}
