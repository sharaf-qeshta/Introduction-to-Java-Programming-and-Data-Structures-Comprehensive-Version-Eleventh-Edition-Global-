package chapter_twenty_eight;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * *28.20 (Display a graph) Write a program that reads a graph from a file and displays
 * it. The first line in the file contains a number that indicates the number of vertices
 * (n). The vertices are labeled 0, 1, . . . , n−1. Each subsequent line, with the
 * format u x y v1 v2 ..., describes the position of u at (x, y) and edges (u,
 * v1), (u, v2), and so on. Figure 28.24a gives an example of the file for their corresponding
 * graph. Your program prompts the user to enter the name of the file,
 * reads data from the file, and displays the graph on a pane using GraphView, as
 * shown in Figure 28.24b.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$20 extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter File Name: ");
        String fileName = scanner.nextLine();
        scanner.close();

        List<Vertex> vertices = new ArrayList<>();
        List<Edge> edges = new ArrayList<>();
        try (Scanner reader = new Scanner(new File(fileName)))
        {
            reader.nextInt(); // vertices

            while (reader.hasNext())
            {
                String line = reader.nextLine();
                if (line.isEmpty())
                    continue;
                Scanner lineReader = new Scanner(line);
                int vertex = lineReader.nextInt();
                int x = lineReader.nextInt();
                int y = lineReader.nextInt();
                vertices.add(new Vertex(vertex + "", x, y));

                while (lineReader.hasNext())
                    edges.add(new Edge(vertex, lineReader.nextInt()));
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }

        Graph<Vertex> graph = new UnweightedGraph<>(vertices, edges);
        GraphView pane = new GraphView(graph);

        Scene scene = new Scene(pane, 500, 500);

        primaryStage.setTitle("Problem$20");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private static class Vertex implements Displayable
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
