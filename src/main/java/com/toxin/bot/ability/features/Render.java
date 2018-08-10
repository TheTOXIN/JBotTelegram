package com.toxin.bot.ability.features;

import org.apache.log4j.Logger;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Render extends AbstractFeature {

    private static final Logger log = Logger.getLogger(Render.class);

    public static final String NAME = "render.png";

    public static File render(String path) {
        File file = new File(path);

        try {
            BufferedImage image = ImageIO.read(file);

            int width = image.getWidth();
            int height = image.getHeight();

            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    image.setRGB(i, j, inverse(image.getRGB(i, j)));
                }
            }

            ImageIO.write(image, "png", file);
        } catch (IOException e) {
            log.error("IO - " + file.getAbsolutePath() + " - error open");
        }

        return file;
    }

    private static int inverse(int pixel) {
        Color oldColor = new Color(pixel);

        int R = rude(oldColor.getRed());
        int G = rude(oldColor.getGreen());
        int B = rude(oldColor.getBlue());

        Color newColor = new Color(R, G, B);

        return newColor.getRGB();
    }

    /**
     * @param tune max = 255 | min = 0
     *
     * interval = max / (k - 1)
     * c = 2 |0; 255|
     * c = 3 |0; 127; 255|
     * c = 4 |0; 85; 170; 255|
     * c = n |i * interval|
     *
     * @return res = tune <= (ni + ni+1 / 2)
     */
    private static int rude(int tune) {
        int min = 0;
        int max = 255;

        if (tune <= min || tune >= max)
            return tune;

        int count = 2;//NOT SET VALUE 1
        int interval = max / (count - 1);
        int res = 0;

        int[] split = new int[count];

        split[0] = 0;
        for (int i = 1; i < split.length; i++) {
            split[i] = i * interval;
        }

        for (int i = 0; i < split.length - 1; i++) {
            int s1 = split[i];
            int s2 = split[i + 1];
            if (s1 <= tune && tune <= s2) {
                int avg = (s1 + s2) / 2;
                if (tune <= avg) {
                    res = s1;
                } else {
                    res = s2;
                }
            }
        }

        return res;
    }

}
