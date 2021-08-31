package osprey.geometry.geo2D.angles;

import osprey.constants.MathConstants;

public final class AngleConversion {

    private AngleConversion() {}

    public static double radiansToDegrees(double radians) {
        return Math.toDegrees(radians);
    }

    public static double radiansToGradians(double radians) {
        return radians * 200 / MathConstants.PI_EXACT;
    }

    public static double degreesToRadians(double degrees) {
        return Math.toRadians(degrees);
    }

    public static double degreesToGradians(double degrees) {
        return degrees * 200/180;
    }

    public static double gradiansToDegrees(double gradians) {
        return gradians * 180/200;
    }

    public static double gradiansToRadians(double gradians) {
        return gradians / 63.662;
    }


}
