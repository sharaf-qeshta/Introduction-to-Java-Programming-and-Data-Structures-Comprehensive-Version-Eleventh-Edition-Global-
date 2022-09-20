package chapter_twenty_eight;



import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

/**
 * **28.19 (Display a DFS/BFS tree in a graph) Modify GraphView in Listing 28.6 to add
 * a new data field tree with a setter method. The edges in the tree are displayed
 * in red. Write a program that displays the graph in Figure 28.1 and the DFS/BFS
 * tree starting from a specified city, as shown in Figures 28.13 and 28.16. If a city
 * not in the map is entered, the program displays an error message in the label.
 *
 *
 * @author Sharaf Qeshta
 */
public class Problem$19 extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        City[] vertices =
                {
                        new City("Seattle", 75, 50),
                        new City("San Francisco", 50, 210),
                        new City("Los Angeles", 75, 275),
                        new City("Denver", 275, 175),
                        new City("Kansas City", 400, 245),
                        new City("Chicago", 450, 100),
                        new City("Boston", 700, 80),
                        new City("New York", 675, 120),
                        new City("Atlanta", 575, 295),
                        new City("Miami", 600, 400),
                        new City("Dallas", 408, 325),
                        new City("Houston", 450, 360)
                };

        // Edge array for graph in Figure 28.1
        int[][] edges =
                {
                        {0, 1}, {0, 3}, {0, 5}, {1, 0}, {1, 2}, {1, 3},
                        {2, 1}, {2, 3}, {2, 4}, {2, 10},
                        {3, 0}, {3, 1}, {3, 2}, {3, 4}, {3, 5},
                        {4, 2}, {4, 3}, {4, 5}, {4, 7}, {4, 8}, {4, 10},
                        {5, 0}, {5, 3}, {5, 4}, {5, 6}, {5, 7},
                        {6, 5}, {6, 7}, {7, 4}, {7, 5}, {7, 6}, {7, 8},
                        {8, 4}, {8, 7}, {8, 9}, {8, 10}, {8, 11},
                        {9, 8}, {9, 11}, {10, 2}, {10, 4}, {10, 8}, {10, 11},
                        {11, 8}, {11, 9}, {11, 10}
                };

        VBox pane = new VBox(5);
        pane.setAlignment(Pos.CENTER);

        Label status = new Label();
        pane.getChildren().add(status);

        Graph<City> graph = new UnweightedGraph<>(vertices, edges);
        GraphView graphView = new GraphView(graph);
        pane.getChildren().add(graphView);


        HBox settings = new HBox(5);
        Label startVertex = new Label("Start Vertex: ");
        TextField vertex = new TextField();
        vertex.setPrefColumnCount(12);
        Button dfs = new Button("DFS");
        Button bfs = new Button("BFS");

        settings.getChildren().addAll(startVertex, vertex, dfs, bfs);
        settings.setAlignment(Pos.CENTER);
        pane.getChildren().add(settings);


        dfs.setOnAction(e ->
        {
            status.setText("");
            String startVertex_ = vertex.getText().trim();
            int index = -1;
            List<City> cities = graph.getVertices();
            for (int i = 0; i < cities.size(); i++)
            {
                if (cities.get(i).getName().equals(startVertex_))
                {
                    index = i;
                    break;
                }
            }

            if (index == -1)
            {
                status.setText("Vertex " + startVertex_ + " is not exist on the graph");
                return;
            }
            graphView.dfs(index);
        });

        bfs.setOnAction(e ->
        {
            status.setText("");
            String startVertex_ = vertex.getText().trim();
            int index = -1;
            List<City> cities = graph.getVertices();
            for (int i = 0; i < cities.size(); i++)
            {
                if (cities.get(i).getName().equals(startVertex_))
                {
                    index = i;
                    break;
                }
            }

            if (index == -1)
            {
                status.setText("Vertex " + startVertex_ + " is not exist on the graph");
                return;
            }
            graphView.bfs(index);
        });
        Scene scene = new Scene(pane, 750, 500);
        primaryStage.setTitle("Problem$19");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    static class City implements Displayable
    {
        private double x, y;
        private String name;

        City(String name, double x, double y)
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
