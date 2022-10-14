package chapter_thirty_two;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;


public class BallPane extends Pane
{
    public final double radius = 20;
    private double x = radius, y = radius;
    private double dx = 1, dy = 1;
    private final Circle circle = new Circle(x, y, radius);
    private final Timeline animation;

    public BallPane()
    {
        circle.setFill(Color.GREEN);
        getChildren().add(circle);

        animation = new Timeline(
                new KeyFrame(Duration.millis(50), e -> moveBall()));
        animation.setCycleCount(Timeline.INDEFINITE);

        new Thread(animation::play).start();
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
        animation.setRate(animation.getRate() + 0.1);
    }

    public void decreaseSpeed()
    {
        animation.setRate(
                animation.getRate() > 0 ? animation.getRate() - 0.1 :0);
    }

    public DoubleProperty rateProperty()
    {
        return animation.rateProperty();
    }

    protected void moveBall()
    {
        if (x < radius || x > getWidth() - radius)
            dx *= -1;
        if (y < radius || y > getHeight() - radius)
            dy *= -1;

        x += dx;
        y += dy;
        circle.setCenterX(x);
        circle.setCenterY(y);
    }
}
