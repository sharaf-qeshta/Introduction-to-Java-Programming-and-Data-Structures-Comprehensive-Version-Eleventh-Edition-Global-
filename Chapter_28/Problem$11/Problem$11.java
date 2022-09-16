package chapter_twenty_eight;

import chapter_twenty_eight.samples.NineTailModel;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.List;
import java.util.Scanner;


/**
 * **28.11 (Revise Listing 28.14, NineTail.java) The program in Listing 28.14 lets the user
 * enter an input for the nine tails problem from the console and displays the result
 * on the console. Write a program that lets the user set an initial state of the nine
 * coins (see Figure 28.22a) and click the Solve button to display the solution, as
 * shown in Figure 28.22b. Initially, the user can click the mouse button to flip a
 * coin. Set a red color on the flipped cells.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$11 extends Application
{
    private static List<Integer> path;
    private static NineTailModel model;
    @Override
    public void start(Stage primaryStage)
    {
        System.out.print("Enter the initial nine coins Hs and Ts: ");
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        char[] initialNode = s.toCharArray();

        VBox pane = new VBox(10);
        pane.setAlignment(Pos.CENTER);


        HBox solutionsContainer = new HBox(10);
        solutionsContainer.setStyle("-fx-border-color: black");

        model = new NineTailModel();
        path = model.getShortestPath(NineTailModel.getIndex(initialNode));
        solutionsContainer.getChildren().add(new TailPane(initialNode,
                3, 3, null));

        pane.getChildren().add(solutionsContainer);

        HBox settings = new HBox(5);
        settings.setAlignment(Pos.CENTER);
        Button solve = new Button("Solve");
        Button startOver = new Button("Start Over");
        settings.getChildren().addAll(solve, startOver);
        pane.getChildren().add(settings);

        solve.setOnAction(e ->
        {
            solutionsContainer.getChildren().clear();
            char[] previous = null;
            for (int i = 0; i < path.size(); i++)
            {
                char[] characters = NineTailModel.getNode(path.get(i));
                solutionsContainer.getChildren()
                        .add(new TailPane(characters,
                                3, 3, previous));
                previous = characters;
            }
        });

        startOver.setOnAction(e ->
        {
            solutionsContainer.getChildren().clear();
            System.out.print("Enter the initial nine coins Hs and Ts: ");
            String string = input.nextLine();
            char[] newInitialNode = string.toCharArray();

            model = new NineTailModel();
            path = model.getShortestPath(NineTailModel.getIndex(newInitialNode));
            solutionsContainer.getChildren().add(new TailPane(newInitialNode,
                    3, 3, null));
        });

        Scene scene = new Scene(pane, 800, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Problem$11");
        primaryStage.show();
    }

    private static class TailPane extends GridPane
    {
        public TailPane(char[] nodes, int rows, int columns, char[] previousSolution)
        {
            int index = 0;
            if (previousSolution == null)
            {
                for (int i = 0; i < rows; i++)
                {
                    for (int j = 0; j < columns; j++)
                    {
                        Text text = new Text(nodes[index++] + " ");
                        text.setFont(Font.font("Arial", FontWeight.BOLD, 36));
                        text.setFill(Color.BLACK);
                        add(text, j, i);
                    }
                }
            }
            else
            {
                for (int i = 0; i < rows; i++)
                {
                    for (int j = 0; j < columns; j++)
                    {
                        Text text = new Text(nodes[index] + " ");
                        text.setFont(Font.font("Arial", FontWeight.BOLD, 36));
                        if (nodes[index] != previousSolution[index])
                            text.setFill(Color.RED);
                        else
                            text.setFill(Color.BLACK);
                        index++;
                        add(text, j, i);
                    }
                }
            }
            setStyle("-fx-border-color: black");
        }
    }
}
