package com.toxin.bot;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Loader {

    public static InputStream getGoogle() {
        try {
            URL url = new URL("https://www.google.ru/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png");
            try (InputStream in = url.openStream()) {
                return in;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
