package chapter_twenty_eight;

import java.util.ArrayList;
import java.util.List;

public class UnweightedGraphTestBipartite<V> extends UnweightedGraph<V>
{
    public UnweightedGraphTestBipartite(V[] vertices, int[][] edges)
    {
        super(vertices, edges);
    }

    public boolean isBipartite()
    {
        List<Integer> v = new ArrayList<>();
        List<Integer> u = new ArrayList<>();
        for (int i = 0; i < getSize(); i++)
        {
            List<Integer> neighbours = getNeighbors(i);
            if (neighbours.isEmpty())
                return false;

            boolean addToV = true;

            for (int neighbour: neighbours)
            {
                if (v.contains(neighbour))
                {
                    addToV = false;
                    break;
                }
            }

            if (addToV)
            {
                v.add(i);
                continue;
            }

            boolean addToU = true;
            for (int neighbour: neighbours)
            {
                if (u.contains(neighbour))
                {
                    addToU = false;
                    break;
                }
            }

            if (addToU)
            {
                u.add(i);
                continue;
            }

            return false;
        }

        return true;
    }
}
