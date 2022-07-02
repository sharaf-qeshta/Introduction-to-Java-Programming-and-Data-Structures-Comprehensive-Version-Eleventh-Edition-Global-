package chapter_sixteen;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;


public class RacingCar extends Pane
{
    private final double x;
    private final double y;
    private PathTransition pt;

    public RacingCar()
    {
        x = 0;
        y = 250;
        draw();
    }

    public RacingCar(double x, double y)
    {
        this.x = x;
        this.y = y;
        draw();
    }


    public void draw()
    {
        // wheels

        Circle wheel1 = new Circle(x+15, y-5, 5);
        Circle wheel2 = new Circle(x+35, y-5, 5);


        // body

        Rectangle body = new Rectangle(x, y-20, 50, 10);
        body.setFill(Color.SKYBLUE);

        // windows

        Polygon windows = new Polygon(x+10, y-20, x+20, y-30, x+30, y-30,
                x+40, y-20);
        windows.setFill(Color.BLUE);

        // combine them

        Group car = new Group(wheel1, wheel2, body, windows);

        // add Race Line

        Line raceLine = new Line(x, y, 600, y);

        pt = new PathTransition(
                Duration.millis(4000), raceLine, car
        );

        pt.setCycleCount(Timeline.INDEFINITE);
        pt.play();

        getChildren().add(car);
    }


    public void pause(){ pt.pause(); }

    public void play(){ pt.play(); }

    public void increaseSpeed()
    {
        pt.setDuration(pt.getDuration().add(Duration.millis(200)));
    }


    public void setSpeed(double speed)
    {
        pt.setDuration(Duration.millis(2000 - speed));
        pt.stop(); pt.play();
    }

    public void decreaseSpeed()
    {
        pt.setDuration(pt.getDuration().subtract(Duration.millis(200)));
    }
}
