package chapter_sixteen;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * **16.23 (Create an image animator with audio) Create animation in Figure 16.46b to
 * meet the following requirements:
 * ■■ Allow the user to specify the animation speed in a text field.
 * ■■ Get the number of images and image’s file-name prefix from the user. For
 * example, if the user enters n for the number of images and L for the image
 * prefix, then the files are L1.gif, L2.gif, and so on, to Ln.gif. Assume the
 * images are stored in the image directory, a subdirectory of the program’s class
 * directory. The animation displays the images one after the other.
 * ■■ Allow the user to specify an audio file URL. The audio is played while the
 * animation runs.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$23 extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        ImageAnimator imageAnimator = new ImageAnimator();
        Scene scene = new Scene(imageAnimator, 100, 100);
        primaryStage.setTitle("Problem$23");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
