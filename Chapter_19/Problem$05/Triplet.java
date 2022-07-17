package chapter_nineteen;

public class Triplet<E>
{
    private final E o1;
    private final E o2;
    private final E o3;

    public Triplet(E o1, E o2, E o3)
    {
        this.o1 = o1;
        this.o2 = o2;
        this.o3 = o3;
    }

    public E getO1()
    {
        return o1;
    }

    public E getO2()
    {
        return o2;
    }

    public E getO3()
    {
        return o3;
    }
}
