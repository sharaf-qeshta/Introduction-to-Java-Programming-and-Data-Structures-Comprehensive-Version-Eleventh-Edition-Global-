package chapter_thirteen;

import java.util.ArrayList;

public class MyStack  extends ArrayList<Object>
{
    public MyStack() { }

    public MyStack(MyStack stack)
    {
        // deep copy
        for (Object x: stack)
            add(x);
    }
    public Object peek()
    {
        return get(size() - 1);
    }

    public Object pop()
    {
        Object o = get(size() - 1);
        remove(size() - 1);
        return o;
    }

    public void push(Object o)
    {
        add(o);
    }

    /** Override the toString in the Object class */
    @Override
    public String toString()
    {
        return "stack: " + super.toString();
    }
}

