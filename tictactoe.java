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
    
    public static void main(String[] args) {
        board = new String[9];
        startup();   
        while(isWinner == false){
            turn();
            turnNumber++;
        }
        
    }
    
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
        
        System.out.println(playerOne + ", choose 1 or 2: ");
        int playerOneChoice = scan.nextInt(); 
        System.out.println("");
        
        System.out.println(playerOne + " chose " + playerOneChoice + ", which "
                + "means " + playerTwo + " chooses the other.");
        
        coin = random.nextInt(2-1) + 1;
        
        if(playerOneChoice == 1 && coin == 1){
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
    
    static void turn(){
        System.out.println("");
        System.out.println("It is turn: " + turnNumber);
        
        System.out.println("It is now " + firstTurnPlayer + "'s turn.");
        player1();
        
        System.out.println("It is now " + secondTurnPlayer + "'s turn.");
        player2();
    }
    
    static boolean winner(){
        System.out.println("The winner is: " + winner);
        return true;
    }
    
    static void player1(){
        //Are the o's
        Scanner choiceO = new Scanner(System.in);
        pasteBoard();
        System.out.println("");
        System.out.println("It is " + firstTurnPlayer + "'s turn.");
        System.out.println("Please make your selection on the grid ranging from "
                + "1 to 9 that is free, "  + firstTurnPlayer + ": ");
        int tempO = choiceO.nextInt();
        if(checkBoard(board, tempO) == true){
            System.out.println("");
            System.out.println("You have selected: " + tempO);
            System.out.println("Please pick another option: ");
            player1();
        }else if(checkBoard(board, tempO) == false){
            try{
                System.out.println("");
                System.out.println("You have selected: " + tempO);
                tempO = tempO - 1;
                board[tempO] = "o";      
            }
            catch(NumberFormatException ex){
                System.out.println("");
                System.out.println("Please enter a number.");
                player1();
            }
        }
        boolean won = checkWinner();
        if(won == true){
            pasteBoard();
            System.out.println("");
            System.out.println("Congratulation " + firstTurnPlayer + ", you won!");
            System.exit(0);
        }
        
    }
    
    static void player2(){
        //Are the x's
        Scanner choiceX = new Scanner(System.in);
        pasteBoard();
        System.out.println("");
        System.out.println("It is " + secondTurnPlayer + "'s turn.");
        System.out.println("Please make your selection on the grid ranging from "
                + "1 to 9 that is free, "  + secondTurnPlayer + ": ");
        int tempX = choiceX.nextInt();
        if(checkBoard(board, tempX) == true){
            System.out.println("");
            System.out.println("You have selected: " + tempX);
            System.out.println("Please pick another option: ");
            player2();
        }else if(checkBoard(board, tempX) == false){
            try{
                System.out.println("");
                System.out.println("You have selected: " + tempX);
                tempX = tempX - 1;
                board[tempX] = "x";     
            }
            catch(NumberFormatException ex){
                System.out.println("");
                System.out.println("Please enter a number.");
                player2();
            }
        }
        boolean won = checkWinner();
        if(won == true){
            pasteBoard();
            System.out.println("");
            System.out.println("Congratulation " + secondTurnPlayer + ", you won!");
            System.exit(0);
        }
        
    }
    
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
        if(board[selection] != "o" && board[selection] != "x"){
            return false;
        }
        return true;
    }
    
    static boolean checkWinner(){
        return false;
    }
}
