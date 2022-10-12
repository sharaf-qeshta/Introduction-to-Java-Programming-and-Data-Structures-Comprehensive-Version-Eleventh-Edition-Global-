package chapter_thirty_one;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * *31.20 (Use tab panes) Modify Listing 31.12, TabPaneDemo.java, to add a pane
 * of radio buttons for specifying the tab placement of the tab pane, as shown in
 * Figure 31.57b and c
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$20 extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        TabPane tabPane = new TabPane();
        Tab tab1 = new Tab("Line");
        StackPane pane1 = new StackPane();
        pane1.getChildren().add(new Line(10, 10, 80, 80));
        tab1.setContent(pane1);
        Tab tab2 = new Tab("Rectangle");
        tab2.setContent(new Rectangle(10, 10, 200, 200));
        Tab tab3 = new Tab("Circle");
        tab3.setContent(new Circle(50, 50, 20));
        Tab tab4 = new Tab("Ellipse");
        tab4.setContent(new Ellipse(10, 10, 100, 80));
        tabPane.getTabs().addAll(tab1, tab2, tab3, tab4);

        ToggleGroup group = new ToggleGroup();

        RadioButton top = new RadioButton("Top");
        top.setToggleGroup(group);

        RadioButton left = new RadioButton("Left");
        left.setToggleGroup(group);

        RadioButton bottom = new RadioButton("Bottom");
        bottom.setToggleGroup(group);

        RadioButton right = new RadioButton("Right");
        right.setToggleGroup(group);

        HBox settings = new HBox(5, top, left, bottom, right);
        settings.setAlignment(Pos.CENTER);
        VBox pane = new VBox(5, tabPane, settings);

        top.setOnAction(e ->
                tabPane.setSide(Side.TOP));

        left.setOnAction(e ->
                tabPane.setSide(Side.LEFT));

        bottom.setOnAction(e ->
                tabPane.setSide(Side.BOTTOM));

        right.setOnAction(e ->
                tabPane.setSide(Side.RIGHT));

        Scene scene = new Scene(pane, 300, 250);
        primaryStage.setTitle("Problem$20");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
