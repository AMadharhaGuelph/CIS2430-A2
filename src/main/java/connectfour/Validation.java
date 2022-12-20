package connectfour;

import java.io.File;
import java.io.IOException;

/**
 * The Validation class is responsible for validating passed values. The methods
 * throw exceptions if the value is invalid.
 * @author Ankush Madharha
 */

public class Validation {
    public void validateMenuChoice(int menuChoice) {
        if(menuChoice != 1 && menuChoice != 2) {
            throw new MenuOutOfBoundsException("Out of Bounds Choice.");
        }
    }

    public void validateColumnChoice(int columnChoice) {
        if((columnChoice != -1) && (columnChoice < 1 || columnChoice > 7)) {
            throw new IllegalColumnException("Invalid Column Choice.");
        }
    }

    public void validateFile(File file) {
        try {
            if(!file.createNewFile()) {
                throw new SaveAlreadyExistsException("Save already exists!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void validateFileRow(String[] rowElements) {
        if(rowElements.length != 7) {
            throw new InvalidElementAmountInRowException("Invalid amount of elements in a row!");
        }
    }

    public void validateAmountOfRows(int rows) {
        if(rows != 6) {
            throw new InvalidAmountOfRowsException("Invalid amount of rows");
        }
    }

    public void validateBoardPosition(Board board) {
        int numPlayerX = board.getNumberOfPlayer(Player.X);
        int numPlayerO = board.getNumberOfPlayer(Player.O);

        if(numPlayerX > numPlayerO+1) {
            throw new ImpossiblePositionException("This position cannot be reached in connect 4.");
        }
        if(numPlayerO > numPlayerX+1) {
            throw new ImpossiblePositionException("This position cannot be reached in connect 4.");
        }
    }

    public String toString() {
        return "Validation";
    }
}
