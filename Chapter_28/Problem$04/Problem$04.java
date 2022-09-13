package chapter_twenty_eight;

/**
 * *28.4 (Find connected components) Create a new class named MyGraph as a subclass
 * of UnweightedGraph that contains a method for finding all connected components
 * in a graph with the following header:
 * public List<List<Integer>> getConnectedComponents();
 * The method returns a List<List<Integer>>. Each element in the list is
 * another list that contains all the vertices in a connected component. For example,
 * for the graph in Figure 28.21b, getConnectedComponents() returns
 * [[0, 1, 2, 3], [4, 5]].
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$04
{
    public static void main(String[] args)
    {
        int[][] edges =
                {
                        {0, 1}, {0, 2}, {0, 3},
                        {1, 0}, {1, 3},
                        {2, 0}, {2, 3},
                        {3, 0}, {3, 1}, {3, 2},
                        {4, 5},
                        {5, 4}
                };

        MyGraph<Integer> graph = new MyGraph<>(edges, 6);
        /*
        * [[0, 1, 2, 3], [4, 5]]
        * */
        System.out.println(graph.getConnectedComponents());
    }
}
