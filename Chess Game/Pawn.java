/*
 * File name: Pawn.java
 * Author: Boyu Li, 041003345#
 * Course: CST8132 – OOP, Lab Section:302
 * Lab: 3
 * Date: 2022-06-14
 * Professor: Daniel Cormier
 * Purpose: The class includes the function that calculate the valid
 * moves, get name and symbol based on pieces' colour for piece "Pawn"
 */
public class Pawn extends Piece {
    Pawn(boolean isBlack){
        black = isBlack;
    }
    /*
     * The method getValidMoves will output the valid moves of piece "pawn"
     */
    @Override
    public void getValidMoves(int row, int col) {
        /*
         * The moving rule of piece "Pawn" is it can move forward two square in their "home",
         * otherwise, it can only move forward one square. Reflect in code, the white piece
         * should be row plus 1 or 2 whereas black piece row miner 1 or 2.
         */
        //if the pawn is out of board, it will tell the user the pawn cannot move forward.
        if (row == 1 || row == 8) {
            System.out.println("The pawn cannot move forward");
        } else {
            //if the pawn is black, the row should -1
            if (black) {
                //if the black pawn is in the home, the valid moves should -1 or -2.
                if (row == 7) {
                    System.out.println("Valid moves are: " + (row - 1) + "," + col + " and " + (row - 2) + "," + col);
                } else {
                    //otherwise, the pawn can only move one square each time
                    System.out.println("Valid move is: " + (row - 1) + "," + col);
                }
                //the code below is for white pawn
                } else {
                if (row == 2) {
                    System.out.println("Valid moves are: " + (row + 1) + "," + col + " and " + (row + 2) + "," + col);
                } else {
                    System.out.println("Valid move is: " + (row + 1) + "," + col);
                }
            }
        }
    }

    //The method here is to return the name of piece based on its colour
    @Override
    public String getName() {
        String name;
        if (black) {
            name = "black Pawn";

        } else {
            name = "white pawn";
        }
        return name;
    }

    //The method here is to return the symbol of piece based on its colour
    @Override
    public String getSymbol() {
        String letter;
        if (black) {
            letter = "P";
        } else {
            letter = "p";
        }
        return letter;
    }
}
