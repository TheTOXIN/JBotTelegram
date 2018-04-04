package com.toxin.jbot;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Render {

    public static final String name = "render.png";

    public static File render(File file) {

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
            e.printStackTrace();
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

    private static int rude(int tune) {
        int min = 0;
        int max = 255;

        if (tune <= min || tune >= max)
            return tune;

        int k = Util.rand.nextInt(max);
        int res = 0;

        int[] split = new int[k];

        for (int i = split.length; i > 0; i--) {
            split[split.length - i] = max / i;
        }

        for (int i = 0; i < split.length; i++) {
            if (tune <= split[i]) {
                res = split[i];
                break;
            }
        }

        return res;
    }

}
