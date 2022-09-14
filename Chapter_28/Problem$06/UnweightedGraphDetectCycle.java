package chapter_twenty_eight;

import java.util.List;

public class UnweightedGraphDetectCycle<V> extends UnweightedGraph<V>
{
    public UnweightedGraphDetectCycle(V[] vertices, int[][] edges)
    {
        super(vertices, edges);
    }

    /**
     * Algorithm:
     *
     * for each point x in the graph
     * get the dfs starting from x and store them
     * in a list called ("possibleCycle")
     * for each point y in possibleCycle
     * starting from the third point
     * in possibleCycle ("since the cycle must have at least 3 distinct points")
     * if the neighbours of y contains x then
     * we found a cycle hence we return true
     * at the end return false ("indicating that there`s no possible cycle in the graph")
     *
     * */
    public boolean isCyclic()
    {
        int size = getSize();
        for (int i = 0; i < size; i++)
        {
            List<Integer> possibleCycle = dfs(i).getSearchOrder();

            // since the cycle must have at least 3 distinct points
            for (int j = 2; j < possibleCycle.size(); j++)
            {
                List<Integer> neighbours = getNeighbors(possibleCycle.get(j));
                if (neighbours.contains(i))
                    return true;
            }
        }
        return false;
    }
}
