package chapter_nineteen.samples;

/**
 * Listing 19.11 IntegerMatrix.java
 */
public class IntegerMatrix extends GenericMatrix<Integer>
{
    @Override
    /** Add two integers */
    protected Integer add(Integer o1, Integer o2)
    {
        return o1 + o2;
    }

    @Override
    /** Multiply two integers */
    protected Integer multiply(Integer o1, Integer o2)
    {
        return o1 * o2;
    }

    @Override
    /** Specify zero for an integer */
    protected Integer zero()
    {
        return 0;
    }
}
