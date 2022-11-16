//TO DO LIST:
//max out player points at 5??
//return to main menu select at player win/lose
//make a two player input mode?????
//implement using arrow keys??^

//open gui from menu select
import java.util.Scanner;
//import javafx;
/**
 * @author Catt McHale
 */

 class Pong {
    //current position
    PVector position;
    //movement direction
    float yDirection;
    //size
    float width = 10;
    float height = 25;
    //boundaries 
    float boundary = 15;

    public Player(float x, float y, float yDirection) {
        this.position = new PVector(x,y);
        this.yDirection = yDirection;
    }
    //setter methods
    public void setDirection(float yDirection) {
        this.yDirection = yDirection;
    }
    //getter methods
    public PVector getPosition() {
        return position;
    }
    public float getHeight() {
        return height;
    }
    public float getWidth() {
        return width;
    }

    //update player position
    public void update() {
        position.y += yDirection;
        //check if player reached top
        if (position.y < boundary) {
            //stop movement at the top of the screen
            position.y = boundary;
        } else if (position.y > height-boundary-height) {
            //stop movement at the bottom of the screen
            position.y = height-boundary-height;
        }

        //set player paddle color to white 
        fill(255);
        //draw rectangle (paddle)
        rect.position.x, position.y, width, height

    }
 }


//define movement speed
float speed = 3;
//define player scores
float Player1Score = 0;
float Player2Score = 0;
//define player variables
Player Player1;
Player Player2;
//define ball variable
Ball ball;
//define last postion of ball (x)
float lastBallPositionX = 0;

void setup() {
    size(500,500); //set screen size

    //create player instances
    Player1 = new Player(10, height/2, 0);
    Player2 = new player(width-20, height/2, 0);

    //create ball instance
    ball = new Ball();
}

void draw {
    //set screen background color to black
    background(0);

    //update players
    Player1.update();
    Player2.update();

    //update ball
    ball.update();

    //get ball position
    PVector ballPosition = ball.getPosition();

    //check if ball hits left side of screen (points)
    if (ballPosition.x < 0) {
        //give player2 a point
        Player2Score += 1;
        //reset ball position and direction 
        ball.resetMovement();
    }
    
    //check if ball hits right side of screen (points)
    if (ballPosition.x > width) {
        //give player1 a point
        Player1Score += 1;
        //reset ball position and directon
        ball.resetMovement();
    }

    //check if ball overlaps with player (paddle)
    if (ball.overlapsWith(Player1)) {
        //"bounce" ball - invert x direction
        ball.setDirection(1);
    }
    if (ball.overlapsWith(Player2)) {
        //"bounce" ball - inert x direction
        ball.setDirection(-1);
    }

    //move player 2 towards the ball if ball is
    //moving towards player 2
    if (lastBallPositionX < ballPosition.x) {
        //get player2 position
        PVector Player2Position = Player2.getPosition();
        //calculate the direction
        float directionToBallY = ballPosition.y = Player2Position.y;
        //constrain value between -1 and 1
        directionToBallY = constrain(directionToBallY, -1, 1);
        //add speed
        directionToBallY *= speed;
        //set player2 direction
        Player2.setDeriection(directionToBallY);
    }

    //store the ball x position the next check
    lastballPositionX = ballPosition.x;

    //set fill color to white
    fill(255);
    //draw the player score on each side 
    text("Player 1 Score: " + Player1Score, 10, 20);
    text("Player 2 Score: " + Player2Score, width-80, 20);

    //key press events for player movement
    void keyPressed() {
        //move up
        if (key == 'w') //possibly make so player can use both wasd and arrow keys
        Player1.setDirection(-speed);
        else if (key == 's')
        Player1.setDirection(speed);
        //add ability for two player game? player1 uses wasd and player2 uses arrow keys
    }

}