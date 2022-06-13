package chapter_thirteen;

public class ComparableSquare extends Square implements Comparable<ComparableSquare>
{
    @Override
    public int compareTo(ComparableSquare o)
    {
        double comparison = getArea() - o.getArea();
        if (comparison > 0)
            return 1;
        else if (comparison < 0)
            return -1;
        return 0;
    }

    public ComparableSquare(double side)
    {
        super(side);
    }
}
