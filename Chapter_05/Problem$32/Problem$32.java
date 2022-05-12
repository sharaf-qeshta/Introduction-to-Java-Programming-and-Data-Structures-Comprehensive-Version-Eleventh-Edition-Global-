package chapter_five;

import java.util.Locale;
import java.util.Scanner;

/**
 * **5.32 (Game: lottery) Revise Listing 3.8, Lottery.java, to generate a lottery of a two-digit
 * number. The two digits in the number are distinct. (Hint: Generate the first digit.
 * Use a loop to continuously generate the second digit until it is different from the
 * first digit.)
 *
 * @author Sharaf Qeshta
 * */

public class Problem$32
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        int lotteryNumber1 = (int) (Math.random() * 10);
        int lotteryNumber2 = (int) (Math.random() * 10);

        while (lotteryNumber1 == lotteryNumber2)
            lotteryNumber2 = (int) (Math.random() * 10);

        System.out.print("enter your luck number: ");
        int number = scanner.nextInt();

        if (number == Integer.parseInt(lotteryNumber1 + "" + lotteryNumber2))
            System.out.println("You win!!! " + number);
        else
            System.out.println(":(");
    }
}

