package chapter_eighteen;

import javafx.scene.control.Label;

public class CustomLabel extends Label
{
    private int row, column;
    private int centerX, centerY;
    private int width, height;


    public CustomLabel(int row, int column,
                       int centerX, int centerY,
                       int width, int height)
    {
        this.row = row;
        this.column = column;
        this.centerX = centerX;
        this.centerY = centerY;
        this.width = width;
        this.height = height;
        setStyle("-fx-border-color: black");
        setPrefSize(width, height);
    }


    public int getRow()
    {
        return row;
    }

    public void setRow(int row)
    {
        this.row = row;
    }

    public int getColumn()
    {
        return column;
    }

    public void setColumn(int column)
    {
        this.column = column;
    }

    public int getCenterX()
    {
        return centerX;
    }

    public void setCenterX(int centerX)
    {
        this.centerX = centerX;
    }

    public int getCenterY()
    {
        return centerY;
    }

    public void setCenterY(int centerY)
    {
        this.centerY = centerY;
    }
}
