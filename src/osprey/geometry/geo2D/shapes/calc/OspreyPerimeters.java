package osprey.geometry.geo2D.shapes.calc;

/**
 * Automatic Generation Project - Author
 * Project Name: mathosp
 * Author: ARCHISMAN NATH on 4/17/2022 in 9:44 PM
 */
public final class OspreyPerimeters {

    private OspreyPerimeters() {}

    public static double perimeterOfRectangle(double width, double height) {
        if(width < 0 || height < 0) {
            throw new IllegalArgumentException("Values cannot be negative");
        } else {
            return (2 * width) + (2 * height);
        }
    }
}
