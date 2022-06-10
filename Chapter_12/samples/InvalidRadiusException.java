package chapter_twelve.samples;


/**
 * Listing 12.10 InvalidRadiusException.java
 * */
public class InvalidRadiusException extends Exception
{
    private double radius;

    /**
     * Construct an exception
     */
    public InvalidRadiusException(double radius)
    {
        super("Invalid radius " + radius);
        this.radius = radius;
    }

    /**
     * Return the radius
     */
    public double getRadius()
    {
        return radius;
    }
}
