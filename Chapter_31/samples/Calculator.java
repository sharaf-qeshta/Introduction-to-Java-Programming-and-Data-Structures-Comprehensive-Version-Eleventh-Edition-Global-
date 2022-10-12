package chapter_thirty_one.samples;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Listing 31.15 Calculator.java
 * */
public class Calculator extends Application
{
    @Override
    public void start(Stage stage) throws Exception
    {
        Parent root =
                FXMLLoader.load(getClass().getResource("FXMLDocument19.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }
}
