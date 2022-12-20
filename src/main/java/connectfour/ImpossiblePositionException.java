package connectfour;

/**
 * This excpetion should be thrown when a board position is 
 * not possible to be reached in connect four.
 * @author Ankush Madharha
 */

public class ImpossiblePositionException extends RuntimeException {
    // No args constructor
    public ImpossiblePositionException(){}

    public ImpossiblePositionException(String message) {
        super(message);
    }

    public ImpossiblePositionException(Throwable cause) {
        super(cause);
    }

    public ImpossiblePositionException(String message, Throwable cause) {
        super(message, cause);
    }
}