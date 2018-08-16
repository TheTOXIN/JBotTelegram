package com.toxin.bot.handler;

import com.toxin.bot.ability.informers.AbstractInformer;
import com.toxin.bot.responser.AbstractRespons;
import com.toxin.bot.responser.InformerRespons;
import com.toxin.bot.transfer.InformerTransf;


public class InformerHendler extends AbstractHandler<InformerTransf> {

    public InformerHendler() {
        super(InformerTransf.class);
    }

    @Override
    public void performTransf(InformerTransf transf) {
        AbstractInformer ability = (AbstractInformer) transf.getAbility();
        transf.setInformation(ability.getInfo());
        getRespons().sendTransf(transf);
    }

    @Override
    public AbstractRespons<InformerTransf> getRespons() {
        return new InformerRespons();
    }

}
