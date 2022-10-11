public class Main{
    public static void main(String[] args){ 
        String[] menu = {"0: Frogger", "1: Pong", "2: Tic Tac Toe", "Q: Quit"}; //menu array for user selection
        System.out.println(menu[0]);
        System.out.println(menu[1]);
        System.out.println(menu[2]);
        System.out.println(menu[3]);//prints menu
        System.out.println("Select your option: ");
        
        Scanner scanner = new Scanner(System.in); //scan for user input

        if(choice.equals("0")){
            System.out.println("Loading Frogger...");
            //forward user to frogger
        } else if (choice.equals("1")) {
            System.out.println("Loading Pong...");
            //forward user to pong
        } else if (choice.equals("2")) {
            System.out.println("Loading Tic Tac Toe...");
            //forward user to tictactoe
        } else if (choice.equalsIgnoreCase("q")) {
            System.out.println("Goodbye!");
        System.exit(0);
        //exits
        }

    }
}

# based on menu select, menu will refence correct file and run that code
