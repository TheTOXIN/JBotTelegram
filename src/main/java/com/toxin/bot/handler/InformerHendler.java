package com.toxin.bot.handler;

import com.toxin.bot.ability.informers.AbstractInformer;
import com.toxin.bot.transfer.InformerTransf;


public class InformerHendler extends AbstractHandler<InformerTransf> {

    public InformerHendler() {
        super(InformerTransf.class);
    }

    @Override
    public void handleTransf(InformerTransf transf) {
        AbstractInformer ability = (AbstractInformer) transf.getAbility();//TODO Hmmm
        transf.setInformation(ability.getInfo());
        transmitter.pushOut(transf);
    }

}
