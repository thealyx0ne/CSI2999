
import java.util.Scanner; //import the Scanner class
import java.fx; //imports UI for games

public class Main{
    public static void main(String[] args){ 
        String[] menu = {"0: Frogger", "1: Pong", "2: Tic Tac Toe", "3: Quit"}; //menu array for user selection
        System.out.println(menu[0]);
        System.out.println(menu[1]);
        System.out.println(menu[2]);
        System.out.println(menu[3]);//prints menu
        
        //scan for user input
        Scanner scanner = new Scanner(System.in); 
        System.out.println("Select a menu option: ");

        //read user input
        int user_input = scanner.nextInt();

        //if else statement for menu input
        //make a while loop??????
        if (user_input == 0){
            System.out.println("Loading Frogger...");
            //forward user to frogger
           
        } 
        else if (user_input == 1) {
            System.out.println("Loading Pong...");
            //forward user to pong
            
        } 
        else if (user_input == 2) {
            System.out.println("Loading Tic Tac Toe...");
            //forward user to tictactoe
            
        } 
        else if (user_input == 3) {
            System.out.println("Goodbye!");
            System.exit(0);
        //exits
        }
        else if (user_input != type.int){
            // throw exception for wrong input type
            // if user enters a non-int for menu choice
            System.out.println("Invalid input. Please select a value 0-3.");
        }
        else {
            //exception for if user enters a number < 3
            System.out.println("Invalid input. Please select a value 0-3.");
        }

    }
    


    public class Frogger {
        //all the workin bits

    }

    public class TicTacToe {
        //all the workin bits

    }

    public class Pong {
        //all the workin bits
        private class paddle1 {

        }
        private class paddle2 {

        }
        private class ball {
            
        }
    }
}

//based on menu select, menu will reference correct game and run the code
