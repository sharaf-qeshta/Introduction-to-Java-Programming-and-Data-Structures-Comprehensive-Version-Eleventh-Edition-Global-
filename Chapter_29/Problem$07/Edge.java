package chapter_twenty_nine;


import java.io.Serializable;

public class Edge implements Serializable
{
    int u;
    int v;

    public Edge(int u, int v)
    {
        this.u = u;
        this.v = v;
    }

    public boolean equals(Object o)
    {
        return u == ((Edge) o).u && v == ((Edge) o).v;
    }
}
