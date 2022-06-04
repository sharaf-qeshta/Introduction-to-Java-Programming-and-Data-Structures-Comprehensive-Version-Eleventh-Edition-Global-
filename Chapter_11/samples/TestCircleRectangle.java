package chapter_eleven.samples;

/**
 * Listing 11.4 TestCircleRectangle.java
 */
public class TestCircleRectangle
{
    public static void main(String[] args)
    {
        Circle circle = new Circle(1);
        System.out.println("A circle " + circle.toString());
        System.out.println("The color is " + circle.getColor());
        System.out.println("The radius is " + circle.getRadius());
        System.out.println("The area is " + circle.getArea());
        System.out.println("The diameter is " + circle.getDiameter());

        Rectangle rectangle = new Rectangle(2, 4);
        System.out.println("\nA rectangle " + rectangle.toString());
        System.out.println("The area is " + rectangle.getArea());
        System.out.println("The perimeter is " +
                rectangle.getPerimeter());
    }
}
