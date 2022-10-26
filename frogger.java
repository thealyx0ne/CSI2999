//open gui from menu select
import java.util.Scanner;
//import javafx;
/**
 * @author 
 */

public class Frogger {

    final static private int animFrames = 4; // 32/4 = 8, 8 animation frames, 10 ms each

    private int animFrame = 0;
    private int animFrame2 = 0;
    private long animTime = 0;
    public boolean alive = false;
    private long deathTime = 0;
    private int curFrame = 0;
    private int tempFrame = 0;
    private long movementDelay = 10; // milliseconds
    public boolean hw_hasMoved = false;

    public Frogger() {
//the main method of frogger
    }

    public void resetFrogger() {
//method used to reset frogger
    }

    public void mvUp() {
//method used to move up
    }

    public void mvDown() {
//method used to move down
    }

    public void mvLeft() {
//method used to move left
    }

    public void mvRight() {
//method used to move right
    }

    public long getTime() {
        //method used to get the time
    }

    public void frogMove() {
//Helps move the animated frog in a direction(TBI)
    }

    public void updateMovement() {
//Updates the previously mentioned animation
    }

    public void setPosition() {
//realigns the frog
    }

    public void updatefollowTree() {
//follows objects such as the tree
    }

    public void followLog() {
        //sets the log to follow
    }

    public void dead() {
//if frogger dies
    }

    public void finish() {
//if frogger makes it to the end/checkpoint
    }

    public void update() {
//things that will constantly update
    }
}
