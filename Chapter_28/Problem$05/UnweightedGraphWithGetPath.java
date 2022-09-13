package chapter_twenty_eight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UnweightedGraphWithGetPath<V> extends UnweightedGraph<V>
{
    public UnweightedGraphWithGetPath(V[] vertices, int[][] edges)
    {
        super(vertices, edges);
    }

    public List<Integer> getPath(int u, int v)
    {
        List<Integer> bfsTraversal = bfs(u).getSearchOrder();

        // there`s no such path
        if (!bfsTraversal.contains(v))
            return null;

        List<Integer> path = new ArrayList<>();
        for (Integer element : bfsTraversal)
        {
            if (element == v)
            {
                path.add(v);
                break;
            }
            path.add(element);
        }

        List<Integer> shortenedPath = new ArrayList<>();
        for (int i = path.size()-1; i > -1; i--)
        {
            shortenedPath.add(path.get(i));
            List<Integer> neighbours = getNeighbors(path.get(i));
            int minIndex = getSize()+1;
            for (int neighbour: neighbours)
            {
                int index = path.indexOf(neighbour);
                if (index != -1 && index < minIndex)
                    minIndex = index;
            }

            // there`s possible shortened
            if (minIndex != getSize()+1)
            {
                if (minIndex < i)
                {
                    i = minIndex+1;
                }
            }
        }

        // reverse
        Collections.reverse(shortenedPath);

        return shortenedPath;
    }
}
