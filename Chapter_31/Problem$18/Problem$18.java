package chapter_thirty_one;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * *31.18 (Use popup menus) Modify Listing 31.9, MenuDemo.java, to create a popup
 * menu that contains the menus Operations and Exit, as shown in Figure 31.56. The
 * popup is displayed when you click the right mouse button on the panel that contains
 * the labels and the text fields.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$18 extends Application
{
    private final TextField tfNumber1 = new TextField();
    private final TextField tfNumber2 = new TextField();
    private final TextField tfResult = new TextField();

    @Override
    public void start(Stage primaryStage)
    {
        ContextMenu menu = new ContextMenu();

        Menu menuOperation = new Menu("Operation");
        Menu menuExit = new Menu("Exit");
        menu.getItems().addAll(menuOperation, menuExit);

        MenuItem menuItemAdd = new MenuItem("Add");
        MenuItem menuItemSubtract = new MenuItem("Subtract");
        MenuItem menuItemMultiply = new MenuItem("Multiply");
        MenuItem menuItemDivide = new MenuItem("Divide");
        menuOperation.getItems().addAll(menuItemAdd, menuItemSubtract,
                menuItemMultiply, menuItemDivide);

        MenuItem menuItemClose = new MenuItem("Close");
        menuExit.getItems().add(menuItemClose);

        menuItemAdd.setAccelerator(
                KeyCombination.keyCombination("Ctrl+A"));
        menuItemSubtract.setAccelerator(
                KeyCombination.keyCombination("Ctrl+S"));
        menuItemMultiply.setAccelerator(
                KeyCombination.keyCombination("Ctrl+M"));
        menuItemDivide.setAccelerator(
                KeyCombination.keyCombination("Ctrl+D"));

        HBox hBox1 = new HBox(5);
        tfNumber1.setPrefColumnCount(2);
        tfNumber2.setPrefColumnCount(2);
        tfResult.setPrefColumnCount(2);
        hBox1.getChildren().addAll(new Label("Number 1:"), tfNumber1,
                new Label("Number 2:"), tfNumber2, new Label("Result:"),
                tfResult);
        hBox1.setAlignment(Pos.CENTER);

        HBox hBox2 = new HBox(5);
        Button btAdd = new Button("Add");
        Button btSubtract = new Button("Subtract");
        Button btMultiply = new Button("Multiply");
        Button btDivide = new Button("Divide");
        hBox2.getChildren().addAll(btAdd, btSubtract, btMultiply, btDivide);
        hBox2.setAlignment(Pos.CENTER);

        VBox vBox = new VBox(10);
        vBox.getChildren().addAll(hBox1, hBox2);
        Pane pane = new Pane(vBox);
        Scene scene = new Scene(pane, 300, 250);
        primaryStage.setTitle("Problem$18");
        primaryStage.setScene(scene);
        primaryStage.show();

        pane.setOnMousePressed(e ->
        {
            if (e.getButton() == MouseButton.SECONDARY)
                menu.show(vBox, e.getSceneX(), e.getScreenY());
        });

        // Handle menu actions
        menuItemAdd.setOnAction(e -> perform('+'));
        menuItemSubtract.setOnAction(e -> perform('-'));
        menuItemMultiply.setOnAction(e -> perform('*'));
        menuItemDivide.setOnAction(e -> perform('/'));
        menuItemClose.setOnAction(e -> System.exit(0));

        // Handle button actions
        btAdd.setOnAction(e -> perform('+'));
        btSubtract.setOnAction(e -> perform('-'));
        btMultiply.setOnAction(e -> perform('*'));
        btDivide.setOnAction(e -> perform('/'));
    }

    private void perform(char operator)
    {
        double number1 = Double.parseDouble(tfNumber1.getText());
        double number2 = Double.parseDouble(tfNumber2.getText());

        double result = 0;
        switch (operator)
        {
            case '+':
                result = number1 + number2;
                break;
            case '-':
                result = number1 - number2;
                break;
            case '*':
                result = number1 * number2;
                break;
            case '/':
                result = number1 / number2;
                break;
        }

        tfResult.setText(result + "");
    }
}
