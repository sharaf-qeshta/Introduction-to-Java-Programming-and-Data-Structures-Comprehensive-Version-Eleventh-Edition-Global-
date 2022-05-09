package chapter_five;

/**
 * **5.7 (Financial application: compute future tuition) Suppose that the tuition for a
 * university is $10,000 this year and increases 6% every year. In one year, the tuition
 * will be $10,600. Write a program that computes the tuition in ten years and the total
 * cost of four years’ worth of tuition after the tenth year.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$07
{
    public static void main(String[] args)
    {
        double tuition = 10000;
        double increaseRate = 1.06; // 106%

        double tenthYear = 0;
        double fourYearsAfterTenthYear;
        double total = 0;

        double tempTotal = 0;

        for (int i = 1; i < 15;i++)
        {
            tuition = tuition * increaseRate;

            if (i == 10)
                tenthYear = tuition;
            if (i > 10)
                tempTotal += tuition;
            if (i < 11)
                total += tuition;
        }

        fourYearsAfterTenthYear =  tempTotal / 4.0;

        System.out.println("the total after 10 years is : " + total);
        System.out.println("in the tenth year the tuition will be : " + tenthYear);
        System.out.println("after 4 years after the tenth year : " + fourYearsAfterTenthYear);
    }
}
