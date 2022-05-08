package chapter_four;

import java.util.Locale;
import java.util.Scanner;


/**
 * *4.15 (Phone key pads) The international standard letter/number mapping found on the
 * telephone is shown below:
 * Write a program that prompts the user to enter a lowercase or uppercase letter and
 * displays its corresponding number. For a nonletter input, display invalid input.
 *
 *          Enter a letter: A
 *          The corresponding number is 2
 *
 *          Enter a letter: a
 *          The corresponding number is 2
 *
 *          Enter a letter: +
 *          + is an invalid input
 *
 * @author Sharaf Qeshta
 * */

public class Problem$15
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter a letter: ");
        String input = scanner.next();

        char letter = Character.toLowerCase(input.charAt(0));   // problems in s, v, y, z
        // a,b,c = 2     97 - 99
        // d,e,f = 3     100 - 102
        // g,h,i = 4     103 - 105
        // j,k,l = 5     106 - 108
        // m,n,o = 6     109 - 111
        // p,q,r,s = 7   112 - 115
        // t,u,v = 8     116 - 118
        // w,x,y,z = 9   119 - 122

        if (letter < 97 || letter > 127)
            System.out.println(letter + " is an invalid input");
        else
        {
            int code = ((int) letter - 91) / 3;

            boolean problemOccurs = letter == 's' || letter == 'v'
                    || letter == 'y' || letter == 'z';

            if (problemOccurs)
                code--;

            System.out.println("The corresponding number is " + code);
        }
    }
}
