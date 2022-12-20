package connectfour;

/**
 * This exceptions should be thrown when a loaded board has an
 * invalid amount of rows.
 * @author Ankush Madharha
 */

public class InvalidAmountOfRowsException extends RuntimeException {
    // No args constructor
    public InvalidAmountOfRowsException(){}

    public InvalidAmountOfRowsException(String message) {
        super(message);
    }

    public InvalidAmountOfRowsException(Throwable cause) {
        super(cause);
    }

    public InvalidAmountOfRowsException(String message, Throwable cause) {
        super(message, cause);
    }
}