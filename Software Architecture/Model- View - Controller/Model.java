package architecureHW;

public class Model {

    static int[][] board;
    static int boardCol;
    static int boardRow;
    //Creates Board with all indexes set to 0.
    public Model() {
        boardCol = 6;
        boardRow = 7;
        board = new int[boardCol][boardRow];

        for (int r = 0; r < boardRow; r++) {
            for (int c = 0; c < boardCol; c++) {

                board[c][r] = 0;
            }
        }

    }
    //Returns current board
    public int[][] getBoard() {
        return board;
    }
    
    // Returns top row of input column
    public static int topCol(int i) {

        for (int w = 5; w >= 0; w--) {
            if (board[w][i] == 0) {
                return w;
            }
        }
        return -1;

    }
    public static boolean isFull() {
        int count =0;
        for(int i=0;i<7;i++) {
            if (board[0][i]!=0) {
            count++;
        }
        }
        if (count == 7) {
            return false;
        }
        return true;
    }
    // Execute move from user. Sets specified index equal to
    // the player number and calls isWinner method.
    public static boolean move(int player, int col) {

        int row = topCol(col - 1);

        if (player == 1) {
            board[row][col - 1] = 1;
            return isWinner(row, col - 1, player);
            // System.out.println(row + " " + col);
        } else {
            board[row][col - 1] = 2;
            return isWinner(row, col - 1, 2);
        }

        // return true;
    }
    //calls all possible win conditions and returns if there is a winner yet.
    public static boolean isWinner(int row, int col, int player) {

        if (isVertical(row, col, player)) {

            return true;
        }
        if (isHorizontal(row, col, player)) {

            return true;
        }
        if (isDiagonal(row, col, player)) {

            return true;
        }
        return false;
    }
    //Checks for a vertical win.
    public static boolean isVertical(int row, int col, int player) {
        int count = 0;
        int i = row;

        while (i < boardCol && board[i][col] == player) {
            count++;
            i++;
        }
        if (count == 4) {
            return true;
        }

        return false;
    }
  //Checks for a horizontal win.
    public static boolean isHorizontal(int row, int col, int player) {
        int count = 0;
        int i = col;

        while (i < boardRow && board[row][i] == player) {
            count++;
            i++;
        }
        i = col - 1;
        while (i >= 0 && board[row][i] == player) {
            count++;
            i--;
        }
        if (count == 4) {
            return true;
        }

        return false;
    }
  //Checks for a diagonal win.
    public static boolean isDiagonal(int row, int col, int player) {

        int count = 0;
        int i = row;
        int j = col;
        // check left to right
        if (col + 3 < 6 && row - 3 >= 0) {
            for (int k = 0; k < 4; k++) {
                if (board[i][j] == player) {
                    count++;
                    i--;
                    j++;
                }
            }
        }
        if (count >= 4) {
            return true;
        }
        count = 0;
        i = row;
        j = col;
        if (col + 3 <= 6 && row + 3 <= 5) {
            // System.out.print(col);
            for (int k = 0; k < 4; k++) {
                if (board[i][j] == player) {
                    count++;
                    i++;
                    j++;
                }
            }
        }
        if (count >= 4) {
            return true;
        }
        count = 0;
        i = row;
        j = col;
        if (col - 3 >= 0 && row + 3 <= 5) {
            // System.out.print(col);
            for (int k = 0; k < 4; k++) {
                if (board[i][j] == player) {
                    count++;
                    i++;
                    j--;
                }
            }
        }
        if (count >= 4) {
            return true;
        }

        return false;
    }

}
