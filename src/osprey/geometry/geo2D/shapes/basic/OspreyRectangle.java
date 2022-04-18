package osprey.geometry.geo2D.shapes.basic;

import osprey.geometry.geo2D.shapes.calc.OspreyAreas;
import osprey.geometry.geo2D.shapes.calc.OspreyPerimeters;

/**
 * Automatic Generation Project - Author
 * Project Name: mathosp
 * Author: ARCHISMAN NATH on 4/17/2022 in 9:14 PM
 */
public class OspreyRectangle {

    private double width;
    private double height;
    private boolean printInfo;

    public double AREA_OF_RECTANGLE = OspreyAreas.areaOfRectangle(this.width, this.height);
    public double PERIMETER_OF_RECTANGLE = OspreyPerimeters.perimeterOfRectangle(this.width, this.height);

    public OspreyRectangle(double width, double height, boolean printInfo) {
        this.width = width;
        this.height = height;
        this.printInfo = printInfo;
        if(printInfo) {
            System.out.println("Width of Rectangle is " + this.width);
            System.out.println("Height of Rectangle is " + this.height);
            System.out.println("Area of Rectangle is " + AREA_OF_RECTANGLE);
            System.out.println("Perimeter of Rectangle is " + PERIMETER_OF_RECTANGLE);
        }
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public boolean isPrintInfo() {
        return printInfo;
    }

    public void setPrintInfo(boolean printInfo) {
        this.printInfo = printInfo;
    }

    public double getAREA_OF_RECTANGLE() {
        return AREA_OF_RECTANGLE;
    }

    public double getPERIMETER_OF_RECTANGLE() {
        return PERIMETER_OF_RECTANGLE;
    }

    //areas, perimeters, receiving values from other values

}
