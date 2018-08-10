package com.toxin.bot.basic;

import com.toxin.bot.requester.*;
import com.toxin.bot.transfer.AbstractTransf;

import java.util.ArrayList;
import java.util.List;

public class Transmitter {

    private List<AbstractRequest> requests = new ArrayList<>();

    public Transmitter() {
        intiRequests();
    }

    public void intiRequests() {
        requests.add(new EventerRequest());
        requests.add(new FeatureRequest());
        requests.add(new GameRequest());
        requests.add(new InformerRequest());
        requests.add(new SpeakerRequest());
    }

    public void processTransf(AbstractTransf transf) {
        for (AbstractRequest request : requests) {

        }
    }

}
