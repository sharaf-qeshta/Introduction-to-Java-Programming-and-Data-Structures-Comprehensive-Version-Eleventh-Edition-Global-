package chapter_sixteen;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * *16.1 (Use radio buttons) Write a GUI program as shown in Figure 16.36a. You can
 * use buttons to move the message to the left and right and use the radio buttons to
 * change the color for the message displayed.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$01 extends Application
{
    private final Text text = new Text("Welcome to Java");

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        HBox colors = new HBox();
        colors.setSpacing(10);
        colors.setAlignment(Pos.CENTER);

        RadioButton red = new RadioButton("Red");
        RadioButton yellow = new RadioButton("Yellow");
        RadioButton black = new RadioButton("Black");
        RadioButton orange = new RadioButton("Orange");
        RadioButton green = new RadioButton("Green");

        colors.getChildren().addAll(red, yellow, black, orange, green);

        // combine the buttons
        ToggleGroup group = new ToggleGroup();
        red.setToggleGroup(group);
        yellow.setToggleGroup(group);
        black.setToggleGroup(group);
        orange.setToggleGroup(group);
        green.setToggleGroup(group);

        // set listeners
        red.setOnAction(e -> text.setFill(Color.RED));
        yellow.setOnAction(e -> text.setFill(Color.YELLOW));
        black.setOnAction(e -> text.setFill(Color.BLACK));
        orange.setOnAction(e -> text.setFill(Color.ORANGE));
        green.setOnAction(e -> text.setFill(Color.GREEN));

        // position controllers
        HBox positionControllers = new HBox();
        positionControllers.setSpacing(10);
        positionControllers.setAlignment(Pos.CENTER);

        Button left = new Button("<=");
        Button right = new Button("=>");

        left.setOnAction(e -> text.setX((text.getX()-5 <= 0)? 0 : text.getX()-5));
        right.setOnAction(e -> text.setX((text.getX()+5 >= 500)? 500 : text.getX()+5));

        positionControllers.getChildren().addAll(left, right);

        Pane paneForText = new Pane(text);

        BorderPane pane = new BorderPane();
        pane.setTop(colors);
        pane.setCenter(paneForText);
        pane.setBottom(positionControllers);


        text.yProperty().bind(pane.heightProperty().divide(2));

        Scene scene = new Scene(pane, 450, 170);
        primaryStage.setTitle("Problem$01");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
