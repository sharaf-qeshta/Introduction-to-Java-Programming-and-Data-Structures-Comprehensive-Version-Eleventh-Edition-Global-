package chapter_eighteen;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class NQueenPane extends GridPane
{
    private int queens;

    public NQueenPane(int queens)
    {
        this.queens = queens;
        draw();
    }

    public void draw()
    {
        int boxWidth = 500/queens, boxHeight = 500/queens;
        ArrayList<int[]> possibleSolutions = NQueensSolver.solve(queens);
        int[] randomSolution = possibleSolutions.get(
                (int) ((Math.random() * possibleSolutions.size() * 2) % possibleSolutions.size()));
        int n = randomSolution.length;

        for (int i = 0; i < n; i++)
        {
            int j = 0;
            for (int value : randomSolution)
            {
                Label label = new Label();
                label.setPrefWidth(boxWidth); label.setPrefHeight(boxHeight);
                label.setStyle("-fx-border-color: black");
                add(label, j, i);
                if (value == i)
                {
                    Image queen = new Image("chapter_eighteen/queen.png");
                    ImageView queenView = new ImageView(queen);
                    queenView.setFitWidth(boxWidth); queenView.setFitHeight(boxHeight);
                    label.setGraphic(queenView);
                }
                j++;
            }
        }
    }
}
