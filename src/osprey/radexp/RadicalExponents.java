package osprey.radexp;

import osprey.base.BasicOperations;
import osprey.logarithms.Logarithms;

public final class RadicalExponents {

    private RadicalExponents() {};

    public static double sqrt(double a) {
        return Math.sqrt(a);
    }

    public static double cbrt(double a) {
        return Math.cbrt(a);
    }

    public static double pow(double base, double exp) {
        return Math.pow(base, exp);
    }

    public static double findExp(double base, double result) {
        return BasicOperations.round(Logarithms.log10(result) / Logarithms.log10(base), 4);
    }

    public static double findValueUsingCustomRoot(double root, double number) {
        double xPre = Math.random() % 10;
        double eps = 0.001;
        double delX = Integer.MAX_VALUE;
        double xK = 0.0;
        while (delX > eps) {
            xK = ((root - 1.0) * xPre + number / Math.pow(xPre, root - 1)) / root;
            delX = Math.abs(xK - xPre);
            xPre = xK;
        }
        return BasicOperations.round(xK, 4);
    }
}
