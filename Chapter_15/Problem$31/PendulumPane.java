package chapter_fifteen;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.util.Duration;

public class PendulumPane extends Pane
{
    private static final double xFactor = 4;
    private static double yFactor = -1;
    private static Timeline animation;

    public PendulumPane(){draw();}

    public void draw()
    {
        Circle topCircle = new Circle(250, 50, 5);
        Line line = new Line(250, 50, 250, 300);
        Circle bottomCircle = new Circle(250, 300, 10);

        getChildren().addAll(topCircle, line, bottomCircle);


        EventHandler<ActionEvent> eventHandler = e ->
        {
            if (bottomCircle.getCenterX() > 500)
            {
                bottomCircle.setCenterX(0);
                bottomCircle.setCenterY(250);
            }
            else
            {
                if (bottomCircle.getCenterX() < 250)
                    yFactor = 1;
                else
                    yFactor = -1;

                bottomCircle.setCenterX(bottomCircle.getCenterX() + xFactor);
                bottomCircle.setCenterY(bottomCircle.getCenterY() + yFactor);
            }
        };

        animation = new Timeline(
                new KeyFrame(Duration.millis(50), eventHandler)
        );
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.setAutoReverse(true);
        animation.play();

        line.endXProperty().bind(bottomCircle.centerXProperty());
        line.endYProperty().bind(bottomCircle.centerYProperty());
    }


    public void play()
    {
        animation.play();
    }

    public void pause()
    {
        animation.pause();
    }

    public void increaseSpeed()
    {
        animation.setRate(animation.getRate() * 2);
    }

    public void decreaseSpeed()
    {
        animation.setRate(animation.getRate() * 0.5);
    }
}
