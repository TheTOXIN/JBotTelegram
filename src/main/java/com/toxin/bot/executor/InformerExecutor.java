package com.toxin.bot.executor;

import com.toxin.bot.basic.Initializer;
import com.toxin.bot.transfer.InformerTransf;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class InformerExecutor extends AbstractExecutor<InformerTransf> {

    @Override
    public void executeTransf(InformerTransf transf) {
        try {
            Initializer.BOT.execute(new SendMessage(
                transf.getUpdate().getMessage().getChatId(),
                transf.getInformation()
            ));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

}
