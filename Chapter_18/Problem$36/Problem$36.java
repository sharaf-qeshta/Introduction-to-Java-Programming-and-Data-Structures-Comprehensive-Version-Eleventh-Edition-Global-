package chapter_eighteen;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * 18.36 (Sierpinski triangle) Write a program that lets the user to enter the order and
 * display the filled Sierpinski triangles as shown in Figure 18.18.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$36 extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        SierpinskiTrianglePane triangle = new SierpinskiTrianglePane(0);

        Label orderLabel = new Label("Enter an Order: ");
        TextField order = new TextField();
        order.setPrefColumnCount(5);

        HBox settings = new HBox(5, orderLabel, order);
        settings.setAlignment(Pos.CENTER);

        HBox triangleContainer = new HBox(triangle);
        triangleContainer.setAlignment(Pos.CENTER);
        BorderPane pane = new BorderPane();
        pane.setCenter(triangle);
        pane.setBottom(settings);

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$36");
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
            triangle.setOrder(order_);
        });

        triangle.widthProperty().addListener(ov -> triangle.paint());
        triangle.heightProperty().addListener(ov -> triangle.paint());
    }
}
