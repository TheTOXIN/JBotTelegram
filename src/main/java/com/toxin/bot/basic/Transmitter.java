package com.toxin.bot.basic;

import com.toxin.bot.executor.*;
import com.toxin.bot.performer.*;
import com.toxin.bot.transfer.*;

import java.util.LinkedList;
import java.util.Queue;


public class Transmitter { //придумать механизм который бдует автоматос дергать очериди и обрабатывать трансферы

    public final static Transmitter INSTANCE = new Transmitter();

    private Queue<AbstractTransf> in = new LinkedList<>();
    private Queue<AbstractTransf> out = new LinkedList<>();

    private Transmitter() {
        //SINGLETON
    }

    public void pushIn(AbstractTransf transf) {
        this.in.offer(transf);
    }

    public void pushOut(AbstractTransf transf) {
        this.out.offer(transf);
    }

    public AbstractTransf pullIn() {
        return this.in.remove();
    }

    public AbstractTransf pullOut() {
        return this.out.remove();
    }

    public void checkTransf() {
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(300);
                    if (!in.isEmpty()) inTransf(pullIn());
                    if (!out.isEmpty()) outTransf((pullOut()));
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
            new EventerPerform().performTransf((EventerTransf) transf);
        } else if (transf instanceof FeatureTransf) {
            new FeaturePerform().performTransf((FeatureTransf) transf);
        } else if (transf instanceof GameTransf) {
            new GamePerform().performTransf((GameTransf) transf);
        } else if (transf instanceof InformerTransf) {
            new InformerPerform().performTransf((InformerTransf) transf);
        } else if (transf instanceof SpeakerTransf) {
            new SpeakerPerform().performTransf((SpeakerTransf) transf);
        } else {
            System.out.println("I made my mistaaaaakess...");
        }
    }
    //TODO ЕБАТЬ ЭТО РАБОТАЕТ (но надо наверное убрать логику с ин аут трансф)
    private void outTransf(AbstractTransf transf) {
        if (transf instanceof EventerTransf) {
            new EventerExecutor().executeTransf((EventerTransf) transf);
        } else if (transf instanceof FeatureTransf) {
            new FeatureExecutor().executeTransf((FeatureTransf) transf);
        } else if (transf instanceof GameTransf) {
            new GameExecutor().executeTransf((GameTransf) transf);
        } else if (transf instanceof InformerTransf) {
            new InformerExecutor().executeTransf((InformerTransf) transf);
        } else if (transf instanceof SpeakerTransf) {
            new SpeakerExecutor().executeTransf((SpeakerTransf) transf);
        } else {
            System.out.println("I’ve got no where to run");
        }
    }

}
