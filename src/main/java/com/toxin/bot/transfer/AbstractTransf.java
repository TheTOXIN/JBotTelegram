package com.toxin.bot.transfer;

import com.toxin.bot.ability.AbstractAbility;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.telegram.telegrambots.meta.api.objects.Update;

@NoArgsConstructor
public abstract class AbstractTransf<A extends AbstractAbility> {

    @Getter
    @Setter
    private Update update;

    @Getter
    @Setter
    private A ability;

    public AbstractTransf(Update update, A ability) {
        this.update = update;
        this.ability = ability;
    }

}
