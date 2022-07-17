package chapter_nineteen;

/**
 * (Several types) Create an Association class that encapsulates two objects of different
 * types. Similar to Programming Exercise 19.5, create a Transition class that does the
 * same of Association class with three objects.
 * */

public class Transition<E, T, X>
{
    private final E o1;
    private final T o2;
    private final X o3;

    public Transition(E o1, T o2, X o3)
    {
        this.o1 = o1;
        this.o2 = o2;
        this.o3 = o3;
    }

    public E getO1()
    {
        return o1;
    }

    public T getO2()
    {
        return o2;
    }

    public X getO3()
    {
        return o3;
    }
}
