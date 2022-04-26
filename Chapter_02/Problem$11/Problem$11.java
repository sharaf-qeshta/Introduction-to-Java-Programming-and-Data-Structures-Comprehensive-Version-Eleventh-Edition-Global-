package chapter_two;

import java.util.*;

/**
 * 2.11 (Population projection) Rewrite Programming Exercise 1.11 to prompt the user
 * to enter the number of years and display the population after the number of years.
 * Use the hint in Programming Exercise 1.11 for this program. Here is a sample run
 * of the program:
 *          Enter the number of years: 5
 *          The population in 5 years is 325932969
 *
 * @author Sharaf Qeshta
 * */

public class Problem$11
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in).useLocale(Locale.US);

        // One birth every 7 seconds
        // One death every 13 seconds
        // One new immigrant every 45 seconds
        // U.S. current population is 312,032,486
        // what will be the population after five years?
        System.out.print("enter number of years: ");
        int years = scan.nextInt();

        int secInYear = 365 * 24 * 60 * 60;
        int births = (secInYear / 7) * years;
        int deaths = (secInYear / 13) * years;
        int immigrant = (secInYear / 45) * years;
        int USPop = (births + immigrant + 312032486) - deaths;
        System.out.println("The population in " + years +  " years is " + USPop);
    }
}
