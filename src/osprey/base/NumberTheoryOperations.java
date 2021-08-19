package osprey.base;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code NumberTheoryOperations} class contains static methods for greates common factor, lowest common multiple,
 * prime factorization, factorization and multiple conversions between decimal, fractional parts, numbers, and percents
 * This is implemented so that users can use these operations with their projects.
 * <p>
 * @see #decimalToFraction(double)
 * @see #percentToDecimal(double)
 * @see #decimalToPercent(double)
 * @see #fractionToDecimal(double, double)
 * @see #fractionToPercent(double, double)
 * @see #percentToFraction(double)
 * @see #gcd(long[])
 * @see #gcd(long, long)
 * @see #lcm(long, long)
 * @see #lcm(long[])
 * @see #primeFactorize(long)
 * @see #factorize(long)
 * @see #simplifyFraction(long, long)
 * @author  Archisman Nath
 * @since   1.0
 **/

public final class NumberTheoryOperations {
    /**
     * Do not let anyone instantiate this class
     **/
    private NumberTheoryOperations() {}

    /**
     * @param a first value
     * @param b second value
     * @return the greatest common divisor
     * @implNote Implementations in {@link #simplifyFraction(long numerator, long denominator)} , {@link #lcm(long a, long b)} , {@link #gcd(long[] numbers)} , {@link #decimalToFraction(double number)}
     *
     */
    public static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    /**@return returns the greatest common divisor of more than 2 numbers
     *
     * @param numbers array of numbers[ ] to enter
     */
    public static long gcd(long[] numbers) {
        long result = 0;
        for (long element : numbers) {
            result = gcd(result, element);
            if (result == 1) {
                return 1;
            }
        }
        return result;
    }

    /**
     * @param numerator first value of fraction
     * @param denominator second value of fraction
     * @return - returns the most simplified version of the fraction
     */
    public static String simplifyFraction(long numerator, long denominator) {
        long gcd = gcd(numerator, denominator);
        return (numerator / gcd) + "/" + (denominator / gcd);
    }

    /**
     *
     * @param a first value
     * @param b second value
     * @return returns the lowest common multiple of two numbers
     */
    public static long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }

    /**
     *
     * @param numbers array[ ] of numbers entered
     * @return the lowest common multiple of the array[ ] entered
     */
    public static long lcm(long[] numbers) {
        long lcm_of_array_elements = 1;
        int divisor = 2;
        while (true) {
            int counter = 0;
            boolean divisible = false;
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] == 0) {
                    return 0;
                } else if (numbers[i] < 0) {
                    numbers[i] = numbers[i] * (-1);
                }
                if (numbers[i] == 1) {
                    counter++;
                }
                if (numbers[i] % divisor == 0) {
                    divisible = true;
                    numbers[i] = numbers[i] / divisor;
                }
            }
            if (divisible) {
                lcm_of_array_elements = lcm_of_array_elements * divisor;
            } else {
                divisor++;
            }
            if (counter == numbers.length) {
                return lcm_of_array_elements;
            }
        }
    }

    /**
     *
     * @param number the number to prime factorize
     * @return the prime factors (if any) of the number as a {@code List<Long>} -> not to be confused with {@link #factorize(long number)} -> which returns all factors regardless if prime or not
     */
    public static List<Long> primeFactorize(long number) {
        List<Long> primeFactors = new ArrayList<>();
        for(long factor = 2; factor <= number; factor++) {
            while (number % factor == 0) {
                primeFactors.add(factor);
                number = number / factor;
            }
        }
        return primeFactors;
    }

    /**
     *
     * @param number number to factorize
     * @return - the factors of the entered number - not to be confused with {@link #primeFactorize(long number)}
     */
    public static List<Long> factorize(long number) {
        long factorNumber = 1;
        List<Long> factors = new ArrayList<>();
        while(factorNumber <= number){
            if(number % factorNumber == 0){
                factors.add(factorNumber);
            }
            factorNumber++;
        }
        return factors;
    }

    /**
     *
     * @param decimalValue value of the decimal
     * @return the percentage of the decimal by conversion
     */
    public static double decimalToPercent(double decimalValue) {
        return decimalValue * 100;
    }

    /**
     *
     * @param number decimal value that will be used to convert into a fractional part
     * @return the fraction simplified to lowest terms as a {@code String} - if simplification is not possible - then total fraction is returned as a {@code String}
     */
    public static String decimalToFraction(double number) {
        double intVal = Math.floor(number);
        double fVal = number - intVal;
        final long pVal = 1000000000;
        long gcdVal = gcd(Math.round(
                fVal * pVal), pVal);
        long num = Math.round(fVal * pVal) / gcdVal;
        long denote = pVal / gcdVal;
        return ((long)(intVal * denote) +
                num + "/" + denote);
    }

    /**
     *
     * @param percentage percentage value entered
     * @return the decimal value that was converted from the percentage value entered
     */
    public static double percentToDecimal(double percentage) {
        return percentage / 100;
    }

    /**
     *
     * @param percentage percentage value entered
     * @return the fractional part that was converted from the percentage value
     */
    public static String percentToFraction(double percentage) {
        double decimal = percentToDecimal(percentage);
        return decimalToFraction(decimal);
    }

    /**
     *
     * @param numerator first or top value of the fraction
     * @param denominator down or below value of the fraction
     * @return the converted percentage from the fraction
     */
    public static String fractionToPercent(double numerator, double denominator) {
        return fractionToDecimal(numerator, denominator) * 100 + "%";
    }

    /**
     *
     * @param numerator first or top value of the fraction
     * @param denominator down or below value of the fraction
     * @return the converted decimal from the fraction
     */
    public static double fractionToDecimal(double numerator, double denominator) {
        return BasicOperations.divide(numerator, denominator);
    }

    /**
     * @param a has to be integer - can be negative - cannot be a decimal value
     * because this destroys the property of addition rules for even or odd numbers which states that
     * {@code even + even = even} and {@code odd + odd = even} always.
     * @return the boolean value if the specified integer is odd or not
     */
    public static boolean isOdd(int a) {
        return a % 2 != 0;
    }

    /**
     * @param a has to be integer - can be negative - cannot be a decimal value
     * because this destroys the property of addition rules for even or odd numbers which states that
     * {@code even + even = even} and {@code odd + odd = even} always.
     * @return the boolean value if the specified integer is even or not
     */
    public static boolean isEven(long a) {
        return a % 2 != 0;
    }

    /**
     * @param a has to be integer - cannot be negative - cannot be a decimal value - cannot be zero
     * @return the boolean value if the specified integer is composite or not
     */
    public static boolean isComposite(long a) {
        List<Long> factors = factorize(a);
        if(a == 0) {
            throw new ArithmeticException("Zero is not prime nor composite");
        } else if(a < 0) {
            throw new ArithmeticException("Negative numbers cannot be composite or prime - and so are not accepted");
        } else {
            return factors.size() > 2;
        }
    }

    /**
     * @param a has to be integer - cannot be negative - cannot be a decimal value -
     * cannot be zero - if a is one then it is not prime because it needs
     * to have two distinct integers to divide by - one only has one and itself
     * which are equal - this does not match the description for a prime number so this is false
     * @return the boolean value if the specified integer is prime or not
     */
    public static boolean isPrime(long a) {
        List<Long> factors = factorize(a);
        if(a == 0) {
            throw new ArithmeticException("Zero is not prime nor composite");
        } else if(a < 0) {
            throw new ArithmeticException("Negative numbers cannot be composite or prime - and so are not accepted");
        } else {
            return factors.contains(1L) && factors.contains(a) && factors.size() == 2;
        }
    }
}