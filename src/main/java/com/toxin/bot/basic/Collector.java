package com.toxin.bot.basic;

import com.toxin.bot.ability.Ability;
import com.toxin.bot.ability.eventers.Mock;
import com.toxin.bot.ability.features.Memator;
import com.toxin.bot.ability.features.Prediction;
import com.toxin.bot.ability.features.Render;
import com.toxin.bot.ability.games.GameBC;
import com.toxin.bot.ability.games.GameKN;
import com.toxin.bot.ability.games.GameKNB;
import com.toxin.bot.ability.games.GameMOL;
import com.toxin.bot.ability.informers.Info;
import com.toxin.bot.ability.speakers.AI;
import com.toxin.bot.ability.speakers.Bla;
import com.toxin.bot.ability.speakers.Hyi;
import com.toxin.bot.contexter.*;
import com.toxin.bot.transfer.*;
import lombok.Getter;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Collector {

    @Getter
    private List<AbstractContexter<? extends Ability>> contexters = new ArrayList<>();

    @Getter
    private List<AbstractTransf<? extends Ability>> transfers = new ArrayList<>();

    public Collector() {
        intiContexts();
    }

    public void intiContexts() {
        intiEventerContexts();
        intiFeatureContexts();
        intiGameContexts();
        intiInformerContexts();
        intiSpeakerContexts();
    }

    public void processUpdate(Update update) {
        //ключевых слов может быть несколько, нужно учитывать все контексты для каждого абилти
        if (update.hasMessage()) {
            this.transfers.addAll(
                    this.contexters
                            .stream()
                            .filter(c -> c.itsMe(update))
                            .map(AbstractContexter::generateTransf)
                            .peek(t -> t.setUpdate(update))
                            .collect(Collectors.toList())
            );
        }
    }

    private void intiEventerContexts() {
        this.contexters.addAll(Arrays.asList(
                new EventerContexter<Mock>()
        ));
    }

    private void intiFeatureContexts() {
        this.contexters.addAll(Arrays.asList(
                new FeatureContexter<Memator>(),
                new FeatureContexter<Prediction>(),
                new FeatureContexter<Render>()
        ));
    }

    private void intiGameContexts() {
        this.contexters.addAll(Arrays.asList(
                new GameContexter<GameBC>(),
                new GameContexter<GameKN>(),
                new GameContexter<GameKNB>(),
                new GameContexter<GameMOL>()
        ));
    }

    private void intiInformerContexts() {
        this.contexters.addAll(Arrays.asList(
                new InformerContexter<Info>()
        ));
    }

    private void intiSpeakerContexts() {
        this.contexters.addAll(Arrays.asList(
                new SpeakerContexter<AI>(),
                new SpeakerContexter<Bla>(),
                new SpeakerContexter<Hyi>()
        ));
    }

}
