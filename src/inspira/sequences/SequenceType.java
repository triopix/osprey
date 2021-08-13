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

    //todo add isGeometricSequence() method

}

final class ExceptionMessage {

    public static final String ARITHMETIC_SEQUENCE_EXCEPTION = "Could not identify arithmetic sequence \nTip #1: Recheck values given in sequence \n" +
            "Tip #2: Make sure common differences are equal and constant - for example, 2 and -2 are not the same common differences";

    //todo place geometric sequence exception message here

}
