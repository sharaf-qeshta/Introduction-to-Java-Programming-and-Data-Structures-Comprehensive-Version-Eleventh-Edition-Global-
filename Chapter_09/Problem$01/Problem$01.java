package chapter_nine;

/**
 * 9.1 (The Rectangle class) Following the example of the Circle class in Section 9.2,
 * design a class named Rectangle to represent a rectangle. The class contains:
 * ■■ Two double data fields named width and height that specify the width and
 * height of the rectangle. The default values are 1 for both width and height.
 * ■■ A no-arg constructor that creates a default rectangle.
 * ■■ A constructor that creates a rectangle with the specified width and height.
 * ■■ A method named getArea() that returns the area of this rectangle.
 * ■■ A method named getPerimeter() that returns the perimeter.
 * Draw the UML diagram for the class then implement the class. Write a test
 * program that creates two Rectangle objects—one with width 4 and height 40
 * the other with width 3.5 and height 35.9. Display the width, height, area, and
 * perimeter of each rectangle in this order.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$01
{
    public static void main(String[] args)
    {
        Rectangle r1 = new Rectangle(4, 40);
        Rectangle r2 = new Rectangle(3.5, 35.9);

        System.out.println("rectangle 1 height: " + r1.height);
        System.out.println("rectangle 1 width: " + r1.width);
        System.out.println("rectangle 1 area: " + r1.getArea());
        System.out.println("rectangle 1 perimeter: " + r1.getPerimeter());

        System.out.println("\nrectangle 2 height: " + r2.height);
        System.out.println("rectangle 2 width: " + r2.width);
        System.out.println("rectangle 2 area: " + r2.getArea());
        System.out.println("rectangle 2 perimeter: " + r2.getPerimeter());
    }
}
