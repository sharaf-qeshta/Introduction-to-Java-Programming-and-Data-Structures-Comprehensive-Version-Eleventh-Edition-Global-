package chapter_eighteen;

import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;


public class HTree extends Pane
{
    private int order = 0;
    private static final HTree instance = new HTree();

    public static HTree getInstance(){ return instance; }
    private HTree(){}

    public void paint()
    {
        getChildren().clear();
        Point2D p1 = new Point2D(500 - 100, 100);
        Point2D p2 = new Point2D(500 - 100, 400);
        Point2D p3 = new Point2D(500 - 400, 100);
        Point2D p4 = new Point2D(500 - 400, 400);

        draw(order, p1, p2, p3, p4);
    }


    public void draw(int order, Point2D p1, Point2D p2, Point2D p3, Point2D p4)
    {
        if (order == 0)
        {
            Line line1 = new Line(p1.getX(), p1.getY(), p2.getX(), p2.getY());
            Line line2 = new Line(p3.getX(), p3.getY(), p4.getX(), p4.getY());
            Point2D mid1 = p1.midpoint(p2), mid2 = p3.midpoint(p4);
            Line middleLine = new Line(mid1.getX(), mid1.getY(), mid2.getX(), mid2.getY());
            getChildren().addAll(line1, line2, middleLine);
        }
        else
        {
            double sideLength = p1.distance(p2)/2;

            Point2D s1 = p3.add(sideLength/2, sideLength/2);
            Point2D s2 = s1.add(0, -sideLength);
            Point2D s3 = s2.add(-sideLength, 0);
            Point2D s4 = s3.add(0, sideLength);
            draw(order - 1, s1, s2, s3, s4);

            s1 = p1.add(sideLength/2, sideLength/2);
            s2 = s1.add(0, -sideLength);
            s3 = s2.add(-sideLength, 0);
            s4 =  s3.add(0, sideLength);
            draw(order - 1, s1, s2, s3, s4);

            s1 = p2.add(sideLength/2, sideLength/2);
            s2 = s1.add(0, -sideLength);
            s3 = s2.add(-sideLength, 0);
            s4 =  s3.add(0, sideLength);
            draw(order - 1, s1, s2, s3, s4);

            s1 = p4.add(sideLength/2, sideLength/2);
            s2 = s1.add(0, -sideLength);
            s3 = s2.add(-sideLength, 0);
            s4 =  s3.add(0, sideLength);
            draw(order - 1, s1, s2, s3, s4);

            draw(order - 1, p1, p2, p3, p4);
        }
    }


    public void setOrder(int order)
    {
        this.order = order;
        paint();
    }
}
