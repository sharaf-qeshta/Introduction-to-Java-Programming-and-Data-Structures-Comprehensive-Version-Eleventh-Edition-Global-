package chapter_twenty_four;

import java.util.Iterator;

public class FibonacciIterator implements Iterator<Integer>
{
    int limit;
    int a1 = 0;
    int a2 = 1;

    public FibonacciIterator(int limit)
    {
        this.limit = limit;
    }

    @Override
    public boolean hasNext()
    {
        return a2 <= limit;
    }

    @Override
    public Integer next()
    {
        int next = a1 + a2;
        a1 = a2;
        a2 = next;
        return a1;
    }
}
