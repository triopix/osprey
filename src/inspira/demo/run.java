package inspira.demo;

import inspira.basic.BasicOperations;
import inspira.sequences.SequenceType;
import inspira.sequences.impl.ArithmeticSequence;
import inspira.sequences.impl.GeometricSequence;
import inspira.sequences.impl.base.Sequence;

public class run {
    public static void main(String[] args) {
        double[] geometricSequence = {2, 4, 8, 16, 32};
        double[] arithmeticSequence = {2, 4, 6, 8, 10};
        double test = BasicOperations.factorial(5);
        System.out.println(test);

        //testing constants

//        System.out.println(MathConstants.UNITS_SQUARED);
//        System.out.println(MathConstants.PI);
//        System.out.println(MathConstants.E);
    }
}
