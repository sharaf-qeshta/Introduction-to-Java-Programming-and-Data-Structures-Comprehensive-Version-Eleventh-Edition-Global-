package chapter_one;

/**
 * * 1.11 (Population projection) The U.S. Census Bureau projects population based on the
 * following assumptions:
 * ■■ One birth every 7 seconds
 * ■■ One death every 13 seconds
 * ■■ One new immigrant every 45 seconds
 * Write a program to display the population for each of the next five years. Assume that
 * the current population is 312,032,486, and one year has 365 days. Hint: In Java, if
 * two integers perform division, the result is an integer. The fractional part is truncated.
 * For example, 5 / 4 is 1 (not 1.25) and 10 / 4 is 2 (not 2.5). To get an accurate result
 * with the fractional part, one of the values involved in the division must be a number
 * with a decimal point. For example, 5.0 / 4 is 1.25 and 10 / 4.0 is 2.5.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$11
{
    public static void main(String[] args)
    {
        // One birth every 7 seconds
        // One death every 13 seconds
        // One new immigrant every 45 seconds
        // U.S. current population is 312,032,486
        // what will be the population after five years?

        int secInYear = 365 * 24 * 60 * 60;
        int births = (secInYear / 7) * 5;
        int deaths = (secInYear / 13) * 5;
        int immigrant = (secInYear / 45) * 5;
        int USPop = (births + immigrant + 312032486) - deaths;
        System.out.println(USPop);
    }
}
