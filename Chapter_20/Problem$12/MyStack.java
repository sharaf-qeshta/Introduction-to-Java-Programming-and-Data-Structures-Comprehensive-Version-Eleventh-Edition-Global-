package chapter_twenty;

import java.util.List;
import java.util.Stack;

public class MyStack<E> extends Stack<E>
{
    public MyStack(List<E> list)
    {
        for (E e : list)
            push(e);
    }
}
