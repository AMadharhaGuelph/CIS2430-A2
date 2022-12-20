package connectfour;

import java.util.Scanner;

/**
 * The TextUI class is responsible for output and input. All the methods
 * within this class output some message to the user or input a desired value.
 * @author Ankush Madharha
 */

public class TextUI{

    private Scanner sc = new Scanner(System.in);
    private Validation validation = new Validation();

    public void outputIntro() {
        System.out.println("-- Welcome to Connect 4! --\n");
    }

    public void outputMenu() {
        System.out.println("Choose one of the following options:");
        System.out.println("\t1. Start a new game!");
        System.out.println("\t2. Load a previous game.");
    }

    public int inputMenuChoice() {
        int menuChoice = 0;

        do {
            try {
                System.out.print("Enter: ");
                menuChoice = Integer.parseInt(sc.nextLine());
                break;
            } catch(NumberFormatException nfe) {
                System.out.println("Enter an integer.");
            }
        }while(true);
        validation.validateMenuChoice(menuChoice);

        return menuChoice;
    }

    public void outputMenuOutOfBoundsMessage() {
        System.out.println("Out of Bounds Choice. Enter 1 or 2.");
    }

    public void outputBoard(Board board) {
        System.out.println("\n" + board);
    }

    public int inputPlayerMove(Player player) {
        int columnChoice;

        do {
            try {
                System.out.print(player + "\'s Turn. Choose a column (1-7) or enter \'-1\' to save the game.: ");
                columnChoice = Integer.parseInt(sc.nextLine());
                break;
            } catch(NumberFormatException nfe) {
                System.out.println("Enter an integer.");
            }
        }while(true);
        validation.validateColumnChoice(columnChoice);

        return columnChoice;
    }

    public void outputIllegalColumnMessage() {
        System.out.println("Invalid Choice!");
    }

    public void outputColumnFullMessage(int columnChoice) {
        System.out.println("Column " + columnChoice + " is full. Please choose a different column.");
    }

    public String inputFilePath() {
        String path = "";

        System.out.print("\nEnter the file path (the file must be within the A2 folder.): ");
        path = sc.nextLine();

        return path;
    }

    public String inputFileName() {
        String fileName = "";

        System.out.print("Enter the name of the file (extension included): ");
        fileName = sc.nextLine();

        return fileName;
    }

    public void outputFileNotFoundMessage() {
        System.out.println("Could not find file.\n");
    }

    public void outputWinner(char winner) {
        System.out.println(winner + " Wins!");
    }

    public void outputTie() {
        System.out.println("Tie Game!");
    }

    public boolean inputOverride() {
        System.out.print("This save already exists, would you like to override it? (yes to override): ");
        String choice = sc.nextLine();
        if(choice.trim().equalsIgnoreCase("yes")) {
            return true;
        }
        return false;
    }

    public void outputInvalidAmountOfRowsMessage() {
        System.out.println("There is an incorrect amount of rows within the file.\n");
    }

    public void outputInvalidElementAmountInRowMessage() {
        System.out.println("Invalid amount of elements in a row!\n");
    }

    public int inputTurn() {
        int turnCounter;

        do {
            try {
                System.out.print("Which player is going first? (1 for X or 2 for O): ");
                turnCounter = Integer.parseInt(sc.nextLine());
                break;
            } catch(NumberFormatException nfe) {
                System.out.println("Enter an integer.");
            }
        }while(true);
        validation.validateMenuChoice(turnCounter);

        return turnCounter;
    }

    public void outputImpossiblePositionMessage() {
        System.out.println("This save file contains a position that is not possible in a game of connect 4.\n");
    }

    @Override
    public String toString() {
        return "-- Welcome to Connect 4! --\n";
    }
}