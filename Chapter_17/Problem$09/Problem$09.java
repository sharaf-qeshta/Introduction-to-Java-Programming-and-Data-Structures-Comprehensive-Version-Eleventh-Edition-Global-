package chapter_seventeen;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import chapter_seventeen.database.Helper;
import chapter_seventeen.model.Address;


/**
 * ***17.9 (Address book) Write a program that stores, retrieves, adds,
 * and updates addresses as
 * shown in Figure 17.20. Use a fixed-length string for storing each attribute
 * in the address.
 * Use random-access file for reading and writing an address. Assume the sizes of the
 * name, street, city, state, and zip are 32, 32, 20, 2, and 5 bytes, respectively.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$09 extends Application
{
    private int currentIndex = -1;
    @Override
    public void start(Stage primaryStage)
    {
        Scene scene = new Scene(getUI(), 600, 500);
        primaryStage.setTitle("Problem$09");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
    }

    private VBox getUI()
    {
        Label nameLabel = new Label("Name");
        TextField name = new TextField();
        name.setPrefColumnCount(32);
        HBox nameHBox = new HBox(10, nameLabel, name);

        Label streetLabel = new Label("Street");
        TextField street = new TextField();
        street.setPrefColumnCount(32);
        HBox streetHBox = new HBox(10, streetLabel, street);

        Label cityLabel = new Label("City");
        TextField city = new TextField();

        Label stateLabel = new Label("State");
        TextField state = new TextField();
        state.setPrefColumnCount(5);

        Label zipLabel = new Label("ZIP");
        TextField zip = new TextField();
        zip.setPrefColumnCount(5);

        HBox otherHBox = new HBox(10, cityLabel, city, stateLabel, state, zipLabel, zip);


        // buttons
        Button add = new Button("Add");
        Button first = new Button("First");
        Button next = new Button("Next");
        Button previous = new Button("Previous");
        Button last = new Button("Last");
        Button update = new Button("Update");

        // listeners
        add.setOnAction(e ->
        {
            String name_, street_, city_, state_, zip_;
            try
            {
                name_ = name.getText().trim();
                street_ = street.getText().trim();
                city_ = city.getText().trim();
                state_ = state.getText().trim();
                zip_ = zip.getText().trim();
            }
            catch (Exception ex)
            {
                return;
            }
            Address address = new Address(name_, street_, city_, state_, zip_);
            Helper.add(address);
            currentIndex = Helper.addresses.indexOf(address);
        });

        first.setOnAction(e ->
        {
            if (Helper.addresses.size() == 0) // nothing in the db
                return;
            Address address = Helper.addresses.get(0); // first address
            currentIndex = 0;
            name.setText(address.getName());
            street.setText(address.getStreet());
            city.setText(address.getCity());
            state.setText(address.getState());
            zip.setText(address.getZip());
        });

        next.setOnAction(e ->
        {
            if (currentIndex+1 >= Helper.addresses.size()) // reach the bound
                return;
            Address address = Helper.addresses.get(++currentIndex); // next address
            name.setText(address.getName());
            street.setText(address.getStreet());
            city.setText(address.getCity());
            state.setText(address.getState());
            zip.setText(address.getZip());
        });


        previous.setOnAction(e ->
        {
            if (currentIndex-1 < 0) // reach the bound
                return;
            Address address = Helper.addresses.get(--currentIndex); // previous address
            name.setText(address.getName());
            street.setText(address.getStreet());
            city.setText(address.getCity());
            state.setText(address.getState());
            zip.setText(address.getZip());
        });

        last.setOnAction(e ->
        {
            if (Helper.addresses.size() == 0) // nothing in the db
                return;
            Address address = Helper.addresses.get(Helper.addresses.size()-1); // last address
            currentIndex = Helper.addresses.size()-1;
            name.setText(address.getName());
            street.setText(address.getStreet());
            city.setText(address.getCity());
            state.setText(address.getState());
            zip.setText(address.getZip());
        });


        update.setOnAction(e ->
        {
            String name_, street_, city_, state_, zip_;
            try
            {
                name_ = name.getText().trim();
                street_ = street.getText().trim();
                city_ = city.getText().trim();
                state_ = state.getText().trim();
                zip_ = zip.getText().trim();
            }
            catch (Exception ex)
            {
                return;
            }
            Address address = new Address(name_, street_, city_, state_, zip_);
            Helper.update(Helper.addresses.get(currentIndex), address);
        });

        HBox buttons = new HBox(10, add, first, next, previous, last, update);
        buttons.setAlignment(Pos.CENTER);

        VBox pane = new VBox(20, nameHBox, streetHBox, otherHBox, buttons);
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(50));
        return pane;
    }
}
