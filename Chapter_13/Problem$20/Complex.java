package chapter_thirteen;

public class Complex implements Comparable<Complex>, Cloneable
{
    // a + bi
    private double a, b;

    public Complex(double a, double b)
    {
        this.a = a;
        this.b = b;
    }

    public Complex(double a)
    {
        this.a = a;
        this.b = 0;
    }

    public Complex()
    {
        this.a = 0; this.b = 0;
    }


    public Complex add(Complex complex)
    {
        return new Complex(a + complex.getA(), b + complex.getB());
    }

    public Complex subtract(Complex complex)
    {
        return new Complex(a - complex.getA(), b - complex.getB());
    }

    public Complex multiply(Complex complex)
    {
        double a_ = (a * complex.getA()) - (b * complex.getB());
        double b_ = (b * complex.getA()) + (a * complex.getB());
        return new Complex(a_, b_);
    }

    public Complex divide(Complex complex)
    {
        // (ac + bd)/(c² + d²)
        double a_ = ((a * complex.getA()) + (b * complex.getB()))
                / ((complex.getA() * complex.getA()) + (complex.getB() * complex.getB()));

        // (bc - ad)i/(c² + d²)
        double b_ = ((b * complex.getA()) - (a * complex.getB()))
                / ((complex.getA() * complex.getA()) + (complex.getB() * complex.getB()));
        return new Complex(a_, b_);
    }

    public double abs()
    {
        return Math.sqrt(a * a + b * b);
    }


    public double getA()
    {
        return a;
    }

    public double getB()
    {
        return b;
    }


    public double getRealPart()
    {
        return a;
    }


    public String getImaginaryPart()
    {
        return b + "i";
    }


    @Override
    public String toString()
    {
        if (b == 0)
            return a + "";
        return "(" + a + " + " + b + "i)";
    }


    @Override
    public int compareTo(Complex o)
    {
        double difference = abs() - o.abs();
        if (difference == 0)
            return 0;
        if (difference < 0)
            return -1;
        return 1;
    }
}
