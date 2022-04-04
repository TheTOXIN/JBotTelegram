package com.toxin.bot;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import java.io.File;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static java.lang.String.format;

public class Gif {

    private static final Logger log = Logger.getLogger(Util.class);

    private final static String API_URL = "https://api.giphy.com/v1/gifs/random";
    private final static String API_PARAM = "?api_key=jZZD55t7vAwmz0LVEHF2bLDziot2hg2k&tag=%s&limit=1";

    private static final String NAME = "tmp.gif";

    public static String randomGif(String msg) {
        String tag = msg.replaceAll("покажи", "").trim();
        String url = API_URL + format(API_PARAM, tag);

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder(URI.create(url)).GET().build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String data = response.body();

            return new JSONObject(data)
                .getJSONObject("data")
                .getJSONObject("images")
                .getJSONObject("downsized")
                .getString("url");
        } catch (Exception ex) {
            log.error("ERROR DOWNLOAD RANDOM GIF");
            return "";
        }
    }
}
