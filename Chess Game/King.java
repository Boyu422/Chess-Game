/*
 * File name: King.java
 * Author: Boyu Li, 041003345#
 * Course: CST8132 – OOP, Lab Section:302
 * Lab: 3
 * Date: 2022-06-14
 * Professor: Daniel Cormier
 * Purpose: The class includes the function that calculate the valid
 * moves, get name and symbol based on pieces' colour for the piece "King"
 */
public class King extends Piece {
    King(boolean isBlack) {
        black = isBlack;
    }
    /*
     * The method will output the valid moves for piece "King"
     */
    @Override
    public void getValidMoves(int row, int col) {
        /*
         * The moving rule of piece "King" is it can move one square in any direction
         * Reflect in code, the valid moves should be (row+1,col),(row-1,col),(row,col+1),
         * (row,col-1),(row+1,col+1),(row+1,col-1),(row-1,col+1),(row-1,col-1)
         * If the moves out of board(row or column >8 or <=0), the moves should be deemed as invalid
         * it will be abandoned instead of accumulate into the valid moves.
         */
        String validMoves = "The valid moves are: \n";
        if (row - 1 >= 1) {
            validMoves += (row - 1) + "," + col + " ";
        }
        if (row + 1 <= 8) {
            validMoves += (row + 1) + "," + col + " ";
        }
        if (col - 1 >= 1) {
            validMoves += row + "," + (col - 1) + " ";
        }
        if (col + 1 <= 8) {
            validMoves += row + "," + (col + 1) + " ";
        }
        if (row +1 <= 8 && col-1>= 1){
            validMoves += (row+1) + "," + (col-1) + " ";
        }
        if (row +1 <= 8 && col+1 <= 8){
            validMoves += (row+1) + "," + (col+1) + " ";
        }
        if (row -1 >= 1 && col-1>=1){
            validMoves += (row-1) + "," + (col+1) + " ";
        }
        if (row -1 >=1 && col+1<=8){
            validMoves += (row-1) + "," + (col-1) + " ";
        }
        //output the valid moves of the King
        System.out.println(validMoves);
    }

    //The method here is to return the name of piece based on its colour
    @Override
    public String getName() {
        String name;
        if (black) {
            name = "black King";

        } else {
            name = "white King";
        }
        return name;
    }

    //The method here is to return the symbol of piece based on its colour
    @Override
    public String getSymbol() {
        String letter;
        if (black) {
            letter = "K";
        } else {
            letter = "k";
        }
        return letter;
    }
}



