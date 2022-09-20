package chapter_twenty_eight;


import javafx.scene.Group;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

import java.util.List;

public class GraphView extends BorderPane
{
    private Graph<? extends Displayable> graph;
    private Group group = new Group();
    private UnweightedGraph<? extends Displayable>.SearchTree tree;

    public GraphView(Graph<? extends Displayable> graph)
    {
        this.graph = graph;
        this.setCenter(group); // Center the group
        repaintGraph();
    }

    public void dfs(int index)
    {
        tree = graph.dfs(index);
        repaintGraph();
    }

    public void bfs(int index)
    {
        tree = graph.bfs(index);
        repaintGraph();
    }

    private void repaintGraph()
    {
        group.getChildren().clear(); // Clear group for a new display

        // Draw vertices and text for vertices
        java.util.List<? extends Displayable> vertices
                = graph.getVertices();
        for (int i = 0; i < graph.getSize(); i++)
        {
            double x = vertices.get(i).getX();
            double y = vertices.get(i).getY();
            String name = vertices.get(i).getName();

            group.getChildren().add(new Circle(x, y, 16));
            group.getChildren().add(new Text(x - 8, y - 18, name));
        }

        // Draw edges for pairs of vertices
        for (int i = 0; i < graph.getSize(); i++)
        {
            java.util.List<Integer> neighbors = graph.getNeighbors(i);
            double x1 = graph.getVertex(i).getX();
            double y1 = graph.getVertex(i).getY();
            for (int v : neighbors)
            {
                double x2 = graph.getVertex(v).getX();
                double y2 = graph.getVertex(v).getY();

                // Draw an edge for (i, v)
                group.getChildren().add(new Line(x1, y1, x2, y2));
            }
        }

        // Draw the search order
        if (tree != null)
        {
            List<Integer> searchOrder = tree.getSearchOrder();
            for (int i = 0; i < searchOrder.size()-1; i++)
            {
                double x1 = graph.getVertex(searchOrder.get(i)).getX();
                double y1 = graph.getVertex(searchOrder.get(i)).getY();
                double x2 = graph.getVertex(searchOrder.get(i+1)).getX();
                double y2 = graph.getVertex(searchOrder.get(i+1)).getY();

                Line line = new Line(x1, y1, x2, y2);
                line.setFill(Color.RED); line.setStroke(Color.RED);
                group.getChildren().add(line);
            }
        }
    }
}