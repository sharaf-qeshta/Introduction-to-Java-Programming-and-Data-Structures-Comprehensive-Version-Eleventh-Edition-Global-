package chapter_twenty_two;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class NQueenPane extends ScrollPane
{
    private int queens;

    public NQueenPane(int queens)
    {
        this.queens = queens;
        draw();
    }

    public void draw()
    {
        int boxWidth = 500/(queens*2), boxHeight = 500/(queens*2);
        ArrayList<int[]> possibleSolutions = NQueensSolver.solve(queens);
        HBox hBox = new HBox(10);
        for (int i = 0; i < possibleSolutions.size(); i++)
            hBox.getChildren().add(getSolutionGUI(possibleSolutions.get(i), i, boxWidth, boxHeight));
        setContent(hBox);
    }

    public VBox getSolutionGUI(int[] solution, int index,
                               int boxWidth, int boxHeight)
    {
        VBox pane = new VBox(10);
        Label solutionNumber = new Label("Solution " + (index + 1));
        pane.setAlignment(Pos.CENTER);
        solutionNumber.setAlignment(Pos.CENTER);
        GridPane board = new GridPane();

        for (int i = 0; i < solution.length; i++)
        {
            int j = 0;
            for (int value : solution)
            {
                Label label = new Label();
                label.setPrefWidth(boxWidth); label.setPrefHeight(boxHeight);
                label.setStyle("-fx-border-color: black");
                board.add(label, j, i);
                if (value == i)
                {
                    Image queen = new Image("chapter_twenty_two/queen.png");
                    ImageView queenView = new ImageView(queen);
                    queenView.setFitWidth(boxWidth); queenView.setFitHeight(boxHeight);
                    label.setGraphic(queenView);
                }
                j++;
            }
        }
        pane.getChildren().addAll(solutionNumber, board);
        return pane;
    }
}
