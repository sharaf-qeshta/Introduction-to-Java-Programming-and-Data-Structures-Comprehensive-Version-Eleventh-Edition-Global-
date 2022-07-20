package chapter_twenty;

import java.util.ListIterator;
import java.util.Locale;
import java.util.Scanner;
import java.util.Stack;

/**
 * *20.11 (Remove Consecutive Integers) Write a program that reads 10 integers and
 * displays them in the reverse of the order in which they were read. If
 * two consecutive numbers are identical, then only display one of them. Implement your
 * program using only stack and not arrays or queues.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$11
{
    public static void main(String[] args)
    {
        Stack<Integer> integers = new Stack<>(); // lifo
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter 10 integers: ");
        for (int i = 0; i < 10; i++)
            integers.push(scanner.nextInt());

        removeConsecutiveIntegers(integers);
        reverse(integers);
        System.out.println(integers);
    }

    public static void removeConsecutiveIntegers(Stack<Integer> stack)
    {
        Stack<Integer> removed = new Stack<>();
        for (Integer integer : stack)
            for (Integer integer2 : stack)
                if (integer + 1 == integer2 || integer - 1 == integer2)
                    removed.push(integer2);
        stack.removeAll(removed);
    }

    public static void reverse(Stack<Integer> stack)
    {
        Stack<Integer> temp = new Stack<>();
        ListIterator<Integer> iterator = stack.listIterator(stack.size());
        while (iterator.hasPrevious())
            temp.push(iterator.previous());
        stack.clear();
        stack.addAll(temp);
    }
}
