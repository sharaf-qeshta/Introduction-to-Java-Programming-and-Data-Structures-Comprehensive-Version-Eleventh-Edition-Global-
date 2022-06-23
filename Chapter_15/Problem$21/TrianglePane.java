package chapter_fifteen;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class TrianglePane extends Pane
{
    private static Circle container;
    private static final double PART = 360.0/3;

    private static Circle circle1;
    private static Circle circle2;
    private static Circle circle3;

    private static Line line1;
    private static Line line2;
    private static Line line3;

    private static final Text text1 = new Text();
    private static final Text text2 = new Text();
    private static final Text text3 = new Text();

    public TrianglePane()
    {
        draw();
    }


    public void draw()
    {
        container = new Circle(250, 250, 100);
        container.setFill(Color.WHITE);
        container.setStroke(Color.BLACK);

        // first circle
        double radians = (1 * PART) * (Math.PI / 180);
        double startX_ = Math.sqrt(Math.cos(radians) * Math.cos(radians)
                * container.getRadius() * container.getRadius()) + container.getCenterX();
        double startY_ = Math.sqrt(Math.sin(radians) * Math.sin(radians)
                * container.getRadius() * container.getRadius())  + container.getCenterY();

        circle1 = new Circle(startX_, startY_, 5);

        // third circle
        radians = (2 * PART) * (Math.PI / 180);
        startX_ = Math.sqrt(Math.cos(radians) * Math.cos(radians)
                * container.getRadius() * container.getRadius()) * -1 + container.getCenterX();
        startY_ = Math.sqrt(Math.sin(radians) * Math.sin(radians)
                * container.getRadius() * container.getRadius())  + container.getCenterY();

        circle2 = new Circle(startX_, startY_, 5);


        // second circle
        radians = (3 * PART) * (Math.PI / 180);
        startX_ = Math.sqrt(Math.cos(radians) * Math.cos(radians)
                * container.getRadius() * container.getRadius()) * -1 + container.getCenterX();
        startY_ = Math.sqrt(Math.sin(radians) * Math.sin(radians)
                * container.getRadius() * container.getRadius()) * -1 + container.getCenterY();

        circle3 = new Circle(startX_, startY_, 5);


        line1 = new Line(circle1.getCenterX(), circle1.getCenterY(), circle2.getCenterX(), circle2.getCenterY());
        line2 = new Line(circle2.getCenterX(), circle2.getCenterY(), circle3.getCenterX(), circle3.getCenterY());
        line3 = new Line(circle3.getCenterX(), circle3.getCenterY(), circle1.getCenterX(), circle1.getCenterY());

        setAngles();
        getChildren().addAll(container, circle1, circle2, circle3,
                line1, line2, line3, text1, text2, text3);


        circle1.setOnMouseDragged(e ->
        {
            if (isOnCircumference(e.getX(), e.getY()))
            {
                circle1.setCenterX(e.getX());
                circle1.setCenterY(e.getY());

                line1.setStartX(e.getX());
                line1.setStartY(e.getY());

                line3.setEndX(e.getX());
                line3.setEndY(e.getY());
                setAngles();
            }
        });

        circle2.setOnMouseDragged(e ->
        {
            if (isOnCircumference(e.getX(), e.getY()))
            {
                circle2.setCenterX(e.getX());
                circle2.setCenterY(e.getY());

                line1.setEndX(e.getX());
                line1.setEndY(e.getY());

                line2.setStartX(e.getX());
                line2.setStartY(e.getY());
                setAngles();
            }
        });


        circle3.setOnMouseDragged(e ->
        {
            if (isOnCircumference(e.getX(), e.getY()))
            {
                circle3.setCenterX(e.getX());
                circle3.setCenterY(e.getY());

                line2.setEndX(e.getX());
                line2.setEndY(e.getY());

                line3.setStartX(e.getX());
                line3.setStartY(e.getY());
                setAngles();
            }
        });
    }

    private void setAngles()
    {
        double c = Math.sqrt(Math.pow(circle1.getCenterX() - circle2.getCenterX(), 2)
         + Math.pow(circle1.getCenterY() - circle2.getCenterY(), 2));

        double a = Math.sqrt(Math.pow(circle2.getCenterX() - circle3.getCenterX(), 2)
                + Math.pow(circle2.getCenterY() - circle3.getCenterY(), 2));

        double b = Math.sqrt(Math.pow(circle3.getCenterX() - circle1.getCenterX(), 2)
                + Math.pow(circle3.getCenterY() - circle1.getCenterY(), 2));
        // A = acos((a * a − b * b − c * c) / (−2 * b * c))
        double A = Math.toDegrees(Math.acos((a*a - b*b - c*c) / (-2 * b * c)));
        // B = acos((b * b − a * a − c * c) / (−2 * a * c))
        double B = Math.toDegrees(Math.acos((b*b - a*a - c*c) / (-2 * a * c)));
        // C = acos((c * c − b * b − a * a) / (−2 * a * b))
        double C = Math.toDegrees(Math.acos((c*c - b*b - a*a) / (-2 * a * b)));

        // displaying angles
        text1.setX(circle1.getCenterX()-10);
        text1.setY(circle1.getCenterY()-10);
        text1.setText(String.format("%.2f", A));

        text2.setX(circle2.getCenterX()-10);
        text2.setY(circle2.getCenterY()-10);
        text2.setText(String.format("%.2f", B));

        text3.setX(circle3.getCenterX()+10);
        text3.setY(circle3.getCenterY()-10);
        text3.setText(String.format("%.2f", C));
    }


    private boolean isOnCircumference(double x, double y)
    {
        double distance = Math.sqrt(Math.pow(container.getCenterX() - x, 2)
        + Math.pow(container.getCenterY() - y, 2));

        return Math.abs(distance - container.getRadius()) <= 0.1;
    }
}
