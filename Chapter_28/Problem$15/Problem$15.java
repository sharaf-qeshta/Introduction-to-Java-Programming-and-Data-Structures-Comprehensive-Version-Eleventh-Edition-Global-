package chapter_twenty_eight;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
 * *28.15 (4 * 4 16 tails GUI) Rewrite Programming Exercise 28.14 to enable the user
 * to set an initial pattern of the 4 * 4 16 tails problem (see Figure 28.23a). The
 * user can click the Solve button to display the solution, as shown in Figure
 * 28.23b. Initially, the user can click the mouse button to flip a coin. If a solution
 * does not exist, display a message dialog to report it.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$15 extends Application
{
    private static List<Integer> path;
    private static SixteenTailModel model;

    @Override
    public void start(Stage primaryStage)
    {
        System.out.print("Enter the initial sixteen coins Hs and Ts: ");
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        char[] initialNode = s.toCharArray();

        VBox pane = new VBox(10);
        pane.setAlignment(Pos.CENTER);

        Label status = new Label();
        pane.getChildren().add(status);

        HBox solutionsContainer = new HBox(10);
        solutionsContainer.setStyle("-fx-border-color: black");

        model = new SixteenTailModel();
        path = model.getShortestPath(SixteenTailModel.getIndex(initialNode));
        solutionsContainer.getChildren().add(new TailPane(initialNode,
                4, 4, null));

        pane.getChildren().add(solutionsContainer);

        HBox settings = new HBox(5);
        settings.setAlignment(Pos.CENTER);
        Button solve = new Button("Solve");
        Button startOver = new Button("Start Over");
        settings.getChildren().addAll(solve, startOver);
        pane.getChildren().add(settings);

        solve.setOnAction(e ->
        {
            if (path.size() == 1)
            {
                status.setText("There`s no solution");
                return;
            }
            status.setText("A solution found");

            solutionsContainer.getChildren().clear();
            char[] previous = null;
            for (int i = 0; i < path.size(); i++)
            {
                char[] characters = SixteenTailModel.getNode(path.get(i));
                solutionsContainer.getChildren()
                        .add(new TailPane(characters,
                                4, 4, previous));
                previous = characters;
            }
        });

        startOver.setOnAction(e ->
        {
            status.setText("");

            solutionsContainer.getChildren().clear();
            System.out.print("Enter the initial sixteen coins Hs and Ts: ");
            String string = input.nextLine();
            char[] newInitialNode = string.toCharArray();

            model = new SixteenTailModel();
            path = model.getShortestPath(SixteenTailModel.getIndex(newInitialNode));
            solutionsContainer.getChildren().add(new TailPane(newInitialNode,
                    4, 4, null));
        });

        Scene scene = new Scene(pane, 800, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Problem$15");
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
