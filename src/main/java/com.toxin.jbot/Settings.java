package com.toxin.jbot;

import java.util.ArrayList;

public class Settings {

    private ArrayList<String> chatId = new ArrayList<>();

    public Settings() {
    }

    public void addChat(String id) {
        chatId.add(id);
    }

    public void removeChat(String id) {
        chatId.remove(id);
    }

    public boolean isChatMock(String id) {
        return !chatId.contains(id);
    }

}
