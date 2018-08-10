package com.toxin.bot.basic;

import com.toxin.bot.contexter.*;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.ArrayList;
import java.util.List;

public class Collector {

    private List<AbstractContexter> contexts = new ArrayList<>();

    public Collector() {
        intiContexts();
    }

    public void intiContexts() {
        contexts.add(new EventerContexter());
        contexts.add(new FeatureContexter());
        contexts.add(new GameContexter());
        contexts.add(new InformerContexter());
        contexts.add(new SpeakerContexter());
    }

    public void processUpdate(Update update) {
        for (AbstractContexter context : contexts) {

        }
    }

}
