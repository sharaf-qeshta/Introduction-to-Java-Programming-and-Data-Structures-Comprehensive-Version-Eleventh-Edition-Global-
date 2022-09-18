package chapter_twenty_eight;

import java.util.ArrayList;
import java.util.List;

/**
 * ***28.18 (Knight’s Tour cycle) Rewrite KnightTourApp.java in the case study in Supplement
 * VI.E to find a knight’s tour that visits each square in a chessboard and
 * returns to the starting square. Reduce the Knight’s Tour cycle problem to the
 * problem of finding a Hamiltonian cycle.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$18
{
    public static void main(String[] args)
    {
        int chessBoardSquares = 64;
        List<Edge> edges = getEdgesForChessboard(chessBoardSquares);
        UnweightedGraph<Integer> graph = new UnweightedGraph<>(edges, chessBoardSquares);
        System.out.println(graph.getHamiltonianCycle());
    }

    public static List<Edge> getEdgesForChessboard(int size)
    {
        List<Edge> list = new ArrayList<>();
        for (int i = 0; i < size; i++)
        {
            int index = i - 17;
            if (index > -1 && index < size)
                list.add(new Edge(i, index));

            index = i + 17;
            if (index > -1 && index < size)
                list.add(new Edge(i, index));

            index = i - 15;
            if (index > -1 && index < size)
                list.add(new Edge(i, index));

            index = i + 15;
            if (index > -1 && index < size)
                list.add(new Edge(i, index));

            index = i - 10;
            if (index > -1 && index < size)
                list.add(new Edge(i, index));

            index = i + 10;
            if (index > -1 && index < size)
                list.add(new Edge(i, index));

            index = i - 6;
            if (index > -1 && index < size)
                list.add(new Edge(i, index));

            index = i + 6;
            if (index > -1 && index < size)
                list.add(new Edge(i, index));
        }

        return list;
    }
}
