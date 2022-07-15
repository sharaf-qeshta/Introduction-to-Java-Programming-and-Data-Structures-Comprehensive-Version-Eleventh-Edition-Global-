package chapter_eighteen;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Polyline;
import javafx.geometry.Pos;

public class HilbertCurvePane extends Pane
{
    private final int UP = 0;
    private final int RIGHT = 1;
    private final int DOWN = 2;
    private final int LEFT = 3;

    Label orderLabel = new Label("Enter Order:");
    TextField orderTextView = new TextField("0");
    Polyline polyline = new Polyline();
    Pane pane = new Pane(polyline);

    private double x1;
    private double y1;
    double length = 10;

    int order;

    public HilbertCurvePane()
    {
        setMinSize(400, 400);

        HBox hBox = new HBox(10, orderLabel, orderTextView);
        hBox.setAlignment(Pos.BASELINE_CENTER);
        hBox.setPadding(new Insets(10));

        orderTextView.setPrefColumnCount(4);
        orderTextView.setAlignment(Pos.BASELINE_RIGHT);
        orderTextView.setOnKeyPressed(e->
        {
            if (e.getCode() == KeyCode.ENTER)
            {
                try
                {
                    order = Integer.parseInt(orderTextView.getText());
                }
                catch (NumberFormatException ex)
                {
                    order = 0;
                    orderTextView.setText("0");
                }
                draw();
            }
            else if (e.getCode() == KeyCode.UP)
            {
                order = Integer.parseInt(orderTextView.getText()) + 1;
                orderTextView.setText(order + "");
                draw();
            }
            else if (e.getCode() == KeyCode.DOWN)
            {
                order = Math.max(Integer.parseInt(orderTextView.getText()) - 1, 0);
                orderTextView.setText(order + "");
                draw();
            }
        });
        VBox vBox = new VBox(pane, hBox);
        vBox.setSpacing(10);
        getChildren().addAll(vBox);
    }

    private void draw()
    {
        if (order == 0) return;

        polyline.getPoints().clear();
        length = 50 / order;
        x1 = Math.min(getWidth(), getHeight()) - 50;
        y1 = x1;
        polyline.getPoints().addAll(x1, y1);
        draw(order, DOWN);
    }

    private void draw(int order, int direction)
    {
        if (order == 1)
        {
            switch (direction)
            {
                case UP ->
                {
                    move(DOWN);
                    move(RIGHT);
                    move(UP);
                }
                case RIGHT ->
                {
                    move(LEFT);
                    move(UP);
                    move(RIGHT);
                }
                case DOWN ->
                {
                    move(UP);
                    move(LEFT);
                    move(DOWN);
                }
                case LEFT ->
                {
                    move(RIGHT);
                    move(DOWN);
                    move(LEFT);
                }
            }

        }
        else if (order > 1)
        {
            switch (direction)
            {
                case UP ->
                {
                    draw(order - 1, LEFT);
                    move(DOWN);
                    draw(order - 1, UP);
                    move(RIGHT);
                    draw(order - 1, UP);
                    move(UP);
                    draw(order - 1, RIGHT);
                }
                case RIGHT ->
                {
                    draw(order - 1, DOWN);
                    move(LEFT);
                    draw(order - 1, RIGHT);
                    move(UP);
                    draw(order - 1, RIGHT);
                    move(RIGHT);
                    draw(order - 1, UP);
                }
                case DOWN ->
                {
                    draw(order - 1, RIGHT);
                    move(UP);
                    draw(order - 1, DOWN);
                    move(LEFT);
                    draw(order - 1, DOWN);
                    move(DOWN);
                    draw(order - 1, LEFT);
                }
                case LEFT ->
                {
                    draw(order - 1, UP);
                    move(RIGHT);
                    draw(order - 1, LEFT);
                    move(DOWN);
                    draw(order - 1, LEFT);
                    move(LEFT);
                    draw(order - 1, DOWN);
                }
            }
        }
    }

    private void move(int direction)
    {
        ObservableList<Double> list = polyline.getPoints();
        switch (direction)
        {
            case UP -> list.addAll(x1, y1 -= length);
            case RIGHT -> list.addAll(x1 += length, y1);
            case DOWN -> list.addAll(x1, y1 += length);
            case LEFT -> list.addAll(x1 -= length, y1);
        }
    }
}
