package connectfour;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

/**
 * The Board class is responsible for anything to do with changing or interacting with the board. You can set Players
 * in columns, get Players in specific board positions, clear the board, check the board for a win, and check if the 
 * board is full. Also, you can load boards and save boards to files.
 * @author Ankush Madharha
 */

public class Board{
    private final int boardRows = 6;
    private final int boardCols = 7;
    private char[][] board = new char[boardRows][boardCols];
    private final Validation validation = new Validation();

    /**
     * Constructs a new empty board.
     */
    public Board() {
        for(char[] row: board) {
            Arrays.fill(row, ' ');
        }
    }

    /**
     * Clears all positions within the board.
     */
    public void clearBoard() {
        for(char[] row: board) {
            Arrays.fill(row, ' ');
        }
    }

    /**
     * Given a column, it will drop the specified player into the next empty position in that column.
     * @param columnChoice The column where the player is dropped.
     * @param player The player that is dropped into the column.
     */
    public void setPlayerInColumn(int columnChoice, Player player) {
        for(int r = boardRows-1; r >= 0; r--) {
            if(board[r][columnChoice-1] == ' ') {
                board[r][columnChoice-1] = player.toString().charAt(0);
                return;
            }
        }

        throw new ColumnFullException("Column Full!");
    }

    /**
     * Sets any specific position on the board to a specified character value.
     * @param row The row where the character is to be placed.
     * @param col The column where the character is to be placed.
     * @param value The character to be put into the board.
     */
    public void setSpecificPosition(int row, int col, char value) {
        board[row][col] = value; 
    }

    /**
     * Retrieve a character from a specified position on the board.
     * @param row The row where the desired character is located.
     * @param col The column where the desired character is located.
     * @return The character located at the specified row and column.
     */
    public char getSpecificPosition(int row, int col) {
        return board[row][col];
    }

    /**
     * Get the number of a specified player on the board.
     * @param player The player on the board that is being counted.
     * @return The number of positions occupied by a specified player.
     */
    public int getNumberOfPlayer(Player player) {
        int num = 0;
        char play = player.toString().charAt(0);

        for(int r = 0; r < boardRows; r++) {
            for(int c = 0; c < boardCols; c++) {
                if(board[r][c] == play) {
                    num++;
                }
            }
        }
        return num;
    }

    /**
     * Checks the current state of a board for a win. A win constitutes as four in a row horizontally, 
     * vertically, or diagonally of a specific player.
     * @return returns a blank space character is there is no win or if there is a win then the player who
     * won.
     */
    public char checkForWin() {
        for(int r = 0; r < boardRows; r++) {
            for(int c = 0; c < boardCols; c++) {
                if(board[r][c] == ' ') {
                    continue;
                }
                if(r < 3) { // CHECK DOWN
                    if(checkDownWin(r, c)) {
                        return board[r][c];
                    }
                }
                if(c == 3) { // CHECK RIGHT AND LEFT
                    if(checkRightWin(r, c) || checkLeftWin(r, c)) {
                        return board[r][c];
                    }
                }
                if(c < 4 && r < 3) {    // CHECK DOWN-RIGHT
                    if(checkDownRightWin(r,c)) {
                        return board[r][c];
                    }
                }
                if(c > 2 && r < 3) {    // CHECK DOWN-LEFT
                    if(checkDownLeftWin(r,c)) {
                        return board[r][c];
                    }
                }
            }
        }
       return ' ';
    }

    private boolean checkDownWin(int r, int c) {
        if(board[r][c] == board[r+1][c] && board[r+1][c] == board[r+2][c] && board[r+2][c] == board[r+3][c]) {
             return true; 
        }
        return false;
    }

    private boolean checkRightWin(int r, int c) {
        if(board[r][c] == board[r][c+1] && board[r][c+1] == board[r][c+2] && board[r][c+2] == board[r][c+3]) {
            return true;
        }
        return false;
    }

    private boolean checkLeftWin(int r, int c) {
        if(board[r][c] == board[r][c-1] && board[r][c-1] == board[r][c-2] && board[r][c-2] == board[r][c-3]) {
            return true;
        }
        return false;
    }

    private boolean checkDownLeftWin(int r, int c) {
        if(board[r][c] == board[r+1][c-1] && board[r+1][c-1] == board[r+2][c-2] && board[r+2][c-2] == board[r+3][c-3]) {
            return true;
        }
        return false;
    }

    private boolean checkDownRightWin(int r, int c) {
        if(board[r][c] == board[r+1][c+1] && board[r+1][c+1] == board[r+2][c+2] && board[r+2][c+2] == board[r+3][c+3]) {
            return true;
        }
        return false;
    }

    /**
     * Checks if the board is full, no empty positions.
     * @return Returns true if the board is full, false otherwise.
     */
    public boolean isFull() {
        for(int r = 0; r < boardRows; r++) {
            for(int c = 0; c < boardCols; c++) {
                if(board[r][c] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Loads a board from a specified file.
     * @param file The file the board is being read from.
     */
    public void loadBoardFromFile(File file) {
        int row = 0;

        BufferedReader br = null;
        try {
            String st;
            br = new BufferedReader(new FileReader(file));

            while((st = br.readLine()) != null) {
                if(!st.isBlank()) {
                    loadRow(st,row);
                    row++;
                }
            }   
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Saves a board to a specified file.
     * @param file The file the board is being written to.
     */
    public void saveBoardToFile(File file) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(file));
            for(int r = 0; r < boardRows; r++) {
                for(int c = 0; c < boardCols; c++) {
                    if(c == boardCols - 1) {
                        if(board[r][c] == ' ') {
                            bw.write('0');
                        } else if(board[r][c] == 'X') {
                            bw.write('1');
                        } else if(board[r][c] == 'O') {
                            bw.write('2');
                        }
                    } else {
                        if(board[r][c] == ' ') {
                            bw.write("0,");
                        } else if(board[r][c] == 'X') {
                            bw.write("1,");
                        } else if(board[r][c] == 'O') {
                            bw.write("2,");
                        }
                    }
                }
                bw.write("\n");
            }
        } catch(IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void loadRow(String st, int row) {
        String[] rowElements = st.split(",");

        validation.validateFileRow(rowElements);
       
        for(int col = 0; col < rowElements.length; col++) {
            if(rowElements[col].equals("1")) {
                setSpecificPosition(row,col,Player.X.toString().charAt(0));
            } else if(rowElements[col].equals("2")) {
                setSpecificPosition(row,col,Player.O.toString().charAt(0));
            }
        }
    }

    
    @Override
    /**
     * Converts the board to a string.
     * @return The string converted board.
     */
    public String toString() {
        StringBuilder string = new StringBuilder();

        int tempCol = 0;
        for(int c = 0; c < boardCols; c++) {
            tempCol = c+1;
            string.append(" (" + tempCol + ")");
        }
        
        string.append("\n");

        for(int r = 0; r < boardRows; r++) {
            for(int c = 0; c < boardCols; c++) {
                string.append(" |" + board[r][c] + "|");
            }
            string.append("\n");
        }

        for(int i = 0; i < 29; i++) {
            string.append("-");
        }

        return string.toString();
    } 
}