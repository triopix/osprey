package inspira.sequences.impl;

import inspira.basic.BasicOperations;
import inspira.sequences.SequenceException;
import inspira.sequences.SequenceIndexException;
import inspira.sequences.SequenceType;
import inspira.sequences.impl.base.Sequence;

import java.util.ArrayList;

public class ArithmeticSequence extends Sequence implements SequenceType {

    public static double findCommonDiffInArithmeticSequence(double[] arithmeticSequence) {
        double d = arithmeticSequence[1] - arithmeticSequence[0];
        if (SequenceType.isArithmeticSequence(arithmeticSequence)) {
            for (int i = 2; i < arithmeticSequence.length; i++) {
                if (arithmeticSequence[i] - arithmeticSequence[i - 1] != d) {
                    return -1;
                }
            }
        }
        return d;
    }

    public static double findNthTermOfArithmeticSequence(double[] arithmeticSequence, int term) {
        double commonDifference = findCommonDiffInArithmeticSequence(arithmeticSequence);
        double firstTermValue = arithmeticSequence[0];
        double termValue;
        termValue = firstTermValue + ((term - 1) * commonDifference);
        if (SequenceType.isArithmeticSequence(arithmeticSequence)) {
            return termValue;
        }
        return -1;
    }

    //still under construction!
    public static double continuedSumOfTermsUpToNth(double[] sequence, int nthTermToStopAt, boolean findNthTermAndContinueSum) {
        double sum;
        if(SequenceType.isArithmeticSequence(sequence)) {
            if(findNthTermAndContinueSum && nthTermToStopAt > sequence.length) {
                double nthTermValue = findNthTermOfArithmeticSequence(sequence, nthTermToStopAt);
                double firstTermValue = sequence[0];
                double commonDifference = findCommonDiffInArithmeticSequence(sequence);
                sum = Sequence.sumOfRangeOfNumbers(firstTermValue, nthTermValue, commonDifference);
            } else if(!findNthTermAndContinueSum && nthTermToStopAt > sequence.length) {
                throw new SequenceIndexException("Chosen nth term out of bounds - findNthTermAndContinueSum was set to false \nTip: to calculate sum over the bounds - make sure to set findNthTermAndContinueSum = true");
            } else {
                return Sequence.sumOfTermsInSequence(sequence, nthTermToStopAt);
            }
        } else {
            return -1;
        }
        return sum;
    }
}
