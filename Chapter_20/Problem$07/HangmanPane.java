package chapter_twenty;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

import java.util.LinkedList;
import java.util.Queue;

public class HangmanPane extends Pane
{
    Queue<Shape> components = new LinkedList<>();

    public HangmanPane()
    {
        draw();
    }

    public void draw()
    {
        components.clear();
        getChildren().clear();
        // base
        Arc arc = new Arc(150, 500, 150, 150, 45, 90);
        arc.setFill(Color.WHITE);
        arc.setType(ArcType.OPEN);
        arc.setStroke(Color.BLACK);
        components.add(arc);

        // stick
        Line line1 = new Line();
        line1.setStartX(150);
        line1.setStartY(350);
        line1.setEndX(150);
        line1.setEndY(100);
        components.add(line1);

        Line line2 = new Line();
        line2.setStartX(150);
        line2.setStartY(100);
        line2.setEndX(300);
        line2.setEndY(100);
        components.add(line2);

        Line line3 = new Line();
        line3.setStartX(300);
        line3.setStartY(100);
        line3.setEndX(300);
        line3.setEndY(150);
        components.add(line3);

        // head
        Circle circle = new Circle();
        circle.setCenterX(300);
        circle.setCenterY(175);
        circle.setRadius(25);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        components.add(circle);


        // body
        Line line4 = new Line();
        line4.setStartX(300);
        line4.setStartY(200);
        line4.setEndX(300);
        line4.setEndY(300);
        components.add(line4);


        // hands
        Line line5 = new Line();
        line5.setStartX(300);
        line5.setStartY(200);
        line5.setEndX(350);
        line5.setEndY(250);
        components.add(line5);

        Line line6 = new Line();
        line6.setStartX(300);
        line6.setStartY(200);
        line6.setEndX(250);
        line6.setEndY(250);
        components.add(line6);


        // legs
        Line line7 = new Line();
        line7.setStartX(300);
        line7.setStartY(300);
        line7.setEndX(350);
        line7.setEndY(350);
        components.add(line7);

        Line line8 = new Line();
        line8.setStartX(300);
        line8.setStartY(300);
        line8.setEndX(250);
        line8.setEndY(350);
        components.add(line8);
    }


    public void next()
    {
        if (components.size() > 0)
            getChildren().add(components.remove());
        else
            Problem$07.finish = true;
    }
}
