package osprey.sequences;

import java.io.Serializable;

public final class SequenceIndexException extends ArrayIndexOutOfBoundsException implements Serializable {

    public static final long serialVersionUID = 972639917239242328L;

    public SequenceIndexException(String s) {
        super(s);
    }
}
