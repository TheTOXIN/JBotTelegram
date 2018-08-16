package com.toxin.bot.basic;

import com.toxin.bot.ability.AbstractAbility;
import com.toxin.bot.requester.*;
import com.toxin.bot.transfer.*;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.LinkedList;
import java.util.Queue;


public class Transmitter { //придумать механизм который бдует автоматос дергать очериди и обрабатывать трансферы

    public final static Transmitter INSTANCE = new Transmitter();

    private Queue<AbstractTransf<? extends AbstractAbility>> in = new LinkedList<>();
    private Queue<AbstractTransf<? extends AbstractAbility>> out = new LinkedList<>();

    private Transmitter() {
        //SINGLETON
    }

    public void pushIn(AbstractTransf<? extends AbstractAbility> transf) {
        this.in.offer(transf);
    }

    public void pushOut(AbstractTransf<? extends AbstractAbility> transf) {
        this.out.offer(transf);
    }

    public AbstractTransf<? extends AbstractAbility> pullIn() {
        return this.in.remove();
    }

    public AbstractTransf<? extends AbstractAbility> pullOut() {
        return this.out.remove();
    }

    public void checkTransf() {
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
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
            new EventerRequest().accpetTranf((EventerTransf) transf);
        } else if (transf instanceof FeatureTransf) {
            new FeatureRequest().accpetTranf((FeatureTransf) transf);
        } else if (transf instanceof GameTransf) {
            new GameRequest().accpetTranf((GameTransf) transf);
        } else if (transf instanceof InformerTransf) {
            new InformerRequest().accpetTranf((InformerTransf) transf);
        } else if (transf instanceof SpeakerTransf) {
            new SpeakerRequest().accpetTranf((SpeakerTransf) transf);
        } else {
            System.out.println("I made my mistaaaaakess...");
        }
    }
    //ЕБАТЬ ЭТО РАБОТАЕТ (но надо наверное убрать логику с ин аут трансф)
    private void outTransf(AbstractTransf transf) {
        try {
            if (transf instanceof EventerTransf) {
            } else if (transf instanceof FeatureTransf) {
            } else if (transf instanceof GameTransf) {
            } else if (transf instanceof InformerTransf) {
                Initializer.BOT.execute(new SendMessage(
                        transf.getUpdate().getMessage().getChatId(),
                        ((InformerTransf) transf).getInformation()
                ));
            } else if (transf instanceof SpeakerTransf) {
            } else {
                System.out.println("The night goes on");
            }
        } catch (TelegramApiException e) {
            System.out.println("As I’m fading away");
        }
    }

}
