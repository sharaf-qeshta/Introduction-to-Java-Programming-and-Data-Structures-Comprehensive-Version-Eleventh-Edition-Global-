package chapter_sixteen;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * **16.9 (Geometry: two rectangles intersect?) Write a program that enables the user to
 * specify the location and size of the rectangles and displays whether the two rectangles
 * intersect, as shown in Figure 16.39b. Enable the user to point the mouse
 * inside a rectangle and drag it. As the rectangle is being dragged, the rectangle’s
 * center coordinates in the text fields are updated.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$09 extends Application
{
    private final Rectangle rectangle1 = new Rectangle(220, 220, 40, 100);
    private final Rectangle rectangle2 = new Rectangle(280, 280, 100, 40);

    // rectangle1 properties
    private final TextField rectangle1X = new TextField(rectangle1.getX() + "");
    private final TextField rectangle1Y = new TextField(rectangle1.getY() + "");
    private final TextField rectangle1Width = new TextField(rectangle1.getWidth() + "");
    private final TextField rectangle1Height = new TextField(rectangle1.getHeight() + "");

    // rectangle2 properties
    private final TextField rectangle2X = new TextField(rectangle2.getX() + "");
    private final TextField rectangle2Y = new TextField(rectangle2.getY() + "");
    private final TextField rectangle2Width = new TextField(rectangle2.getWidth() + "");
    private final TextField rectangle2Height = new TextField(rectangle2.getHeight() + "");

    Label answer = new Label((intersects())? "Yes" : "No");
    // redraw handler
    EventHandler<ActionEvent> handler = e ->
    {
        double x1, y1, w1, h1,
                x2, y2, w2, h2;
        try
        {
            x1 = Double.parseDouble(rectangle1X.getText());
            y1 = Double.parseDouble(rectangle1Y.getText());
            w1 = Double.parseDouble(rectangle1Width.getText());
            h1 = Double.parseDouble(rectangle1Height.getText());

            x2 = Double.parseDouble(rectangle2X.getText());
            y2 = Double.parseDouble(rectangle2Y.getText());
            w2 = Double.parseDouble(rectangle2Width.getText());
            h2 = Double.parseDouble(rectangle2Height.getText());
        }
        catch (Exception ex)
        {
            System.out.println("Enter valid information");
            return;
        }

        rectangle1.setX(x1); rectangle2.setX(x2);
        rectangle1.setY(y1); rectangle2.setY(y2);
        rectangle1.setWidth(w1); rectangle2.setWidth(w2);
        rectangle1.setHeight(h1); rectangle2.setHeight(h2);
        answer.setText((intersects())? "Yes" : "No");
    };


    @Override
    public void start(Stage primaryStage)
    {
        setDefault();
        // top question
        Label question = new Label("Two rectangles intersects");
        HBox top = new HBox(10, question, answer);
        top.setAlignment(Pos.CENTER);

        //rectangles
        Pane rectanglesPane = new Pane(rectangle1, rectangle2);

        // rectangles settings
        GridPane rectangle1Settings = getRectangleSettings(1);
        GridPane rectangle2Settings = getRectangleSettings(2);
        HBox settings = new HBox(10, rectangle1Settings, rectangle2Settings);
        settings.setAlignment(Pos.CENTER);

        // redraw
        Button redraw = new Button("Redraw Rectangles");
        redraw.setOnAction(handler);

        // main pane
        VBox pane = new VBox(20, top, rectanglesPane, settings, redraw);
        pane.setAlignment(Pos.CENTER);


        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$09");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private GridPane getRectangleSettings(int rect)
    {
        Label title = new Label("Enter Rectangle " + rect + " Info: ");


        GridPane rectangleSettings = new GridPane();
        rectangleSettings.setHgap(5); rectangleSettings.setVgap(5);
        rectangleSettings.add(title, 0, 0);
        rectangleSettings.setStyle("-fx-border-color: black");

        Label x = new Label("X: ");
        rectangleSettings.add(x, 0, 1);
        Label y = new Label("Y: ");
        rectangleSettings.add(y, 0, 2);
        Label width = new Label("Width: ");
        rectangleSettings.add(width, 0, 3);
        Label height = new Label("Height: ");
        rectangleSettings.add(height, 0, 4);

        if (rect == 1)
        {
            rectangleSettings.add(rectangle1X, 1, 1);
            rectangleSettings.add(rectangle1Y, 1, 2);
            rectangleSettings.add(rectangle1Width, 1, 3);
            rectangleSettings.add(rectangle1Height, 1, 4);
        }
        else
        {
            rectangleSettings.add(rectangle2X, 1, 1);
            rectangleSettings.add(rectangle2Y, 1, 2);
            rectangleSettings.add(rectangle2Width, 1, 3);
            rectangleSettings.add(rectangle2Height, 1, 4);
        }
        return rectangleSettings;
    }

    private void setDefault()
    {
        rectangle1.setFill(Color.WHITE);
        rectangle1.setStroke(Color.BLACK);
        rectangle2.setFill(Color.WHITE);
        rectangle2.setStroke(Color.BLACK);
    }


    private boolean intersects()
    {
        Point2D point1 = new Point2D(rectangle2.getX(), rectangle2.getY());
        Point2D point2 = new Point2D(rectangle2.getX(), rectangle2.getY() + rectangle2.getHeight());
        Point2D point3 = new Point2D(rectangle2.getX() + rectangle2.getWidth(), rectangle2.getY());
        Point2D point4 = new Point2D(rectangle2.getX() + rectangle2.getWidth(),
                rectangle2.getY() + rectangle2.getHeight());

        return rectangle1.contains(point1) || rectangle1.contains(point2)
                || rectangle1.contains(point3) || rectangle1.contains(point4);
    }
}
