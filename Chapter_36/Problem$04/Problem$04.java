package chapter_thirty_six;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Locale;
import java.util.TimeZone;

/**
 * 36.4 (Find the available locales and time zone IDs) Write two programs to display the
 * available locales and time zone IDs using buttons, as shown in Figure 36.16.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$04 extends Application
{
    private static final Locale[] LOCALES = Locale.getAvailableLocales();
    private static final String[] TIME_ZONES = TimeZone.getAvailableIDs();

    @Override
    public void start(Stage stage)
    {
        TextArea taContent = new TextArea();
        taContent.setEditable(false);

        Button allLocales = new Button("All Locales");
        Button allTimeZones = new Button("All Time Zones");
        HBox buttonsContainer = new HBox(20, allLocales, allTimeZones);
        buttonsContainer.setAlignment(Pos.CENTER);

        VBox pane = new VBox(10, taContent, buttonsContainer);
        Scene scene = new Scene(pane, 250, 250);
        stage.setScene(scene);
        stage.setTitle("Problem$04");
        stage.show();


        allLocales.setOnAction(e ->
        {
            taContent.setText("");
            for (Locale locale : LOCALES)
                taContent.appendText(locale
                        .getDisplayName() + " " + locale.toString() + "\n");
        });

        allTimeZones.setOnAction(e ->
        {
            taContent.setText("");
            for (String timeZone: TIME_ZONES)
                taContent.appendText(timeZone + "\n");
        });
    }
}
