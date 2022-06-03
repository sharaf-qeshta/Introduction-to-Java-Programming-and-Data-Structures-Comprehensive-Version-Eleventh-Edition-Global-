package chapter_eleven;

import java.util.ArrayList;

public class MyStack<T> extends ArrayList<T>
{

    public T peek()
    {
        return get(size() - 1);
    }

    public T pop()
    {
        T object = get(size() - 1);
        remove(size() - 1);
        return object;
    }

    public void push(T element)
    {
        add(element);
    }

    public void reverse()
    {
        int j = size() - 1;
        for (int i = 0; i < size()/2;i++, j--)
        {
            T temp = this.get(i);
            this.set(i, get(j));
            this.set(j, temp);
        }
    }


    @Override
    public String toString()
    {
        return "MyStack{ "+  super.toString() +" }";
    }
}
