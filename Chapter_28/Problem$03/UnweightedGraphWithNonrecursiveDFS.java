package chapter_twenty_eight;

import java.util.*;

public class UnweightedGraphWithNonrecursiveDFS<V> extends UnweightedGraph<V>
{
    public UnweightedGraphWithNonrecursiveDFS(V[] vertices, int[][] edges)
    {
        super(vertices, edges);
    }
    /**
     * Algorithm
     * Step1:
     * create a list ("searchOrder")
     * create an array that indicates the parent of each node ("parent")
     * fill parent with -1 ("parents not found yet")
     * create another array of type boolean indicates whether a node visited or not ("isVisited")
     * create a stack of integers ("stack")
     * add v to stack
     *
     * Step2:
     * delete the last element in the stack ("current")
     * if the deleted element is not visited then add
     * the deleted element to searchOrder and mark the deleted
     * element as visited then iterate through all the neighbours
     * of the deleted element if the current neighbour is not visited
     * then push the current neighbour to the stack and assign the parent
     * of the current neighbour to the deleted element.
     *
     * Step3:
     *  if stack is empty then return a SearchTree otherwise back to Step2
     * */
    @Override
    public SearchTree dfs(int v)
    {
        List<Integer> searchOrder = new ArrayList<>();
        int[] parent = new int[vertices.size()];

        Arrays.fill(parent, -1);

        boolean[] isVisited = new boolean[vertices.size()];

        Stack<Integer> stack = new Stack<>();
        stack.push(v);

        while (!stack.isEmpty())
        {
            v = stack.pop();

            if (!isVisited[v])
            {
                searchOrder.add(v);
                isVisited[v] = true;

                for (Edge e : neighbors.get(v))
                {
                    if (!isVisited[e.v])
                    {
                        stack.push(e.v);
                        parent[e.v] = v;
                    }
                }
            }
        }
        return new SearchTree(v, parent, searchOrder);
    }
}
