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
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

/**
 * *31.9 (Scale graphics) Write a program that displays an ellipse. The ellipse is centered
 * in the pane with width 60 and height 40. Enter the scaling factors in the text fields
 * and press the Scale button to scale the ellipse, as shown in Figure 31.50c.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$09 extends Application
{
    @Override
    public void start(Stage stage)
    {
        VBox pane = new VBox(10);

        Ellipse ellipse = new Ellipse(200, 100, 60, 40);
        ellipse.setFill(Color.WHITE); ellipse.setStroke(Color.BLACK);
        Pane ellipseContainer = new Pane(ellipse);
        ellipseContainer.setMinSize(400, 200);
        pane.getChildren().add(ellipseContainer);


        Label xLabel = new Label("Scale factor for x: ");
        TextField x = new TextField();
        x.setPrefColumnCount(3);

        Label yLabel = new Label("y: ");
        TextField y = new TextField();
        y.setPrefColumnCount(3);

        Button scale = new Button("Scale");


        HBox settings = new HBox(5, xLabel, x, yLabel, y, scale);
        settings.setAlignment(Pos.CENTER);
        pane.getChildren().add(settings);

        scale.setOnAction(e ->
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

            ellipse.setScaleX(x_);
            ellipse.setScaleY(y_);
        });

        Scene scene = new Scene(pane, 400, 300);
        stage.setScene(scene);
        stage.setTitle("Problem$09");
        stage.show();
    }
}
