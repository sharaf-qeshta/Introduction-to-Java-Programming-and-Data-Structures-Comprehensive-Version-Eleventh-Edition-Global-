package chapter_thirty_six;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.Locale;
import java.util.ResourceBundle;


public class CalendarApp extends Application
{
    private ResourceBundle resourceBundle
            = ResourceBundle.getBundle("Problem$09Resource");

    private final CalendarPane calendarPane = new CalendarPane();
    private final Button btPrior = new Button("Prior");
    private final Button btNext = new Button("Next");
    private final ComboBox<String> cboLocales = new ComboBox<>();
    private final Locale[] availableLocales = Locale.getAvailableLocales();

    private final Label lblSelectLocale =
            new Label(resourceBundle.getString("select_a_locale"));
    private Stage stage;
    private Locale locale = Locale.US;

    @Override
    public void start(Stage primaryStage)
    {
        stage = primaryStage;
        HBox hBox = new HBox(5);
        hBox.getChildren().addAll(btPrior, btNext);
        hBox.setAlignment(Pos.CENTER);

        setAvailableLocales();
        HBox hBoxLocale = new HBox(5);
        hBoxLocale.getChildren().addAll(lblSelectLocale, cboLocales);

        BorderPane pane = new BorderPane();
        pane.setCenter(calendarPane);
        pane.setTop(hBoxLocale);
        hBoxLocale.setAlignment(Pos.CENTER);
        pane.setBottom(hBox);
        hBox.setAlignment(Pos.CENTER);


        Scene scene = new Scene(pane, 600, 300);
        primaryStage.setTitle(resourceBundle.getString("title"));
        primaryStage.setScene(scene);
        primaryStage.show();

        btPrior.setOnAction(e ->
        {
            int currentMonth = calendarPane.getMonth();
            if (currentMonth == 0)
            {
                calendarPane.setYear(calendarPane.getYear() - 1);
                calendarPane.setMonth(11);
            }
            else
            {
                calendarPane.setMonth((currentMonth - 1) % 12);
            }
        });

        btNext.setOnAction(e ->
        {
            int currentMonth = calendarPane.getMonth();
            if (currentMonth == 11)
                calendarPane.setYear(calendarPane.getYear() + 1);

            calendarPane.setMonth((currentMonth + 1) % 12);
        });

        cboLocales.setOnAction(e ->
        {
            Locale locale = availableLocales[cboLocales.
                    getSelectionModel().getSelectedIndex()];
            calendarPane.setLocale(locale);
            this.locale = locale;
            updateUI();
        });
    }

    public void updateUI()
    {
        resourceBundle = ResourceBundle.getBundle("Problem$09Resource", locale);
        stage.setTitle(resourceBundle.getString("title"));
        lblSelectLocale.setText(resourceBundle.getString("select_a_locale"));
    }

    private void setAvailableLocales()
    {
        for (Locale availableLocale : availableLocales)
            cboLocales.getItems().add(availableLocale
                    .getDisplayName() + " " + availableLocale.toString());

        cboLocales.getSelectionModel().selectFirst();
    }
}
