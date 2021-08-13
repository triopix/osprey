package inspira.sequences.impl.base;

import inspira.basic.BasicOperations;
import inspira.statistics.Statistics;

public class Sequence {

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

    public static double sumOfRangeOfNumbers(double start, double end, double step) {
        int sum = 0;
        for (double i = start; i <= end; i += step) {
            sum += i;
        }
        return sum;
    }


    public static double getTotalNumberOfTermsInSequence(double[] sequence) {
        return sequence.length;
    }

    //applications of statistics in sequences
    public static double getMaxOfSequence(double[] sequence) {
        return Statistics.getMax(sequence);
    }

    public static double getMinOfSequence(double[] sequence) {
        return Statistics.getMin(sequence);
    }

    public static double arithmeticMeanOfSequence(double[] sequence) {
        return Statistics.arithmeticMean(sequence);
    }

    public static double modeOfSequence(double[] sequence) {
        return Statistics.mode(sequence);
    }

    public static double medianOfSequence(double[] sequence) {
        return Statistics.median(sequence);
    }

    public static double rangeOfSequence(double[] sequence) {
        return Statistics.range(sequence);
    }
}
