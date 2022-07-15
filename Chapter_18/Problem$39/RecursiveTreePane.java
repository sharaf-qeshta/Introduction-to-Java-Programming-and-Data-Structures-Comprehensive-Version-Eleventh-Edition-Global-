package chapter_eighteen;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

public class RecursiveTreePane extends Pane
{
    private static final int ANGLE = 25;
    private final static RecursiveTreePane instance = new RecursiveTreePane();
    private int order = 0;

    public static RecursiveTreePane getInstance(){ return instance; }

    private RecursiveTreePane(){}

    public void paint()
    {
        setMaxHeight(200); setMaxWidth(200);
        getChildren().clear();
        double length =  60;

        draw(200, 300, 90, length, order);

        setOnMouseDragged(e ->
        {
            getChildren().clear();
            draw(e.getX(), e.getY(), 90, length, order);
        });
    }

    private void draw(double x, double y, double angle, double length, int order)
    {
        if (order <= 0) return;
        double x2 = x + length * Math.cos(Math.toRadians(angle));
        double y2 = y - length * Math.sin(Math.toRadians(angle));
        double x3 = x + length * Math.cos(Math.toRadians(angle));
        double y3 = y - length * Math.sin(Math.toRadians(angle));
        getChildren().add(new Line(x, y, x2, y2));
        getChildren().add(new Line(x, y, x3, y3));

        draw(x2, y2, angle + ANGLE, length * 0.8, order - 1);
        draw(x3, y3, angle - ANGLE, length * 0.8, order - 1);
    }

    public void setOrder(int order)
    {
        this.order = order;
        paint();
    }
}
