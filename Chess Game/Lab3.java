/*
 * File name: Lab3.java
 * Author: Boyu Li, 041003345#
 * Course: CST8132 – OOP, Lab Section:302
 * Lab: 3
 * Date: 2022-06-14
 * Professor: Daniel Cormier
 * Purpose: The class includes four methods to provide functions check the
 * piece for valid moves,draw the board,move piece and filling the board
 * with pieces.
 */
import java.util.Scanner;
public class Lab3 {
    private Piece board[][] = new Piece[8][8];
    private Scanner keyboard=new Scanner(System.in);
    public static void main(String args[]){
        Lab3 lab3 = new Lab3();
        lab3.pieceFilling();
        lab3.boardDrawing();
    }
    /*
    * The method pieceFilling fills the board with black and white pieces
    */
    public void pieceFilling(){
        board[0][0] = new Rock(false);
        board[0][1] = new Knight(false);
        board[0][2] = new Bishop(false);
        board[0][3] = new King(false);
        board[0][4] = new Queen(false);
        board[0][5] = new Bishop(false);
        board[0][6] = new Knight(false);
        board[0][7] = new Rock(false);
        board[1][0] = new Pawn(false);
        board[1][1] = new Pawn(false);
        board[1][2] = new Pawn(false);
        board[1][3] = new Pawn(false);
        board[1][4] = new Pawn(false);
        board[1][5] = new Pawn(false);
        board[1][6] = new Pawn(false);
        board[1][7] = new Pawn(false);
        board[6][0] = new Pawn(true);
        board[6][1] = new Pawn(true);
        board[6][2] = new Pawn(true);
        board[6][3] = new Pawn(true);
        board[6][4] = new Pawn(true);
        board[6][5] = new Pawn(true);
        board[6][6] = new Pawn(true);
        board[6][7] = new Pawn(true);
        board[7][0] = new Rock(true);
        board[7][1] = new Knight(true);
        board[7][2] = new Bishop(true);
        board[7][3] = new King(true);
        board[7][4] = new Queen(true);
        board[7][5] = new Bishop(true);
        board[7][6] = new Knight(true);
        board[7][7] = new Rock(true);
    }
    /*
    * The method boardDrawing prints the 8*8 size board
    * */
    public void boardDrawing(){
        //instantiate three variables to hold the future terms
        String plus = "+";
        String bar = "|";
        String barWithPiece = "|";
        String firstLine = "";
        //instantiate a boolean variable to detect user's input
        boolean quit = true;
        //The outermost loop decide how many rows should be output
        for(int i=0;i<board.length;i++){
            //The second loop decide how long each row would be
            for(int j=0;j<board[0].length;j++){
                //The bar row, plus row, bar with the pieces row and the x-coordinates accumulate 8 times
                    plus += "-----+";
                    bar += "     |";
                    //when there is no piece at the location, the if conditional statement will
                    //leave the blank for accumulation of barWithPiece.
                    if(board[i][j] != null) {
                        barWithPiece += "  " + board[i][j].getSymbol() + "  |";
                    }
                    else{
                        barWithPiece += "     |";
                    }
                    firstLine += "     " + (j+1);
            }
            //When it comes to the first loop, the program outputs the firstLine as the
            //x-coordinates of the board
            if(i==0){
                System.out.println(firstLine);
            }
            //Using switch and for to output the board
            for (int k = 0; k < 4; k++) {
                switch (k) {
                    case 0:
                        System.out.println("  " + plus);
                        break;
                    case 1:
                    case 3:
                        System.out.println("  " + bar);
                        break;
                    case 2:
                        //When it comes to the third line of the square
                        //The bar will output with the y-coordinate
                        System.out.println((i+1) + " " + barWithPiece);
                }
            }
            //initialize all the variables
            bar = "|";
            plus = "+";
            barWithPiece = "|";
        }
        //The "for" here output the bottom line
        for(int i=0;i<board.length;i++){
            plus += "-----+";
        }
        System.out.println("  "+plus);
        System.out.println();
        /*
         * The "do while" here is used to output the menu system, the program will output menu without
         * any judgement at first time. After first time user input, the program will decide whether
         * continue to loop or not.
        */
        do {
            System.out.println("1. Move a piece");
            System.out.println("2. Check a piece for valid moves");
            System.out.println("3. Redraw the board");
            System.out.println("Q. quit");
            String option = keyboard.nextLine();
            //if the user's input is "Q", the value of quit will become false, the loop and program
            //will end
            if(option.equals("Q"))
            {
                quit = false;
            }
            //The switch here will invoke correspond methods based on user's input
            switch (option) {
                case "1":
                    pieceMoves();
                    break;
                case "2":
                    pieceCheck();
                    break;
                case "3":
                    boardDrawing();
                    break;
                    //If the user input invalid option, the program will prompt user the valid options.
                default:
                        System.out.println("Valid options are 1, 2, 3 or Q.");
            }
        }
        while (quit);
        System.out.println("Thanks for your playing!");
    }
       /*
        * The method prompts the user to input the coordinates of the piece
        * which they want to move, the coordinates of where they want to move at.
        * Then the program will move the piece to the place.
        */
    public Piece pieceMoves() {
        /*
        * The four "while" here will make sure the user's input is legal
        * if the user's input is illegal, the while will ask user input again
        * until the program receive the legal values
        */
        System.out.println("What piece do you want to move?");
        System.out.println("Enter row number: ");
        int pieceRow = keyboard.nextInt();
        keyboard.nextLine();
        while (pieceRow > 8 || pieceRow <= 0) {
            System.out.println("Valid row numbers are from 1 to 8");
            System.out.println("Enter row number : ");
            pieceRow = keyboard.nextInt();
            keyboard.nextLine();
        }
        System.out.println("Enter column number: ");
        int pieceCol = keyboard.nextInt();
        keyboard.nextLine();
        while (pieceCol > 8 || pieceCol <= 0) {
            System.out.println("Valid column numbers are from 1 to 8");
            System.out.println("Enter column number : ");
            pieceCol = keyboard.nextInt();
            keyboard.nextLine();
        }
        System.out.println("Where do you wish to move this piece?");
        System.out.println("Enter row number: ");
        int moveRow = keyboard.nextInt();
        keyboard.nextLine();
        while (moveRow > 8 || moveRow <= 0) {
            System.out.println("Valid row numbers are from 1 to 8");
            System.out.println("Enter row number : ");
            moveRow = keyboard.nextInt();
            keyboard.nextLine();
        }
        System.out.println("Enter column number: ");
        int moveCol = keyboard.nextInt();
        keyboard.nextLine();
        while (moveCol > 8 || moveCol <= 0) {
            System.out.println("Valid column numbers are from 1 to 8");
            System.out.println("Enter column number : ");
            moveCol = keyboard.nextInt();
            keyboard.nextLine();
        }
        //the code here will assign value of the piece which user required to the place
        //user required. Then, clear the original place.
        board[moveRow-1][moveCol-1]=board[pieceRow-1][pieceCol-1];
        board[pieceRow-1][pieceCol-1]=null;
        return board[moveRow-1][moveCol-1];
    }
    /*
    * The method asks user to input the valid coordinates of the piece which they
    * want to check the valid moves, then invoke the two methods and output the valid moves
    */
    public void pieceCheck() {
        System.out.println("Enter row number : ");
        int pieceRow = keyboard.nextInt();
        keyboard.nextLine();
        while (pieceRow > 8 || pieceRow <= 0) {
            System.out.println("Valid row numbers are from 1 to 8 ");
            System.out.println("Enter row number : ");
            pieceRow = keyboard.nextInt();
            keyboard.nextLine();
        }
        System.out.println("Enter column number : ");
        int pieceCol = keyboard.nextInt();
        keyboard.nextLine();
        while (pieceCol > 8 || pieceCol <= 0) {
            System.out.println("Valid row numbers are from 1 to 8 ");
            System.out.println("Enter row number : ");
            pieceCol = keyboard.nextInt();
            keyboard.nextLine();
        }
        //Only when the place has a piece on it, the method output the name of piece and valid moves
        if (board[pieceRow - 1][pieceCol-1] != null) {
            System.out.println("The piece at that location is a " + board[pieceRow - 1][pieceCol - 1].getName());
            board[pieceRow - 1][pieceCol - 1].getValidMoves(pieceRow, pieceCol);
        } //otherwise it prompts user there is no piece at that location
        else{
            System.out.println("There is no piece at that location!");
        }
    }
}


