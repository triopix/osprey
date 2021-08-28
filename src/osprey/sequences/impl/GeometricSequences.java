package osprey.sequences.impl;

import osprey.radexp.RadicalExponents;
import osprey.sequences.SequenceIndexException;
import osprey.sequences.SequenceType;
import osprey.sequences.impl.base.Sequences;

public final class GeometricSequences extends Sequences implements SequenceType {

    private GeometricSequences() {};

    public static double findCommonRatioOfGeometricSequence(double[] sequence) {
        double commonRatio = sequence[1] / sequence[0];
        if(SequenceType.isGeometricSequence(sequence)) {
            for (int i = 2; i < sequence.length; i++) {
                if (sequence[i] / sequence[i - 1] != commonRatio) {
                    return -1;
                }
            }
        }
        return commonRatio;
    }

    public static double findNthTermInGeometricSequence(double[] sequence, int term) {
        double commonRatio = findCommonRatioOfGeometricSequence(sequence);
        double firstTermValue = sequence[0];
        double termValue;
        termValue = firstTermValue * (RadicalExponents.pow(commonRatio, term-1));
        if (SequenceType.isGeometricSequence(sequence)) {
            return termValue;
        }
        return -1;
    }

    public static double continuedSumOfTermsUpToNth(double[] sequence, int nthTermToStopAt, boolean findNthTermAndContinueSum) {
        double sum;
        if(SequenceType.isGeometricSequence(sequence)) {
            if(findNthTermAndContinueSum && nthTermToStopAt > sequence.length) {
                double nthTermValue = findNthTermInGeometricSequence(sequence, nthTermToStopAt);
                double firstTermValue = sequence[0];
                double commonRatio = findCommonRatioOfGeometricSequence(sequence);
                sum = Sequences.sumOfRangeOfNumbersAsGeometric(firstTermValue, nthTermValue, commonRatio);
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

    public static double findMeanOfTwoTermsInGeometricSequence(double[] sequence, int term, int anotherTerm) {
        if(SequenceType.isGeometricSequence(sequence)) {
            double termValue = findNthTermInGeometricSequence(sequence, term);
            double anotherTermValue = findNthTermInGeometricSequence(sequence, anotherTerm);
            return RadicalExponents.sqrt(termValue * anotherTermValue);
        } else {
            return -1;
        }
    }

    public static double[] constructGeometricSequence(double firstTermValue, double commonRatio, int constructUpToTerm) {
        double[] constructedArithmeticSequence = new double[constructUpToTerm];
        int i;
        for(i = 0; i <= constructedArithmeticSequence.length-1; i++) {
            if(i==0) {
                constructedArithmeticSequence[0] = firstTermValue;
            } else {
                constructedArithmeticSequence[i] = firstTermValue *= commonRatio;
            }
        }
        return constructedArithmeticSequence;
    }
}
