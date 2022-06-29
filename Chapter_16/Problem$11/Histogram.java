package chapter_sixteen;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;


public class Histogram extends Pane
{
    private int[] letters;


    public Histogram(int[] letters)
    {
        this.letters = letters;
        paint();
    }


    public void rePaint(int[] letters)
    {
        this.letters = letters;
        getChildren().clear();
        paint();
    }


    private void paint()
    {
        // x Axis
        Line xAxis = new Line();
        xAxis.setStartX(0);
        xAxis.startYProperty().bind(heightProperty().divide(2));
        xAxis.endXProperty().bind(widthProperty());
        xAxis.endYProperty().bind(heightProperty().divide(2));
        getChildren().add(xAxis);

        // draw letters
        for (int i = 0; i < 26; i++)
        {
            char letter = (char) (i + 65);
            Text text = new Text(letter + "");
            text.yProperty().bind(heightProperty().divide(2).add(20));
            text.xProperty().bind(widthProperty().divide(26).multiply(i));
            getChildren().add(text);
        }

        // draw statics
        shrink(10);
        int maxIndex = getMaxIndex();
        int minIndex = getMinIndex();
        int divisor = (letters[minIndex] == 0)? 1 : letters[maxIndex] - letters[minIndex];
        for (int i = 0; i < 26; i++)
        {
            if (letters[i] != 0)
            {
                Rectangle rectangle = new Rectangle();
                rectangle.setFill(Color.WHITE); rectangle.setStroke(Color.BLACK);
                rectangle.xProperty().bind(widthProperty().divide(26).multiply(i));
                rectangle.yProperty().bind(heightProperty().divide(2).
                        subtract(heightProperty().divide(26).multiply(letters[i]/divisor)));
                rectangle.widthProperty().bind(widthProperty().divide(26).divide(2));
                rectangle.heightProperty().bind(heightProperty().divide(26).multiply(letters[i]/divisor));
                getChildren().add(rectangle);
            }
        }
    }


    private int getMaxIndex()
    {
        int index = 0;
        for (int i = 0; i < 26; i++)
        {
            if (letters[i] > letters[index])
                index = i;
        }
        return index;
    }

    private int getMinIndex()
    {
        int index = 0;
        for (int i = 0; i < 26; i++)
        {
            if (letters[i] < letters[index])
                index = i;
        }
        return index;
    }

    private void shrink(int factor)
    {
        for (int i = 0; i < letters.length; i++)
            letters[i] /= factor;
    }
}
