package inspira.statistics;

import inspira.basic.BasicOperations;

import java.util.Arrays;

public class Statistics {

    public static double arithmeticMean(double[] values) {
        return BasicOperations.divide(BasicOperations.add(values), values.length);
    }

    public static double range(double[] values) {
        return BasicOperations.subtract(getMax(values), getMin(values));
    }

    public static double median(double[] values) {
        // sort array
        Arrays.sort(values);
        double median;
        // get count of scores
        int totalElements = values.length;
        // check if total number of scores is even
        if (totalElements % 2 == 0) {
            double sumOfMiddleElements = values[totalElements / 2] +
                    values[totalElements / 2 - 1];
            // calculate average of middle elements
            median = sumOfMiddleElements / 2;
        } else {
            // get the middle element
            median = values[values.length / 2];
        }
        return median;
    }

    public static double mode(double[] values) {
        double maxValue = 0.0, maxCount = 0.0, i, j;
        for (i = 0; i < values.length; ++i) {
            int count = 0;
            for (j = 0; j < values.length; ++j) {
                if (values[(int) j] == values[(int) i])
                    count++;
            }
            if (count > maxCount) {
                maxCount = count;
                maxValue = values[(int) i];
            }
        }
        return maxValue;
    }

    // Method for getting the maximum value
    public static double getMax(double[] inputArray){
        double maxValue = inputArray[0];
        for(int i=1;i < inputArray.length;i++){
            if(inputArray[i] > maxValue){
                maxValue = inputArray[i];
            }
        }
        return maxValue;
    }

    // Method for getting the minimum value
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
