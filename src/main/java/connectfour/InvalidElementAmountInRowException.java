package connectfour;

/**
 * This exception should be thrown when a loaded board contains a row
 * with an invalid amount of elements.
 * @author Ankush Madharha
 */

public class InvalidElementAmountInRowException extends RuntimeException {
    // No args constructor
    public InvalidElementAmountInRowException(){}

    public InvalidElementAmountInRowException(String message) {
        super(message);
    }

    public InvalidElementAmountInRowException(Throwable cause) {
        super(cause);
    }

    public InvalidElementAmountInRowException(String message, Throwable cause) {
        super(message, cause);
    }
}