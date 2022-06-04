package chapter_eleven;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.lang.System;

/**
 * **11.18 (ArrayList of Character) Write a method that returns an array list of Character
 * from a string using the following header:
 * public static ArrayList<Character> toCharacterArray(String s)
 * For example, toCharacterArray("abc") returns an array list that contains
 * characters 'a', 'b', and 'c'.
 *
 * @author Sharaf Qeshta
 * */
public class Problem$18
{
    public static void main(String[] args)
    {
        /* [a, b, c] */
        System.out.println(toCharacterArray("abc"));
    }


    public static ArrayList<Character> toCharacterArray(String s)
    {
        ArrayList<Character> characters = new ArrayList<>();
        for (int i = 0; i < s.length();i++)
            characters.add(s.charAt(i));
        return characters;
    }
}
