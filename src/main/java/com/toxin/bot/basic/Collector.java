package com.toxin.bot.basic;

import com.toxin.bot.ability.AbstractAbility;
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
import lombok.Getter;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Collector {

    @Getter
    private List<AbstractContexter<? extends AbstractAbility>> contexters = new ArrayList<>();

    public Collector() {
        Transmitter.INSTANCE.checkTransf();//автоматизировать
        intiContexts();
    }

    private void intiContexts() {
        //в рот ебал я эти синглтоны
        intiEventerContexts();
        intiFeatureContexts();
        intiGameContexts();
        intiInformerContexts();
        intiSpeakerContexts();
    }

    public void processUpdate(Update update) {
        this.contexters
            .stream()
            .peek(c -> c.computeScore(update))
            .filter(AbstractContexter::haveScore)
            .max(Comparator.comparingInt(AbstractContexter::getScore))
            .ifPresent(contexter -> {
                Transmitter.INSTANCE.pushIn(contexter.generateTransf(update));
                contexter.clearScore();
            });
    }

    private void intiEventerContexts() {
        this.contexters.addAll(Arrays.asList(
            new EventerContexter<>(Mock.instance)
        ));
    }

    private void intiFeatureContexts() {
        this.contexters.addAll(Arrays.asList(
            new FeatureContexter<>(Memator.instance),
            new FeatureContexter<>(Prediction.instance),
            new FeatureContexter<>(Render.instance)
        ));
    }

    private void intiGameContexts() {
        this.contexters.addAll(Arrays.asList(
            new GameContexter<>(GameBC.instance),
            new GameContexter<>(GameKN.instance),
            new GameContexter<>(GameKNB.instance),
            new GameContexter<>(GameMOL.instance)
        ));
    }

    private void intiInformerContexts() {
        this.contexters.addAll(Arrays.asList(
            new InformerContexter<>(Info.instance)
        ));
    }

    private void intiSpeakerContexts() {
        this.contexters.addAll(Arrays.asList(
            new SpeakerContexter<>(AI.instance),
            new SpeakerContexter<>(Bla.instance),
            new SpeakerContexter<>(Hyi.instance)
        ));
    }

}
