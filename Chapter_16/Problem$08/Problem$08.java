package chapter_sixteen;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * **16.8 (Geometry: two circles intersect?) Write a program that enables the user to
 * specify the location and size of the circles, and displays whether the two circles
 * intersect, as shown in Figure 16.39a. Enable the user to point the mouse inside a
 * circle and drag it. As the circle is being dragged, the circle’s center coordinates
 * in the text fields are updated.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$08 extends Application
{
    private final Circle circle1 = new Circle(200, 250, 50, Color.WHITE);
    private final Circle circle2 = new Circle(300, 250, 50, Color.WHITE);

    // circle 1 settings
    private final TextField circle1CenterX =  new TextField();
    private final TextField circle1CenterY = new TextField();
    private final TextField circle1Radius = new TextField();

    // circle 2 settings
    private final TextField circle2CenterX = new TextField();
    private final TextField circle2CenterY = new TextField();
    private final TextField circle2Radius = new TextField();

    // intersection Answer
    Label answer = new Label(intersects());

    // handler
    EventHandler<ActionEvent> redrawHandler = e ->
    {
        double center1X, center1Y, radius1,
                center2X, center2Y, radius2;
        try
        {
            center1X = Double.parseDouble(circle1CenterX.getText());
            center1Y = Double.parseDouble(circle1CenterY.getText());
            radius1 = Double.parseDouble(circle1Radius.getText());

            center2X = Double.parseDouble(circle2CenterX.getText());
            center2Y = Double.parseDouble(circle2CenterY.getText());
            radius2 = Double.parseDouble(circle2Radius.getText());

        }
        catch (Exception ex)
        {
            System.out.println("Complete the information!!");
            return;
        }

        circle1.setCenterX(center1X);
        circle1.setCenterY(center1Y);
        circle1.setRadius(radius1);

        circle2.setCenterX(center2X);
        circle2.setCenterY(center2Y);
        circle2.setRadius(radius2);
        answer.setText(intersects());
    };

    @Override
    public void start(Stage primaryStage)
    {
        // default settings
        circle1.setStroke(Color.BLACK);
        circle2.setStroke(Color.BLACK);

        // intersection question
        Label intersects = new Label("Two circles intersect? ");
        HBox top = new HBox(10, intersects, answer);
        top.setAlignment(Pos.CENTER);

        // circles
        Pane circlesPane = new Pane(circle1, circle2);

        // circles settings

        // circle 1 settings
        GridPane circle1Settings = new GridPane();
        Label title1 = new Label("Enter Circle Info: ");
        circle1Settings.add(title1, 0, 0);

        Label center1XLabel = new Label("Center X: ");
        circle1Settings.add(center1XLabel, 0, 1);
        circle1Settings.add(circle1CenterX, 1, 1);
        circle1CenterX.setText(circle1.getCenterX() + "");

        Label center1YLabel = new Label("Center Y: ");
        circle1Settings.add(center1YLabel, 0, 2);
        circle1Settings.add(circle1CenterY, 1, 2);
        circle1CenterY.setText(circle1.getCenterY() + "");

        Label radius1 = new Label("Radius: ");
        circle1Settings.add(radius1, 0, 3);
        circle1Settings.add(circle1Radius, 1, 3);
        circle1Radius.setText(circle1.getRadius() + "");

        circle1Settings.setVgap(5); circle1Settings.setHgap(5);
        circle1Settings.setStyle("-fx-border-color:black");

        // circle 2 settings
        GridPane circle2Settings = new GridPane();
        Label title2 = new Label("Enter Circle Info: ");
        circle2Settings.add(title2, 0, 0);

        Label center2XLabel = new Label("Center X: ");
        circle2Settings.add(center2XLabel, 0, 1);
        circle2Settings.add(circle2CenterX, 1, 1);
        circle2CenterX.setText(circle2.getCenterX() + "");

        Label center2YLabel = new Label("Center Y: ");
        circle2Settings.add(center2YLabel, 0, 2);
        circle2Settings.add(circle2CenterY, 1, 2);
        circle2CenterY.setText(circle2.getCenterY() + "");

        Label radius2 = new Label("Radius: ");
        circle2Settings.add(radius2, 0, 3);
        circle2Settings.add(circle2Radius, 1, 3);
        circle2Radius.setText(circle2.getRadius()+ "");

        circle2Settings.setVgap(5); circle2Settings.setHgap(5);
        circle2Settings.setStyle("-fx-border-color:black");

        HBox settings = new HBox(10, circle1Settings, circle2Settings);
        settings.setAlignment(Pos.CENTER);

        // redraw button
        Button redraw = new Button("Redraw Circles");
        redraw.setOnAction(redrawHandler);


        VBox pane = new VBox(10, top, circlesPane, settings, redraw);
        pane.setAlignment(Pos.CENTER);


        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$08");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    /**(x0, y0, R0) and (x1, y1, R1)
     * ABS(R0 - R1) <= SQRT((x0 - x1)^2 + (y0 - y1)^2) <= (R0 + R1) */
    private String intersects()
    {
        double d1 = circle1.getRadius() + circle2.getRadius();
        double d2 = Math.abs(circle1.getRadius() - circle2.getRadius());
        double distance = Math.sqrt(Math.pow(circle1.getCenterX() - circle2.getCenterX(), 2)
                + Math.pow(circle1.getCenterY() - circle2.getCenterY(), 2));
        return (distance >= d2 && d1 >= distance)? "Yes" : "No";
    }
}
