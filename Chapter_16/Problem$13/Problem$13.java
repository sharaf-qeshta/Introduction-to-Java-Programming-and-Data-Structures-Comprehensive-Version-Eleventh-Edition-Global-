package chapter_sixteen;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * *16.13 (Compare loans with various interest rates) Rewrite Programming Exercise
 * 5.21 to create a GUI, as shown in Figure 16.41b. Your program should let the
 * user enter the loan amount and loan period in the number of years from text
 * fields, and it should display the monthly and total payments for each interest
 * rate starting from 5% to 8%, with increments of one-eighth, in a text area.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$13 extends Application
{
    public static final double BEGIN_INTEREST = 5.0;
    public static final double END_INTEREST = 8.0;
    public static final double INTEREST_INCREMENT = 0.125;
    @Override
    public void start(Stage primaryStage)
    {
        // inputs
        Label loanAmountLabel = new Label("Loan Amount");
        TextField loanAmount = new TextField();
        Label numberOfYearsLabel = new Label("Number Of Years");
        TextField numberOfYears = new TextField();
        Button showTable = new Button("Show Table");

        HBox controllers = new HBox(10, loanAmountLabel, loanAmount, numberOfYearsLabel, numberOfYears, showTable);
        controllers.setAlignment(Pos.CENTER);

        // table
        TextArea table = new TextArea();
        ScrollPane tableContainer = new ScrollPane(table);

        // main pane
        VBox pane = new VBox(10, controllers, tableContainer);

        table.prefWidthProperty().bind(pane.widthProperty());
        table.prefHeightProperty().bind(pane.heightProperty().subtract(20));

        Scene scene = new Scene(pane, 600, 500);
        primaryStage.setTitle("Problem$13");
        primaryStage.setScene(scene);
        primaryStage.show();

        // creating table
        showTable.setOnAction(e ->
        {
            double loanAmount_; int years;
            try
            {
                loanAmount_ = Double.parseDouble(loanAmount.getText());
                years = Integer.parseInt(numberOfYears.getText());
            }
            catch (Exception ex)
            {
                System.out.println("Wrong Entries");
                return;
            }
            adjustTable(table, loanAmount_, years);
        });
    }

    private void adjustTable(TextArea table, double loanAmount, int years)
    {
        ArrayList<String> lines = getRows(loanAmount, years);
        table.clear();

        String content = String.format("%s%20s%20s",
                "Interest Rte", "Monthly Payment", "Total Payment") + "\n";
        for (String line: lines)
            content += line + "\n";

        table.setText(content);
    }


    private ArrayList<String> getRows(double loanAmount, int years)
    {
        ArrayList<String> lines = new ArrayList<>();

        for (double i = BEGIN_INTEREST; i < END_INTEREST; i+= INTEREST_INCREMENT)
        {
            double monthlyPayment =  loanAmount * (i/1200) / (1 - 1 / Math.pow(1 + i/1200, years * 12));

            double totalCost = monthlyPayment * 12 * years;

            lines.add(String.format("%s%30s%30s", String.format("%.2f", i),
                    String.format("%.2f", monthlyPayment), String.format("%.2f", totalCost)));
        }

        return lines;
    }
}
