package osprey.sequences.impl;

import osprey.sequences.SequenceIndexException;
import osprey.sequences.SequenceType;
import osprey.sequences.impl.base.Sequences;

public final class ArithmeticSequences extends Sequences implements SequenceType {

    private ArithmeticSequences() {};

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

    
    public static double continuedSumOfTermsUpToNth(double[] sequence, int nthTermToStopAt, boolean findNthTermAndContinueSum) {
        double sum;
        if(SequenceType.isArithmeticSequence(sequence)) {
            if(findNthTermAndContinueSum && nthTermToStopAt > sequence.length) {
                double nthTermValue = findNthTermOfArithmeticSequence(sequence, nthTermToStopAt);
                double firstTermValue = sequence[0];
                double commonDifference = findCommonDiffInArithmeticSequence(sequence);
                sum = Sequences.sumOfRangeOfNumbersAsArithmetic(firstTermValue, nthTermValue, commonDifference);
            } else if(!findNthTermAndContinueSum && nthTermToStopAt > sequence.length) {
                throw new SequenceIndexException("Chosen nth term out of bounds - findNthTermAndContinueSum was set to false \nTip: to calculate sum over the bounds - make sure to set findNthTermAndContinueSum = true");
            } else {
                return Sequences.sumOfTermsInSequence(sequence, nthTermToStopAt);
            }
        } else {
            return -1;
        }
        return sum;
    }

    public static double findMeanOfTwoTermsInArithmeticSequence(double[] sequence, int term, int anotherTerm) {
        if(SequenceType.isArithmeticSequence(sequence)) {
            double termValue = findNthTermOfArithmeticSequence(sequence, term);
            double anotherTermValue = findNthTermOfArithmeticSequence(sequence, anotherTerm);
            return (termValue + anotherTermValue) / 2;
        } else {
            return -1;
        }
    }

    public static double[] constructArithmeticSequence(double firstTermValue, double commonDifference, int constructUpToTerm) {
        double[] constructedArithmeticSequence = new double[constructUpToTerm];
        for(int i = 0; i <= constructedArithmeticSequence.length-1; i++) {
            if(i==0) {
                constructedArithmeticSequence[0] = firstTermValue;
            } else {
                constructedArithmeticSequence[i] = firstTermValue += commonDifference;
            }
        }
        return constructedArithmeticSequence;
    }
}
