package chapter_eighteen;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

public class KochSnowflakePane extends BorderPane
{
    Pane pane = new Pane();
    ObservableList<Node> list = pane.getChildren();

    int order;

    KochSnowflakePane()
    {
        TextField textOrder = new TextField();
        textOrder.setAlignment(Pos.BASELINE_RIGHT);
        textOrder.setPrefColumnCount(4);
        Label lblOrder = new Label("Enter an order: ");

        textOrder.setOnKeyPressed(e ->
        {
            if (e.getCode() == KeyCode.ENTER)
            {
                try
                {
                    order = Integer.parseInt(textOrder.getText());
                }
                catch (NumberFormatException ex)
                {
                    order = 0;
                    textOrder.setText("0");
                }
            }
            else if (e.getCode() == KeyCode.UP)
            {
                order = Integer.parseInt(textOrder.getText()) + 1;
                textOrder.setText(order + "");
            }
            else if (e.getCode() == KeyCode.DOWN)
            {
                order = Math.max(Integer.parseInt(textOrder.getText()) - 1, 0);
                textOrder.setText(order + "");
            }
            draw();
        });

        textOrder.setText("0");
        pane.setPrefSize(400, 400);
        setCenter(pane);
        setMargin(pane, new Insets(100));

        HBox hBox = new HBox(20, lblOrder, textOrder);
        hBox.setAlignment(Pos.BASELINE_CENTER);
        hBox.setPadding(new Insets(30, 10, 10, 10));
        setBottom(hBox);
        draw();
    }

    private void draw()
    {
        list.clear();
        double length = 400;

        Line l1 = new Line(200, 0, 200
                + length * Math.cos(1 * (Math.PI * 2 / 6)),
                0 + length * Math.sin(1 * (Math.PI * 2 / 6)));

        Line l2 = new Line(l1.getEndX(), l1.getEndY(), l1.getEndX() - length, l1.getEndY());
        Line l3 = new Line(l2.getEndX(), l2.getEndY(), l1.getStartX(), l1.getStartY());
        list.addAll(l1, l2, l3);
        draw(order);
    }

    private void draw(int order)
    {
        if (order == 0)
            return;

        Line[] lines = new Line[list.size()];
        for (int i = 0; i < list.size(); i++)
            lines[i] = (Line) list.get(i);

        for (Line line : lines)
            createTriangle(line);
        draw(order - 1);
    }

    private void createTriangle(Line line)
    {
        double distance = getDistance(line) / 3;

        double dy = (line.getStartY() - line.getEndY());
        double dx = (line.getEndX() - line.getStartX());
        double theta = Math.atan2(dy, dx);

        double x1 = line.getStartX() + distance * Math.cos(theta);
        double y1 = line.getStartY() - distance * Math.sin(theta);

        double x2 = line.getEndX() + distance * Math.cos(theta + Math.toRadians(180));
        double y2 = line.getEndY() - distance * Math.sin(theta + Math.toRadians(180));

        double x3 = x2 + distance * Math.cos(theta + Math.toRadians(120));
        double y3 = y2 - distance * Math.sin(theta + Math.toRadians(120));

        Line l1 = new Line(line.getStartX(), line.getStartY(), x1, y1);
        Line l2 = new Line(x2, y2, line.getEndX(), line.getEndY());
        Line l3 = new Line(l1.getEndX(), l1.getEndY(), x3, y3);
        Line l4 = new Line(l3.getEndX(), l3.getEndY(), x2, y2);

        pane.getChildren().remove(line);
        list.addAll(l1, l2, l3, l4);
    }


    private double getDistance(Line line)
    {
        return Math.sqrt(Math.pow(line.getStartX() - line.getEndX(), 2)
                + Math.pow(line.getStartY() - line.getEndY(), 2));
    }
}
