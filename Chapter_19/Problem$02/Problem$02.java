package chapter_nineteen;

import java.util.Scanner;

/**
 * 19.2 (Implement GenericStack using inheritance) In Listing 19.1, GenericStack is
 * implemented using composition. Define a new stack class that extends ArrayList.
 * Draw the UML diagram for the classes then implement GenericStack. Write a test
 * program that prompts the user to enter five strings and displays them in reverse order.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$02
{
    public static void main(String[] args)
    {
        GenericStack<String> stack = new GenericStack<>();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0;i < 5; i++)
        {
            System.out.print("Enter Five Strings: ");
            stack.push(scanner.next());
        }

        System.out.println(stack);
        System.out.println(stack.reverse());
    }
}
