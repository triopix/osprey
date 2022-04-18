package osprey.geometry.geo2D.shapes.calc;

import java.awt.*;

/**
 * Automatic Generation Project - Author
 * Project Name: mathosp
 * Author: ARCHISMAN NATH on 4/17/2022 in 9:44 PM
 */
public final class OspreyAreas {

    private OspreyAreas() {}

    public static double areaOfRectangle(double width, double height) {
        if(width < 0 || height < 0) {
            throw new IllegalArgumentException("Values cannot be negative");
        }
        return width * height;
    }

}
