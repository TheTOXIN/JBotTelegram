package com.toxin.bot.basic;


import com.toxin.bot.ability.Ability;
import com.toxin.bot.transfer.AbstractTransf;

import java.util.LinkedList;
import java.util.Queue;

public class Transmitter { //придумать механизм который бдует автоматос дергать очериди и обрабатывать трансферы

    private Queue<AbstractTransf<? extends Ability>> in = new LinkedList<>();
    private Queue<AbstractTransf<? extends Ability>> out = new LinkedList<>();

    public void pushIn(AbstractTransf<? extends Ability> transf) {
        this.in.offer(transf);
    }

    public void pushOut(AbstractTransf<? extends Ability> transf) {
        this.out.offer(transf);
    }

    public AbstractTransf<? extends Ability> pullIn() {
        return this.in.remove();
    }

    public AbstractTransf<? extends Ability> pullOut() {
        return this.out.remove();
    }

    private void inTransf(AbstractTransf transf) {
        transf.generateRequest().accpetTranf(transf);//OMG
    }

    private AbstractTransf outTransf() {
        return null;
    }

}
