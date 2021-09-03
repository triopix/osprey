package osprey.geometry.geo2D.trig;

import osprey.constants.MathConstants;
import osprey.geometry.geo2D.angles.AngleConversion;

public class InverseTrigFunctions {

    //return the arc or inverse sine of x - so y = arcsin(x) where x = sin(y); result in deg rad or grad

    //arc sin
    public static double arcSinRad(double x) {
        return Math.asin(x);
    }

    public static double arcSinDeg(double x) {
        double val = AngleConversion.radiansToDegrees(arcSinRad(x));
        //considering the domain and range of the function - true return val - not return NaN
        return (x >= -1 && x <= 1) && (val >= -90 && val <= 90) ? val : MathConstants.DOUBLE_NaN;
    }

    public static double arcSinGrad(double x) {
        return AngleConversion.radiansToGradians(arcSinRad(x));
    }
}
