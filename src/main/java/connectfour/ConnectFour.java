package connectfour;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * The ConnectFour class is responsible for running the game. This includes keeptrack of player turns
 * and having methods to display the menu, creating a new game, loading an existing game, saving a game,
 * etc. It works with the TextUI class for input/output.
 * @author Ankush Madharha
 */

public class ConnectFour{

    private static final TextUI UI = new TextUI();
    private static final Validation VALIDATION = new Validation();

    public static void main(String[] args) {
        UI.outputIntro();
        displayMenu();
    }

    private static void displayMenu() {
        int menuChoice;

        UI.outputMenu();
        
        do {
            try {
                menuChoice = UI.inputMenuChoice();
                break;
            } catch(MenuOutOfBoundsException mbe) {
                UI.outputMenuOutOfBoundsMessage();
            }
        } while(true);
        
        switch(menuChoice) {
            case 1:
                newGame();
                break;
            default:
                loadGame();
        }
    }

    private static void newGame() {
        Board board = new Board();

        runGame(board, 0);
    }

    private static void loadGame() {
        Board board = new Board();
        String path;
        String fileName;
        int rows = 0;
        String st;
        int turnCounter = 0;

        path = UI.inputFilePath();
        fileName = UI.inputFileName();

        File file = new File("././././" + path + fileName);
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            while((st = br.readLine()) != null) {
                if(!st.isBlank()) {
                    rows++;
                }
            }
            VALIDATION.validateAmountOfRows(rows);
        } catch(IOException ioe) {
            UI.outputFileNotFoundMessage();
            displayMenu();
        } catch(InvalidAmountOfRowsException iare) {
            UI.outputInvalidAmountOfRowsMessage();
            displayMenu();  
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            board.loadBoardFromFile(file);
        } catch(InvalidElementAmountInRowException ieare) {
            UI.outputInvalidElementAmountInRowMessage();
            displayMenu();
        }
        try {
            VALIDATION.validateBoardPosition(board);
        } catch(ImpossiblePositionException ipe) {
            UI.outputImpossiblePositionMessage();
            displayMenu();
        }

        turnCounter = determineTurnCounter(board);
        runGame(board, turnCounter);
    }

    private static int determineTurnCounter(Board board) {
        int numPlayerX = board.getNumberOfPlayer(Player.X);
        int numPlayerO = board.getNumberOfPlayer(Player.O);
        int turnCounter = 0;
 
        if(board.checkForWin() == ' ' && !board.isFull()) {
            if(numPlayerX == numPlayerO) {
                do {
                    try {
                        turnCounter = UI.inputTurn()-1;
                        break;
                    } catch(MenuOutOfBoundsException mbe) {
                        UI.outputMenuOutOfBoundsMessage();
                    }
                } while(true);
            } else if(numPlayerX > numPlayerO) {
                return 1;
            } else if(numPlayerO < numPlayerX) {
                return 0;
            }
        }

        return turnCounter;
    }

    private static void runGame(Board board, int turnCounter) {
        int columnChoice = 0;
        char winner;

        while(true) {
            UI.outputBoard(board);
            Player turn = whichTurn(turnCounter);

            winner = board.checkForWin();
            if(winner != ' ') {
                UI.outputWinner(winner);
                break;
            }
            if(board.isFull()) {
                UI.outputTie();
                break;
            }

            do {
                try {
                    columnChoice = getColumnChoice(turn);
                    if(columnChoice == -1) { 
                        saveGame(board);
                    } else {
                        board.setPlayerInColumn(columnChoice, turn);
                        turnCounter++;
                    }
                    break;
                } catch(ColumnFullException cfe) {
                    UI.outputColumnFullMessage(columnChoice);
                }
            } while(true);
        }
    }

    private static void saveGame(Board board) {
        File file = null;

        do {
            try {
                String fileName = UI.inputFileName();
                file = new File("././././assets/"+fileName);
                VALIDATION.validateFile(file);
                break;
            } catch(SaveAlreadyExistsException saee) {
                if(UI.inputOverride()) {
                    break;
                }   
            }
        }while(true);

        board.saveBoardToFile(file);
    }
    
    private static Player whichTurn(int turnCounter) {
        if(turnCounter % 2 == 0) {
            return Player.X;
        }
        return Player.O;
    }

    private static int getColumnChoice(Player turn) {
        int columnChoice;

        do {
            try {
                columnChoice = UI.inputPlayerMove(turn);
                break;
            } catch(IllegalColumnException ice) {
                UI.outputIllegalColumnMessage();
            }
        } while(true);

        return columnChoice;
    }
}