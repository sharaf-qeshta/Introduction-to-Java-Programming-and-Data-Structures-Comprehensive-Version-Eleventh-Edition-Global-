package chapter_thirty_two;

import javafx.application.Application;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.geometry.Point2D;
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

import java.util.ArrayList;

/**
 * 32.21 (Combine colliding bouncing balls) Rewrite Programming Exercise 20.5 using
 * a thread to animate bouncing ball movements.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$21 extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        MultipleBallPane ballPane = new MultipleBallPane();
        ballPane.setStyle("−fx−border−color: yellow");

        Button suspend = new Button("Suspend");
        Button resume = new Button("Resume");
        Button add = new Button("+");
        Button subtract = new Button("−");
        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(suspend, resume, add, subtract);
        hBox.setAlignment(Pos.CENTER);

        add.setOnAction(e -> Platform.runLater(ballPane::add));
        subtract.setOnAction(e -> Platform.runLater(ballPane::subtract));

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
        primaryStage.setTitle("Problem$21");
        primaryStage.setScene(scene);
        primaryStage.show();

        resume.setOnAction(e -> ballPane.play());
        suspend.setOnAction(e -> ballPane.pause());
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
            Platform.runLater(animation::play);
        }

        public void add()
        {
            Color color = new Color(Math.random(), Math.random(), Math.random(), 0.5);
            Ball ball = new Ball(30, 30, 20, color);
            getChildren().add(ball);
            ball.setOnMouseClicked(e -> getChildren().remove(ball));
        }

        public void subtract()
        {
            if (getChildren().size() > 0)
                getChildren().remove(getChildren().size() - 1);
        }

        public void play()
        {
            Platform.runLater(animation::play);
        }

        public void pause()
        {
            Platform.runLater(animation::pause);
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
            touch();
        }


        protected void touch()
        {
            ArrayList<Ball> removed = new ArrayList<>();
            for (Node node1: this.getChildren())
            {
                Ball ball1 = (Ball)node1;
                for (Node node2: this.getChildren())
                {
                    Ball ball2 = (Ball)node2;
                    // touch calculation
                    double distance = new Point2D(ball1.getCenterX(), ball1.getCenterY())
                            .distance(ball2.getCenterX(), ball2.getCenterY());

                    if (distance < ball1.getRadius() + ball2.getRadius()
                            && !ball1.equals(ball2) && !removed.contains(ball1) && !removed.contains(ball2))
                    {
                        ball1.setRadius(ball1.getRadius() + ball2.getRadius());
                        removed.add(ball2);
                    }
                }
            }
            this.getChildren().removeAll(removed);
        }
    }


    static class Ball extends Circle
    {
        private double dx = 1, dy = 1;
        Ball(double x, double y, double radius, Color color)
        {
            super(x, y, radius);
            setFill(color);
        }
    }
}
