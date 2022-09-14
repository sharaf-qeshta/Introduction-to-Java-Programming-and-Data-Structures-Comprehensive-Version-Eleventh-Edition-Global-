package chapter_twenty_eight;

/**
 * *28.7 (Find a cycle) Define a new class named UnweightedGraphFindCycle that
 * extends UnweightedGraph with a new method for finding a cycle starting at
 * vertex u with the following header:
 * public List<Integer> getACycle(int u);
 * The method returns a List that contains all the vertices in a cycle starting from
 * u. If the graph doesn’t have any cycles, the method returns null. Describe the
 * algorithm in pseudocode and implement it.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$07
{
    public static void main(String[] args)
    {
        String[] vertices = {"Seattle", "San Francisco", "Los Angeles",
                "Denver", "Kansas City", "Chicago", "Boston", "New York",
                "Atlanta", "Miami", "Dallas", "Houston"};

        int[][] edges =
                {
                        {0, 1}, {0, 3}, {0, 5},
                        {1, 0}, {1, 2}, {1, 3},
                        {2, 1}, {2, 3}, {2, 4}, {2, 10},
                        {3, 0}, {3, 1}, {3, 2}, {3, 4}, {3, 5},
                        {4, 2}, {4, 3}, {4, 5}, {4, 7}, {4, 8}, {4, 10},
                        {5, 0}, {5, 3}, {5, 4}, {5, 6}, {5, 7},
                        {6, 5}, {6, 7},
                        {7, 4}, {7, 5}, {7, 6}, {7, 8},
                        {8, 4}, {8, 7}, {8, 9}, {8, 10}, {8, 11},
                        {9, 8}, {9, 11},
                        {10, 2}, {10, 4}, {10, 8}, {10, 11},
                        {11, 8}, {11, 9}, {11, 10}
                };

        UnweightedGraphFindCycle<String> graph
                = new UnweightedGraphFindCycle<>(vertices, edges);

        /*
         * [0, 1, 2, 3, 0]
         * */
        System.out.println(graph.getACycle(0));

        /*
        * [1, 0, 3, 1]
        * */
        System.out.println(graph.getACycle(1));

        /*
        * [2, 1, 0, 3, 2]
        * */
        System.out.println(graph.getACycle(2));

        /*
        * [3, 0, 1, 3]
        * */
        System.out.println(graph.getACycle(3));

        /*
        * [4, 2, 1, 0, 3, 4]
        * */
        System.out.println(graph.getACycle(4));

        /*
        * [5, 0, 1, 2, 3, 5]
        * */
        System.out.println(graph.getACycle(5));

        /*
        * [6, 5, 0, 1, 2, 3, 4, 7, 6]
        * */
        System.out.println(graph.getACycle(6));

        /*
        * [7, 4, 2, 1, 0, 3, 5, 7]
        * */
        System.out.println(graph.getACycle(7));

        /*
        * [8, 4, 2, 1, 0, 3, 5, 6, 7, 8]
        * */
        System.out.println(graph.getACycle(8));

        /*
        * [9, 8, 4, 2, 1, 0, 3, 5, 6, 7, 10, 11, 9]
        * */
        System.out.println(graph.getACycle(9));

        /*
        * [10, 2, 1, 0, 3, 4, 10]
        * */
        System.out.println(graph.getACycle(10));

        /*
        * [11, 8, 4, 2, 1, 0, 3, 5, 6, 7, 10, 11]
        * */
        System.out.println(graph.getACycle(11));
    }
}
