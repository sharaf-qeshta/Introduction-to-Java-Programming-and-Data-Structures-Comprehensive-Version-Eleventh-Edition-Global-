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
 * *31.8 (Rotation) Write a program that displays an ellipse. The ellipse is centered in the
 * pane with width 60 and height 40. Enter the value in the text field Angle and press
 * the Rotate button to rotate the ellipse, as shown in Figure 31.50b.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$08 extends Application
{
    @Override
    public void start(Stage stage)
    {
        VBox pane = new VBox(10);

        Ellipse ellipse = new Ellipse(150, 100, 60, 40);
        ellipse.setFill(Color.WHITE); ellipse.setStroke(Color.BLACK);
        Pane ellipseContainer = new Pane(ellipse);
        ellipseContainer.setMinSize(300, 200);
        pane.getChildren().add(ellipseContainer);


        Label angleLabel = new Label("Angle: ");
        TextField angle = new TextField();
        angle.setPrefColumnCount(3);

        Button rotate = new Button("Rotate");

        HBox settings = new HBox(5, angleLabel, angle, rotate);
        settings.setAlignment(Pos.CENTER);
        pane.getChildren().add(settings);

        rotate.setOnAction(e ->
        {
            int angle_;
            try
            {
                angle_ = Integer.parseInt(angle.getText());
            }
            catch (Exception exception)
            {
                return;
            }

            ellipse.setRotate(angle_);
        });

        Scene scene = new Scene(pane, 300, 300);
        stage.setScene(scene);
        stage.setTitle("Problem$08");
        stage.show();
    }
}
