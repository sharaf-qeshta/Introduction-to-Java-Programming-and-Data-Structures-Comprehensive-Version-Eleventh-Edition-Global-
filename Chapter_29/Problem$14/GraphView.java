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

    public GraphView(WeightedGraph<? extends Displayable> graph) throws Exception
    {
        this.graph = graph;
        this.setCenter(group); // Center the group
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

        List<Integer> mst = graph.getMinimumSpanningTree().getSearchOrder();
        for (int i = 0; i < mst.size()-1; i++)
        {
            double x1 = graph.getVertex(mst.get(i)).getX();
            double y1 = graph.getVertex(mst.get(i)).getY();
            double x2 = graph.getVertex(mst.get(i+1)).getX();
            double y2 = graph.getVertex(mst.get(i+1)).getY();

            Line line = new Line(x1, y1, x2, y2);
            line.setFill(Color.RED); line.setStroke(Color.RED);

            group.getChildren().add(line);

            // draw arrows
            Line arrow1 = new Line();
            Line arrow2 = new Line();

            arrow1.setEndX(x2);
            arrow1.setEndY(y2);
            arrow2.setEndX(x2);
            arrow2.setEndY(y2);

            if (x1 == x2 && y1 == y2)
            {
                arrow1.setStartX(x2);
                arrow1.setStartX(y2);
                arrow2.setStartX(x2);
                arrow2.setStartY(y2);
            }
            else
            {
                double hyp =  Math.hypot(x1 - x2, y1 - y2);
                double factor = 20 / hyp;
                double factorO = 10 / hyp;

                double dx = (x1 - x2) * factor;
                double dy = (y1 - y2) * factor;

                double ox = (x1 - x2) * factorO;
                double oy = (y1 - y2) * factorO;

                arrow1.setStartX(x2 + dx - oy);
                arrow1.setStartY(y2 + dy + ox);
                arrow2.setStartX(x2 + dx + oy);
                arrow2.setStartY(y2 + dy - ox);
            }

            arrow1.setFill(Color.RED); arrow1.setStroke(Color.RED);
            arrow2.setFill(Color.RED); arrow2.setStroke(Color.RED);

            group.getChildren().addAll(arrow1, arrow2);
        }
    }
}