package chapter_eighteen;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * **18.39 (Drag the tree) Revise Programming Exercise 18.38 to move the tree to where
 * the mouse is dragged.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$39 extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        Label orderLabel = new Label("Enter an Order");
        TextField order = new TextField();
        order.setPrefColumnCount(5);

        HBox settings = new HBox(5, orderLabel, order);
        settings.setAlignment(Pos.CENTER);

        Pane pane = new Pane(RecursiveTreePane.getInstance(), settings);

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$39");
        primaryStage.setScene(scene);
        primaryStage.show();

        order.setOnAction(e ->
        {
            int order_;
            try
            {
                order_ = Integer.parseInt(order.getText());
            }
            catch (Exception ex)
            {
                return;
            }
            RecursiveTreePane.getInstance().setOrder(order_);
        });
    }
}
