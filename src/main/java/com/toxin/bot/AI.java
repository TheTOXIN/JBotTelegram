package com.toxin.bot;

import ai.api.AIConfiguration;
import ai.api.AIDataService;
import ai.api.AIServiceException;
import ai.api.model.AIRequest;
import ai.api.model.AIResponse;

public class AI {

    public static String getAnswer(String text) {
        String answer = "";
        text = refactor(text);

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

    private static String refactor(String str) {
        return str.replaceFirst("бот", "").trim();
    }
}
