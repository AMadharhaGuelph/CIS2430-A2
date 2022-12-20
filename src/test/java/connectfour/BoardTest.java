package connectfour;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

public class BoardTest{
    private Board testBoard;

    @Before
    public void setup(){
        testBoard = new Board();

    }

    @Test
    public void clearBoardTest() {
        File file = new File("././././assets/testBoards/generalTest.csv");
        testBoard.loadBoardFromFile(file);
        testBoard.clearBoard();
        assertEquals(0, testBoard.getNumberOfPlayer(Player.X));
        assertEquals(0, testBoard.getNumberOfPlayer(Player.O));
    }

    @Test
    public void setPlayerInColumnTest() {
        testBoard.setPlayerInColumn(1, Player.X);
        testBoard.setPlayerInColumn(1, Player.O);
        assertEquals('O', testBoard.getSpecificPosition(4,0));
        assertEquals('X', testBoard.getSpecificPosition(5,0));
    }

    @Test
    public void setSpecificPositionTest() {
        testBoard.setSpecificPosition(4,5,'X');
        assertEquals('X', testBoard.getSpecificPosition(4,5));
    }

    @Test
    public void getNumberOfPlayerTest() {
        File file = new File("././././assets/testBoards/generalTest.csv");
        testBoard.loadBoardFromFile(file);
        assertEquals(12, testBoard.getNumberOfPlayer(Player.X));
        assertEquals(11, testBoard.getNumberOfPlayer(Player.O));
    }
    
    @Test
    public void downWinTest() {
        File file = new File("././././assets/testBoards/downWinTestBoard.csv");
        testBoard.loadBoardFromFile(file);
        assertEquals('X', testBoard.checkForWin());
    }

    @Test
    public void rightWinTest() {
        File file = new File("././././assets/testBoards/rightWinTestBoard.csv");
        testBoard.loadBoardFromFile(file);
        assertEquals('O', testBoard.checkForWin());
    }

    @Test
    public void leftWinTest() {
        File file = new File("././././assets/testBoards/leftWinTestBoard.csv");
        testBoard.loadBoardFromFile(file);
        assertEquals('X', testBoard.checkForWin());
    }

    @Test
    public void downRightWinTest() {
        File file = new File("././././assets/testBoards/downRightWinTestBoard.csv");
        testBoard.loadBoardFromFile(file);
        assertEquals('O', testBoard.checkForWin());
    }

    @Test 
    public void downLeftWinTest() {
        File file = new File("././././assets/testBoards/downLeftWinTestBoard.csv");
        testBoard.loadBoardFromFile(file);
        assertEquals('X', testBoard.checkForWin());
    }

    @Test
    public void fullBoardWinTest() {
        File file = new File("././././assets/testBoards/fullBoardWin.csv");
        testBoard.loadBoardFromFile(file);
        assertEquals('X',testBoard.checkForWin());
    }

    @Test
    public void tieGameTest() {
        File file = new File("././././assets/testBoards/tieGameTestBoard.csv");
        testBoard.loadBoardFromFile(file);
        assertEquals(' ', testBoard.checkForWin());
    }

    @Test
    public void loadGameTest() {
        File file = new File("././././assets/testBoards/generalTest.csv");
        testBoard.loadBoardFromFile(file);
        assertEquals('O', testBoard.getSpecificPosition(0,2));
        assertEquals('X', testBoard.getSpecificPosition(1,2));
        assertEquals('O', testBoard.getSpecificPosition(2,0));
        assertEquals('X', testBoard.getSpecificPosition(2,1));
        assertEquals('X', testBoard.getSpecificPosition(2,2));
        assertEquals('X', testBoard.getSpecificPosition(3,0));
        assertEquals('O', testBoard.getSpecificPosition(3,1));
        assertEquals('O', testBoard.getSpecificPosition(3,2));
        assertEquals('X', testBoard.getSpecificPosition(3,3));
        assertEquals('X', testBoard.getSpecificPosition(3,4));
        assertEquals('O', testBoard.getSpecificPosition(4,0));
        assertEquals('O', testBoard.getSpecificPosition(4,1));
        assertEquals('X', testBoard.getSpecificPosition(4,2));
        assertEquals('O', testBoard.getSpecificPosition(4,3));
        assertEquals('O', testBoard.getSpecificPosition(4,4));
        assertEquals('X', testBoard.getSpecificPosition(4,6));
        assertEquals('X', testBoard.getSpecificPosition(5,0));
        assertEquals('O', testBoard.getSpecificPosition(5,1));
        assertEquals('X', testBoard.getSpecificPosition(5,2));
        assertEquals('O', testBoard.getSpecificPosition(5,3));
        assertEquals('O', testBoard.getSpecificPosition(5,4));
        assertEquals('X', testBoard.getSpecificPosition(5,5));
        assertEquals('X', testBoard.getSpecificPosition(5,6));
    }

    @Test
    public void saveGameTest() {
        File file = new File("././././assets/testBoards/saveGameTest.csv");

        testBoard.setPlayerInColumn(1,Player.X);
        testBoard.setPlayerInColumn(2,Player.O);
        testBoard.setPlayerInColumn(3,Player.X);
        testBoard.setPlayerInColumn(4,Player.O);
        testBoard.setPlayerInColumn(5,Player.X);
        testBoard.setPlayerInColumn(6,Player.O);
        testBoard.setPlayerInColumn(7,Player.X);
        testBoard.saveBoardToFile(file);
        assertEquals('X', testBoard.getSpecificPosition(5,0));
        assertEquals('O', testBoard.getSpecificPosition(5,1));
        assertEquals('X', testBoard.getSpecificPosition(5,2));
        assertEquals('O', testBoard.getSpecificPosition(5,3));
        assertEquals('X', testBoard.getSpecificPosition(5,4));
        assertEquals('O', testBoard.getSpecificPosition(5,5));
        assertEquals('X', testBoard.getSpecificPosition(5,6));
    }

    @Test
    public void boardFullTest() {
        File file = new File("././././assets/testBoards/tieGameTestBoard.csv");
        testBoard.loadBoardFromFile(file);
        assertEquals(true, testBoard.isFull());
    }

    @Test
    public void boardNotFullTest() {
        File file = new File("././././assets/testBoards/generalTest.csv");
        testBoard.loadBoardFromFile(file);
        assertEquals(false, testBoard.isFull());
    }

}