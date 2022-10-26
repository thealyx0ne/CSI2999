package tictactoe;

/**
 *
 * @author Ian Koss
 */
import java.util.*;
import java.lang.Math;   

public class TicTacToe {
    public static String x = "x";
    public static String o = "o";
    public static int turn = 0; 
    public static boolean winner;
    public static int coin = 0;
    
    public static void main(String[] args) {
        startup();   
        while(winner == false){
            
        }
    }
    
    public static void startup(){
        Random random = new Random();
        Scanner scan = new Scanner(System.in); 
        
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
        String firstTurnPlayer;
        String secondTurnPlayer;
        
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
    }
    
    public void turn(){
        
    }
    
    public boolean winner(){
        System.out.println("The winner is: ");
        return true;
    }
    
    public void player1(){
        
    }
    
    public void player2(){
        
    }
    
    public String board(){
        String board = "Now";
        return board;
    }
}
