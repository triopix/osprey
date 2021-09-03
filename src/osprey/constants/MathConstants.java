package osprey.constants;

public final class MathConstants {

    private MathConstants() {}

    //important Math constants used in mathematics
    public static final double PI_EXACT = Math.PI;
    public static final double PI_NORMAL = 3.14;
    public static final double E_EXACT = Math.E;
    public static final double E_NORMAL = 2.718;
    public static final String UNITS = "units";
    private static final char SQUARED = '\u00B2';
    public static final String UNITS_SQUARED = UNITS+SQUARED;

    //Nan values - float, double, int, long
    public static final double DOUBLE_NaN = Double.NaN;
    public static final float FLOAT_NaN = Float.NaN;

    //other important constants
    public static final double POSITIVE_INFINITY_DOUBLE = Double.POSITIVE_INFINITY;
    public static final double POSITIVE_INFINITY_FLOAT = Float.POSITIVE_INFINITY;
    public static final double NEGATIVE_INFINITY_DOUBLE = Double.NEGATIVE_INFINITY;
    public static final double NEGATIVE_INFINITY_FLOAT = Float.NEGATIVE_INFINITY;



}
