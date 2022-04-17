package chapter_one;

/** (Approximate p) p can be computed using the following formula:
 * p = 4 * (1 - (1/3) + (1/5) + (1/9) - (1/11) .. )
 * Write a program that displays the result of 4 * (1 - (1/3) + (1/5) + (1/9) - (1/11))
 * and 4 * (1 - (1/3) + (1/5) + (1/9) - (1/11) + (1/13)
 * Use 1.0 instead of 1 in your
 * program.
 *
 * @author Sharaf Qeshta */

public class Problem$07
{
    public static void main(String[] args)
    {
        System.out.println(4.0 * (1.0 - (1.0 / 3.0) + (1.0 / 5.0)
                - (1.0 / 7.0) + (1.0 / 9.0) + (1.0 / 11.0)));

        System.out.println(4.0 * (1.0 - (1.0 / 3.0) + (1.0 / 5.0)
                - (1.0 / 7.0) + (1.0 / 9.0) + (1.0 / 11.0) + (1.0 / 13.0)));
    }
}
