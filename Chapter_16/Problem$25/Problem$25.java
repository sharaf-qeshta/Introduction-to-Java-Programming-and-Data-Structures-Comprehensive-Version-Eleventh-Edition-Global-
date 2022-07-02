package chapter_sixteen;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * **16.25 (Racing cars) Write a program that simulates four cars racing, as shown in
 * Figure 16.47b. You can set the speed for each car, with a maximum of 100.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$25 extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        TextField car1Speed = new TextField(); car1Speed.setPrefColumnCount(5);
        TextField car2Speed = new TextField(); car2Speed.setPrefColumnCount(5);
        TextField car3Speed = new TextField(); car3Speed.setPrefColumnCount(5);
        TextField car4Speed = new TextField(); car4Speed.setPrefColumnCount(5);

        HBox carsSettings = new HBox(5, new Label("Car 1"), car1Speed
                , new Label("Car 2"), car2Speed, new Label("Car 3"), car3Speed,
                new Label("Car 4"), car4Speed);
        carsSettings.setAlignment(Pos.CENTER);

        RacingCar car1 = new RacingCar(0, 100);
        RacingCar car2 = new RacingCar(0, 250);
        RacingCar car3 = new RacingCar(0, 400);
        RacingCar car4 = new RacingCar(0, 550);

        Pane pane = new Pane(carsSettings, car1, car2, car3, car4);

        Scene scene = new Scene(pane, 600, 600);
        primaryStage.setTitle("Problem$25");
        primaryStage.setScene(scene);
        primaryStage.show();

        car1Speed.setOnAction(e ->
        {
            double speed;
            try
            {
                speed = Double.parseDouble(car1Speed.getText());
            }
            catch (Exception ex)
            {
                System.out.println("Invalid Input For Car 1");
                return;
            }
            if (speed > 0 && speed < 100)
                car1.setSpeed(speed);
        });

        car2Speed.setOnAction(e ->
        {
            double speed;
            try
            {
                speed = Double.parseDouble(car2Speed.getText());
            }
            catch (Exception ex)
            {
                System.out.println("Invalid Input For Car 2");
                return;
            }
            if (speed > 0 && speed < 100)
                car2.setSpeed(speed);
        });


        car3Speed.setOnAction(e ->
        {
            double speed;
            try
            {
                speed = Double.parseDouble(car3Speed.getText());
            }
            catch (Exception ex)
            {
                System.out.println("Invalid Input For Car 3");
                return;
            }
            if (speed > 0 && speed < 100)
                car3.setSpeed(speed);
        });


        car4Speed.setOnAction(e ->
        {
            double speed;
            try
            {
                speed = Double.parseDouble(car4Speed.getText());
            }
            catch (Exception ex)
            {
                System.out.println("Invalid Input For Car 4");
                return;
            }
            if (speed > 0 && speed < 100)
                car4.setSpeed(speed);
        });
    }
}
