package chapter_sixteen;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * **16.15 (Demonstrate Label properties) Write a program to let the user dynamically
 * set the properties contentDisplay and graphicTextGap, as shown in
 * Figure 16.42b.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$15 extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        // controllers
        Label contentDisplay = new Label("contentDisplay");
        Label graphicTextGap = new Label("graphicTextGap");
        ComboBox<String> positions = new ComboBox<>();
        positions.getItems().addAll("left", "center", "right");
        positions.setValue("left");

        ComboBox<Integer> horizontalGap = new ComboBox<>();
        for (int i = 1; i < 101; i++)
            horizontalGap.getItems().add(i);
        horizontalGap.setValue(50);

        HBox controllers = new HBox(10, contentDisplay, positions, graphicTextGap, horizontalGap);
        controllers.setAlignment(Pos.CENTER);

        Label grapes = new Label("Grapes");
        ImageView image = new ImageView("chapter_sixteen/grapes.png");
        image.setFitWidth(50); image.setFitHeight(50);
        grapes.setGraphic(image);
        grapes.setGraphicTextGap(50);
        grapes.setContentDisplay(ContentDisplay.LEFT);
        grapes.setAlignment(Pos.CENTER);

        VBox pane = new VBox(20, controllers, grapes);
        pane.setAlignment(Pos.CENTER);

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$15");
        primaryStage.setScene(scene);
        primaryStage.show();

        positions.setOnAction(e ->
        {
            if (positions.getValue().equals("left"))
                grapes.setContentDisplay(ContentDisplay.LEFT);
            else if (positions.getValue().equals("center"))
                grapes.setContentDisplay(ContentDisplay.CENTER);
            else
                grapes.setContentDisplay(ContentDisplay.RIGHT);
        });

        horizontalGap.setOnAction(e -> grapes.setGraphicTextGap(horizontalGap.getValue()));

    }
}
