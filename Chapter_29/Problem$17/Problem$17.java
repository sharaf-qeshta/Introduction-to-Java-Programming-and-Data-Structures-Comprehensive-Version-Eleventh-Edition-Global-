package chapter_twenty_nine;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * ***29.17 (Weighted graph visualization tool) Develop a GUI program as shown in
 * Figure 29.2, with the following requirements: (1) The radius of each vertex is
 * 20 pixels. (2) The user clicks the left mouse button to place a vertex centered
 * at the mouse point, provided the mouse point is not inside or too close to an
 * existing vertex. (3) The user clicks the right mouse button inside an existing
 * vertex to remove the vertex. (4) The user presses a mouse button inside a vertex
 * and drags to another vertex then releases the button to create an edge, and the
 * distance between the two vertices is also displayed. (5) The user drags a vertex
 * while pressing the CTRL key to move a vertex. (6) The vertices are numbers
 * starting from 0. When a vertex is removed, the vertices are renumbered. (7) You
 * can click the Show MST or Show All SP From the Source button to display an
 * MST or SP tree from a starting vertex. (8) You can click the Show Shortest
 * Path button to display the shortest path between the two specified vertices.
 *
 *
 * @author Sharaf Qeshta
 */
public class Problem$17 extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        VBox pane = new VBox(20);
        WeightedGraph<Vertex> graph = new WeightedGraph<>();
        GraphView graphView = new GraphView(graph);
        pane.getChildren().add(graphView);

        graphView.setOnMouseClicked(e ->
        {
            if (e.getButton() == MouseButton.PRIMARY) // Left click
            {
                double x = e.getX(), y = e.getY();
                if (graphView.validCoordinates(x, y))
                {
                    graph.addVertex(new Vertex(graph.getSize() + "", x, y));
                    try
                    {
                        graphView.path = null;
                        graphView.shortestPath = null;
                        graphView.repaintGraph();
                    }
                    catch (Exception exception)
                    {
                        exception.printStackTrace();
                    }
                }
            }

            if (e.getButton() == MouseButton.SECONDARY) // Right Click
            {
                if (GraphView.indexToRemoved != -1)
                {
                    graph.remove(graph.getVertex(GraphView.indexToRemoved));

                    for (int i = 0; i < graph.getSize(); i++)
                        graph.getVertex(i).name = i + "";

                    try
                    {
                        graphView.repaintGraph();
                    }
                    catch (Exception exception)
                    {
                        exception.printStackTrace();
                    }

                    GraphView.indexToRemoved = -1;
                }
            }
        });


        graphView.setOnKeyPressed(e ->
                GraphView.controlPressed = e.getCode() == KeyCode.CONTROL);

        graphView.setOnKeyReleased(e ->
                GraphView.controlPressed = false);

        HBox settings = new HBox(10);
        settings.setAlignment(Pos.CENTER);
        Button mst = new Button("MST");

        Label label1 = new Label("Start Vertex: ");
        TextField startVertex = new TextField();
        startVertex.setPrefColumnCount(6);

        Label label2 = new Label("End Vertex: ");
        TextField endVertex = new TextField();
        endVertex.setPrefColumnCount(6);

        Button shortestPath = new Button("Shortest Path Tree");

        settings.getChildren().addAll(mst, label1, startVertex, label2, endVertex, shortestPath);

        pane.getChildren().add(settings);


        mst.setOnAction(e ->
        {
            try
            {
                graphView.displayMST();
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
            graphView.requestFocus();
        });

        shortestPath.setOnAction(e ->
        {
            try
            {
                int u = Integer.parseInt(startVertex.getText().trim());
                int v = Integer.parseInt(endVertex.getText().trim());
                graphView.displaySP(u, v);
                graphView.requestFocus();
            }
            catch (Exception exception)
            {
                graphView.requestFocus();
            }
        });

        Scene scene = new Scene(pane, 800, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Problem$17");
        primaryStage.show();

        graphView.requestFocus();
    }

    static class Vertex implements Displayable
    {
        private double x;
        private double y;
        private String name;

        Vertex(String name, double x, double y)
        {
            this.name = name;
            this.x = x;
            this.y = y;
        }

        @Override
        public void setX(double x)
        {
            this.x = x;
        }

        @Override
        public void setY(double y)
        {
            this.y = y;
        }

        @Override
        public double getX()
        {
            return x;
        }

        @Override
        public double getY()
        {
            return y;
        }


        @Override
        public String getName()
        {
            return name;
        }
    }
}
