package chapter_nine;

public class QuadraticEquation
{
    private double a, b, c;

    public QuadraticEquation(double a, double b, double c)
    {
        this.a = a;
        this.b = b;
        this.c = c;
    }


    public double getDiscriminant()
    {
        return (b * b) - (4 * a * c);
    }


    public double getRoot1()
    {
        double discriminant = getDiscriminant();
        if (discriminant < 0)
            return 0;
        return (-b + Math.sqrt(discriminant)) / (2 * a);
    }


    public double getRoot2()
    {
        double discriminant = getDiscriminant();
        if (discriminant < 0)
            return 0;
        return (-b - Math.sqrt(discriminant)) / (2 * a);
    }


    public String getOutput()
    {
        double discriminant = getDiscriminant();

        if (discriminant < 0)
            return "the equation have no roots";
        if (discriminant == 0)
            return getRoot2() +"";
        return getRoot1() + ", " + getRoot2();

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
}
