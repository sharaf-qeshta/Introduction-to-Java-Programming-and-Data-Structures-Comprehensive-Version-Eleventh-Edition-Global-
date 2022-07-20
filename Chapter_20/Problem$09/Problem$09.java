package chapter_twenty;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Comparator;

/**
 * ***20.9 (Remove the largest ball first) Modify Listing 20.10, MultipleBallApp
 * .java to assign a random radius between 2 and 20 when a ball is created.
 * When the - button is clicked, one of largest balls is removed.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$09 extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        MultipleBallPane ballPane = new MultipleBallPane();
        ballPane.setStyle("−fx−border−color: yellow");

        Button btAdd = new Button("+");
        Button btSubtract = new Button("−");
        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(btAdd, btSubtract);
        hBox.setAlignment(Pos.CENTER);

        btAdd.setOnAction(e -> ballPane.add());
        btSubtract.setOnAction(e -> ballPane.subtract());

        ballPane.setOnMousePressed(e -> ballPane.pause());
        ballPane.setOnMouseReleased(e -> ballPane.play());

        ScrollBar sbSpeed = new ScrollBar();
        sbSpeed.setMax(20);
        sbSpeed.setValue(10);
        ballPane.rateProperty().bind(sbSpeed.valueProperty());

        BorderPane pane = new BorderPane();
        pane.setCenter(ballPane);
        pane.setTop(sbSpeed);
        pane.setBottom(hBox);

        Scene scene = new Scene(pane, 250, 150);
        primaryStage.setTitle("Problem$09");
        primaryStage.setScene(scene);
        primaryStage.show();


        pane.setOnKeyPressed(e ->
        {
            if (ballPane.getChildren().size() > 0)
            {
                int maxIndex = 0;
                for (int i = 1; i < ballPane.getChildren().size(); i++)
                {
                    Ball ball = (Ball) ballPane.getChildren().get(i);
                    if (ball.compare(ball, (Ball) ballPane.getChildren()
                            .get(maxIndex)) > 0)
                        maxIndex = i;
                }
                ballPane.getChildren().remove(maxIndex);
            }
        });
    }

    private static class MultipleBallPane extends Pane
    {
        private final Timeline animation;

        public MultipleBallPane()
        {
            animation = new Timeline(
                    new KeyFrame(Duration.millis(50), e -> moveBall())
            );
            animation.setCycleCount(Timeline.INDEFINITE);
            animation.play();
        }

        public void add()
        {
            Color color = new Color(Math.random(), Math.random(), Math.random(), 0.5);
            double radius = ((Math.random() * 1000) % 19) + 2;
            getChildren().add(new Ball(30, 30, radius, color));
        }

        public void subtract()
        {
            if (getChildren().size() > 0)
                getChildren().remove(getChildren().size() - 1);
        }

        public void play()
        {
            animation.play();
        }

        public void pause()
        {
            animation.pause();
        }

        public DoubleProperty rateProperty()
        {
            return animation.rateProperty();
        }

        protected void moveBall()
        {
            for (Node node: this.getChildren())
            {
                Ball ball = (Ball)node;
                if (ball.getCenterX() < ball.getRadius() ||
                        ball.getCenterX() > getWidth() - ball.getRadius())
                    ball.dx *= -1;

                if (ball.getCenterY() < ball.getRadius() ||
                        ball.getCenterY() > getHeight() - ball.getRadius())
                    ball.dy *= -1;

                ball.setCenterX(ball.dx + ball.getCenterX());
                ball.setCenterY(ball.dy + ball.getCenterY());
            }
        }
    }


    static class Ball extends Circle implements Comparator<Ball>
    {
        private double dx = 1;
        private double dy = 1;

        Ball(double x, double y, double radius, Color color)
        {
            super(x, y, radius);
            setFill(color);
        }

        @Override
        public int compare(Ball o1, Ball o2)
        {
            return Double.compare(o1.getRadius(), o2.getRadius());
        }
    }
}
