package chapter_fifteen.samples;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Listing 15.9 ControlCircleWithMouseAndKey.java
 */
public class ControlCircleWithMouseAndKey extends Application
{
    private CirclePane circlePane = new CirclePane();

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage)
    {
        // Hold two buttons in an HBox
        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);
        Button btEnlarge = new Button("Enlarge");
        Button btShrink = new Button("Shrink");
        hBox.getChildren().add(btEnlarge);
        hBox.getChildren().add(btShrink);

        // Create and register the handler
        btEnlarge.setOnAction(e -> circlePane.enlarge());
        btShrink.setOnAction(e -> circlePane.shrink());

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(circlePane);
        borderPane.setBottom(hBox);
        BorderPane.setAlignment(hBox, Pos.CENTER);

        // Create a scene and place it in the stage
        Scene scene = new Scene(borderPane, 200, 150);
        primaryStage.setTitle("ControlCircle"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

        circlePane.setOnMouseClicked(e ->
        {
            if (e.getButton() == MouseButton.PRIMARY)
            {
                circlePane.enlarge();
            }
            else if (e.getButton() == MouseButton.SECONDARY)
            {
                circlePane.shrink();
            }
        });

        scene.setOnKeyPressed(e ->
        {
            if (e.getCode() == KeyCode.UP)
            {
                circlePane.enlarge();
            }
            else if (e.getCode() == KeyCode.DOWN)
            {
                circlePane.shrink();
            }
        });
    }
}
