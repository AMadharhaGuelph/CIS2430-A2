package connectfour;

/**
 * This excpetion should be thrown when the board is being 
 * saved to a file that already exists.
 * @author Ankush Madharha
 */

public class SaveAlreadyExistsException extends RuntimeException {
    // No args constructor
    public SaveAlreadyExistsException(){}

    public SaveAlreadyExistsException(String message) {
        super(message);
    }

    public SaveAlreadyExistsException(Throwable cause) {
        super(cause);
    }

    public SaveAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}