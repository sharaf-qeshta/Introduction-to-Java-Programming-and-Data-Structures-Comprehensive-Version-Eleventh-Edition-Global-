package chapter_eighteen;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * **18.38 (Recursive tree) Write a program to display a recursive tree as shown in
 * Figure 18.20
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$38 extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        Label orderLabel = new Label("Enter an Order");
        TextField order = new TextField();
        order.setPrefColumnCount(5);

        HBox settings = new HBox(5, orderLabel, order);
        settings.setAlignment(Pos.CENTER);

        VBox pane = new VBox(10, RecursiveTreePane.getInstance(), settings);
        pane.setAlignment(Pos.CENTER);

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$38");
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
            RecursiveTreePane.getInstance().setOrder(order_+1);
        });
    }
}
