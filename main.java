
import java.util.Scanner; //import the Scanner class

public class Main{
    public static void main(String[] args){ 
        String[] menu = {"0: Frogger", "1: Pong", "2: Tic Tac Toe", "3: Quit"}; //menu array for user selection
        System.out.println(menu[0]);
        System.out.println(menu[1]);
        System.out.println(menu[2]);
        System.out.println(menu[3]);//prints menu
        
        
        Scanner scanner = new Scanner(System.in); //scan for user input
        System.out.println("Select a menu option: ");

        int user_input = scanner.nextInt(); //read user input

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
        else {
            System.out.println("Invalid input. Please select a value 0-3.");
        }

    }
    


    public class Frogger() {

    }

    public class TicTacToe{

    }

    public class Pong{
        
    }
}

# based on menu select, menu will refence correct file and run that code
