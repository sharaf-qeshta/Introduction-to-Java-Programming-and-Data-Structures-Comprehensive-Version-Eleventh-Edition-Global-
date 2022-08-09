package chapter_twenty_three;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * **23.10 (Heap visualization) Write a program that displays a heap graphically, as shown
 * in Figure 23.10. The program lets you insert and delete an element from the heap.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$10 extends Application
{
    private static final ArrayList<Circle> CIRCLES = new ArrayList<>();
    private static final ArrayList<Line> LINES = new ArrayList<>();
    private static final ArrayList<Text> TEXTS = new ArrayList<>();
    private static final Heap<Integer> HEAP = new Heap<>();
    private static final int VERTICAL_GAP = 20;


    @Override
    public void start(Stage primaryStage)
    {
        Pane heapGUI = getHeapGUI();
        HBox hBox = new HBox(5);
        Label enterKeyLabel = new Label("Enter Key: ");
        TextField key = new TextField();
        key.setPrefColumnCount(6);
        Button insert = new Button("Insert");
        Button removeRoot = new Button("Remove the Root");

        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(enterKeyLabel, key, insert, removeRoot);

        VBox pane = new VBox(heapGUI, hBox);


        insert.setOnAction(e ->
        {
            int key_;
            try
            {
                key_ = Integer.parseInt(key.getText());
            }
            catch (Exception exception)
            {
                return;
            }

            HEAP.add(key_);
            pane.getChildren().set(0, getHeapGUI());
            key.setText("");
        });


        removeRoot.setOnAction(e ->
        {
            HEAP.remove();
            pane.getChildren().set(0, getHeapGUI());
        });

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$10");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public Pane getHeapGUI()
    {
        Pane pane = new Pane();
        CIRCLES.clear(); LINES.clear(); TEXTS.clear();
        if (HEAP.list.size() == 0)
            return pane;
        getHeapGUI(250, 20, 0, 125, new Circle());
        pane.getChildren().addAll(LINES);
        pane.getChildren().addAll(CIRCLES);
        pane.getChildren().addAll(TEXTS);
        return pane;
    }

    public void getHeapGUI(double x, double y, int currentIndex, double xFactor, Circle parent)
    {
        Circle circle = new Circle(x, y, 10);
        circle.setFill(Color.WHITE); circle.setStroke(Color.BLACK);
        CIRCLES.add(circle);

        Text text = new Text(x-5, y+5, HEAP.list.get(currentIndex) + "");
        TEXTS.add(text);

        if (currentIndex != 0)
        {
            Line line = new Line(parent.getCenterX(), parent.getCenterY(), x, y);
            LINES.add(line);
        }

        int leftChildIndex = 2 * currentIndex + 1;
        int rightChildIndex = 2 * currentIndex + 2;

        // left children exist
        if (leftChildIndex < HEAP.list.size())
            getHeapGUI(x - xFactor, y+VERTICAL_GAP, leftChildIndex, xFactor/2, circle);

        // right children exist
        if (rightChildIndex < HEAP.list.size())
            getHeapGUI(x + xFactor, y+VERTICAL_GAP, rightChildIndex, xFactor/2, circle);
    }
}
