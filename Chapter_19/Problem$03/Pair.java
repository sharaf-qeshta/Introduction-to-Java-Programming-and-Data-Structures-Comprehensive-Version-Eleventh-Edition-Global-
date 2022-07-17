package chapter_nineteen;

public class Pair<E>
{
    private E o1;
    private E o2;

    public Pair(E o1, E o2)
    {
        this.o1 = o1;
        this.o2 = o2;
    }


    public E getO1()
    {
        return o1;
    }

    public E getO2()
    {
        return o2;
    }
}
