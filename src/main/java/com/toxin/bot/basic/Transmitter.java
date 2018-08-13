package com.toxin.bot.basic;


import com.toxin.bot.ability.Ability;
import com.toxin.bot.requester.AbstractRequest;
import com.toxin.bot.transfer.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Transmitter { //придумать механизм который бдует автоматос дергать очериди и обрабатывать трансферы

    private List<AbstractRequest<? extends AbstractTransf>> requests = new ArrayList<>();

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

    public void checkTransf() {
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                    if (!in.isEmpty()) inTransf(pullIn());
                    if (!out.isEmpty()) inTransf(pullOut());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("How could this happen to meeeeee....");
                    break;
                }
            }
        }).start();
    }

    private void inTransf(AbstractTransf transf) {
        if (transf instanceof EventerTransf) {

        } else if (transf instanceof FeatureTransf) {

        } else if (transf instanceof GameTransf) {

        } else if (transf instanceof InformerTransf) {

        } else if (transf instanceof SpeakerTransf) {

        } else {
            System.out.println("I made my mistaaaaakess...");
        }
    }

    private AbstractTransf outTransf() {
        return null;
    }

}
