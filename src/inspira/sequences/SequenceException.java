package inspira.sequences;

import java.io.Serializable;

public final class SequenceException extends ArithmeticException implements Serializable {

    public static final long serialVersionUID = 927118283299193929L;

    public SequenceException(String s) {
        super(s);
    }
}
