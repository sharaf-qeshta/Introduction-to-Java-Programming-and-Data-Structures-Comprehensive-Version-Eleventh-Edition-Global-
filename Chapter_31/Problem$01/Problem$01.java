package chapter_thirty_one;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import sample.MapPane;

/**
 * 31.1 (Use JavaFX CSS) Create a CSS style sheet that defines a class for white fill and
 * black stroke color and an id for red stroke and green color. Write a program that
 * displays four circles and uses the style class and id. The sample run of the program
 * is shown in Figure 31.48a.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$01 extends Application
{
    @Override
    public void start(Stage stage)
    {
        HBox pane = new HBox(10);
        pane.setAlignment(Pos.CENTER);
        Scene scene = new Scene(pane, 500, 80);
        scene.getStylesheets().add("chapter_thirty_one/Problem$01.css");

        Circle circle1 = new Circle(50, 100, 30);
        HBox circle1Container = new HBox(circle1);
        circle1Container.getStyleClass().add("circleBorder");
        circle1.getStyleClass().add("circle1");

        Circle circle2 = new Circle(130, 100, 30);
        circle2.getStyleClass().addAll("circle1");

        Circle circle3 = new Circle(210, 100, 30);
        circle3.setId("circle2");

        Circle circle4 = new Circle(290, 100, 30);
        HBox circle4Container = new HBox(circle4);
        circle4Container.getStyleClass().add("circleBorder");
        circle4.getStyleClass().add("circle3");

        pane.getChildren().addAll(circle1Container, circle2, circle3, circle4Container);

        stage.setScene(scene);
        stage.setTitle("Problem$01");
        stage.show();
    }
}
