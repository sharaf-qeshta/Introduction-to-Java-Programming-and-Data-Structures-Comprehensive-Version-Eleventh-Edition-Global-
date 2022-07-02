package chapter_sixteen;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Text;
import javafx.util.Duration;


public class ImageAnimator extends Pane
{
    private int animationSpeed_ = 0;
    private String imageFilePrefix_ = null;
    private int numberOfImages_ = 0;
    private String audioUrl_ = null;
    private int currentIndex = 0;


    public ImageAnimator()
    {
        draw();
    }

    private void draw()
    {
        Button startAnimation = new Button("Start Animation");
        HBox buttonContainer = new HBox(startAnimation);
        buttonContainer.setAlignment(Pos.BASELINE_RIGHT);

        ImageView image = new ImageView();
        image.setFitHeight(200); image.setFitWidth(200);

        Text text = new Text("Enter Information For Animation");
        HBox textContainer = new HBox(text);
        textContainer.setAlignment(Pos.BASELINE_LEFT);

        // information
        GridPane information = new GridPane();
        Label animationSpeedLabel = new Label("Animation speed in milliseconds");
        TextField animationSpeed = new TextField();

        Label imageFilePrefixLabel = new Label("Image File Prefix");
        TextField imageFilePrefix = new TextField();

        Label numberOfImagesLabel = new Label("Number Of Images");
        TextField numberOfImages = new TextField();

        Label audioFileUrlLabel = new Label("Audio File Url");
        TextField audioFileUrl = new TextField();

        information.add(animationSpeedLabel, 0, 0);
        information.add(animationSpeed, 1, 0);

        information.add(imageFilePrefixLabel, 0, 1);
        information.add(imageFilePrefix, 1, 1);

        information.add(numberOfImagesLabel, 0, 2);
        information.add(numberOfImages, 1, 2);

        information.add(audioFileUrlLabel, 0, 3);
        information.add(audioFileUrl, 1, 3);

        information.setVgap(5); information.setHgap(10);
        information.setAlignment(Pos.CENTER);

        VBox pane = new VBox(5, buttonContainer, image, textContainer, information);
        getChildren().add(pane);


        startAnimation.setOnAction(e ->
        {
            try
            {
                animationSpeed_ = Integer.parseInt(animationSpeed.getText());
                imageFilePrefix_ = imageFilePrefix.getText();
                numberOfImages_ = Integer.parseInt(numberOfImages.getText());
                audioUrl_ = audioFileUrl.getText();
            }
            catch (Exception ex)
            {
                System.out.println("Invalid Information");
                return;
            }

            Timeline animation = new Timeline(
                    new KeyFrame(Duration.millis(animationSpeed_), ev ->
                    {
                        image.setImage(getImage());
                        currentIndex++;
                    })
            );
            animation.setCycleCount(numberOfImages_);
            animation.play();

            animation.setOnFinished(ev ->
            {
                AudioClip audioClip = new AudioClip(audioUrl_);
                audioClip.play();
                audioClip.setCycleCount(1);
                restore();
            });
        });
    }


    private Image getImage()
    {
        return new Image("sample/images/" + imageFilePrefix_ + currentIndex + ".png");
    }

    private void restore()
    {
        animationSpeed_ = 0;
        imageFilePrefix_ = null;
        numberOfImages_ = 0;
        audioUrl_ = null;
        currentIndex = 0;
    }


}
