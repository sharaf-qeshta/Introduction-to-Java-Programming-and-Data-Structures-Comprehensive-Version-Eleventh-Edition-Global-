package chapter_thirty_five;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * *35.1 (Batch update) Write a program that inserts a thousand records to a database, and
 * compare the performance with and without batch updates, as shown in Figure 35.5a.
 * Suppose the table is defined as follows:
 * create table Temp(num1 double, num2 double, num3 double)
 *  Use the Math.random() method to generate random numbers for each record.
 * Create a dialog box that contains DBConnectionPanel, discussed in Exercise
 * 34.3. Use this dialog box to connect to the database. When you click the Connect
 * to Database button in Figure 35.5a, the dialog box in Figure 35.5b is displayed.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$01 extends Application
{
    @Override
    public void start(Stage stage)
    {
        DBConnectionPane connectionPane = new DBConnectionPane();

        Scene scene = new Scene(connectionPane, 350, 200);
        stage.setTitle("Problem$01");
        stage.setScene(scene);
        stage.show();
    }
}
