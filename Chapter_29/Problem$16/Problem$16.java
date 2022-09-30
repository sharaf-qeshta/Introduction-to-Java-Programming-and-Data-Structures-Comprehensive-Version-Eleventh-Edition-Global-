package chapter_twenty_nine;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * ***29.16 (Display a dynamic MST) Write a program that lets the user create a weighted
 * graph dynamically. The user can create a vertex by entering its name and location,
 * as shown in Figure 29.28. The user can also create a
 * vertices. To simplify the program, assume vertex names are the same as those
 * of vertex indices. You have to add the vertex indices 0, 1, . . . , and n, in this
 * order. The edges in the MST are displayed in red. As new edges are added, the
 * MST is redisplayed.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$16 extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        VBox pane = new VBox(5);
        pane.setAlignment(Pos.CENTER);

        Label status = new Label();
        pane.getChildren().add(status);

        WeightedGraph<Vertex> graph = new WeightedGraph<>();
        GraphView graphView = new GraphView(graph);
        pane.getChildren().add(graphView);

        HBox settings = new HBox(10);
        settings.setAlignment(Pos.CENTER);

        // Add Vertex
        VBox newVertexPane = new VBox(5);

        Label addNewVertexLabel = new Label("Add a new vertex");
        newVertexPane.getChildren().add(addNewVertexLabel);

        HBox vertexNameContainer = new HBox(5);
        vertexNameContainer.setAlignment(Pos.CENTER);
        Label vertexNameLabel = new Label("Vertex name: ");
        TextField vertexName_newVertex = new TextField();
        vertexName_newVertex.setPrefColumnCount(12);
        vertexNameContainer.getChildren().addAll(vertexNameLabel, vertexName_newVertex);
        newVertexPane.getChildren().add(vertexNameContainer);

        HBox xCoordinateContainer = new HBox(5);
        xCoordinateContainer.setAlignment(Pos.CENTER);
        Label xCoordinateLabel = new Label("x-coordinate: ");
        TextField xCoordinate = new TextField();
        xCoordinate.setPrefColumnCount(12);
        xCoordinateContainer.getChildren().addAll(xCoordinateLabel, xCoordinate);
        newVertexPane.getChildren().add(xCoordinateContainer);


        HBox yCoordinateContainer = new HBox(5);
        yCoordinateContainer.setAlignment(Pos.CENTER);
        Label yCoordinateLabel = new Label("y-coordinate: ");
        TextField yCoordinate = new TextField();
        yCoordinate.setPrefColumnCount(12);
        yCoordinateContainer.getChildren().addAll(yCoordinateLabel, yCoordinate);
        newVertexPane.getChildren().add(yCoordinateContainer);

        HBox addNewVertexContainer = new HBox();
        addNewVertexContainer.setAlignment(Pos.CENTER);
        Button addVertex = new Button("Add Vertex");
        addNewVertexContainer.getChildren().add(addVertex);
        newVertexPane.getChildren().add(addNewVertexContainer);

        settings.getChildren().add(newVertexPane);


        // Add Edge
        VBox newEdgePane = new VBox(5);

        Label addNewEdgeLabel = new Label("Add a new edge");
        newEdgePane.getChildren().add(addNewEdgeLabel);

        HBox vertexUContainer = new HBox(5);
        vertexUContainer.setAlignment(Pos.CENTER);
        Label vertexULabel = new Label("Vertex u (index): ");
        TextField vertexU_newEdge = new TextField();
        vertexU_newEdge.setPrefColumnCount(12);
        vertexUContainer.getChildren().addAll(vertexULabel, vertexU_newEdge);
        newEdgePane.getChildren().add(vertexUContainer);

        HBox vertexVContainer = new HBox(5);
        vertexVContainer.setAlignment(Pos.CENTER);
        Label vertexVLabel = new Label("Vertex v (index): ");
        TextField vertexV_newEdge = new TextField();
        vertexV_newEdge.setPrefColumnCount(12);
        vertexVContainer.getChildren().addAll(vertexVLabel, vertexV_newEdge);
        newEdgePane.getChildren().add(vertexVContainer);


        HBox vertexWeightContainer = new HBox(5);
        vertexWeightContainer.setAlignment(Pos.CENTER);
        Label vertexWeightLabel = new Label(String.format("%-19s", "Weight (int): "));
        TextField vertexWeight_newEdge = new TextField();
        vertexWeight_newEdge.setPrefColumnCount(12);
        vertexWeightContainer.getChildren().addAll(vertexWeightLabel, vertexWeight_newEdge);
        newEdgePane.getChildren().add(vertexWeightContainer);

        HBox addNewEdgeContainer = new HBox();
        addNewEdgeContainer.setAlignment(Pos.CENTER);
        Button addEdge = new Button("Add Edge");
        addNewEdgeContainer.getChildren().add(addEdge);
        newEdgePane.getChildren().add(addNewEdgeContainer);

        settings.getChildren().add(newEdgePane);

        pane.getChildren().add(settings);

        Button clear = new Button("Start Over (Clear Graphs)");
        pane.getChildren().add(clear);


        addVertex.setOnAction(e ->
        {
            status.setText("");
            String name = vertexName_newVertex.getText().trim();
            double x, y;
            try
            {
                x = Double.parseDouble(xCoordinate.getText().trim());
                y = Double.parseDouble(yCoordinate.getText().trim());
            }
            catch (Exception exception)
            {
                status.setText("Invalid Coordinates");
                return;
            }

            graph.addVertex(new Vertex(name, x, y));

            try
            {
                graphView.repaintWithNewVertex();
            }
            catch (Exception exception)
            {
                status.setText("Something went wrong");
            }
        });


        addEdge.setOnAction(e ->
        {
            status.setText("");
            int u, v, weight;
            try
            {
                u = Integer.parseInt(vertexU_newEdge.getText().trim());
                v = Integer.parseInt(vertexV_newEdge.getText().trim());
                weight = Integer.parseInt(vertexWeight_newEdge.getText().trim());
            }
            catch (Exception exception)
            {
                status.setText("Invalid Edge Data");
                return;
            }

            try
            {
                graphView.addEdge(u, v, weight);
            }
            catch (Exception exception)
            {
                status.setText("Something went wrong");
            }
        });


        clear.setOnAction(e ->
        {
            status.setText("");
            try
            {
                graphView.clear();
            }
            catch (Exception exception)
            {
                status.setText("Something went wrong");
            }
        });

        Scene scene = new Scene(pane, 800, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Problem$16");
        primaryStage.show();
    }

    static class Vertex implements Displayable
    {
        private final double x;
        private final double y;
        private final String name;

        Vertex(String name, double x, double y)
        {
            this.name = name;
            this.x = x;
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
