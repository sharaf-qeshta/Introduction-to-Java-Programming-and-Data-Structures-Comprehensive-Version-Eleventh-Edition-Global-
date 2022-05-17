package chapter_seven;


/**
 * *7.7 (Count single digits) Write a program that generates 200 random integers between
 * 0 and 9 and displays the count for each number. (Hint: Use an array of ten integers,
 * say counts, to store the counts for the number of 0s, 1s, . . . , 9s.)
 *
 * @author Sharaf Qeshta
 * */

public class Problem$07
{
    public static void main(String[] args)
    {
        int[] occurrence = generateNumbers(200);

        for (int i = 0; i < occurrence.length; i++)
            System.out.println(i + " occurs " + occurrence[i] + " time"
                    + ((occurrence[i] > 1)? "s" : "") );
    }

    public static int[] generateNumbers(int n)
    {
        int[] occurrence = new int[10];

        for (int i = 0; i < n; i++)
            occurrence[(int) ((Math.random() * 10) % 10)] += 1;

        return occurrence;
    }
}
