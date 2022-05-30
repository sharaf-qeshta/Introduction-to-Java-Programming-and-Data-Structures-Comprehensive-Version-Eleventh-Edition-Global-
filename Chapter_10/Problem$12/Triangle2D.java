package chapter_ten;

public class Triangle2D
{
    private MyPoint p1, p2, p3;

    public Triangle2D()
    {
        p1 = new MyPoint(0, 0);
        p2 = new MyPoint(1, 1);
        p3 = new MyPoint(2, 5);
    }

    public Triangle2D(MyPoint p1, MyPoint p2, MyPoint p3)
    {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }


    public double getArea()
    {
        return Math.abs((p1.getX() * p2.getY() + p2.getX() * p3.getY()
                + p3.getX() * p1.getY() - p1.getY() * p2.getX()
                - p2.getY() * p3.getX() - p3.getY() - p1.getX()) / 2);
    }

    public double getPerimeter()
    {
        double s1 = Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
        double s2 = Math.sqrt(Math.pow(p3.getX() - p2.getX(), 2) + Math.pow(p3.getY() - p2.getY(), 2));
        double s3 = Math.sqrt(Math.pow(p1.getX() - p3.getX(), 2) + Math.pow(p1.getY() - p3.getY(), 2));
        return s1 + s2 + s3;
    }


    private double sign (MyPoint p1, MyPoint p2, MyPoint p3)
    {
        return (p1.getX() - p3.getX()) * (p2.getY()
                - p3.getY()) - (p2.getX() - p3.getX()) * (p1.getY() - p3.getY());
    }

    public boolean contains(double x, double y)
    {
        return contains(new MyPoint(x, y));
    }


    public boolean contains(MyPoint p)
    {
        double d1, d2, d3;
        boolean has_neg, has_pos;

        d1 = sign(p, p1, p2);
        d2 = sign(p, p2, p3);
        d3 = sign(p, p3, p1);

        has_neg = (d1 < 0) || (d2 < 0) || (d3 < 0);
        has_pos = (d1 > 0) || (d2 > 0) || (d3 > 0);

        return !(has_neg && has_pos);
    }


    public boolean contains(Triangle2D t)
    {
        return contains(t.p1) && contains(t.p2) && contains(t.p3);
    }


    public boolean overlaps(Triangle2D t)
    {
        MyPoint[] t1 = new MyPoint[] {p1, p2, p3};
        MyPoint[] t2 = new MyPoint[] {t.p1, t.p2, t.p3};

        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++)
                if (intersect(t1[i], t1[i+1], t2[j], t2[j+1]))
                    return true;
        return false;
    }


    private boolean intersect(MyPoint p1, MyPoint p2,
                              MyPoint p3, MyPoint p4)
    {
        int ML1 = (int) ((p2.getY() - p1.getY()) / (p2.getX() -p1.getX()));
        int ML2 = (int) ((p4.getY() - p3.getY()) / (p4.getX() - p3.getX()));

        return ML1 != ML2;
    }

    public MyPoint getP1()
    {
        return p1;
    }

    public void setP1(MyPoint p1)
    {
        this.p1 = p1;
    }

    public MyPoint getP2()
    {
        return p2;
    }

    public void setP2(MyPoint p2)
    {
        this.p2 = p2;
    }

    public MyPoint getP3()
    {
        return p3;
    }

    public void setP3(MyPoint p3)
    {
        this.p3 = p3;
    }
}
