package chapter_fourteen;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

/**
 * *14.9 (Create four taichis) Write a program that places four taichis in a GridPane
 * with two rows and two columns, as shown in Figure 14.45b.
 *
 * @author Sharaf Qeshta
 * */
public class Problem$09 extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        GridPane primaryPane = new GridPane();
        primaryPane.setAlignment(Pos.CENTER);
        primaryPane.setHgap(50);
        primaryPane.setVgap(50);

        for (int i = 0; i < 2; i++)
        {
            for (int j = 0; j < 2; j++)
            {
                GridPane pane = new GridPane();
                pane.setAlignment(Pos.CENTER);
                pane.setHgap(5);
                pane.setVgap(5);
                pane.setPrefSize(200, 200);
                pane.setStyle("-fx-border-radius: 50%; -fx-border-color:red;");

                Arc arc1 = new Arc(150, 100, 80, 80, 30, 35);
                arc1.setFill(Color.RED);
                arc1.setType(ArcType.ROUND);

                Arc arc2 = new Arc(150, 100, 80, 80, 120, 35);
                arc2.setFill(Color.RED);
                arc2.setType(ArcType.ROUND);

                Arc arc3 = new Arc(150, 100, 80, 80, 205, 35);
                arc3.setFill(Color.RED);
                arc3.setType(ArcType.ROUND);

                Arc arc4 = new Arc(150, 100, 80, 80, 300, 35);
                arc4.setFill(Color.RED);
                arc4.setType(ArcType.ROUND);


                pane.add(arc2, 0, 0);
                pane.add(arc1, 1, 0);
                pane.add(arc3, 0, 1);
                pane.add(arc4, 1, 1);
                GridPane.setConstraints(pane, j, i);
                primaryPane.getChildren().add(pane);
            }
        }

        Scene scene = new Scene(primaryPane, 500, 500);
        primaryStage.setTitle("Problem$09");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
