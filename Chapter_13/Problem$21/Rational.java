package chapter_thirteen;

import java.math.BigInteger;

public class Rational extends Number implements Comparable<Rational>
{
    // Data fields for numerator and denominator
    private BigInteger[] r = new BigInteger[2];
    private static int NUMERATOR = 0;
    private static int DENOMINATOR = 1;

    /**
     * Default constructor
     */
    public Rational()
    {
        this(BigInteger.ZERO, BigInteger.ONE);
    }

    /**
     * Construct a rational with specified numerator and denominator
     */
    public Rational(BigInteger numerator, BigInteger denominator)
    {
        r[NUMERATOR] = numerator;
        r[DENOMINATOR] = denominator;
    }

    /**
     * Find GCD of two numbers
     */
    private BigInteger gcd(BigInteger n, BigInteger d)
    {
        BigInteger t1 = n.abs();
        BigInteger t2 = d.abs();
        BigInteger remainder = t1.remainder(t2);

        while (!remainder.equals(BigInteger.ZERO)) {
            t1 = t2;
            t2 = remainder;
            remainder = t1.remainder(t2);
        }

        return t2;
    }

    /**
     * Return numerator
     */
    public BigInteger getNumerator()
    {
        return r[NUMERATOR];
    }

    /**
     * Return denominator
     */
    public BigInteger getDenominator()
    {
        return r[DENOMINATOR];
    }

    /**
     * Add a rational number to this rational
     */
    public Rational add(Rational secondRational)
    {
        BigInteger n = r[NUMERATOR].multiply(secondRational.getDenominator())
                .add(r[DENOMINATOR].multiply(secondRational.getNumerator()));
        BigInteger d = r[DENOMINATOR].multiply(secondRational.getDenominator());
        return new Rational(n, d);
    }

    /**
     * Subtract a rational number from this rational
     */
    public Rational subtract(Rational secondRational)
    {
        BigInteger n = r[NUMERATOR].multiply(secondRational.getDenominator())
                .subtract(r[DENOMINATOR].multiply(secondRational.getNumerator()));
        BigInteger d = r[DENOMINATOR].multiply(secondRational.getDenominator());
        return new Rational(n, d);
    }

    /**
     * Multiply a rational number to this rational
     */
    public Rational multiply(Rational secondRational)
    {
        BigInteger n = r[NUMERATOR].multiply(secondRational.getNumerator());
        BigInteger d = r[DENOMINATOR].multiply(secondRational.getDenominator());
        return new Rational(n, d);
    }

    /**
     * Divide a rational number from this rational
     */
    public Rational divide(Rational secondRational)
    {
        BigInteger n = r[NUMERATOR].multiply(secondRational.getDenominator());
        BigInteger d = r[DENOMINATOR].multiply(secondRational.r[NUMERATOR]);
        return new Rational(n, d);
    }

    @Override
    public String toString()
    {
        return r[NUMERATOR] + "/" + r[DENOMINATOR];
    }

    /**
     * Override the equals method in the Object class
     */
    public boolean equals(Object parm1)
    {
        return (this.subtract((Rational) (parm1))).getNumerator().equals(BigInteger.ZERO);
    }

    /**
     * Override the hashCode method in the Object class
     */
    public int hashCode()
    {
        return new Double(this.doubleValue()).hashCode();
    }

    /**
     * Override the abstract intValue method in java.lang.Number
     */
    public int intValue()
    {
        return (int) doubleValue();
    }

    @Override
    public long longValue()
    {
        return 0;
    }

    /**
     * Override the abstract floatValue method in java.lang.Number
     */
    public float floatValue()
    {
        return (float) doubleValue();
    }

    @Override
    public double doubleValue()
    {
        double r1 = Double.parseDouble(r[0].toString());
        double r2 = Double.parseDouble(r[1].toString());

        return r1 / r2;
    }

    @Override
    public int compareTo(Rational o)
    {
        return (int) subtract(o).doubleValue();
    }

    public static int findGCD(int number1, int number2)
    {
        //base case
        if(number2 == 0)
            return number1;
        return findGCD(number2, number1%number2);
    }

    public static Rational createRational(double decimal)
    {
        int denominator = (decimal + "").split("\\.")[1].length() * 10;
        int numerator = (int) (decimal * denominator);
        int gcd = findGCD(numerator, denominator);

        return new Rational(new BigInteger((numerator/gcd)+""),
                new BigInteger((denominator/gcd)+""));
    }
}
