package com.toxin.bot;

import org.apache.log4j.Logger;

import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Memator {

    public static final String KEY_WORD = "meme";

    private static final String MEME_API = "https://memastick-back.herokuapp.com/memes/random";
    private static final String NAME = "mem.jpg";

    private static final Logger log = Logger.getLogger(Memator.class);

    public static File getMem() {
        log.info("START DOWNLOAD RANDOM MEME");

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder(URI.create(MEME_API)).GET().build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String url = response.body();

            Util.downloadImage(url, NAME);
        } catch (Exception ex) {
            log.error("ERROR DOWNLOAD RANDOM MEME");
        }

        return new File(Util.RES + NAME);
    }
}
