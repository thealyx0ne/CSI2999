package games;
import java.util.Random;
import java.util.Scanner;
import java.util.*;
import java.util.Arrays;
/**
 * @author Catt McHale
 */
public class Math { //create Math class and initialize variables
    Random random = new Random();
    Scanner input = new Scanner(System.in);
    int count = 0;
    //int score = 0;
    int a;
    int b;
    int correct;
    int score;

    public static void main(String[] args) { //create a main class to ask user each question
        try {
            for (int count = 0; count < 10; count++) { //ensures the player is asked 10 questions
                Math q1 = new Math();
                q1.askquestion();
                q1.check();
            }
        } catch (InputMismatchException ex) { //mismatch error if input type != int
            System.out.println("Please enter an integer for your answer.");
            //return;
        }
    }
        private Math() { //generate random integers 1-10
            a =random.nextInt(10);
            b =random.nextInt(10);
        }

        public void askquestion() {
            if (a > b) { //ensure no negative numbers for subtraction
                System.out.println("What is " + a + " - " + b + "?");
                correct = a - b;
            } else if (a < b) { //addition
                System.out.println("What is " + a + " + " + b + "?");
                correct = a + b;
            } else { //if both numbers are the same --> subtraction
                System.out.println("What is " + a + " - " + b + "?");
            }
        }

        public void check () { //check if the user answers the question correctly
            int response = input.nextInt(); //take user input
            if (response == correct) {
                System.out.println("Correct!"); //verify answer
            } else if (response != correct) {
                System.out.println("Incorrect. Answer is: " + correct); //print correct answer
            } else {
                System.out.println("Please select an integer as your answer.");
            }

        }
    }
