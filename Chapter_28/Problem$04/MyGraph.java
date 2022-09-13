package chapter_twenty_eight;

import java.util.ArrayList;
import java.util.List;

public class MyGraph<V> extends UnweightedGraph<V>
{
    public MyGraph(int[][] edges, int vertices)
    {
        super(edges, vertices);
    }

    public List<List<Integer>> getConnectedComponents()
    {
        List<List<Integer>> connectedComponents = new ArrayList<>();
        int vertices = getSize();
        for (int i = 0; i < vertices; i++)
        {
            boolean validStart = true;
            for (List<Integer> list : connectedComponents)
            {
                if (list.contains(i))
                {
                    validStart = false;
                    break;
                }
            }

            if (validStart)
                connectedComponents.add(bfs(i).getSearchOrder());
        }
        return connectedComponents;
    }
}
