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
 * **18.35 (H-tree fractal) An H-tree (introduced at the beginning of this chapter in
 * Figure 18.1) is a fractal defined as follows:
 * 1. Begin with a letter H. The three lines of H are of the same length, as shown
 * in Figure 18.1a.
 * 2. The letter H (in its sans-serif form, H) has four endpoints. Draw an H centered
 * at each of the four endpoints to an H-tree of order 1, as shown in Figure 18.1b.
 * These Hs are half the size of the H that contains the four endpoints.
 * 3. Repeat Step 2 to create an H-tree of order 2, 3, . . . , and so on, as shown in
 * Figures 18.1c and d.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$35 extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        HTree.getInstance().setOrder(0);

        HBox hBox = new HBox(HTree.getInstance());
        hBox.setAlignment(Pos.CENTER);

        Label orderLabel = new Label("Enter an Order: ");
        TextField order = new TextField();
        order.setPrefColumnCount(5);

        HBox settings = new HBox(5, orderLabel, order);
        settings.setAlignment(Pos.CENTER);

        VBox pane1 = new VBox(50, hBox, settings);
        pane1.setAlignment(Pos.CENTER);

        Scene scene = new Scene(pane1, 800, 800);
        primaryStage.setTitle("Problem$35");
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
            HTree.getInstance().setOrder(order_);
        });
    }
}
