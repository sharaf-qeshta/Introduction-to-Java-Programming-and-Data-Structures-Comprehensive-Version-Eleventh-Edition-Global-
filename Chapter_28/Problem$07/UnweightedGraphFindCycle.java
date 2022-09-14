package chapter_twenty_eight;

import java.util.ArrayList;
import java.util.List;

public class UnweightedGraphFindCycle<V> extends UnweightedGraph<V>
{
    public UnweightedGraphFindCycle(V[] vertices, int[][] edges)
    {
        super(vertices, edges);
    }

    /**
     * Algorithm :
     * PROCEDURE getACycle(int u):
     *      DECLARE List possibleCycle ← depth first search from point u
     *      for j from 2 to possibleCycle.size()-1:
     *          DECLARE List neighbours = neighbours of possibleCycle.get(j)
     *          if u ∈ neighbours:
     *              // cycle found
     *              DECLARE List cycle = empty list
     *              for k from 0 to j+1:
     *                  add possibleCycle.get(k) to cycle
     *              add u to cycle
     *              return cycle
     *      // cycle not found
     *      return null
     * */
    public List<Integer> getACycle(int u)
    {
        List<Integer> possibleCycle = dfs(u).getSearchOrder();

        // since the cycle must have at least 3 distinct points
        for (int j = 2; j < possibleCycle.size(); j++)
        {
            List<Integer> neighbours = getNeighbors(possibleCycle.get(j));
            if (neighbours.contains(u))
            {
                // cycle found
                List<Integer> cycle = new ArrayList<>();
                for (int k = 0; k < j+1; k++)
                    cycle.add(possibleCycle.get(k));
                cycle.add(u);
                return cycle;
            }
        }

        // there`s no possible cycle starting from u
        return null;
    }
}
