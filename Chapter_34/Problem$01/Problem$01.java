package chapter_thirty_four;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * *34.1 (Access and update a Staff table) Write a program that views, inserts, and updates
 * staff information stored in a database, as shown in Figure 34.27a. The View button
 * displays a record with a specified ID. The Insert button inserts a new record. The
 * Update button updates the record for the specified ID. The Staff table is created
 * as follows:
 * create table Staff (
 *  id char(9) not null,
 *  lastName varchar(15),
 *  firstName varchar(15),
 *  mi char(1),
 *  address varchar(20),
 *  city varchar(20),
 *  state char(2),
 *  telephone char(10),
 *  email varchar(40),
 *  primary key (id)
 * );
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$01 extends Application
{
    @Override
    public void start(Stage stage) throws IOException
    {
        Parent root =
                FXMLLoader.load(getClass().getResource("Problem$01UI.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Problem$01");
        stage.show();
    }
}
