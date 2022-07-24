package chapter_twenty;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * ***20.17 (Game: the 24-point card game) This exercise is a variation of the 24-point
 * card game described in Programming Exercise 20.13. Write a program to
 * check whether there is a 24-point solution for the four specified numbers. The
 * program lets the user enter four values, each between 1 and 13, as shown in
 * Figure 20.20. The user can then click the Solve button to display the solution or
 * display “No solution” if none exists:
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$17 extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        TextField solution = new TextField();
        solution.setPrefColumnCount(12);
        solution.setEditable(false);
        Button solve = new Button("SOLVE");

        HBox solutionContainer = new HBox(5, solution, solve);
        solutionContainer.setAlignment(Pos.CENTER);

        TextField n1 = new TextField();
        n1.setPrefColumnCount(3);

        TextField n2 = new TextField();
        n2.setPrefColumnCount(3);

        TextField n3 = new TextField();
        n3.setPrefColumnCount(3);

        TextField n4 = new TextField();
        n4.setPrefColumnCount(3);

        HBox numbersContainer = new HBox(10, n1, n2, n3, n4);
        numbersContainer.setAlignment(Pos.CENTER);

        VBox pane = new VBox(10, solutionContainer, numbersContainer);
        pane.setAlignment(Pos.CENTER);

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$17");
        primaryStage.setScene(scene);
        primaryStage.show();


        solve.setOnAction(e -> {
            String[] numbers = new String[4];
            try
            {
                numbers[0] = n1.getText().trim();
                numbers[1] = n2.getText().trim();
                numbers[2] = n3.getText().trim();
                numbers[3] = n4.getText().trim();
            }
            catch (Exception ex)
            {
                return;
            }
            solution.setText(TwentyFourCardsSolver.getSolution(numbers));
        });
    }
}
