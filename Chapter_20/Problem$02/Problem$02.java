package chapter_twenty;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.*;


/**
 * *20.2 (Store numbers in a linked list) Write a program that lets the user enter numbers
 * from a graphical user interface and displays them in a text area, as shown
 * in Figure 20.17a. Use a linked list to store the numbers. Do not store duplicate
 * numbers. Add the buttons Sort, Shuffle, and Reverse to sort, shuffle, and
 * reverse the list.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$02 extends Application
{
    private LinkedList<Number> numbers = new LinkedList<>();

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        // inserting a number
        Label enterANumber = new Label("Enter a Number: ");
        TextField number = new TextField();
        number.setPrefColumnCount(10);
        HBox container = new HBox(5, enterANumber, number);
        container.setAlignment(Pos.CENTER);

        // text area
        TextArea textArea = new TextArea();
        textArea.setEditable(false);
        ScrollPane textAreaPane = new ScrollPane(textArea);

        // options
        Button sort = new Button("Sort");
        Button shuffle = new Button("Shuffle");
        Button reverse = new Button("Reverse");
        HBox options = new HBox(10, sort, shuffle, reverse);
        options.setAlignment(Pos.CENTER);

        VBox pane = new VBox(5, container, textAreaPane, options);

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Problem$02");
        primaryStage.show();

        textArea.prefWidthProperty().bind(pane.widthProperty());
        textArea.prefHeightProperty().bind(pane.heightProperty().divide(1.5));

        number.setOnAction(e ->
        {
            int number_ = Integer.parseInt(number.getText());
            if (!numbers.contains(number_))
            {
                numbers.add(number_);
                updateView(textArea);
            }
        });

        sort.setOnAction(e ->
        {
            numbers.sort(Comparator.comparingInt(Number::intValue));
            updateView(textArea);
        });

        reverse.setOnAction(e ->
        {
            reverse();
            updateView(textArea);
        });

        shuffle.setOnAction(e ->
        {
            shuffle();
            updateView(textArea);
        });
    }

    private void updateView(TextArea textArea)
    {
        textArea.setText("");
        numbers.forEach(e -> textArea.appendText(e.toString() + " "));
    }


    private void shuffle()
    {
        for (int i = 0; i < numbers.size(); i++)
        {
            int index1 = (int) ((Math.random() * numbers.size() * 2) % numbers.size());

            Number temp = numbers.get(index1);
            numbers.set(index1, numbers.get(i));
            numbers.set(i, temp);
        }
    }


    private void reverse()
    {
        LinkedList<Number> temp = new LinkedList<>();
        ListIterator<Number> iterator = numbers.listIterator(numbers.size());
        while (iterator.hasPrevious())
            temp.add(iterator.previous());
        numbers = temp;
    }
}
