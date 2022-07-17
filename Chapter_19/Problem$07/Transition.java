package chapter_nineteen;

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


    public static <E extends Number,
            T extends Number, X extends Number> double sum(Transition<E, T, X> transition)
    {
        return transition.getO1().doubleValue() + transition.getO2().doubleValue()
                + transition.getO3().doubleValue();
    }
}
