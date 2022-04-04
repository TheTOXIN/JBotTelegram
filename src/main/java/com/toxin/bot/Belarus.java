package com.toxin.bot;

import java.util.Random;

public class Belarus {

    private final static Random random = new Random();

    public static Location getAttack() {
        double x0 = 27.559716;
        double y0 = 53.894271;

        int radius = 1000000;
        double radiusInDegrees = radius / 111000f;

        double u = random.nextDouble();
        double v = random.nextDouble();

        double w = radiusInDegrees * Math.sqrt(u);
        double t = 2 * Math.PI * v;

        double x = w * Math.cos(t);
        double y = w * Math.sin(t);

        double new_x = x / Math.cos(Math.toRadians(y0));

        double longitude = new_x + x0;
        double latitude = y + y0;

        return new Location(latitude, longitude);
    }

    public static class Location {
        public double latitude;
        public double longitude;

        public Location(double latitude, double longitude) {
            this.latitude = latitude;
            this.longitude = longitude;
        }
    }
}
