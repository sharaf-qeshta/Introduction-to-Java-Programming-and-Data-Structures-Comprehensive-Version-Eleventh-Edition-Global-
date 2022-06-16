package chapter_fourteen;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * **14.12 (Display a bar chart) Write a program that uses a bar chart to display the percentages
 * of the overall market share represented by Apple, HTC, Samsung, and
 * Others, as shown in Figure 14.46b. Suppose that Apple takes 20 percent and is
 * displayed in red, HTC takes 26 percent and is displayed in blue, Samsung takes
 * 28 percent and is displayed in green, and the Others take 26 and are displayed
 * in orange. Use the Rectangle class to display the bars. Interested readers may
 * explore the JavaFX BarChart class for further study.
 *
 * @author Sharaf Qeshta
 * */
public class Problem$12 extends Application
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

    public static final double START_X = 10;
    public static final double START_Y = 250;

    public static final double PANE_WIDTH = 500;
    public static final double PANE_HEIGHT = 500;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        Pane pane = new Pane();
        Pane bars = new Pane();
        Pane labels = new Pane();

        double width = PANE_WIDTH/(DATA.length + 1);
        double heightUnit = PANE_HEIGHT/100;

        for (int i = 0; i < DATA.length; i++)
        {
            double x = (width * i) + (START_X * (i+3));
            double barHeight = SHARES[i] * heightUnit;

            Rectangle bar = new Rectangle(x, START_Y, width,
                    SHARES[i] * heightUnit );
            bar.setFill(COLORS[i]);
            bars.getChildren().add(bar);

            Text text = new Text(DATA[i]);
            text.setLayoutX(x); text.setLayoutY(START_Y+barHeight+20);
            text.setRotate(180);
            labels.getChildren().add(text);
        }

        pane.setRotate(180);
        pane.getChildren().addAll(bars, labels);

        Scene scene = new Scene(pane, PANE_WIDTH, PANE_HEIGHT);
        primaryStage.setTitle("Problem$12");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
