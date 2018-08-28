package com.toxin.bot.ability.speakers;

import ai.api.AIConfiguration;
import ai.api.AIDataService;
import ai.api.AIServiceException;
import ai.api.model.AIRequest;
import ai.api.model.AIResponse;
import com.toxin.bot.basic.IDS;
import com.toxin.bot.other.Config;

import java.util.Arrays;
import java.util.List;

public class AI extends AbstractSpeaker {

    public static final AI instance = new AI();

    private AI() {
    }

    @Override
    public String getAnswer(String text) {
        return getAiAnswer(text);
    }

    private String getAiAnswer(String text) {
        String answer = "";
        text = text.replaceFirst("бот", "").trim();

        if (text.equals("") || text.isEmpty()) {
            return answer;
        }

        try {
            AIConfiguration conf = new AIConfiguration(Config.BOT_AI);
            AIDataService service = new AIDataService(conf);
            AIRequest request = new AIRequest(text);
            AIResponse response = service.request(request);

            answer = response.getResult().getFulfillment().getSpeech();
        } catch (AIServiceException e) {
            e.printStackTrace();
        }

        return answer;
    }

    @Override
    public List<String> getKeyWords() {
        return Arrays.asList(
            "бот",
            "эй"
        );
    }

    @Override
    public String getId() {
        return IDS.AIG;
    }

}
