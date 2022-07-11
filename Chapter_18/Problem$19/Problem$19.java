package chapter_eighteen;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * *18.19 (Sierpinski triangle) Revise Listing 18.9 to develop a program that lets
 * the user use the +/- buttons, primary/secondary mouse buttons, and UP/
 * DOWN arrow keys to increase or decrease the current order by 1, as shown
 * in Figure 18.12a. The initial order is 0. If the current order is 0, the Decrease
 * button is ignored.
 *
 *
 * @author Sharaf Qeshta
 */
public class Problem$19 extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        SierpinskiTrianglePane pane = new SierpinskiTrianglePane();
        pane.paint();

        Button increment = new Button("+");
        Button decrement = new Button("-");

        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(increment, decrement);
        hBox.setAlignment(Pos.CENTER);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(pane);
        borderPane.setBottom(hBox);

        Scene scene = new Scene(borderPane, 500, 500);
        primaryStage.setTitle("Problem$19");
        primaryStage.setScene(scene);
        primaryStage.show();

        pane.widthProperty().addListener(ov -> pane.paint());
        pane.heightProperty().addListener(ov -> pane.paint());


        increment.setOnAction(e ->
        {
            increment(pane);
            borderPane.requestFocus();
        });
        decrement.setOnAction(e ->
        {
            decrement(pane);
            borderPane.requestFocus();
        });

        borderPane.setOnKeyPressed(e ->
        {
            if (e.getCode() == KeyCode.UP)
                increment(pane);
            if (e.getCode() == KeyCode.DOWN)
                decrement(pane);
            borderPane.requestFocus();
        });

        borderPane.setOnMouseClicked(e ->
        {
            if (e.getButton() == MouseButton.PRIMARY)
                increment(pane);
            if (e.getButton() == MouseButton.SECONDARY)
                decrement(pane);
            borderPane.requestFocus();
        });

        borderPane.requestFocus();

    }


    private void increment(SierpinskiTrianglePane pane)
    {
        pane.setOrder(pane.getOrder() + 1);
    }

    private void decrement(SierpinskiTrianglePane pane)
    {
        pane.setOrder(Math.max(pane.getOrder() - 1, 0));
    }
}
