package com.toxin.bot.transfer;

import com.toxin.bot.ability.Ability;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.telegram.telegrambots.meta.api.objects.Update;

@NoArgsConstructor
public abstract class AbstractTransf<A extends Ability> {

    private A ability;

    @Getter
    @Setter
    private Update update;

    @Getter
    @Setter
    private String chatId;

    public AbstractTransf(Update update) {
        this.update = update;
    }

    public abstract A getAbility();

}
