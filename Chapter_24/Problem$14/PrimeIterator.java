package chapter_twenty_four;

import java.util.Iterator;

public class PrimeIterator implements Iterator<Integer>
{
    int current = 2;
    int limit; 

    public PrimeIterator(int limit)
    {
       this.limit = limit;
    }

    @Override
    public boolean hasNext()
    {
        return current <= limit;
    }

    @Override
    public Integer next()
    {
        int next = current+1;
        boolean found = false;
        while (!found)
        {
            found = true;
            for (int i = 2; i < next; i++)
                if (next % i == 0)
                {
                    found = false;
                    next++;
                    break;
                }
        }
        int out = current;
        current = next;
        return out;
    }
}
