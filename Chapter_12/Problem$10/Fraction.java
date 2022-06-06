package chapter_twelve;

public class Fraction
{
    private final double denominator, numerator;

    public Fraction(double denominator, double numerator) throws NullDenominatorException
    {
        if (denominator == 0)
            throw new NullDenominatorException();
        this.denominator = denominator;
        this.numerator = numerator;
    }
}
