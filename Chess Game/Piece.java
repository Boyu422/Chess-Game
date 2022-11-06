/*
 * File name: Piece.java
 * Author: Boyu Li, 041003345#
 * Course: CST8132 – OOP, Lab Section:302
 * Lab: 3
 * Date: 2022-06-14
 * Professor: Daniel Cormier
 * Purpose: The class is the father class for all the pieces, it will offer
 * a variable to help pieces distinguish the colour, also, the three abstract
 * class for all the pieces.
 */
public abstract class Piece {
    protected boolean black = true;
    public abstract String getName();
    public abstract String getSymbol();
    public abstract void getValidMoves(int row, int col);
}
