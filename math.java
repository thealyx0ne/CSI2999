//backup game :)
import java.util.Random;
import java.util.Scanner;
import java.util.*;
import java.util.Arrays;


/**
 * @author Catt McHale
 */


public class Math {
    Random random = new Random();
    Scanner input = new Scanner(System.in);
    int count = 0;
    //int score = 0;
    int a;
    int b;
    int correct;
    int score;

    public static void main(String[] args) {
        for (int count = 0; count < 10; count++) {
            Math q1 = new Math();
            q1.askquestion();
            q1.check();
        }
    }

    private Math() {
        a = random.nextInt(10);
        b = random.nextInt(10);
    }

    public void askquestion() {
        if (a > b) {
            System.out.println("What is " + a + " - " + b + "?");
            correct = a - b;
        } else if (a < b) {
            System.out.println("What is " + a + " + " + b + "?");
            correct = a + b;
        } else {
            System.out.println("What is " + a + " - " + b + "?");
        }
    }

    public void check() {
        int response = input.nextInt();
        if (response == correct) {
            System.out.println("Correct!");
        } else {
            System.out.println("Incorrect. Answer is: " + correct);
        }
    }
}
