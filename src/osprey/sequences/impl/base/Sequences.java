package osprey.sequences.impl.base;

import osprey.base.BasicOperations;
import osprey.statistics.Statistics;

import java.util.Arrays;
import java.util.List;

public class Sequences {

    //general sequence calculations - regardless of geometric or arithmetic types

    public static double sumOfTermsInSequence(double[] sequence) {
        return BasicOperations.add(sequence);
    }

    public static double sumOfTermsInSequence(double[] sequence, int nthTermToStopAt) {
        double sum = 0;
        for (int i = 0; i <= nthTermToStopAt-1; i++) {
            sum += sequence[i];
        }
        return sum;
    }

    public static double sumOfRangeOfNumbers(double start, double end) {
        int sum = 0;
        for (double i = start; i <= end; i++) {
            sum += i;
        }
        return sum;
    }

    public static double sumOfRangeOfNumbersAsArithmetic(double start, double end, double step) {
        int sum = 0;
        for (double i = start; i <= end; i += step) {
            sum += i;
        }
        return sum;
    }

    //for geometric
    public static double sumOfRangeOfNumbersAsGeometric(double start, double end, double step) {
        int sum = 0;
        for (double i = start; i <= end; i *= step) {
            sum += i;
        }
        return sum;
    }


    public static double getTotalNumberOfTermsInSequence(double[] sequence) {
        return sequence.length;
    }

    //applications of statistics in sequences - probably not a good idea as it destroys the idea or concept of sequences
    //ahh but who cares - there all just numbers! - but don't worry these methods are free of bugs! :)
    public static double getMaxOfSequence(double[] sequence) {
        return Statistics.getMax(sequence);
    }

    public static double getMinOfSequence(double[] sequence) {
        return Statistics.getMin(sequence);
    }

    public static double arithmeticMeanOfSequence(double[] sequence) {
        return Statistics.arithmeticMean(sequence);
    }

    public static List<Double> modeOfSequence(double[] sequence) {
        return Statistics.mode(sequence);
    }

    public static double medianOfSequence(double[] sequence) {
        return Statistics.median(sequence);
    }

    public static double rangeOfSequence(double[] sequence) {
        return Statistics.range(sequence);
    }

    public static void printSequence(double[] sequence) {
        System.out.println(Arrays.toString(sequence));
    }

    //sorting and searching algorithms go here as well from the compsci package
}
