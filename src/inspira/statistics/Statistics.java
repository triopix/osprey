package inspira.statistics;

import inspira.base.BasicOperations;

import java.util.*;

public class Statistics {

    public static double arithmeticMean(double[] values) {
        return BasicOperations.divide(BasicOperations.add(values), values.length);
    }

    public static double range(double[] values) {
        return BasicOperations.subtract(getMax(values), getMin(values));
    }

    public static double median(double[] values) {
        Arrays.sort(values);
        double median;
        int totalElements = values.length;
        if (totalElements % 2 == 0) {
            double sumOfMiddleElements = values[totalElements / 2] +
                    values[totalElements / 2 - 1];
            median = sumOfMiddleElements / 2;
        } else {
            median = values[values.length / 2];
        }
        return median;
    }

    public static List<Double> mode(double[] m) {
        HashMap<Double, Double> freqs = new HashMap<>();
        for (double d : m) {
            Double freq = freqs.get(d);
            freqs.put(d, (freq == null ? 1 : freq + 1));
        }
        List<Double> mode = new ArrayList<>();
        List<Double> frequency = new ArrayList<>();
        List<Double> values = new ArrayList<>();

        for (Map.Entry<Double, Double> entry : freqs.entrySet()) {
            frequency.add(entry.getValue());
            values.add(entry.getKey());
        }
        double max = Collections.max(frequency);

        for(int i=0; i< frequency.size();i++)
        {
            double val = frequency.get(i);
            if(max == val && getOccurrences(m, values.get(i)) != 1) {
                mode.add(values.get(i));
            }
        }
        return mode;
    }

    public static int getOccurrences(double[] values, double numToCheck) {
        int frequencies = 0;
        for (double value : values) {
            if (numToCheck == value) {
                frequencies++;
            }
        }
        return frequencies;
    }

    public static double getMax(double[] inputArray){
        double maxValue = inputArray[0];
        for(int i=1;i < inputArray.length;i++){
            if(inputArray[i] > maxValue){
                maxValue = inputArray[i];
            }
        }
        return maxValue;
    }

    public static double getMin(double[] inputArray){
        double minValue = inputArray[0];
        for(int i=1;i<inputArray.length;i++){
            if(inputArray[i] < minValue){
                minValue = inputArray[i];
            }
        }
        return minValue;
    }
}
