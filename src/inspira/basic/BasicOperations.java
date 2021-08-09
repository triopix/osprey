package inspira.basic;

public class BasicOperations {

    public static double add(double[] nums) {
        double sum = 0;
        for (double num : nums) {
            sum += num;
        }
        return sum;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double[] nums) {
        int product = 1;
        for(double k : nums) {
            product *= k;
        }
        return product;
    }

    public static double divide(double a, double b) {
        return a / b;
    }
}
