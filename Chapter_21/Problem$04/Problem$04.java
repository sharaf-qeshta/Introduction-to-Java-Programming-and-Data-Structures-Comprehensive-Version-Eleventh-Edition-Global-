package chapter_twenty_one;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * *21.4 (Count consonants and vowels) Write a program that prompts the user to enter a
 * text file name and displays the number of vowels and consonants in the file. Use
 * a set to store the vowels A, E, I, O, and U.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$04
{
    public static final ArrayList<Character> VOWELS = new ArrayList<>
            (Arrays.asList('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'));

    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter File Name: ");
        String fileName = keyboard.next();
        keyboard.close();

        Map<String, Integer> occurrence = new HashMap<>();
        occurrence.put("consonants", 0);
        occurrence.put("vowels", 0);

        Scanner scanner = new Scanner(new File(fileName));
        while (scanner.hasNext())
        {
            String name = scanner.nextLine();
            char[] chars = name.toCharArray();
            for (char x: chars)
            {
                if (Character.isLetter(x))
                {
                    if (VOWELS.contains(x))
                        occurrence.put("vowels", occurrence.get("vowels") + 1);
                    else
                        occurrence.put("consonants", occurrence.get("consonants") + 1);
                }
            }
        }

        System.out.println(occurrence);
    }
}
