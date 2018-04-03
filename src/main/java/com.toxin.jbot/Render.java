package com.toxin.jbot;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Render {

    private static final List<String> bacicRGB = Arrays.asList(
        "#000000",
        "#FFFFFF",
        "#FF0000",
        "#00FF00",
        "#0000FF",
        "#FFFF00",
        "#00FFFF",
        "#FF00FF",
        "#C0C0C0",
        "#808080",
        "#800000",
        "#808000",
        "#008000",
        "#800080",
        "#008080",
        "#000080"
    );

    static {
        bacicRGB.sort(String::compareTo);
    }

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

            ImageIO.write(image, "png", new File(Util.RES + "after.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static int inverse(int pixel) {
        Color c = new Color(pixel);

        String s = String.format("#%02x%02x%02x", c.getRed(), c.getGreen(), c.getGreen());

        for (int i = 0; i < bacicRGB.size() - 1; i++) {
            String min = bacicRGB.get(i);
            String max = bacicRGB.get(i);
            String hex = s.toUpperCase();
            System.out.println("HEX=" + hex + " MIN" + min + " MAX" + max);
            if (beetween(hex, min, max)) {
                c = Color.decode(bacicRGB.get(i));
            }
        }

        return c.getRGB();
    }

    private static boolean beetween(String hex, String min, String max) {
        return
            (hex.compareTo(min) > 0 || hex.compareTo(min) == 0)
            &&
            (hex.compareTo(max) < 0 || hex.compareTo(max) == 0);
    }

    public static void main(String[] args) {
        render(new File(Util.RES + "before.png"));
    }

}
