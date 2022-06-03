package chapter_eleven;

import java.util.Locale;
import java.util.Scanner;

/**
 * 11.10 (Implement MyStack using inheritance) In Listing 11.10, MyStack is
 * implemented using composition. Define a new stack class that extends ArrayList.
 * Draw the UML diagram for the classes then implement MyStack. Write a test
 * program that prompts the user to enter five strings and displays them in reverse order
 *
 * @author Sharaf Qeshta
 * */
public class Problem$10
{
    public static void main(String[] args)
    {
        MyStack<String> myStack = new MyStack<>();

        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("enter strings: ");
        for (int i = 0; i < 5;i++)
            myStack.push(scanner.next());

        myStack.reverse();
        System.out.println(myStack);
    }
}
