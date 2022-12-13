package games;
//the necessary imports for the frogger game

import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


import javafx.animation.AnimationTimer;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Node;
import javafx.scene.Parent;
import java.util.ArrayList;
import java.util.List;

public class Frogger extends Application {
//a timer vriable

    private AnimationTimer timer;
//a pane variable to play the game in
    private Pane window;
//a node for the frog and a List for the cars
    private List<Node> car = new ArrayList<>();
    private Node frog;
//the method that creates the panel the game is played in aswell as 
    //adding the frog and setting a timer

    private Parent createContent() {
        window = new Pane();
        window.setPrefSize(800, 600);
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                onUpdate();
            }
        };

        frog = startFrog();

        window.getChildren().add(frog);

        timer.start();

        return window;
    }
//creates the green frog box, gives him his dimensions, and lets him move

    private Node startFrog() {
        Rectangle rect = new Rectangle(38, 38, Color.GREEN);
        rect.setTranslateY(600 - 39);

        return rect;
    }
//creates the red cars that move right, gives them a size, color, and moves them

    private Node makeCar() {
        Rectangle rect = new Rectangle(40, 40, Color.RED);
        window.getChildren().add(rect);

        rect.setTranslateY((int) (Math.random() * 14) * 40);

        return rect;
    }
//describes what gets updated as time passes, such as the amount of cars that spawn and theamount of movement across the screen

    private void onUpdate() {
        if (Math.random() < 0.075) {
            car.add(makeCar());
        }
        for (Node car1 : car) {
            car1.setTranslateX(car1.getTranslateX() + Math.random() * 10);
        }

        state();
    }

    private void state() {
        //a for loop that sends the frog back to the beginning upon getting hit
        for (Node car2 : car) {
            if (car2.getBoundsInParent().intersects(frog.getBoundsInParent())) {
                frog.setTranslateX(0);
                frog.setTranslateY(600 - 39);
                return;
            }
        }
// an if statement that says if the frog makes it to the end to stop the timer moving everything and display a "you win" message
        if (frog.getTranslateY() <= 0) {
            timer.stop();
            String win = "YOU WIN";

            HBox hBox = new HBox();
            hBox.setTranslateX(300);
            hBox.setTranslateY(250);
            window.getChildren().add(hBox);
//font and transition setting for the "you win" text
            for (int i = 0; i < win.toCharArray().length; i++) {
                char key = win.charAt(i);

                Text text = new Text(String.valueOf(key));
                text.setFont(Font.font(48));
                text.setOpacity(0);

                hBox.getChildren().add(text);

                FadeTransition ft = new FadeTransition(Duration.seconds(0.66), text);
                ft.setToValue(1);
                ft.setDelay(Duration.seconds(i * 0.15));
                ft.play();
            }
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(createContent()));
//a switch that makes the controls, with WASD being the main way to move
        stage.getScene().setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case W:
                    frog.setTranslateY(frog.getTranslateY() - 40);
                    break;
                case S:
                    frog.setTranslateY(frog.getTranslateY() + 40);
                    break;
                case A:
                    frog.setTranslateX(frog.getTranslateX() - 40);
                    break;
                case D:
                    frog.setTranslateX(frog.getTranslateX() + 40);
                    break;
                default:
                    break;
            }
        });

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
