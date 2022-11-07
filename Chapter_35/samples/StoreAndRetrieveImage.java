package chapter_thirty_five.samples;

import java.sql.*;
import java.io.*;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import sample.DescriptionPane;

/**
 * Listing 35.8 StoreAndRetrieveImage.java
 * */
public class StoreAndRetrieveImage extends Application
{
    // Connection to the database
    private Connection connection;

    // Statement for static SQL statements
    private Statement stmt;

    // Prepared statement
    private PreparedStatement pstmt = null;
    private DescriptionPane descriptionPane
            = new DescriptionPane();

    private ComboBox<String> cboCountry = new ComboBox<>();

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage)
    {
        try
        {
            connectDB(); // Connect to DB
            storeDataToTable(); //Store data to the table (including image)
            fillDataInComboBox(); // Fill in combo box
            retrieveFlagInfo(cboCountry.getSelectionModel().getSelectedItem());
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        BorderPane paneForComboBox = new BorderPane();
        paneForComboBox.setLeft(new Label("Select a country: "));
        paneForComboBox.setCenter(cboCountry);
        cboCountry.setPrefWidth(400);
        BorderPane pane = new BorderPane();
        pane.setTop(paneForComboBox);
        pane.setCenter(descriptionPane);

        Scene scene = new Scene(pane, 350, 150);
        primaryStage.setTitle("StoreAndRetrieveImage");
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

        cboCountry.setOnAction(e ->
                retrieveFlagInfo(cboCountry.getValue()));
    }

    private void connectDB() throws Exception
    {
        // Load the driver
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver loaded");

        // Establish connection
        connection = DriverManager.getConnection
                ("jdbc:mysql://localhost/javabook", "scott", "tiger");
        System.out.println("Database connected");

        // Create a statement for static SQL
        stmt = connection.createStatement();

        // Create a prepared statement to retrieve flag and description
        pstmt = connection.prepareStatement("select flag, description " +
                "from Country where name = ?");
    }

    private void storeDataToTable()
    {
        String[] countries = {"Canada", "UK", "USA", "Germany",
                "Indian", "China"};

        String[] imageFilenames = {"image/ca.gif", "image/uk.gif",
                "image/us.gif", "image/germany.gif", "image/india.gif",
                "image/china.gif"};

        String[] descriptions = {"A text to describe Canadian " +
                "flag is omitted", "British flag ...", "American flag ...",
                "German flag ...", "Indian flag ...", "Chinese flag ..."};

        try
        {
            // Create a prepared statement to insert records
            PreparedStatement pstmt = connection.prepareStatement(
                    "insert into Country values(?, ?, ?)");

            // Store all predefined records
            for (int i = 0; i < countries.length; i++)
            {
                pstmt.setString(1, countries[i]);

                // Store image to the table cell
                java.net.URL url =
                        this.getClass().getResource(imageFilenames[i]);
                InputStream inputImage = url.openStream();
                pstmt.setBinaryStream(2, inputImage,
                        (int) (inputImage.available()));

                pstmt.setString(3, descriptions[i]);
                pstmt.executeUpdate();
            }

            System.out.println("Table Country populated");
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    private void fillDataInComboBox() throws Exception
    {
        ResultSet rs = stmt.executeQuery("select name from Country");
        while (rs.next())
        {
            cboCountry.getItems().add(rs.getString(1));
        }
        cboCountry.getSelectionModel().selectFirst();
    }

    private void retrieveFlagInfo(String name)
    {
        try
        {
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next())
            {
                Blob blob = rs.getBlob(1);
                ByteArrayInputStream in = new ByteArrayInputStream
                        (blob.getBytes(1, (int) blob.length()));
                Image image = new Image(in);
                ImageView imageView = new ImageView(image);
                descriptionPane.setImageView(imageView);
                descriptionPane.setTitle(name);
                String description = rs.getString(2);
                descriptionPane.setDescription(description);
            }
        }
        catch (Exception ex)
        {
            System.err.println(ex);
        }
    }
}
