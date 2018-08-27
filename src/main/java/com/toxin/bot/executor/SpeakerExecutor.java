package com.toxin.bot.executor;

import com.toxin.bot.basic.Initializer;
import com.toxin.bot.transfer.SpeakerTransf;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class SpeakerExecutor extends AbstractExecutor<SpeakerTransf> {

    @Override
    public void executeTransf(SpeakerTransf transf) {
        try {
            Initializer.BOT.execute(new SendMessage(
                transf.getUpdate().getMessage().getChatId(),
                transf.getAnswer()
            ));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

}
