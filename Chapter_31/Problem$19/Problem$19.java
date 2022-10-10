package chapter_thirty_one;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

/**
 * *31.19 (Use SplitPane) Create a program that displays four shapes in split panes, as
 * shown in Figure 31.57a.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$19 extends Application
{
    @Override
    public void start(Stage stage)
    {
        SplitPane pane = new SplitPane();
        pane.setOrientation(Orientation.VERTICAL);

        SplitPane row1 = new SplitPane();
        row1.setOrientation(Orientation.HORIZONTAL);

        Circle circle = new Circle(250, 250, 50);
        circle.setFill(Color.WHITE); circle.setStroke(Color.BLACK);
        StackPane pane1 = new StackPane(circle);

        Arc arc = new Arc(250, 250, 50, 80, 180, -90);
        arc.setType(ArcType.OPEN);
        arc.setFill(null);
        arc.setStroke(Color.BLACK);
        StackPane pane2 = new StackPane(arc);

        row1.getItems().addAll(pane1, pane2);

        SplitPane row2 = new SplitPane();
        row2.setOrientation(Orientation.HORIZONTAL);

        Rectangle rectangle = new Rectangle(250, 250, 50, 80);
        rectangle.setFill(Color.WHITE); rectangle.setStroke(Color.BLACK);
        StackPane pane3 = new StackPane(rectangle);

        Ellipse ellipse = new Ellipse(250, 250, 70, 50);
        ellipse.setFill(Color.WHITE); ellipse.setStroke(Color.BLACK);
        StackPane pane4 = new StackPane(ellipse);
        row2.getItems().addAll(pane3, pane4);

        pane.getItems().addAll(row1, row2);

        Scene scene = new Scene(pane, 500, 500);
        stage.setScene(scene);
        stage.setTitle("Problem$19");
        stage.show();
    }
}
