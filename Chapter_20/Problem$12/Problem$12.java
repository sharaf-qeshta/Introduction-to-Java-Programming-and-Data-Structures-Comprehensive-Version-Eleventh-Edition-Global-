package chapter_twenty;

import java.util.Arrays;
import java.util.List;

/**
 * 20.12 (Create Stack from list) Define a class MyStack that extends Stack to be
 * able to have its constructor use a list of objects instead of pushing each object
 * individually.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$12
{
    public static void main(String[] args)
    {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        MyStack<Integer> stack = new MyStack<>(list);

        /* [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] */
        System.out.println(stack);
    }
}
