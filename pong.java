
import java.awt.geom.Rectangle2D;
import java.util.Scanner;
import java.util.*;
import java.lang.Math;
import java.lang.Object;
import java.awt.geom.Rectangle2D.Float;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.TextField;

/**
 *
 */

public class pong {
    public static void main(String[] args) {

        private PVector(float x, float y) {
            PVector(float x2, float y2) {
                x = x2;
                y = y2;
            }

            PVector position;
        }
    }
        public class Player {
            //current position
            PVector x;
            //movement direction
            float yDirection;
            //size
            float width = 10;
            float height = 25;
            //boundaries
            float boundary = 15;

            Player(float x, float y, float yDirection) {
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
            }

            //set player paddle color to white
            public abstract class Rectangle2D {
                Rectangle2D rect = new Rectangle2D(position.x, position.y, width, height);
                //rect = fill(255);

                //draw rectangle (paddle)
                //rect(position.x, position.y, width, height);
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
                float x = width / 2;
                float y = height / 2;
                position = new PVector(x, y);
                //get random speed
                //speed = ???
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
                ball.fill(255);
                //draw the ball's circle
                Circle.draw(position.x, position.y, diameter);

            }

            //collision methods
            public boolean overlapsWith(Player player) {
                //player getter method
                //get player position, width, and height
                var position = player.getPosition();
                var width = player.getWidth();
                var height = player.getHeight();

                //calculate the radius
                var d = ball.diameter;
                var r = d / 2;

                //loop eight points
                for (int i = 0; i < 8; i++) {
                    //convert i * 45 degree to radians
                    var degree = (i * 45) * (3.14159 / 180);

                    //calculate x and y points by rotating a vector
                    //relative to the position 45 degrees
                    var x = r * Math.cos(position.x + degree) + position.x;
                    var y = r * Math.sin(position.y + degree) + position.y;

                    //return true if the point is within both the x and y axis
                    if (position.x < x && x < position.x + width && player.y < y && y < player.y + height) return true;
                    else
                        //if none of the points were within the player
                        return false;
                }

            }

            //define movement speed
            float movespeed = 3;
            //define player scores
            float Player1Score = 0;
            float Player2Score = 0;
            //define player variables
            float width = 10;
            float height = 10;
            Player Player1;
            Player Player2;
            //define ball variable
            Ball ball;
            //define last postion of ball (x)
            float lastBallPositionX = 0;

            public void setup() {
                size(500, 500); //set screen size

                //create player instances
                Player Player1 = new Player(10, height / 2, 0);
                Player Player2 = new Player(width - 20, height / 2, 0);

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
                    Player2.setDirection(directionToBallY);
                }

                //store the ball x position the next check
                lastBallPositionX = ballPosition.x;

                //set fill color to white
                ball.fill(255);
            }

            //key press events for player movement
            public void keyPressed() {
                Scanner keyPressed = new Scanner();
                //move up
                if (keyPressed == 'w') //possibly make so player can use both wasd and arrow keys
                    Player1.setDirection(-speed);
                else if (keyPressed == 's')
                    Player1.setDirection(speed);
                //add ability for two player game? player1 uses wasd and player2 uses arrow keys
            }
        }
    }


