package chapter_thirty_one.samples;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Listing 31.11 SplitPaneDemo.java
 * */
public class SplitPaneDemo extends Application
{
    private Image usImage = new Image(
            "http://www.cs.armstrong.edu/liang/common/image/us.gif");
    private Image ukImage = new Image(
            "http://www.cs.armstrong.edu/liang/common/image/uk.gif");
    private Image caImage = new Image(
            "http://www.cs.armstrong.edu/liang/common/image/ca.gif");
    private String usDescription = "Description for US ...";
    private String ukDescription = "Description for UK ...";
    private String caDescription = "Description for CA ...";

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage)
    {
        VBox vBox = new VBox(10);
        RadioButton rbUS = new RadioButton("US");
        RadioButton rbUK = new RadioButton("UK");
        RadioButton rbCA = new RadioButton("CA");
        vBox.getChildren().addAll(rbUS, rbUK, rbCA);

        SplitPane content = new SplitPane();
        content.setOrientation(Orientation.VERTICAL);
        ImageView imageView = new ImageView(usImage);
        StackPane imagePane = new StackPane();
        imagePane.getChildren().add(imageView);
        TextArea taDescription = new TextArea();
        taDescription.setText(usDescription);
        content.getItems().addAll(
                imagePane, new ScrollPane(taDescription));

        SplitPane sp = new SplitPane();
        sp.getItems().addAll(vBox, content);

        Scene scene = new Scene(sp, 300, 250);
        primaryStage.setTitle("SplitPaneDemo"); // Set the window title
        primaryStage.setScene(scene); // Place the scene in the window
        primaryStage.show(); // Display the window

        // Group radio buttons
        ToggleGroup group = new ToggleGroup();
        rbUS.setToggleGroup(group);
        rbUK.setToggleGroup(group);
        rbCA.setToggleGroup(group);

        rbUS.setSelected(true);
        rbUS.setOnAction(e ->
        {
            imageView.setImage(usImage);
            taDescription.setText(usDescription);
        });

        rbUK.setOnAction(e ->
        {
            imageView.setImage(ukImage);
            taDescription.setText(ukDescription);
        });

        rbCA.setOnAction(e ->
        {
            imageView.setImage(caImage);
            taDescription.setText(caDescription);
        });
    }
}


