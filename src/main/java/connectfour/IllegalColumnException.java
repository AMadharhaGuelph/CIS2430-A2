package connectfour;

/**
 * This exception should be thrown when the user attempts to choose
 * an illegal column (not 1-7).
 * @author Ankush Madharha
 */

public class IllegalColumnException extends RuntimeException {
    // No args constructor
    public IllegalColumnException(){}

    public IllegalColumnException(String message) {
        super(message);
    }

    public IllegalColumnException(Throwable cause) {
        super(cause);
    }

    public IllegalColumnException(String message, Throwable cause) {
        super(message, cause);
    }
}