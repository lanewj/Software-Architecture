package architecureHW;

import static org.junit.Assert.*;

import org.junit.Test;

public class ModelTest {
    static Model board1;

    @Test
    //Tests a vertical win.
    public void Verticaltest() {
        board1 = new Model();
        int[][] board = board1.getBoard();
        for (int i = 2; i < 6; i++) {
            board[i][0] = 1;
        }
        boolean k = true;
        // System.out.print(View.displayBoard(board));
        assertEquals("vertical test: ", k, board1.isVertical(2, 0, 1));
    }

    @Test
    //Tests a horizontal win.
    public void Horiztest() {
        board1 = new Model();
        int[][] board = board1.getBoard();
        for (int i = 0; i < 4; i++) {
            board[5][i] = 1;
        }
        boolean k = true;
        // System.out.print(View.displayBoard(board));
        assertEquals("Horizontal test: ", k, board1.isHorizontal(5, 4, 1));
    }

    @Test
  //Tests a diag win left to right.
    public void Diagtest1() {
        board1 = new Model();
        int[][] board = board1.getBoard();
        board[5][0] = 1;
        board[4][1] = 1;
        board[3][2] = 1;
        board[2][3] = 1;
        boolean k = true;
        assertEquals("Diag test: ", k, board1.isDiagonal(2, 3, 1));

    }

    @Test
  //Tests a diag win right to left
    public void Diagtest2() {
        board1 = new Model();
        int[][] board = board1.getBoard();
        board[2][3] = 1;
        board[3][4] = 1;
        board[4][5] = 1;
        board[5][6] = 1;
        boolean k = true;
        assertEquals("Diag test: ", k, board1.isDiagonal(2, 3, 1));

    }
    @Test
    //checks if a column is full
    public void fullColtest() {
        board1 = new Model();
        int[][] board = board1.getBoard();
        for (int i = 0; i < 6; i++) {
            board[i][0] = 1;
        }
        int k =-1;
        // System.out.print(View.displayBoard(board));
        assertEquals("vertical test: ", k, board1.topCol(0));
    }
    @Test
    //checks if the board is full
    public void fullBoardtest() {
        board1 = new Model();
        int[][] board = board1.getBoard();
        for (int r = 0; r < 7; r++) {
            for (int c = 0; c < 6; c++) {
                board[c][r] = 1;
            }
        }
        boolean k = false;
        assertEquals("vertical test: ", k, board1.isFull());
    }
}

