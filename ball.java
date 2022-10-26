import java.util.Scanner;
import random;
import math.pi;
 /**
  * @author Catt McHale
  */

class Ball {
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
    position = new PVector(width/2, hieght/2);

    //get random speed
    float speed = random(-s, s);
    //set y direction to half speed to make it move faster
    direction = new PVector(speed, speed/2);
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
    var r = d/2;

    //loop eight points
    for (int i = 0; i < 8; i++) {
        //convert i * 45 degree to radians
        var degree = (i * 45) * (Pi/180)

        //calculate x and y points by rotating a vector
        //relative to the position 45 degrees
        var x = r * cos(position.x + degree) + position.x;
        var y = r * sin(position.y + degree) + position.y;

        //return true if the point is within both the x and y axis
        if (position.x < x && < position.x + w && p.y < y && y < p.y +h)
            return true;
        else 
        //if none of the points were within the player
            return false;
    }

  }

}

