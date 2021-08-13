package inspira.basic;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BasicOperations {

    public static double add(double[] nums) {
        double sum = 0;
        for (int num = 0; num <= nums.length-1; num++) {
            sum+=nums[num];
        }
        return sum;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double[] nums) {
        int product = 1;
        for(int i = 0; i <= nums.length-1; i++) {
            product *= nums[i];
        }
        return product;
    }

    public static double divide(double a, double b) {
        return a / b;
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
