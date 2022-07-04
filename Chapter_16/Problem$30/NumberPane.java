package chapter_sixteen;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class NumberPane extends VBox
{
    private final String SUCCESS_MESSAGE = "A consecutive four found";
    private final String FAILURE_MESSAGE = "Wrong Pattern";
    private final int[] factors = {1, -1, 6, -6, 7, -7, 8, -8};

    private static ArrayList<Button> pattern = new ArrayList<>();
    private static ArrayList<Button> solution = new ArrayList<>();

    public NumberPane(){ draw(); }


    public void draw()
    {
        Text status = new Text("");
        HBox statusContainer = new HBox(status);
        statusContainer.setAlignment(Pos.CENTER);

        // numbers
        GridPane numbersPane = new GridPane();
        numbersPane.setAlignment(Pos.CENTER);

        Button button = new Button();

        for (int i = 0; i < 6; i++)
        {
            for (int j = 0; j < 7; j++)
            {
                int random = (int) ((Math.random() * 10) % 10);
                Button number = new Button(random + "");
                numbersPane.add(number, j, i);

                number.setOnAction(e ->
                {
                    if (pattern.size() == 3)
                    {
                        if (check())
                            status.setText(SUCCESS_MESSAGE);
                        else
                            status.setText(FAILURE_MESSAGE);
                    }

                    if (pattern.contains(number))
                    {
                        pattern.remove(number);
                        number.getStyleClass().clear();
                        number.getStyleClass().addAll(button.getStyleClass());
                        number.setStyle(null);
                    }
                    else if (pattern.size() < 4)
                    {
                        if (validMove(numbersPane, number))
                        {
                            pattern.add(number);
                            number.setStyle("-fx-border-color: black");
                        }
                    }
                });
            }
        }

        addSolution(numbersPane);

        // solve button
        Button solve = new Button("Solve");
        solve.setOnAction(e -> markSolution());


        getChildren().addAll(status, numbersPane, solve);
        setSpacing(5); setAlignment(Pos.CENTER);
    }


    private boolean validMove(GridPane pane, Button button)
    {
        if (pattern.size() == 0)
            return true;

        if (pattern.size() == 1)
        {
            int difference = Math.abs(pane.getChildren().indexOf(pattern.get(pattern.size()-1))
                    - pane.getChildren().indexOf(button));
            return difference == 1 || difference == 7 || difference == 6 || difference == 8;
        }

        int difference = Math.abs(pane.getChildren().indexOf(pattern.get(pattern.size()-1))
                - pane.getChildren().indexOf(pattern.get(pattern.size()-2)));
        for (Button x: pattern)
        {
            int difference_ = Math.abs(pane.getChildren().indexOf(x)
                    - pane.getChildren().indexOf(button));
            if (difference == difference_)
                return true;
        }
        return false;
    }


    private boolean check()
    {
        boolean equals = true;
        for (int i = 0; i < pattern.size()-1; i++)
            equals &= pattern.get(i+1).getText().equals(pattern.get(i).getText());
        return equals;
    }


    private void addSolution(GridPane pane)
    {
        int randomIndex = (int) ((Math.random() * 100) % 42); // 0 - 41
        Button randomButton = (Button) pane.getChildren().get(randomIndex);
        int randomNumber = (int) (Math.random() * 10); // 0 - 9
        randomButton.setText(randomNumber + "");

        for (int j = factors.length-1; j > -1; j--)
        {
            int factor = factors[j];
            int newRandomIndex = randomIndex;
            ArrayList<Button> tempSolution = new ArrayList<>();
            int row = newRandomIndex / 6;
            int column = newRandomIndex % 7;
            for (int i = 0; i < 3; i++)
            {
                newRandomIndex += factor;

                // check if the they are at the same row
                if (j <= 1 && newRandomIndex/6 != row)
                    break;
                else if (j > 1 && j <= 3 && newRandomIndex%7 != column)
                    break;

                if (newRandomIndex < 0 || newRandomIndex > 41) break;

                Button currentButton = (Button) pane.getChildren().get(newRandomIndex);
                currentButton.setText(randomNumber + "");
                tempSolution.add(currentButton);
            }
            solution = tempSolution;
            if (tempSolution.size() == 3) break;
        }
        solution.add(randomButton);
    }

    public void markSolution()
    {
        // unmarked the solution
        Button button = new Button();
        for (Button x: pattern)
        {
            x.getStyleClass().clear();
            x.getStyleClass().addAll(button.getStyleClass());
            x.setStyle(null);
        }

        pattern.clear();

        for (Button x: solution)
            x.setStyle("-fx-border-color: black");

        pattern = (ArrayList<Button>) solution.clone();
    }
}
