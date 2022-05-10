package chapter_five;

/**
 * *5.18 (Display four patterns using loops) Use nested loops that display the following
 * patterns in four separate programs:
 *
 *
 *  Pattern A       Pattern B       Pattern C       Pattern D
 *  *               * * * * * *             *       * * * * * *
 *  * *             * * * * *             * *         * * * * *
 *  * * *           * * * *             * * *           * * * *
 *  * * * *         * * *              * * * *            * * *
 *  * * * * *       * *              * * * * *              * *
 *  * * * * * *     *              * * * * * *                *
 *
 * @author Sharaf Qeshta
 * */

public class Problem$18
{
    public static void main(String[] args)
    {
        patternA();
        patternB();
        patternC();
        patternD();
    }

    public static void patternA()
    {
        System.out.println("Pattern A");

        for (int i = 0; i < 6; i++)
        {
            for (int j =0;j < i+1;j++)
                System.out.print("* ");
            System.out.println();
        }
    }

    public static void patternB()
    {
        System.out.println("Pattern B");

        for (int i = 6; i > 0; i--)
        {
            for (int j = 0;j < i;j++)
                System.out.print("* ");
            System.out.println();
        }
    }

    public static void patternC()
    {
        System.out.println("Pattern C");

        for (int i = 6; i > 0; i--)
        {
            for (int j =0;j < i-1;j++)
                System.out.print("  ");

            for (int k = 0; k < 7-i;k++)
                System.out.print("* ");

            System.out.println();
        }
    }

    public static void patternD()
    {
        System.out.println("Pattern D");

        for (int i = 6; i > 0; i--)
        {
            for (int j =0;j < 6-i;j++)
                System.out.print("  ");

            for (int k = 0; k < i;k++)
                System.out.print("* ");

            System.out.println();
        }
    }
}
