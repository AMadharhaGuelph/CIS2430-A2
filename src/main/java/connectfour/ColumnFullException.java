package connectfour;

/**
 * This exception should be thrown when the user attempts to place
 * a Player into a full column.
 * @author Ankush Madharha
 */

public class ColumnFullException extends RuntimeException {
    // No args constructor
    public ColumnFullException(){}

    public ColumnFullException(String message) {
        super(message);
    }

    public ColumnFullException(Throwable cause) {
        super(cause);
    }

    public ColumnFullException(String message, Throwable cause) {
        super(message, cause);
    }
}