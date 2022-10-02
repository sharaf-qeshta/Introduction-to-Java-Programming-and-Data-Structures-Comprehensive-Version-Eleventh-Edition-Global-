package chapter_twenty_nine;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

import java.util.List;


public class GraphView extends Pane
{
    private final WeightedGraph<? extends Displayable> graph;
    private final Group group = new Group();
    public List<Integer> path = null;
    public List<? extends Displayable> shortestPath = null;
    public static int indexToRemoved = -1;
    public static boolean controlPressed = false;


    public GraphView(WeightedGraph<? extends Displayable> graph) throws Exception
    {
        setMinSize(800, 400);
        setStyle("-fx-border-color: black");
        this.graph = graph;
        getChildren().add(group);
        repaintGraph();
    }

    public void displayMST() throws Exception
    {
        shortestPath = null;
        if (graph.getSize() > 0)
            path = graph.getMinimumSpanningTree().getSearchOrder();
        repaintGraph();
    }

    public void displaySP(int u, int v) throws Exception
    {
        path = null;
        WeightedGraph<? extends Displayable>.ShortestPathTree shortestPathTree = graph.getShortestPath(v);
        shortestPath = shortestPathTree.getPath(u);
        repaintGraph();
    }

    public boolean validCoordinates(double x, double y)
    {
        for (Node node : group.getChildren())
        {
            if (node instanceof Circle)
            {
                if (node.contains(x, y)
                        || node.contains(x - 20, y) || node.contains(x + 20, y)
                        || node.contains(x, y - 20) || node.contains(x, y + 20)
                        || node.contains(x - 20, y - 20) || node.contains(x + 20, y + 20))
                    return false;
            }
        }
        return true;
    }


    public void addEdge(int u, int v, double weight) throws Exception
    {
        graph.addEdge(u, v, weight);
        path = null;
        shortestPath = null;
        repaintGraph();
    }

    public Circle checkCircles(double x, double y, Circle circle)
    {
        for (Node node : group.getChildren())
        {
            if (node instanceof Circle)
            {
                if (node.contains(x, y) && node != circle)
                    return (Circle) node;
            }
        }
        return null;
    }

    public int getIndexOfACircle(Circle circle)
    {
        for (int i = 0; i < graph.getSize(); i++)
            if (circle.contains(graph.getVertex(i).getX(), graph.getVertex(i).getY()))
                return i;
        return -1;
    }

    public void updateWeights(int index) throws Exception
    {
        List<Integer> neighbours = graph.getNeighbors(index);
        for (int i = 0; i < neighbours.size(); i++)
        {
            double distance = Math.sqrt(
                    Math.pow(graph.getVertex(index).getX() - graph.getVertex(neighbours.get(i)).getX(), 2)
                    + Math.pow(graph.getVertex(index).getY() - graph.getVertex(neighbours.get(i)).getY(), 2));
            ((WeightedEdge) graph.neighbors.get(index).get(i)).weight = Math.round(distance);
        }
        path = null;
        shortestPath = null;
        repaintGraph();
    }


    public void repaintGraph() throws Exception
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


            Circle circle = new Circle(x, y, 20);

            circle.setOnMouseClicked(e ->
            {
                if (e.getButton() == MouseButton.SECONDARY) // Right click
                {
                    indexToRemoved = Integer.parseInt(name);
                }
                path = null;
                shortestPath = null;
            });

            circle.setOnMouseDragged(e ->
            {
                if (controlPressed)
                {
                    if (validCoordinates(e.getX(), e.getY()))
                    {
                        circle.setCenterX(e.getX());
                        circle.setCenterY(e.getY());

                        int index = Integer.parseInt(name);
                        graph.getVertex(index).setX(e.getX());
                        graph.getVertex(index).setY(e.getY());

                        try
                        {
                            updateWeights(index);
                        }
                        catch (Exception exception)
                        {
                            exception.printStackTrace();
                        }
                    }
                }
                else
                {
                    Circle draggedTo = checkCircles(e.getX(), e.getY(), circle);

                    if (draggedTo != null)
                    {
                        int index = getIndexOfACircle(draggedTo);
                        if (index != -1)
                        {
                            double distance = Math.sqrt(Math.pow(circle.getCenterX() - draggedTo.getCenterX(), 2)
                                    + Math.pow(circle.getCenterY() - draggedTo.getCenterY(), 2));
                            try
                            {
                                addEdge(Integer.parseInt(name), index, Math.round(distance));
                            }
                            catch (Exception exception)
                            {
                                exception.printStackTrace();
                            }
                        }
                    }
                }
                path = null;
                shortestPath = null;
            });


            group.getChildren().add(circle);
            group.getChildren().add(new Text(x - 8, y - 22, name));
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

        if (path != null)
        {
            for (int i = 0; i < path.size()-1; i++)
            {
                double x1 = graph.getVertex(path.get(i)).getX();
                double y1 = graph.getVertex(path.get(i)).getY();
                double x2 = graph.getVertex(path.get(i+1)).getX();
                double y2 = graph.getVertex(path.get(i+1)).getY();

                Line line = new Line(x1, y1, x2, y2);
                line.setFill(Color.RED); line.setStroke(Color.RED);

                group.getChildren().add(line);
            }
        }

        if (shortestPath != null)
        {
            for (int i = 0; i < shortestPath.size()-1; i++)
            {
                double x1 = shortestPath.get(i).getX();
                double y1 = shortestPath.get(i).getY();
                double x2 = shortestPath.get(i+1).getX();
                double y2 = shortestPath.get(i+1).getY();
                Line line = new Line(x1, y1, x2, y2);
                line.setFill(Color.RED); line.setStroke(Color.RED);
                group.getChildren().add(line);
            }
        }
    }
}