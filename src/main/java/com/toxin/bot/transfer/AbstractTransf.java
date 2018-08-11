package com.toxin.bot.transfer;

import com.toxin.bot.ability.Ability;
import com.toxin.bot.requester.AbstractRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.telegram.telegrambots.meta.api.objects.Update;

@NoArgsConstructor
public abstract class AbstractTransf<A extends Ability> {

    @Getter
    @Setter
    private Update update;

    @Getter
    @Setter
    private String chatId;

    public AbstractTransf(Update update) {
        this.update = update;
    }

    public abstract AbstractRequest<? extends AbstractTransf> generateRequest();

}
