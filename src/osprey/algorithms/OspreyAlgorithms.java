package osprey.algorithms;

import osprey.statistics.Statistics;

public final class OspreyAlgorithms extends Statistics {

    private OspreyAlgorithms() {};

    public static double[] bubbleSort(double[] data) {
        double temp;
        boolean changed;
        do {
            changed = false;
            for(int j = 0; j < data.length - 1; j++)
                if(data[j] > data[j + 1]) {
                    temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                    changed = true;
                }
        } while(changed);
        return data;
    }

    public static double linearSearch(double[] arr, int searchAtElement, boolean firstSortThenSearch) {
        if(firstSortThenSearch) {
            double[] sortedArray = bubbleSort(arr);
            for (int index = 0; index < sortedArray.length; index++) {
                if (sortedArray[index] == searchAtElement) {
                    return index;
                }
            }
        } else {
            for (int index = 0; index < arr.length; index++) {
                if (arr[index] == searchAtElement) {
                    return index;
                }
            }
        }
        return -1;
    }

    public static double[] reverse(double[] array, boolean reverseAfterSort) {
        if(reverseAfterSort) {
            double[] sorted = bubbleSort(array);
            double i, temp;
            for (i = 0; i < sorted.length / 2d; i++) {
                temp = sorted[(int) i];
                sorted[(int) i] = sorted[(int) (sorted.length - i - 1)];
                sorted[(int) (sorted.length - i - 1)] = temp;
            }
            return sorted;
        } else {
            double i, temp;
            for (i = 0; i < array.length / 2d; i++) {
                temp = array[(int) i];
                array[(int) i] = array[(int) (array.length - i - 1)];
                array[(int) (array.length - i - 1)] = temp;
            }
            return array;
        }
    }

    public static boolean isSorted(double[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkReversed(double[] x, double[] y) {
        if (x.length != y.length) {
            return false;
        }
        for (int i = 0; i < x.length; i++) {
            if (x[i] != y[y.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isReversed(double[] array) {
        
        return true;
    }


}
