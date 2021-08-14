package inspira.sequences;

public interface SequenceType {

    static boolean isArithmeticSequence(double[] sequence) {
        if (sequence.length == 1)
            return true;
        double d = sequence[1] - sequence[0];
        for (int i = 2; i < sequence.length; i++)
            if (sequence[i] - sequence[i - 1] != d) {
                throw new SequenceException(ExceptionMessage.ARITHMETIC_SEQUENCE_EXCEPTION);
            }
        return true;
    }

    static boolean isGeometricSequence(double[] geometricSequence) {
        if (geometricSequence.length == 1)
            return true;
        double commonRatio = geometricSequence[1] / geometricSequence[0];
        for (int i = 2; i < geometricSequence.length; i++)
            if (geometricSequence[i] / geometricSequence[i - 1] != commonRatio) {
                throw new SequenceException(ExceptionMessage.GEOMETRIC_SEQUENCE_EXCEPTION);
            }
        return true;
    }
}

final class ExceptionMessage {

    public static final String ARITHMETIC_SEQUENCE_EXCEPTION = "Could not identify arithmetic sequence \nTip #1: Recheck values given in sequence \n" +
            "Tip #2: Make sure common differences are equal and constant - for example, 2 and -2 are not the same common differences";

    public static final String GEOMETRIC_SEQUENCE_EXCEPTION = "Could not identify geometric sequence \nTip: Recheck given values in sequence \n" +
            "Tip 2: Make sure the common ratio is equal and constant - geometric sequences are created by multiplying terms by a common ratio such as -2 or 2 each time \n" +
            "For example: The sequence {2, 4, 8, 16, 32} is a geometric sequence because the common ratio is 2. Here we multiply the terms by 2 each time";
}