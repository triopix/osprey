package osprey.geometry.geo2D.trig;

import osprey.constants.MathConstants;
import osprey.geometry.geo2D.angles.AngleConversion;

public class InverseTrigFunctions {

    //arc sine
    public static double arcSinRad(double x) {
        return Math.asin(x); //already implements conditions in domain and range for radians
    }

    public static double arcSinDeg(double x) {
        double val = AngleConversion.radiansToDegrees(arcSinRad(x));
        boolean degCond = (x >= -1 && x <= 1) && (val >= -90 && val <= 90);
        return degCond ? val : MathConstants.DOUBLE_NaN;
    }

    public static double arcSinGrad(double x) {
        double val = AngleConversion.radiansToGradians(arcSinRad(x));
        boolean gradCond = (x >= -1 && x <= 1) && (val >= -100 && val <= 100);
        return gradCond ? val : MathConstants.DOUBLE_NaN;
    }

    //arc cosine
    public static double arcCosRad(double x) {
        return Math.acos(x);
    }

    public static double arcCosDeg(double x) {
        double val = AngleConversion.radiansToDegrees(arcCosRad(x));
        boolean degCond = (x >= -1 && x <= 1) && (val >= 0 && val <= 180);
        return degCond ? val : MathConstants.DOUBLE_NaN;
    }

    public static double arcCosGrad(double x) {
        double val = AngleConversion.radiansToGradians(arcCosRad(x));
        boolean degCond = (x >= -1 && x <= 1) && (val >= 0 && val <= 200);
        return degCond ? val : MathConstants.DOUBLE_NaN;
    }

    //arc tangent
    public static double arcTanRad(double x) {
        return Math.atan(x);
    }

    public static double arcTanDeg(double x) {
        double val = AngleConversion.radiansToDegrees(arcTanRad(x));
        boolean degCond = (x >= -1 && x <= 1) && (val >= -90 && val <= 90);
        return degCond ? val : MathConstants.DOUBLE_NaN;
    }

    public static double arcTanGrad(double x) {
        double val = AngleConversion.radiansToGradians(arcTanRad(x));
        boolean gradCond = (x >= -1 && x <= 1) && (val >= -100 && val <= 100);
        return gradCond ? val : MathConstants.DOUBLE_NaN;
    }


    //inverse tangent function both of them
    public static double atan2(double x, double y) {
        return Math.atan2(x, y);
    }
}
