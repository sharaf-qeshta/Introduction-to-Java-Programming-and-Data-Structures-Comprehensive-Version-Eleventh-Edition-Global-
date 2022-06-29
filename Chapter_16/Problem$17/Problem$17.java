package chapter_sixteen;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * **16.17 (Use ScrollBar and Slider) Write a program that uses scroll bars or sliders
 * to select the color for a text, as shown in Figure 16.43b. Four horizontal scroll
 * bars are used for selecting the colors: red, green, blue, and opacity percentages.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$17 extends Application
{
    private double red_ = 0.5;
    private double green_ = 0.5;
    private double blue_ = 0.5;
    private double opacity_ = 0.5;

    @Override
    public void start(Stage primaryStage)
    {
        Text showColors = new Text("Show Colors");

        Label redLabel = new Label("Red");
        ScrollBar red = new ScrollBar();
        red.setMin(0); red.setMax(1);
        HBox redContainer = new HBox(5, redLabel, red);
        redContainer.setAlignment(Pos.CENTER);


        Label greenLabel = new Label("Green");
        ScrollBar green = new ScrollBar();
        green.setMin(0); green.setMax(1);
        HBox greenContainer = new HBox(5, greenLabel, green);
        greenContainer.setAlignment(Pos.CENTER);


        Label blueLabel = new Label("Blue");
        ScrollBar blue = new ScrollBar();
        blue.setMin(0); blue.setMax(1);
        HBox blueContainer = new HBox(5, blueLabel, blue);
        blueContainer.setAlignment(Pos.CENTER);

        Label opacityLabel = new Label("Opacity");
        ScrollBar opacity = new ScrollBar();
        opacity.setMin(0); opacity.setMax(1);
        HBox opacityContainer = new HBox(5, opacityLabel, opacity);
        opacityContainer.setAlignment(Pos.CENTER);


        VBox pane = new VBox(20, showColors, redContainer, greenContainer,
                blueContainer, opacityContainer);
        pane.setAlignment(Pos.CENTER);

        red.setValue(0.5); green.setValue(0.5); blue.setValue(0.5); opacity.setValue(0.5);

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$17");
        primaryStage.setScene(scene);
        primaryStage.show();

        red.valueProperty().addListener(e ->
        {
            red_ = red.getValue();
            showColors.setFill(Color.color(red_, green_, blue_, opacity_));
        });

        green.valueProperty().addListener(e ->
        {
            green_ = green.getValue();
            showColors.setFill(Color.color(red_, green_, blue_, opacity_));
        });

        blue.valueProperty().addListener(e ->
        {
            blue_ = blue.getValue();
            showColors.setFill(Color.color(red_, green_, blue_, opacity_));
        });

        opacity.valueProperty().addListener(e ->
        {
            opacity_ = opacity.getValue();
            showColors.setFill(Color.color(red_, green_, blue_, opacity_));
        });
    }
}
