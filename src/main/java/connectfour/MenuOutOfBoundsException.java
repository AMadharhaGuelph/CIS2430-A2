package connectfour;

/**
 * This exception should be thrown when the user chooses an invalid
 * menu option.
 * @author Ankush Madharha
 */

public class MenuOutOfBoundsException extends RuntimeException {
    // No args constructor
    public MenuOutOfBoundsException(){}

    public MenuOutOfBoundsException(String message) {
        super(message);
    }

    public MenuOutOfBoundsException(Throwable cause) {
        super(cause);
    }

    public MenuOutOfBoundsException(String message, Throwable cause) {
        super(message, cause);
    }
}