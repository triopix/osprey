package inspira.demo;

import inspira.sequences.impl.ArithmeticSequence;

public class run {
    public static void main(String[] args) {
        double[] mySequence = {2, 4, 6};
        double basicTest = ArithmeticSequence.continuedSumOfTermsUpToNth(mySequence, 3, false);
        System.out.println(basicTest);

        //testing constants

//        System.out.println(MathConstants.UNITS_SQUARED);
//        System.out.println(MathConstants.PI);
//        System.out.println(MathConstants.E);
    }
}
