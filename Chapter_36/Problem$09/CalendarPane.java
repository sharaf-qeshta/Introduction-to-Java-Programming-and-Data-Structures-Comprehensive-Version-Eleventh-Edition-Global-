package chapter_thirty_six;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;


public class CalendarPane extends BorderPane
{
    private final Label lblHeader = new Label();

    private final Label[] lblDay = new Label[49];

    private final Calendar calendar;
    private int month;
    private int year;
    private Locale locale = Locale.US;

    public CalendarPane()
    {
        for (int i = 0; i < 49; i++)
        {
            lblDay[i] = new Label();
            lblDay[i].setTextAlignment(TextAlignment.RIGHT);
        }

        showDayNames();

        GridPane dayPane = new GridPane();
        dayPane.setAlignment(Pos.CENTER);

        dayPane.setHgap(10);
        dayPane.setVgap(10);
        for (int i = 0; i < 49; i++)
        {
            dayPane.add(lblDay[i], i % 7, i / 7);
        }

        this.setTop(lblHeader);
        BorderPane.setAlignment(lblHeader, Pos.CENTER);
        this.setCenter(dayPane);

        calendar = new GregorianCalendar();
        month = calendar.get(Calendar.MONTH);
        year = calendar.get(Calendar.YEAR);
        updateCalendar();

        showHeader();
        showDays();
    }

    /**
     * Update the day names based on locale
     */
    private void showDayNames()
    {
        DateFormatSymbols dfs = new DateFormatSymbols(locale);
        String[] dayNames = dfs.getWeekdays();

        for (int i = 0; i < 7; i++)
            lblDay[i].setText(dayNames[i + 1]);
    }

    /**
     * Update the header based on locale
     */
    private void showHeader()
    {
        SimpleDateFormat sdf =
                new SimpleDateFormat("MMMM yyyy", locale);
        String header = sdf.format(calendar.getTime());
        lblHeader.setText(header);
    }

    public void showDays()
    {
        int startingDayOfMonth = calendar.get(Calendar.DAY_OF_WEEK);

        Calendar cloneCalendar = (Calendar) calendar.clone();
        cloneCalendar.add(Calendar.DATE, -1);
        int daysInPrecedingMonth = cloneCalendar.getActualMaximum(
                Calendar.DAY_OF_MONTH);

        for (int i = 0; i < startingDayOfMonth - 1; i++)
        {
            lblDay[i + 7].setTextFill(Color.LIGHTGRAY);
            lblDay[i + 7].setText(daysInPrecedingMonth
                     - startingDayOfMonth + 2 + i + "");
        }

        int daysInCurrentMonth = calendar.getActualMaximum(
                Calendar.DAY_OF_MONTH);
        for (int i = 1; i <= daysInCurrentMonth; i++)
        {
            lblDay[i - 2 + startingDayOfMonth + 7].setTextFill(Color.BLACK);
            lblDay[i - 2 + startingDayOfMonth + 7].setText(i + "");
        }

        int j = 1;
        for (int i = daysInCurrentMonth - 1 + startingDayOfMonth + 7;
             i < 49; i++)
        {
            lblDay[i].setTextFill(Color.LIGHTGRAY);
            lblDay[i].setText(j++ + "");
        }
    }

    /**
     * Set the calendar to the first day of the
     * specified month and year
     */
    public void updateCalendar()
    {
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DATE, 1);
    }

    public int getMonth()
    {
        return month;
    }

    public void setMonth(int newMonth)
    {
        month = newMonth;
        updateCalendar();
        showHeader();
        showDays();
    }

    public int getYear()
    {
        return year;
    }

    public void setYear(int newYear)
    {
        year = newYear;
        updateCalendar();
        showHeader();
        showDays();
    }

    public void setLocale(Locale locale)
    {
        this.locale = locale;
        updateCalendar();
        showDayNames();
        showHeader();
        showDays();
    }
}
