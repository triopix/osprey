package osprey.geometry.geo2D.trig;

import osprey.geometry.geo2D.angles.AngleConversion;

public final class BaseTrigFunctions {

    private BaseTrigFunctions() {};

    //sin
    public static double sinRad(double radians) {
        return Math.sin(radians);
    }

    public static double sinDeg(double degrees) {
        return Math.sin(AngleConversion.degreesToRadians(degrees));
    }

    public static double sinGrad(double gradians) {
        return Math.sin(AngleConversion.gradiansToRadians(gradians));
    }

    //cos
    public static double cosRad(double radians) {
        return Math.cos(radians);
    }

    public static double cosDeg(double degrees) {
        return Math.cos(AngleConversion.degreesToRadians(degrees));
    }

    public static double cosGrad(double gradians) {
        return Math.cos(AngleConversion.gradiansToRadians(gradians));
    }

    //tan
    public static double tanRad(double radians) {
        return Math.tan(radians);
    }

    public static double tanDeg(double degrees) {
        return Math.tan(AngleConversion.degreesToRadians(degrees));
    }

    public static double tanGrad(double gradians) {
        return Math.tan(AngleConversion.gradiansToRadians(gradians));
    }


    //sec
    public static double secRad(double radians) {
        return 1 / cosRad(radians);
    }

    public static double secDeg(double degrees) {
        return 1 / cosDeg(degrees);
    }

    public static double secGrad(double gradians) {
        return 1 / cosGrad(gradians);
    }

    //csc
    public static double cscRad(double radians) {
        return 1 / sinRad(radians);
    }

    public static double cscDeg(double degrees) {
        return 1 / sinDeg(degrees);
    }

    public static double cscGrad(double gradians) {
        return 1 / sinGrad(gradians);
    }


    //cot
    public static double cotRad(double radians) {
        return cosRad(radians) / sinRad(radians);
    }

    public static double cotDeg(double degrees) {
        return cosDeg(degrees) / sinDeg(degrees);
    }

    public static double cotGrad(double gradians) {
        return cosGrad(gradians) / sinGrad(gradians);
    }
}
