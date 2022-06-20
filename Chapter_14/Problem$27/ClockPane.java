package chapter_fourteen;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class ClockPane extends Pane
{
    private int hour;
    private int minute;
    private int second;

    /** Construct a default clock with the current time*/
    public ClockPane()
    {
        setCurrentTime();
    }

    /** Construct a clock with specified hour, minute, and second */
    public ClockPane(int hour, int minute, int second)
    {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    /** Return hour */
    public int getHour()
    {
        return hour;
    }

    /** Set a new hour */
    public void setHour(int hour)
    {
        this.hour = hour;
        paintClock();
    }

    /** Return minute */
    public int getMinute()
    {
        return minute;
    }

    /** Set a new minute */
    public void setMinute(int minute)
    {
        this.minute = minute;
        paintClock();
    }

    /** Return second */
    public int getSecond()
    {
        return second;
    }

    /** Set a new second */
    public void setSecond(int second)
    {
        this.second = second;
        paintClock();
    }

    /* Set the current time for the clock */
    public void setCurrentTime()
    {
        // Construct a calendar for the current date and time
        Calendar calendar = new GregorianCalendar();

        // Set current hour, minute and second
        this.hour = calendar.get(Calendar.HOUR_OF_DAY);
        this.minute = calendar.get(Calendar.MINUTE);
        this.second = calendar.get(Calendar.SECOND);

        paintClock(); // Repaint the clock
    }

    /** Paint the clock */
    private void paintClock()
    {
        // Initialize clock parameters
        double clockRadius =
                Math.min(getWidth(), getHeight()) * 0.8 * 0.5;
        double centerX = getWidth() / 2;
        double centerY = getHeight() / 2;

        // Draw circle
        Circle circle = new Circle(centerX, centerY, clockRadius);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);

        // Draw second hand
        double sLength = clockRadius * 0.8;
        double secondX = centerX + sLength *
                Math.sin(second * (2 * Math.PI / 60));
        double secondY = centerY - sLength *
                Math.cos(second * (2 * Math.PI / 60));
        Line sLine = new Line(centerX, centerY, secondX, secondY);
        sLine.setStroke(Color.RED);

        // Draw minute hand
        double mLength = clockRadius * 0.65;
        double xMinute = centerX + mLength *
                Math.sin(minute * (2 * Math.PI / 60));
        double minuteY = centerY - mLength *
                Math.cos(minute * (2 * Math.PI / 60));
        Line mLine = new Line(centerX, centerY, xMinute, minuteY);
        mLine.setStroke(Color.BLUE);

        // Draw hour hand
        double hLength = clockRadius * 0.5;
        double hourX = centerX + hLength *
                Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
        double hourY = centerY - hLength *
                Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
        Line hLine = new Line(centerX, centerY, hourX, hourY);
        hLine.setStroke(Color.GREEN);

        getChildren().clear(); // Clear the pane
        getChildren().addAll(circle, sLine, mLine, hLine);

        double part = 360.0/60;
        int hour = 3;
        double angle = 0;
        for (int i = 0; i < 60; i++)
        {
            double startX = clockRadius * Math.cos(Math.toRadians(angle)) + centerX;
            double startY = clockRadius * Math.sin(Math.toRadians(angle)) + centerY;

            double midX = ( centerX + startX ) / 2;
            double midY = ( centerY + startY ) / 2;

            angle += part;

            Line line;
            if (i % 5 == 0)
            {
                if (hour == 13)
                    hour = 1;
                for (int j = 0; j < 3; j++)
                {
                    midX = ( midX + startX ) / 2;
                    midY = ( midY + startY ) / 2;
                    if (j == 1)
                    {
                        Text text = new Text(midX, midY, hour++ + "");
                        getChildren().add(text);
                    }
                }

            }
            else
            {
                for (int j = 0; j < 4; j++)
                {
                    midX = ( midX + startX ) / 2;
                    midY = ( midY + startY ) / 2;
                }
            }
            line = new Line(startX, startY, midX, midY);

            getChildren().add(line);
        }
    }

    @Override
    public void setWidth(double width)
    {
        super.setWidth(width);
        paintClock();
    }

    @Override
    public void setHeight(double height)
    {
        super.setHeight(height);
        paintClock();
    }
}