package chapter_fifteen;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class TrianglePane extends Pane
{
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
        circle1 = new Circle(250, 250, 5);
        circle2 = new Circle(250, 300, 5);
        circle3 = new Circle(300, 275, 5);
        line1 = new Line(250, 250, 250, 300);
        line2 = new Line(250, 300, 300, 275);
        line3 = new Line(300, 275, 250, 250);
        draw();
    }


    public void draw()
    {
        setAngles();
        getChildren().addAll(circle1, circle2, circle3,
                line1, line2, line3, text1, text2, text3);

        circle1.setOnMouseDragged(e ->
        {
            circle1.setCenterX(e.getX());
            circle1.setCenterY(e.getY());

            line1.setStartX(e.getX());
            line1.setStartY(e.getY());

            line3.setEndX(e.getX());
            line3.setEndY(e.getY());
            setAngles();
        });

        circle2.setOnMouseDragged(e ->
        {
            circle2.setCenterX(e.getX());
            circle2.setCenterY(e.getY());

            line1.setEndX(e.getX());
            line1.setEndY(e.getY());

            line2.setStartX(e.getX());
            line2.setStartY(e.getY());
            setAngles();
        });


        circle3.setOnMouseDragged(e ->
        {
            circle3.setCenterX(e.getX());
            circle3.setCenterY(e.getY());

            line2.setEndX(e.getX());
            line2.setEndY(e.getY());

            line3.setStartX(e.getX());
            line3.setStartY(e.getY());
            setAngles();
        });
    }


    public void setAngles()
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
}
