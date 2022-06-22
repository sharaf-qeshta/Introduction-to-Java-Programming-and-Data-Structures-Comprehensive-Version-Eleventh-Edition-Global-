package chapter_fifteen;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * *15.8 (Display the mouse position) Write two programs, such that one displays the
 * mouse position when the mouse button is clicked (see Figure 15.28a), and the
 * other displays the mouse position when the mouse button is pressed and ceases
 * to display it when the mouse button is released.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$08 extends Application
{
    private static double mouseX = 0;
    private static double mouseY = 0;
    private static String coordinate = "(" + mouseX + ", " + mouseY + ")";

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        Pane pane = new Pane();

        Text text = new Text(coordinate);
        text.setVisible(false);

        pane.setOnMousePressed(e -> {
            text.setVisible(false);
            mouseX = e.getSceneX();
            mouseY = e.getSceneY();
        });

        pane.setOnMouseReleased(e -> {
            coordinate = "(" + mouseX + ", " + mouseY + ")";
            text.setX(mouseX);
            text.setY(mouseY);
            text.setText(coordinate);
            text.setVisible(true);
        });


        pane.getChildren().add(text);

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$08");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
