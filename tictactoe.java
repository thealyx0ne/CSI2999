/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tictactoe;

/**
 *
 * @author Ian Koss
 */
import java.util.*;
import java.lang.Math;
import java.util.Arrays;

public class TicTacToe {
    //Initialization of all variables
    public static String xs = "x";
    public static String os = "o";
    public static int turnNumber = 1; 
    public static boolean isWinner;
    public static String winner;
    public static int coin = 0;
    static String[] board;
    public static String firstTurnPlayer;
    public static String secondTurnPlayer;
    public static int gridSelect;
    
    //Calls the methods for the game loop, creates board variable
    public static void main(String[] args) {
        board = new String[9];
        startup();   
        while(isWinner == false){
            turn();
            turnNumber++;
        }
        
    }
    
    //The non-looped process starting up the game.
    public static void startup(){
        Random random = new Random();
        Scanner scan = new Scanner(System.in); 
        
        System.out.println("Welcome to Tic-Tac-Toe!");
        System.out.println("Enter name of Player 1: ");
        String playerOne = scan.nextLine(); 
        System.out.println("");
        
        System.out.println("Enter name of Player 2: ");
        String playerTwo = scan.nextLine(); 
        System.out.println("");
        
        System.out.println(playerOne + ", choose 0 or 1: ");
        int playerOneChoice = scan.nextInt(); 
        System.out.println("");
        
        System.out.println(playerOne + " chose " + playerOneChoice + ", which "
                + "means " + playerTwo + " chooses the other.");
        
        coin = random.nextInt(1);
        
        if(playerOneChoice == 0 && coin == 0){
            firstTurnPlayer = playerOne;
            secondTurnPlayer = playerTwo;
        }else{
            firstTurnPlayer = playerTwo;
            secondTurnPlayer = playerOne;
        }
        
        System.out.println("The random number was " + coin + ", which means " + 
                firstTurnPlayer + " goes first.");    
        System.out.println("");
        System.out.println(firstTurnPlayer + " are the o's, and " + playerTwo +
                " are the x's.");
        
        for (int a = 0; a < 9; a++) {
            board[a] = String.valueOf(a + 1);
        }
        
        pasteBoard();
        System.out.println("");
        System.out.println("When playing and on your turn, put the number in"
                + " for the spot you want!");
    }
    
    //Will start each players turn
    static void turn(){
        System.out.println("");
        System.out.println("It is turn: " + turnNumber);
        
        System.out.println("It is now " + firstTurnPlayer + "'s turn.");
        player1();
        
        System.out.println("It is now " + secondTurnPlayer + "'s turn.");
        player2();
    }
    
    //Player 1's entire turn of choice
    static void player1(){
        //Are the o's
        Scanner choiceO = new Scanner(System.in);
        pasteBoard();
        System.out.println("");
        System.out.println("It is " + firstTurnPlayer + "'s turn.");
        System.out.println("Please make your selection on the grid ranging from "
                + "1 to 9 that is free, "  + firstTurnPlayer + ": ");
        try{
            int tempO = choiceO.nextInt() - 1;
            if(checkBoard(board, tempO) == true){   
                System.out.println("");
                System.out.println("Please pick another option: ");
                player1();
            }else if(checkBoard(board, tempO) == false){
                System.out.println("");
                board[tempO] = "o";             
            }
        }
        catch(Exception e){
            System.out.println("");
            System.out.println("Please enter a number.");
            player1();
        }
        boolean won = checkWinner();
        if(won == true){
            pasteBoard();
            System.out.println("");
            System.out.println("Congratulation " + firstTurnPlayer + ", you won!");
            System.exit(0);
        }
        
    }
    
    //Player 2's entire turn of choice
    static void player2(){
        //Are the x's
        Scanner choiceX = new Scanner(System.in);
        pasteBoard();
        System.out.println("");
        System.out.println("It is " + secondTurnPlayer + "'s turn.");
        System.out.println("Please make your selection on the grid ranging from "
                + "1 to 9 that is free, "  + secondTurnPlayer + ": ");
        try{
            int tempX = choiceX.nextInt() - 1;
            if(checkBoard(board, tempX) == true){   
                System.out.println("");
                System.out.println("Please pick another option: ");
                player2();
            }else if(checkBoard(board, tempX) == false){
                System.out.println("");
                board[tempX] = "x";             
            }
        }
        catch(Exception e){
            System.out.println("");
            System.out.println("Please enter a number.");
            player2();
        }
        boolean won = checkWinner();
        if(won == true){
            isWinner = true;
            pasteBoard();
            System.out.println("");
            System.out.println("Congratulation " + secondTurnPlayer + ", you won!");
            System.exit(0);
        }
        
    }
    
    //Simply creates the board whenever called with any changes.
    static void pasteBoard(){
        System.out.println("|---|---|---|");
        System.out.println("| " + board[0] + " | "
                           + board[1] + " | " + board[2]
                           + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[3] + " | "
                           + board[4] + " | " + board[5]
                           + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[6] + " | "
                           + board[7] + " | " + board[8]
                           + " |");
        System.out.println("|---|---|---|");
    }
    
    static boolean checkBoard(String[] boardChange, int selection){
        return "o".equals(board[selection]) || "x".equals(board[selection]);
    }
    
    //Looks at each line seeing if there is a winner with x's or o's
    static boolean checkWinner(){
        for (int a = 0; a < 8; a++) {
            String line = null;
 
            switch (a) {
            case 0:
                line = board[0] + board[1] + board[2];
                break;
            case 1:
                line = board[3] + board[4] + board[5];
                break;
            case 2:
                line = board[6] + board[7] + board[8];
                break;
            case 3:
                line = board[0] + board[3] + board[6];
                break;
            case 4:
                line = board[1] + board[4] + board[7];
                break;
            case 5:
                line = board[2] + board[5] + board[8];
                break;
            case 6:
                line = board[0] + board[4] + board[8];
                break;
            case 7:
                line = board[2] + board[4] + board[6];
                break;
            }
            //For X winner
            if (line.equals("xxx")) {
                winner = secondTurnPlayer;
                return true;
            }
             
            // For O winner
            else if (line.equals("ooo")) {
                winner = firstTurnPlayer;
                return true;
            }   
        }
        for (int a = 0; a < 9; a++) {
            if (Arrays.asList(board).contains(
                    String.valueOf(a + 1))) {
                break;
            }
            else if (a == 8) {
                System.out.println("No one wins... it is a draw!");
                System.exit(0);
                return false;
            }
        }
        return false;
    }
}
