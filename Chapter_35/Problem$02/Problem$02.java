package chapter_thirty_five;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * **35.2 (Scrollable result set) Write a program that uses the buttons First,
 * Next, Prior, Last,
 * Insert, Delete, and Update, and modify a single record in the Address table, as
 * shown in Figure 35.6.
 * The Address table is defined as follows:
 * create table Address (
 *  firstname varchar(25),
 *  mi char(1),
 *  lastname varchar(25),
 *  street varchar(40),
 *  city varchar(20),
 *  state varchar(2),
 *  zip varchar(5),
 *  telephone varchar(10),
 *  email varchar(30),
 *  primary key (firstname, mi, lastname)
 * );
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$02 extends Application
{
    @Override
    public void start(Stage stage) throws Exception
    {
        Parent root =
                FXMLLoader.load(getClass().getResource("Problem$02.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Problem$02");
        stage.show();
    }
}
