package chapter_thirty_three;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class Problem$06Client extends Application
{
    private ArrayList<StudentAddress> addresses = new ArrayList<>();
    private int currentIndex = 0;
    ObjectInputStream fromServer;
    ObjectOutputStream toServer;


    @Override
    public void start(Stage stage)
    {
        try
        {
            Socket socket = new Socket("localhost", 8_000);
            fromServer = new ObjectInputStream(socket.getInputStream());
            toServer = new ObjectOutputStream(socket.getOutputStream());
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            System.exit(-1);
        }

        TextField tfName = new TextField();
        TextField tfStreet = new TextField();
        TextField tfCity = new TextField();
        TextField tfState = new TextField();
        TextField tfZip = new TextField();

        GridPane pane = new GridPane();
        pane.add(new Label("Name"), 0, 0);
        pane.add(tfName, 1, 0);
        pane.add(new Label("Street"), 0, 1);
        pane.add(tfStreet, 1, 1);
        pane.add(new Label("City"), 0, 2);
        HBox hBox = new HBox(2);
        pane.add(hBox, 1, 2);
        hBox.getChildren().addAll(tfCity, new Label("State"), tfState,
                new Label("Zip"), tfZip);


        Button btnAdd = new Button("Add");
        Button btnFirst = new Button("First");
        Button btnNext = new Button("Next");
        Button btnPrevious = new Button("Previous");
        Button btnLast = new Button("Last");

        HBox buttonsContainer = new HBox(btnAdd, btnFirst, btnNext, btnPrevious, btnLast);
        pane.add(buttonsContainer, 1, 3);
        GridPane.setHalignment(buttonsContainer, HPos.CENTER);

        pane.setAlignment(Pos.CENTER);
        tfName.setPrefColumnCount(15);
        tfStreet.setPrefColumnCount(15);
        tfCity.setPrefColumnCount(10);
        tfState.setPrefColumnCount(2);
        tfZip.setPrefColumnCount(3);

        btnAdd.setOnAction(e ->
        {
            try
            {
                String name = tfName.getText().trim();
                String street = tfStreet.getText().trim();
                String city = tfCity.getText().trim();
                String state = tfState.getText().trim();
                String zip = tfZip.getText().trim();

                StudentAddress address = new StudentAddress(name, street,
                        city, state, zip);
                toServer.writeObject(address);
                toServer.flush();
                addresses = (ArrayList<StudentAddress>) fromServer.readObject();
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
                System.exit(-1);
            }
        });

        btnFirst.setOnAction(e ->
        {
            currentIndex = 0;
            if (currentIndex < addresses.size())
            {
                StudentAddress address = addresses.get(currentIndex);
                tfName.setText(address.getName());
                tfCity.setText(address.getCity());
                tfState.setText(address.getState());
                tfStreet.setText(address.getStreet());
                tfZip.setText(address.getZip());
            }
        });

        btnNext.setOnAction(e ->
        {
            if (currentIndex+1 < addresses.size())
            {
                currentIndex++;
                StudentAddress address = addresses.get(currentIndex);
                tfName.setText(address.getName());
                tfCity.setText(address.getCity());
                tfState.setText(address.getState());
                tfStreet.setText(address.getStreet());
                tfZip.setText(address.getZip());
            }
        });

        btnPrevious.setOnAction(e ->
        {
            if (currentIndex-1 < addresses.size() && currentIndex-1 >= 0)
            {
                currentIndex--;
                StudentAddress address = addresses.get(currentIndex);
                tfName.setText(address.getName());
                tfCity.setText(address.getCity());
                tfState.setText(address.getState());
                tfStreet.setText(address.getStreet());
                tfZip.setText(address.getZip());
            }
        });

        btnLast.setOnAction(e ->
        {
            currentIndex = addresses.size()-1;
            if (currentIndex < addresses.size() && currentIndex >= 0)
            {
                StudentAddress address = addresses.get(currentIndex);
                tfName.setText(address.getName());
                tfCity.setText(address.getCity());
                tfState.setText(address.getState());
                tfStreet.setText(address.getStreet());
                tfZip.setText(address.getZip());
            }
        });

        Scene scene = new Scene(pane, 450, 200);
        stage.setTitle("Problem$06Client");
        stage.setScene(scene);
        stage.show();
    }
}
