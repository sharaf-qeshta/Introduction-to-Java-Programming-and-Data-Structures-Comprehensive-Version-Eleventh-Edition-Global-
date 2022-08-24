package chapter_twenty_four;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Stack;

/**
 * *24.10 (Animation: stack) Write a program to animate push and pop in a stack, as shown
 * in Figure 24.20a.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$10 extends Application
{
    private static final Stack<Integer> stack = new Stack<>();

    @Override
    public void start(Stage primaryStage)
    {
        VBox pane = new VBox(10);
        pane.setAlignment(Pos.CENTER);
        Pane stackGUI = drawStack(stack, 500);
        pane.getChildren().add(stackGUI);

        HBox settings = new HBox(5);
        Label enterValue = new Label("Enter a value: ");
        TextField value = new TextField();
        value.setPrefColumnCount(6);
        Button push = new Button("Push");
        Button pop = new Button("Pop");

        settings.getChildren().addAll(enterValue, value, push, pop);
        settings.setAlignment(Pos.CENTER);
        pane.getChildren().add(settings);

        push.setOnAction(e ->
        {
            int value_;
            try
            {
                value_ = Integer.parseInt(value.getText());
            }
            catch (Exception exception)
            {
                return;
            }

            stack.push(value_);
            pane.getChildren().set(0, drawStack(stack, 500));
        });


        pop.setOnAction(e ->
        {
            if (stack.isEmpty())
                return;
            stack.pop();
            pane.getChildren().set(0, drawStack(stack, 500));
        });

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Problem$10");
        primaryStage.show();
    }

    public Pane drawStack(Stack<Integer> stack, int parentWidth)
    {
        Pane pane = new Pane();
        pane.setMinSize(parentWidth, 200);
        pane.setStyle("-fx-border-color: black");

        if (stack.isEmpty())
            pane.getChildren().add(new Text(parentWidth/2.0 - 20, 50, "Stack is empty"));

        int x = parentWidth/2;
        int y = 50;
        for (int i = stack.size()-1; i > -1 ; i--)
        {
            Element element = new Element(stack.get(i), x, y, i == stack.size()-1);
            pane.getChildren().add(element);
            pane.getChildren().addAll(element.getDecorations());
            y += 20;
        }

        return pane;
    }

    private static class Element extends Rectangle
    {
        int value;
        boolean isTop;

        public Element(int value, int x, int y, boolean isTop)
        {
            super(x, y, 40, 20);
            setFill(Color.WHITE); setStroke(Color.BLACK);
            this.value = value;
            this.isTop = isTop;
        }

        public ArrayList<Node> getDecorations()
        {
            ArrayList<Node> decorations = new ArrayList<>();
            Text text = new Text(getX() + getWidth()/2 - 5, getY() + getHeight()/2 + 5, value + "");
            decorations.add(text);

            if (isTop)
            {
                double startY = getY() + getHeight()/2;
                Line line1 = new Line(getX(), startY, getX()-40, startY); // --
                Line line2 = new Line(getX(), startY, getX()-10, startY-10); // \
                Line line3 = new Line(getX(), startY, getX()-10, startY+10); // /
                Text topText = new Text(getX() - 70, startY, "Top");
                decorations.add(line1); decorations.add(line2); decorations.add(line3);
                decorations.add(topText);
            }

            return decorations;
        }
    }
}
