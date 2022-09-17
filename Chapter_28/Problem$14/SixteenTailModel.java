package chapter_twenty_eight;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SixteenTailModel
{
    public final static int NUMBER_OF_NODES = 65_536; // 2^16
    protected UnweightedGraph<Integer>.SearchTree tree;
    protected UnweightedGraph<Integer> graph;

    /**
     * Construct a model
     */
    public SixteenTailModel()
    {
        // Create edges
        List<Edge> edges = getEdges();

        // Create a graph
        graph = new UnweightedGraph<>(
                edges, NUMBER_OF_NODES);

        // Obtain a BSF tree rooted at the target node
        tree = graph.bfs(65535);
    }

    /**
     * Create all edges for the graph
     */
    private List<Edge> getEdges()
    {
        List<Edge> edges =
                new ArrayList<>(); // Store edges

        for (int u = 0; u < NUMBER_OF_NODES; u++)
        {
            for (int k = 0; k < 16; k++)
            {
                char[] node = getNode(u); // Get the node for vertex u
                if (node[k] == 'H')
                {
                    int v = getFlippedNode(node, k);
                    // Add edge (v, u) for a legal move from node u to node v
                    edges.add(new Edge(v, u));
                }
            }
        }

        return edges;
    }

    public static int getFlippedNode(char[] node, int position)
    {
        int row = position / 4;
        int column = position % 4;

        flipACell(node, row, column); // flip the current cell
        flipACell(node, row - 1, column); // flip the cell to the left of the current cell
        flipACell(node, row + 1, column); // flip the cell to the right of the current cell
        flipACell(node, row, column - 1); // flip the cell above the current cell
        flipACell(node, row, column + 1); // flip the cell below the current cell

        return getIndex(node);
    }

    public static void flipACell(char[] node, int row, int column)
    {
        if (row >= 0 && row <= 3 && column >= 0 && column <= 3)
        {
            // Within the boundary
            if (node[row * 4 + column] == 'H')
                node[row * 4 + column] = 'T'; // Flip from H to T
            else
                node[row * 4 + column] = 'H'; // Flip from T to H
        }
    }

    public static int getIndex(char[] node)
    {
        int result = 0;

        for (int i = 0; i < 16; i++)
            if (node[i] == 'T')
                result = result * 2 + 1;
            else
                result = result * 2 + 0;

        return result;
    }

    public static char[] getNode(int index)
    {
        char[] result = new char[16];

        for (int i = 0; i < 16; i++)
        {
            int digit = index % 2;
            if (digit == 0)
                result[15 - i] = 'H';
            else
                result[15 - i] = 'T';
            index = index / 2;
        }

        return result;
    }

    public List<Integer> getShortestPath(int nodeIndex)
    {
        return tree.getPath(nodeIndex);
    }

    public static void printNode(char[] node)
    {
        for (int i = 0; i < 16; i++)
            if (i % 4 != 3)
                System.out.print(node[i]);
            else
                System.out.println(node[i]);

        System.out.println();
    }

    public int getNumberOfInvalidStartPatter()
    {
        IntegerHolder holder = new IntegerHolder();
        HashSet<Integer> visited = new HashSet<>();
        countValidStart(holder, 65535, visited);
        return graph.getSize() - holder.getInteger();
    }

    /**
    * we count the neighbours of the neighbours ... of the last element
    * in the graph which is the solution
    * */
    public void countValidStart(IntegerHolder holder, int currentIndex, HashSet<Integer> visited)
    {
        if (visited.contains(currentIndex))
            return;

        List<Integer> neighbours = graph.getNeighbors(currentIndex);
        holder.increment();
        visited.add(currentIndex);

        if (neighbours.isEmpty())
            return;

        for (int neighbour: neighbours)
            countValidStart(holder, neighbour, visited);
    }

    private static class IntegerHolder
    {
        int integer = 0;

        public void increment()
        {
            integer++;
        }

        public int getInteger()
        {
            return integer;
        }
    }
}
