package com.toxin.jbot;

import java.util.ArrayList;

public class Settings {

    private ArrayList<String> mockId = new ArrayList<>();

    public Settings() {
    }

    public ArrayList<String> getMockId() {
        return mockId;
    }

    public void setMockId(ArrayList<String> mockId) {
        this.mockId = mockId;
    }

    public void addMock(String id) {
        mockId.add(id);
    }

    public void removeMock(String id) {
        mockId.remove(id);
    }

    public boolean isMock(String id) {
        return mockId.contains(id);
    }

}
