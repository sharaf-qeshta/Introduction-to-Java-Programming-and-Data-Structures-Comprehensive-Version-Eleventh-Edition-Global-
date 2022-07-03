package chapter_sixteen;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class MonthPane extends VBox
{
    private Calendar calendar = Calendar.getInstance();
    private int year = calendar.get(Calendar.YEAR);
    private int monthIndex = calendar.get(Calendar.MONTH);
    private int limit = Integer.parseInt(MONTHS[monthIndex][1]);

    private final static String[][] MONTHS =
    {
            {"January", "31"},
            {"February", "28"},
            {"March", "31"},
            {"April", "30"},
            {"May", "31"},
            {"June", "30"},
            {"July", "31"},
            {"August", "31"},
            {"September", "30"},
            {"October", "31"},
            {"November", "30"},
            {"December", "31"}
    };

    private final static String[] DAYS = {"Sunday", "Monday", "Tuesday", "Wednesday",
            "Thursday", "Friday", "Saturday"};

    public MonthPane()
    {
        draw();
    }


    public MonthPane(Calendar calendar)
    {
        this.calendar = calendar;
        this.year = calendar.get(Calendar.YEAR);
        this.monthIndex = calendar.get(Calendar.MONTH);
        this.limit = Integer.parseInt(MONTHS[monthIndex][1]);
        draw();
    }

    private static void leapCheck(int year) // 29
    {
        boolean leap = (year % 4 == 0 & year % 100 != 0) | (year % 400 == 0);
        if (leap)
            MONTHS[1][1] = "29";
        else
            MONTHS[1][1] = "28";
    }

    private void draw()
    {
        leapCheck(year);
        // title
        Text label = new Text(  MONTHS[monthIndex][0] + ", " + year );
        HBox title = new HBox(label);
        title.setAlignment(Pos.CENTER);

        // days of the week
        HBox days = new HBox(5);
        days.setAlignment(Pos.CENTER);
        for (int i = 0; i < 7; i++)
            days.getChildren().add(new Text(DAYS[i]));

        // days of the month

        int previousMonthDays = Integer.parseInt(MONTHS[(monthIndex == 0)? 11 : monthIndex-1][1]);
        GridPane daysOfMonth = new GridPane();
        daysOfMonth.setAlignment(Pos.CENTER);
        daysOfMonth.setVgap(5); daysOfMonth.setHgap(35);

        Calendar firstDayOfMonth = new GregorianCalendar(year, monthIndex, 1);
        int dayIndex = firstDayOfMonth.get(Calendar.DAY_OF_WEEK) - 1;

        // adding previous month days
        for (int i = dayIndex-1; i >= 0; i--)
        {
            Text dayText = new Text(previousMonthDays-- + " ");
            dayText.setFill(Color.GRAY);
            daysOfMonth.add(dayText, i, 0);
        }

        int rowsNeeded = (dayIndex > 4 & limit == 31)? 6 : 5;
        // adding the current month days
        int day = 1;
        int row = 0, column = 0;
        for (int i = 0; i < rowsNeeded; i++) // rows
        {
            for (int j = 0; j < 7; j++) // columns
            {
                column = j;
                if (day > limit)
                {
                    break;
                }
                if (j >= dayIndex || i != 0)
                    daysOfMonth.add(new Text( day++ + " "), j, i);
            }

            if (day > limit)
            {
                row = i;
                break;
            }
        }


        // adding the next month days
        day = 1;
        for (int i = row; i < rowsNeeded; i++) // rows
        {
            for (int j = column; j < 7; j++) // columns
            {
                Text dayText = new Text(day++ + " ");
                dayText.setFill(Color.GRAY);
                daysOfMonth.add(dayText, j, i);
            }
            column = (rowsNeeded == 6)? 0 : column;
        }

        // creating buttons for next and prior
        Button next = new Button("Next");
        Button prior = new Button("Prior");

        HBox buttons = new HBox(5, prior, next);
        buttons.setAlignment(Pos.CENTER);

        setSpacing(5);
        setAlignment(Pos.CENTER);
        getChildren().addAll(title, days, daysOfMonth, buttons);

        next.setOnAction(e -> nextMonth());
        prior.setOnAction(e -> previousMonth());
    }


    public void nextMonth()
    {
        monthIndex = (monthIndex+1 >= 11)? 0 : monthIndex+1;
        year = (monthIndex == 0)? year+1 : year;
        calendar = new GregorianCalendar(year, monthIndex, 1);
        limit = Integer.parseInt(MONTHS[monthIndex][1]);
        getChildren().clear();
        draw();
    }

    public void previousMonth()
    {
        monthIndex = (monthIndex-1 <= -1)? 11 : monthIndex-1;
        year = (monthIndex == 11)? year-1 : year;
        calendar = new GregorianCalendar(year, monthIndex, 1);
        limit = Integer.parseInt(MONTHS[monthIndex][1]);
        getChildren().clear();
        draw();
    }
}
