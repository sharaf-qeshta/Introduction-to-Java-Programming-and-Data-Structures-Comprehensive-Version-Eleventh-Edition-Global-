package chapter_twenty_nine;

/**
 * ***29.20 (Test if a vertex u is in T efficiently) Since T is implemented using a list in
 * the getMinimumSpanningTree and getShortestPath methods in Listing
 * 29.2 WeightedGraph.java, testing whether a vertex u is in T by invoking T.
 * contains(u) takes O(n) time. Modify these two methods by introducing an
 * array named isInT. Set isInT[u] to true when a vertex u is added to T.
 * Testing whether a vertex u is in T can now be done in O(1) time. Write a test
 * program using the following code, where graph1 is created from Figure 29.1:
 * WeightedGraph<String> graph1 = new WeightedGraph<>(edges, vertices);
 * WeightedGraph<String>.MST tree1 = graph1.getMinimumSpanningTree();
 * System.out.println("Total weight is " + tree1.getTotalWeight());
 * tree1.printTree();
 * WeightedGraph<String>.ShortestPathTree tree2 =
 *  graph1.getShortestPath(graph1.getIndex("Chicago"));
 * tree2.printAllPaths();
 *
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$20
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


        ShortestPathWeightedGraph<String> graph1 = new ShortestPathWeightedGraph<>(vertices, edges);
        ShortestPathWeightedGraph<String>.MST tree1 = graph1.getMinimumSpanningTree();
        System.out.println("Total weight is " + tree1.getTotalWeight());
        tree1.printTree();
        ShortestPathWeightedGraph<String>.ShortestPathTree tree2 =
                graph1.getShortestPath(graph1.getIndex("Chicago"));
        tree2.printAllPaths();
    }
}
