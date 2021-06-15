package architecureHW;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.util.Vector;
import java.util.Scanner;

    public class View {
        //Method displays the board
        public static void displayBoard(int[][] b) {
            String ret = "-----------------------------";
            ret = ret + "\n";
            for (int r = 0; r < 6; r++) {
            ret = ret + "| ";
            for (int c = 0; c < 7; c++) {
            ret = ret + String.valueOf(b[r][c]) + " | ";
            }
            ret = ret + "\n";
            }
            //ret = ret + "_____________________________";
            ret = ret + "-----------------------------";
            ret = ret + "\n";
            ret = ret + "  1   2   3   4   5   6   7";
            ret = ret + "\n";
            ret = ret + "_____________________________";

            System.out.println(ret);
        }
        public static void isDraw() {
            System.out.println("This Game ends in a draw.");
        }
        public static void full() {
            System.out.println("Specified column is full.");
        }
        // Gets input from user to drop piece is specified column
        public static int getCol(int i) {
            Scanner myInput = new Scanner(System.in);
            int input;
            if (i == 1) {
                System.out.print("Player 1 Choose a column:");
                input = myInput.nextInt();
                while (true) {
                    if (input < 1 || input > 7) {
                        System.out.print("Player 1 Choose a column:");
                        input = myInput.nextInt();
                    } else {
                        break;
                    }

                }
                return input;
            } else {
                System.out.print("Player 2 Choose a column:");
                input = myInput.nextInt();
                while (true) {
                    if (input < 1 || input > 7) {
                        System.out.print("Player 2 Choose a column:");
                        input = myInput.nextInt();
                    } else {
                        break;
                    }

                }
                return input;
            }
        }
        //prints out the winner
        public static void whoWon(int i) {
            if (i == 1) {
                System.out.println("Winner Player 1");
            } else {
                System.out.println("Winner Player 2");
            }
        }
    }
