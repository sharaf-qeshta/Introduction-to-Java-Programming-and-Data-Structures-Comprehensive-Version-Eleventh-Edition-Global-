package chapter_nine;

public class LinearEquation
{
    private double a, b, c, d, e, f;

    public LinearEquation(double a, double b, double c,
                          double d, double e, double f)
    {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }


    public boolean isSolvable()
    {
        return a * d - b * c != 0;
    }

    public double getX()
    {
        if (isSolvable())
            return (e * d - b * f) / (a * d - b * c);
        return 0;
    }

    public double getY()
    {
        if (isSolvable())
            return (a * f - e * c) / (a * d - b * c);
        return 0;
    }


    public double getA()
    {
        return a;
    }

    public double getB()
    {
        return b;
    }

    public double getC()
    {
        return c;
    }

    public double getD()
    {
        return d;
    }

    public double getE()
    {
        return e;
    }

    public double getF()
    {
        return f;
    }
}
