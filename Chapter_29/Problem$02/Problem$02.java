package chapter_twenty_nine;


/**
 * *29.2 (Implement Prim’s algorithm using an adjacency matrix) The text implements
 * Prim’s algorithm using lists for adjacent edges. Implement the algorithm using
 * an adjacency matrix for weighted graphs.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$02
{
    public static void main(String[] args)
    {
        String[] vertices = {"Seattle", "San Francisco", "Los Angeles",
                "Denver", "Kansas City", "Chicago", "Boston", "New York",
                "Atlanta", "Miami", "Dallas", "Houston"};

        int[][] edges =
                {
                        {0, 1, 807}, {0, 3, 1331}, {0, 5, 2097},
                        {1, 0, 807}, {1, 2, 381}, {1, 3, 1267},
                        {2, 1, 381}, {2, 3, 1015}, {2, 4, 1663}, {2, 10, 1435},
                        {3, 0, 1331}, {3, 1, 1267}, {3, 2, 1015}, {3, 4, 599},
                        {3, 5, 1003},
                        {4, 2, 1663}, {4, 3, 599}, {4, 5, 533}, {4, 7, 1260},
                        {4, 8, 864}, {4, 10, 496},
                        {5, 0, 2097}, {5, 3, 1003}, {5, 4, 533},
                        {5, 6, 983}, {5, 7, 787},
                        {6, 5, 983}, {6, 7, 214},
                        {7, 4, 1260}, {7, 5, 787}, {7, 6, 214}, {7, 8, 888},
                        {8, 4, 864}, {8, 7, 888}, {8, 9, 661},
                        {8, 10, 781}, {8, 11, 810},
                        {9, 8, 661}, {9, 11, 1187},
                        {10, 2, 1435}, {10, 4, 496}, {10, 8, 781}, {10, 11, 239},
                        {11, 8, 810}, {11, 9, 1187}, {11, 10, 239}
                };

        WeightedGraph<String> graph1 = new WeightedGraph<>(vertices, edges);
        WeightedGraph<String>.MST tree1 = graph1.getMinimumSpanningTree();
        System.out.println("tree1: Total weight is " + tree1.getTotalWeight());
        tree1.printTree();
    }
}
