/*
 * File name: Queen.java
 * Author: Boyu Li, 041003345#
 * Course: CST8132 – OOP, Lab Section:302
 * Lab: 3
 * Date: 2022-06-14
 * Professor: Daniel Cormier
 * Purpose: The class includes the function that calculate the valid
 * moves, get name and symbol based on pieces' colour for the piece "Queen"
 */
public class Queen extends Piece{
    Queen(boolean isBlack){
        black = isBlack;
    }

    /*
     * The method will output the valid moves for piece "Queen"
     */
    @Override
    public void getValidMoves(int row, int col) {
        /* The rule of queen is it can move any number of square vertically, horizontally or diagonally.
         * Reflect in code, it is a combination of bishop and rock. So I directly copy the code from the
         * previous class, there are less comments for the code below.
         */
        int pararow=0;
        int paracol=0;
        String validMoves = "The valid moves are: \n";
        for(int i=1;i<=8;i++) {
            if (i != row) {
                validMoves += i+","+col+" ";
            } else {
                validMoves += "";
            }
        }
        for(int i=1;i<=8;i++) {
            if (i != col) {
                validMoves += row + "," + i + " ";
            } else {
                validMoves += "";
            }
        }
        pararow = row;
        paracol = col;
        while(pararow<8&&paracol>1){
            pararow++;
            paracol--;
            validMoves+=pararow+","+paracol+" ";
        }
        pararow = row;
        paracol = col;
        while(pararow<8&&paracol<8) {
            pararow++;
            paracol++;
            validMoves += pararow + "," + paracol + " ";
        }
        pararow = row;
        paracol = col;
        while(pararow>1&&paracol>1){
            pararow--;
            paracol--;
            validMoves += pararow + "," + paracol + " ";
        }
        pararow = row;
        paracol = col;
        while(pararow>1&&paracol<8) {
            pararow--;
            paracol++;
            validMoves += pararow + "," + paracol + " ";
        }
        System.out.println(validMoves);
    }

    //The method here is to return the name of piece based on its colour
    @Override
    public String getName() {
        String name;
        if (black) {
            name = "black Queen";

        } else {
            name = "white Queen";
        }
        return name;
    }

    //The method here is to return the symbol of piece based on its colour
    @Override
    public String getSymbol() {
        String letter;
        if (black) {
            letter = "Q";
        } else {
            letter = "q";
        }
        return letter;
    }

}

