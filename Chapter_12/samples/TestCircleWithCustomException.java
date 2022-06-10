package chapter_twelve.samples;

/**
 * Listing 12.11 TestCircleWithCustomException.java
 * */
public class TestCircleWithCustomException
{
    public static void main(String[] args)
    {
        try
        {
            new CircleWithCustomException(5);
            new CircleWithCustomException(-5);
            new CircleWithCustomException(0);
        }
        catch (InvalidRadiusException ex)
        {
            System.out.println(ex);
        }

        System.out.println("Number of objects created: " +
                CircleWithCustomException.getNumberOfObjects());
    }
}

class CircleWithCustomException
{
    /**
     * The radius of the circle
     */
    private double radius;

    /**
     * The number of objects created
     */
    private static int numberOfObjects = 0;

    /**
     * Construct a circle with radius 1
     */
    public CircleWithCustomException() throws InvalidRadiusException
    {
        this(1.0);
    }

    /**
     * Construct a circle with a specified radius
     */
    public CircleWithCustomException(double newRadius)
            throws InvalidRadiusException
    {
        setRadius(newRadius);
        numberOfObjects++;
    }


    /**
     * Return radius
     */
    public double getRadius()
    {
        return radius;
    }

    /**
     * Set a new radius
     */
    public void setRadius(double newRadius)
            throws InvalidRadiusException
    {
        if (newRadius >= 0)
            radius = newRadius;
        else
            throw new InvalidRadiusException(newRadius);
    }

    /**
     * Return numberOfObjects
     */
    public static int getNumberOfObjects()
    {
        return numberOfObjects;
    }

    /**
     * Return the area of this circle
     */
    public double findArea()
    {
        return radius * radius * 3.14159;
    }
}
