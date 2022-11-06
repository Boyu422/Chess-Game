/*
 * File name: Knight.java
 * Author: Boyu Li, 041003345#
 * Course: CST8132 – OOP, Lab Section:302
 * Lab: 3
 * Date: 2022-06-14
 * Professor: Daniel Cormier
 * Purpose: The class includes the function that calculate the valid
 * moves, get name and symbol based on pieces' colour for piece "Knight"
 */
public class Knight extends Piece{
    Knight(boolean isBlack) {
        black = isBlack;
    }
    /*
    * The method getValidMoves will output the valid moves of piece "Knight"
    */
    @Override
    public void getValidMoves(int row, int col)
    {
        /*
         * The moving rule of piece "Knight" is it can move two square or one square in
         * the back and front one or two row. Reflect in code, the coordinates would be
         * (row -+1 or row -+2) & (col-+1 or col-+2), if the move row,col +1 or 2 >8, row,col -1
         * or 2<1, the moves will be deemed as invalid moves, the invalid moves won't be
         * accumulated into String validMoves.
         */
        String validMoves = "The validMoves are: ";
        if(row-1>=1&&col-2>=1){
            validMoves += (row-1)+","+(col-2)+" ";
        }
        if(row-2>=1&&col-1>=1){
            validMoves += (row-2)+","+(col-1)+" ";
        }
        if(row-1>=1&&col+2<=8){
            validMoves += (row-1)+","+(col+2)+" ";
        }
        if(row-2>=1&&col+1<=8){
            validMoves += (row-2)+","+(col+1)+" ";
        }
        if(row+1<=8&&col-2>=1){
            validMoves += (row+1)+","+(col-2)+" ";
        }
        if(row+2<=8&&col-1>=1){
            validMoves += (row+2)+","+(col-1)+" ";
        }
        if(row+1<=8&&col+2<=8){
            validMoves += (row+1)+","+(col+2)+" ";
        }
        if(row+2<=8&&col+1<=8){
            validMoves += (row+2)+","+(col+1)+" ";
        }
        System.out.println(validMoves);
    }

    //The method here is to return the name of piece based on its colour
    @Override
    public String getName() {
        String name;
        if (black) {
            name = "black Knight";

        } else {
            name = "white Knight";
        }
        return name;
    }

    //The method here is to return the symbol of piece based on its colour
    @Override
    public String getSymbol() {
        String letter;
        if (black) {
            letter = "N";
        } else {
            letter = "n";
        }
        return letter;
    }
}
