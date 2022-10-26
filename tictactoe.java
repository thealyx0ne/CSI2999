package tictactoe;

/**
 *
 * @author Ian Koss
 */
import java.util.*;
import java.lang.Math;   

public class TicTacToe {
    public static String xs = "x";
    public static String os = "o";
    public static int turnNumber = 0; 
    public static boolean isWinner;
    public static String winner;
    public static int coin = 0;
    static String[] board;
    public static String firstTurnPlayer;
    public static String secondTurnPlayer;
    
    public static void main(String[] args) {
        board = new String[9];
        startup();   
        while(isWinner == false){
            turn();
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
        
        if(playerOneChoice == 1){
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
                + "for the spot you want!");
    }
    
    static void turn(){
        System.out.println("");
        System.out.println("It is turn: " + turnNumber);
        turnNumber++;
        
        System.out.println("It is now " + firstTurnPlayer + "'s turn.");
        player1();
        
        System.out.println("It is now " + secondTurnPlayer + "'s turn.");
        player2();
    }
    
    static boolean winner(){
        System.out.println("The winner is: ");
        return true;
    }
    
    static void player1(){
        
    }
    
    static void player2(){
        
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
}
