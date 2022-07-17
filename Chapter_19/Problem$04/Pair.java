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

    public static <E extends Comparable<E>> E getSmallest(Pair<E> pair)
    {
        int comparison = pair.getO1().compareTo(pair.o2);
        if (comparison == 0)
            return null;
        else if (comparison < 0)
            return pair.getO1();
        else
            return pair.getO2();
    }
}
