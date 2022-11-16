package pong;
//open gui from menu select
import java.util.Scanner;
import java.util.random;
import math.*;
//import javafx;
/**
 * @author Catt McHale
 */
    public class Player {
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
            this.position = new PVector(x, y);
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
            } else if (position.y > height - boundary - height) {
                //stop movement at the bottom of the screen
                position.y = height - boundary - height;
            }

            //set player paddle color to white
            fill(255);
            //draw rectangle (paddle)
            rect(position.x, position.y, width, height);

        }
    }

    public class Ball {
        //current position of ball
        PVector position;

        //direction of ball
        PVector direction;

        //diameter of ball
        float diameter = 15;

        //ball speed
        float speed = 5;


        public Ball() {
            resetMovement();
        }

        //Getter

        public PVector getPosition() {
            return position;
        }

        //reset ball position and randomize the direction
        public void resetMovement() {
            //set position to center of screen
            position = new PVector(width / 2, hieght / 2);

            //get random speed
            float speed = random(-s, s);
            //set y direction to half speed to make it move faster
            direction = new PVector(speed, speed / 2);
        }

        //set x-axis direction
        public void setDirection(float x) {
            direction.x = x * speed;
        }

        //update ball position and add boundaries
        //draw the visuals
        public void update() {
            //velocity
            position.add(direction);

            //check if ball reached top or bottom of screen
            if (position.y < 0 || position.y > height) {
                //invert the direction on the y axis -- "bounce" effect
                direction.y = -direction.y;
            }

            //set the ball fill color to white
            fill(255);
            //draw the ball's circle
            circle(position.x, position.y, d);

        }

        //collision methods
        public boolean overlapsWith(Player1 player) {
            //player getter method
            //get player position, width, and height
            var position = player.getPosition();
            var width = player.getWidth();
            var height = player.getHeight();

            //calculate the radius
            var r = d / 2;

            //loop eight points
            for (int i = 0; i < 8; i++) {
                //convert i * 45 degree to radians
                var degree = (i * 45) * (Pi / 180);

                //calculate x and y points by rotating a vector
                //relative to the position 45 degrees
                var x = r * cos(position.x + degree) + position.x;
                var y = r * sin(position.y + degree) + position.y;

                //return true if the point is within both the x and y axis
                if (position.x < x && x < position.x + width && p.y < y && y < p.y + height) return true;
                else
                    //if none of the points were within the player
                    return false;
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

        public void setup() {
            size(500, 500); //set screen size

            //create player instances
            Player1 = new Player(10, height / 2, 0);
            Player2 = new player(width - 20, height / 2, 0);

            //create ball instance
            ball = new Ball();
        }

        public void draw() {
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
            text("Player 2 Score: " + Player2Score, width - 80, 20);
        }

        //key press events for player movement
        public void keyPressed() {
            //move up
            if (key == 'w') //possibly make so player can use both wasd and arrow keys
                Player1.setDirection(-speed);
            else if (key == 's')
                Player1.setDirection(speed);
            //add ability for two player game? player1 uses wasd and player2 uses arrow keys
        }
    }
}
