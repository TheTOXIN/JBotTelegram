package com.toxin.bot.responser;

import com.toxin.bot.transfer.InformerTransf;


public class InformerRespons extends AbstractRespons<InformerTransf> {

    public InformerRespons() {
        super(InformerTransf.class);
    }

    @Override
    public void sendTransf(InformerTransf transf) {
        super.transmitter.pushOut(transf);
    }

}
