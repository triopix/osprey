package osprey.demo;

import osprey.sequences.SequenceType;
import osprey.sequences.impl.ArithmeticSequences;

public class run {

    public static void main(String[] args) {

        double[] myConstructedArithmeticSequence = ArithmeticSequences.constructArithmeticSequence(2, -3, 10);
        ArithmeticSequences.printSequence(myConstructedArithmeticSequence);

        //check for common difference
        System.out.println(ArithmeticSequences.findCommonDiffInArithmeticSequence(myConstructedArithmeticSequence));
    }
}