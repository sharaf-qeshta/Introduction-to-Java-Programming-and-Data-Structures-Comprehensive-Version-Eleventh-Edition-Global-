package chapter_nineteen;

import java.util.ArrayList;

public class GenericStack<E> extends ArrayList<E>
{
    public int getSize()
    {
        return size();
    }

    public E peek()
    {
        return get(getSize()-1);
    }

    public void push(E o)
    {
        add(o);
    }

    public E pop()
    {
        E o = get(getSize()-1);
        remove(getSize()-1);
        return o;
    }

    public GenericStack<E> reverse()
    {
        GenericStack<E> output = new GenericStack<>();
        for (int i = size()-1; i > -1; i--)
            output.push(get(i));
        return output;
    }
}
