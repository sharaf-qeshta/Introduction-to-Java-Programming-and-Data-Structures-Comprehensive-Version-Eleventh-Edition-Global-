package chapter_twenty_nine;

import javafx.scene.Group;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

import java.util.List;


public class GraphView extends BorderPane
{
    private WeightedGraph<? extends Displayable> graph;
    private Group group = new Group();
    private List<? extends Displayable> path = null;

    public GraphView(WeightedGraph<? extends Displayable> graph) throws Exception
    {
        setMinSize(800, 200);
        this.graph = graph;
        this.setCenter(group); // Center the group
        repaintGraph();
    }


    public void repaintWithNewVertex() throws Exception
    {
        path = null;
        repaintGraph();
    }

    public void addEdge(int u, int v, double weight) throws Exception
    {
        path = null;
        graph.addEdge(u, v, weight);
        repaintGraph();
    }

    public void drawShortestPath(int u, int v) throws Exception
    {
        WeightedGraph<? extends Displayable>.ShortestPathTree shortestPathTree = graph.getShortestPath(v);
        path = shortestPathTree.getPath(u);
        repaintGraph();
    }

    public void clear() throws Exception
    {
        graph.clear();
        path = null;
        repaintGraph();
    }

    private void repaintGraph() throws Exception
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
                double weight = graph.getWeight(i, v);
                group.getChildren().add(new Text((x1 + x2) / 2, (y1 + y2) / 2 - 5, weight + ""));
                // Draw an edge for (i, v)
                group.getChildren().add(new Line(x1, y1, x2, y2));
            }
        }

        // Draw shortest path
        if (path != null)
        {
            for (int i = 0; i < path.size()-1; i++)
            {
                double x1 = path.get(i).getX();
                double y1 = path.get(i).getY();
                double x2 = path.get(i+1).getX();
                double y2 = path.get(i+1).getY();
                Line line = new Line(x1, y1, x2, y2);
                line.setFill(Color.RED); line.setStroke(Color.RED);
                group.getChildren().add(line);
            }
        }
    }
}