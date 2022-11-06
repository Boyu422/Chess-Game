/*
 * File name: Rock.java
 * Author: Boyu Li, 041003345#
 * Course: CST8132 – OOP, Lab Section:302
 * Lab: 3
 * Date: 2022-06-14
 * Professor: Daniel Cormier
 * Purpose: The class includes the function that calculate the valid
 * moves, get name and symbol based on pieces' colour for the piece "Rock"
 */
public class Rock extends Piece {
    Rock(boolean isBlack) {
        black = isBlack;
    }
    /*
     * The method will output the valid moves for piece "Rock"
     */
    @Override
    public void getValidMoves(int row, int col) {
        /*
         * The rule of Rock is it can move forward, backward or sideways. Reflect in code
         * it should be all coordinates of a row and a column the piece in.
         */
        String validMovesRow = "";
        String validMovesCol = "";
        //The first loop is for print all the coordinates of the valid row with the same column
        for (int i = 1; i <= 8; i++) {
            if (i != row) {
                validMovesRow += i + "," + col + " ";
            } else {
                validMovesRow += "";
            }
        }

        //The second loop is for print all the coordinates of the valid column with the same row
        System.out.println("The valid moves are: \n" + validMovesRow + "and");
        for (int i = 1; i <= 8; i++) {
            if (i != row) {
                validMovesCol += row + "," + i + " ";
            } else {
                validMovesCol += "";
            }
        }
        System.out.println(validMovesCol);
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
            letter = "R";
        } else {
            letter = "r";
        }
        return letter;
    }
}

