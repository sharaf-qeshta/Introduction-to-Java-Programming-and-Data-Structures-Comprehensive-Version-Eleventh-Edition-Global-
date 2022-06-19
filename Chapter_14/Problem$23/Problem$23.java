package chapter_fourteen;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Locale;
import java.util.Scanner;

/**
 * *14.23 (Geometry: two rectangles) Write a program that prompts the user to enter the
 * center coordinates, width, and height of two rectangles from the command line.
 * The program displays the rectangles and a text indicating whether the two are
 * overlapping, whether one is contained in the other, or whether they don’t overlap,
 * as shown in Figure 14.50. See Programming Exercise 10.13 for checking the
 * relationship between two rectangles
 *
 * @author Sharaf Qeshta
 */
public class Problem$23 extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        Pane pane = new Pane();
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("enter centerX for the first rectangle: ");
        double centerX1 = scanner.nextDouble();

        System.out.print("enter centerY for the first rectangle: ");
        double centerY1 = scanner.nextDouble();

        System.out.print("enter the first rectangle width: ");
        double width1 = scanner.nextDouble();

        System.out.print("enter the first rectangle height: ");
        double height1 = scanner.nextDouble();

        System.out.print("enter centerX for the second rectangle: ");
        double centerX2 = scanner.nextDouble();

        System.out.print("enter centerY for the second rectangle: ");
        double centerY2 = scanner.nextDouble();

        System.out.print("enter the second rectangle width: ");
        double width2 = scanner.nextDouble();

        System.out.print("enter the second rectangle height: ");
        double height2 = scanner.nextDouble();

        draw(pane, centerX1, centerY1, width1, height1, centerX2, centerY2, width2, height2);


        String rectStatus = "";

        switch (getStatus(centerX1, centerY1,
                width1, height1, centerX2, centerY2, width2, height2))
        {
            case 0 -> rectStatus = "rect2 in rect1";
            case 1 -> rectStatus = "rect1 in rect2";
            case 2 -> rectStatus = "rect1 overlaps rect2";
            case 3 -> rectStatus = "rect2 overlaps rect1";
            case 4 -> rectStatus = "there is no relation";
        }

        Text text = new Text(rectStatus);

        text.xProperty().bind(pane.widthProperty().divide(2));
        text.yProperty().bind(pane.heightProperty().divide(2));
        text.setStyle("-fx-margin: 50px;");

        pane.getChildren().add(text);

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$23");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void draw(Pane pane, double... values)
    {
        if (values.length == 8)
        {
            Rectangle rectangle1 = new Rectangle(values[0], values[1], values[2], values[3]);
            Rectangle rectangle2 = new Rectangle(values[4], values[5], values[6], values[7]);
            rectangle1.setStroke(Color.BLACK);
            rectangle2.setStroke(Color.BLACK);
            rectangle1.setFill(Color.WHITE);
            rectangle2.setFill(Color.WHITE);
            pane.getChildren().addAll(rectangle1, rectangle2);
        }
        else
            throw new IllegalArgumentException();
    }

    public static int getStatus(double... values) {
        if (values.length == 8) {
            MyRectangle rect1 = new MyRectangle(values[0], values[1], values[2], values[3]);
            MyRectangle rect2 = new MyRectangle(values[4], values[5], values[6], values[7]);

            if (rect1.contains(rect2))
                return 0; // rect2 in rect1
            if (rect2.contains(rect1))
                return 1; // rect1 in rect2
            if (rect1.overlaps(rect2))
                return 2; // rect1 overlaps rect2
            if (rect2.overlaps(rect1))
                return 3; // rect2 overlaps rect1
            return 4; // there is no relation
        } else
            return -1;
    }
}
