package osprey.base;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
        * The {@code BasicOperations} class contains static methods for summation, subtraction,
        * multiplication, and division with double[] array types.
        * This is implemented so that users can do basic operations with multiple numbers
        * <p>
 * Other operations such as finding the absolute value using {@link #abs(double a)}
         * Rounding using {@link #round(double value, int places)}
         * Factorial using {@link #factorial(int x)} or {@link #factorialNonRecursion(int x)} which is deprecated
        * @author  Archisman Nath
        * @since   1.0
 **/

public final class BasicOperations {

    /**Do not let anyone instantiate this class**/
    private BasicOperations() {}
    
    /** @return the sum of an array - user can put more than 2 elements to sum**/
    public static double add(double[] nums) {
        double sum = 0;
        for (int num = 0; num <= nums.length-1; num++) {
            sum+=nums[num];
        }
        return sum;
    }

    /** @return the result of subtraction between 2 numbers**/
    public static double subtract(double a, double b) {
        return a - b;
    }

    /** @return the product between elements inside an array**/
    public static double multiply(double[] nums) {
        int product = 1;
        for(int i = 0; i <= nums.length-1; i++) {
            product *= nums[i];
        }
        return product;
    }

    /** @return the absolute value of a number value**/
    public static double abs(double a) {
        return Math.abs(a);
    }
    
    /** @return the result of division between 2 numbers*/
    public static double divide(double a, double b) {
        return a / b;
    }

    /** @return the accurate rounded value of a decimal or integer value 
     * 
     * @param value the initial value
     * @param places places to round to
     */
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    /**Calculates the factorial value of entered integer
     *
     * @param x value to factorial -> x!
     * @exception ArithmeticException if specified conditions are not met
     * @return the factorial of x
     * @deprecated since 8
     * -> use latest - {@link #factorial(int x)}
     * <ul><li>Constraints -> x is 0 or x is 1, then the
     * result is 1.</ul>
     */
    @Deprecated(since = "8")
    public static double factorialNonRecursion(int x) {
        if(x == 0 || x == 1) {
            return 1;
        } else {
            if(x < 0) {
                throw new ArithmeticException("Negative values cannot have factorials");
            }
            int result = 1;
            for(int i = x; i >= 1; i--) {
                result*=i;
            }
            return result;
        }
    }

    /**Calculates the factorial value of entered integer
     * 
     * @param x value to factorial -> x!
     * @return the factorial of x
     * @exception StackOverflowError if number is negative due to deep recursive overflow
     * <ul><li>Constraints -> x is 0 or x is 1, then the
     * result is 1.</ul>
     */
    public static double factorial(int x) {
        return x == 0 || x == 1 ? 1: x * factorial(x-1);
    }
}
