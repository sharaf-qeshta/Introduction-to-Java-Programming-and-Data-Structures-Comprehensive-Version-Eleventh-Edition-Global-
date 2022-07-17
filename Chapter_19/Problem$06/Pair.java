package chapter_nineteen;


public class Pair<E, T>
{
    private E o1;
    private T o2;

    public Pair(E o1, T o2)
    {
        this.o1 = o1;
        this.o2 = o2;
    }


    public E getO1()
    {
        return o1;
    }

    public T getO2()
    {
        return o2;
    }
}
