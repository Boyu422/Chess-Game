/*
 * File name: Bishop.java
 * Author: Boyu Li, 041003345#
 * Course: CST8132 – OOP, Lab Section:302
 * Lab: 3
 * Date: 2022-06-14
 * Professor: Daniel Cormier
 * purpose: The class includes the function that calculate the valid
 * moves, get name and symbol based on pieces' colour for the piece "Bishop"
 */
public class Bishop extends Piece{
    Bishop(boolean isBlack){
        black = isBlack;
    }
    /*
     * The method will output the valid moves for piece "Bishop"
     */
    @Override
    public void getValidMoves(int row, int col) {
        /*
         * The rule of "bishop" is it can move diagonally in any direction. Reflect in the code
         * it should be distributed into 4 directions, up left(row+1,col-1), up right(row1+,col+1) ,
         * down left(row-1,col-1), down right(row-1, col+1). If the row+1>8,row-1 <=0 or col-1 <=0, row+1>8
         * the moves will be deemed as invalid moves and the loop for valid moves will end.
         */
        String validMoves = "The valid moves are: \n";
        //Because the actual row and col cannot directly involve into calculation
        //So I created two variables to hold the actual row and col, then initialize
        //them after each loops
        int pararow=0;
        int paracol=0;
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
            name = "black Bishop";

        } else {
            name = "white Bishop";
        }
        return name;
    }

    //The method here is to return the symbol of piece based on its colour
    @Override
    public String getSymbol() {
        String letter;
        if (black) {
            letter = "B";
        } else {
            letter = "b";
        }
        return letter;
    }

}

