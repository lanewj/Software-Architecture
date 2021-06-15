package architecureHW;

import java.util.Scanner;

public class Controller {
    static Model board;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        board = new Model(); //creates a game
        // System.out.println(View.displayBoard(board.getBoard()));
        playGame(); //starts the game
    }

    public static void playGame() {
        int input;
        int player = 1;

        while (board.isFull()) { 
            View.displayBoard(board.getBoard()); //displays board at start of every turn
            if (player == 1) { //player 1 move
                input = View.getCol(1); //Calls view to get input from user
                if(board.topCol(input-1)==-1) {
                    while(board.topCol(input-1)==-1) {
                        View.full();
                        input = View.getCol(1); 
                    }
                }
                if (Model.move(player, input)) { //Calls model to execute User move and Move returns boolean to determine winner.
                    View.displayBoard(board.getBoard());//Shows final game board
                    View.whoWon(1); // prints winner
                    break;
                
                }
                player = 2;
            } else { // player 2 move
                input = View.getCol(2);
                if(board.topCol(input-1)==-1) {
                    while(board.topCol(input-1)==-1) {
                        View.full();
                        input = View.getCol(2); 
                    }
                }
                if (Model.move(player, input)) {

                    View.displayBoard(board.getBoard());
                    View.whoWon(2); // prints winner
                    break;
                }
                player = 1;
                
            
            }
        }
        if(board.isFull()==false) {
           View.isDraw();
        }
    }

}
