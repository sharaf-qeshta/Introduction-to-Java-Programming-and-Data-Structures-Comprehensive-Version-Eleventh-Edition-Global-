package chapter_thirty_six;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/**
 * **36.2 (Display date and time) Write a program that displays the current date and time as
 * shown in Figure 36.14. The program enables the user to select a locale, time zone,
 * date style, and time style from the combo boxes.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$02 extends Application
{
    private static final Locale[] LOCALES = Locale.getAvailableLocales();
    private static final String[] TIME_ZONES = TimeZone.getAvailableIDs();

    @Override
    public void start(Stage stage)
    {
        Label lblDate = new Label("Date: ");
        TextField txtDate = new TextField();
        Label lblTime = new Label("Time: ");
        TextField txtTime = new TextField();
        HBox row1 = new HBox(5, lblDate, txtDate, lblTime, txtTime);

        Label lblLocale = new Label("Locale: ");
        ComboBox<String> cboLocale = new ComboBox<>();
        for (Locale locale : LOCALES)
            cboLocale.getItems().add(locale
                    .getDisplayName() + " " + locale.toString());
        cboLocale.getSelectionModel().selectFirst();

        Label lblTimeZone = new Label("Time Zone: ");
        ComboBox<String> cboTimeZone = new ComboBox<>();
        for (String timeZone : TIME_ZONES)
            cboTimeZone.getItems().add(timeZone);
        cboTimeZone.getSelectionModel().selectFirst();

        HBox row2 = new HBox(5, lblLocale, cboLocale, lblTimeZone, cboTimeZone);

        VBox pane = new VBox(5, row1, row2);
        Scene scene = new Scene(pane, 500, 500);
        stage.setScene(scene);
        stage.setTitle("Problem$02");
        stage.show();

        EventHandler<ActionEvent> eventHandler = event ->
        {
            Locale locale = LOCALES[cboLocale.getSelectionModel().getSelectedIndex()];
            TimeZone timeZone = TimeZone.getTimeZone
                    (TIME_ZONES[cboTimeZone.getSelectionModel().getSelectedIndex()]);

            // add time
            Calendar calendar = new GregorianCalendar(timeZone, locale);
            DateFormat formatter = DateFormat.getDateTimeInstance
                    (DateFormat.MEDIUM, DateFormat.LONG, locale);
            formatter.setTimeZone(timeZone);
            txtTime.setText(formatter.format(calendar.getTime()));

            // add date
            SimpleDateFormat sdf =
                    new SimpleDateFormat("EEE, MMM d, yyyy", locale);
            txtDate.setText(sdf.format(calendar.getTime()));
        };

        cboLocale.setOnAction(eventHandler);
        cboTimeZone.setOnAction(eventHandler);
    }
}
