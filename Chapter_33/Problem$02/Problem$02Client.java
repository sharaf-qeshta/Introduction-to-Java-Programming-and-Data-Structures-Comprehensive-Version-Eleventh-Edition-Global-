package chapter_thirty_three;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Problem$02Client extends Application
{
    private DataInputStream fromServer;
    private DataOutputStream toServer;

    @Override
    public void start(Stage stage)
    {
        VBox pane = new VBox(5);
        pane.setAlignment(Pos.CENTER);

        GridPane dataContainer = new GridPane();

        dataContainer.add(new Label("Weight: "), 0, 0);
        TextField weight = new TextField();
        weight.setPrefColumnCount(12);
        dataContainer.add(weight, 1, 0);

        dataContainer.add(new Label("Height: "), 0, 1);
        TextField height = new TextField();
        height.setPrefColumnCount(12);
        dataContainer.add(height, 1, 1);

        Button submit = new Button("Submit");
        dataContainer.add(submit, 2, 1);

        TextArea connectionStatus = new TextArea();
        pane.getChildren().addAll(dataContainer, connectionStatus);

        Scene scene = new Scene(pane, 500, 500);
        stage.setScene(scene);
        stage.setTitle("Problem$02Client");
        stage.show();

        submit.setOnAction(e ->
        {
            double weight_ = Double.parseDouble(weight.getText());
            double height_ = Double.parseDouble(height.getText());
            try
            {
                toServer.writeDouble(weight_);
                toServer.flush();
                toServer.writeDouble(height_);
                toServer.flush();

                String response = fromServer.readUTF();

                connectionStatus.setText(connectionStatus.getText() + "\n" + response);
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }

        });

        try
        {
            Socket socket = new Socket(Problem$02Server.NAME, Problem$02Server.PORT);
            toServer = new DataOutputStream(socket.getOutputStream());
            fromServer = new DataInputStream(socket.getInputStream());
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
