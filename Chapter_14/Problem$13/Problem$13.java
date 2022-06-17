package chapter_fourteen;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * **14.13 (Display a pie chart) Write a program that uses a pie chart to display the
 * percentages of the overall market share represented by Apple, HTC, Samsung, and
 * Others, as shown in Figure 14.46c. Suppose that Apple takes 26 percent and is
 * displayed in red, HTC takes 26 percent and is displayed in blue, Samsung takes
 * 28 percent and is displayed in green, and the Others take 26 percent and are displayed
 * in orange. Use the Arc class to display the pies. Interested readers may
 * explore the JavaFX PieChart class for further study.
 *
 * @author Sharaf Qeshta
 * */
public class Problem$13 extends Application
{
    public static final String[] DATA =
    {
                    "Apple -- 20%",
                    "HTC -- 26%",
                    "Samsung -- 28%",
                    "Others -- 26%",
    };

    public static final double[] SHARES =
    {
                    20,
                    26,
                    28,
                    26
    };

    public static final Color[] COLORS =
    {
                    Color.RED,
                    Color.BLUE,
                    Color.GREEN,
                    Color.ORANGE
    };


    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        // Create a pane
        Pane pane = new Pane();

        double startAngle = 0;
        for (int i = 0; i < DATA.length; i++)
        {
            Arc arc = new Arc(250, 250, 80, 80,
                    startAngle, 360 * (SHARES[i] / 100));
            arc.setFill(COLORS[i]);
            arc.setType(ArcType.ROUND);
            pane.getChildren().add(arc);
            startAngle += arc.getLength();
        }

        Text text1 = new Text(280, 220, DATA[0]);
        Text text2 = new Text(180, 220, DATA[1]);
        Text text3 = new Text(180, 280, DATA[2]);
        Text text4 = new Text(280, 280, DATA[3]);

        pane.getChildren().addAll(text1, text2, text3, text4);
        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$13");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
