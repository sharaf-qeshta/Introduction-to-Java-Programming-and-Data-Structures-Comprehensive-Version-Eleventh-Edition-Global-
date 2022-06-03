package chapter_eleven;

import java.util.ArrayList;
import java.util.Date;

/**
 * 11.6 (Use ArrayList) Write a program that creates an ArrayList and adds a Loan
 * object, a Date object, a string, and a Circle object to the list, and use a loop to
 * display all the elements in the list by invoking the object’s toString() method.
 *
 * @author Sharaf Qeshta
 * */
public class Problem$06
{
    public static void main(String[] args)
    {
        ArrayList<Object> list = new ArrayList<>();

        list.add(new Loan());
        list.add(new Circle());
        list.add("Polymorphism");
        list.add(new Date());

        /*
        * Loan{}
        * Circle{}
        * Polymorphism
        * Fri Jun 03 09:14:42 PDT 2022
        * */
        for (Object o : list) System.out.println(o.toString());
    }
}
