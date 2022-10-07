package chapter_thirty_one;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


/**
 * *31.7 (Translation) Write a program that displays a rectangle with upper-left corner point
 * at (40, 40), width 50, and height 40. Enter the values in the text fields x and y and
 * press the Translate button to translate the rectangle to a new location, as shown in
 * Figure 31.50a
 *
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$07 extends Application
{
    @Override
    public void start(Stage stage)
    {
        VBox pane = new VBox(10);

        Rectangle rectangle = new Rectangle(40, 40, 50, 40);
        rectangle.setFill(Color.WHITE); rectangle.setStroke(Color.BLACK);
        Pane rectangleContainer = new Pane(rectangle);
        rectangleContainer.setMinSize(300, 200);
        pane.getChildren().add(rectangleContainer);


        Label xLabel = new Label("x: ");
        TextField x = new TextField();
        x.setPrefColumnCount(3);

        Label yLabel = new Label("y: ");
        TextField y = new TextField();
        y.setPrefColumnCount(3);

        Button translate = new Button("Translate");


        HBox settings = new HBox(5, xLabel, x, yLabel, y, translate);
        settings.setAlignment(Pos.CENTER);
        pane.getChildren().add(settings);

        translate.setOnAction(e ->
        {
            int x_, y_;
            try
            {
                x_ = Integer.parseInt(x.getText());
                y_ = Integer.parseInt(y.getText());
            }
            catch (Exception exception)
            {
                return;
            }

            rectangle.setTranslateX(x_);
            rectangle.setTranslateY(y_);
        });

        Scene scene = new Scene(pane, 300, 300);
        stage.setScene(scene);
        stage.setTitle("Problem$07");
        stage.show();
    }
}
