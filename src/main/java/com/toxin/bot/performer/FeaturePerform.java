package com.toxin.bot.performer;

import com.toxin.bot.ability.features.Render;
import com.toxin.bot.basic.Bot;
import com.toxin.bot.handler.AbstractHandler;
import com.toxin.bot.handler.FeatureHendler;
import com.toxin.bot.other.Util;
import com.toxin.bot.transfer.FeatureTransf;
import org.telegram.telegrambots.meta.api.methods.GetFile;
import org.telegram.telegrambots.meta.api.objects.File;
import org.telegram.telegrambots.meta.api.objects.PhotoSize;

import java.util.List;

public class FeaturePerform extends AbstractPerform<FeatureTransf> {

    public FeaturePerform() {
        super(FeatureTransf.class);
    }

    @Override
    public void performTransf(FeatureTransf transf) {

        if (transf.getUpdate().hasMessage()) {

        }

        super.performTransf(transf);
    }

    @Override
    public AbstractHandler<FeatureTransf> getHandler() {
        return new FeatureHendler();
    }

}
