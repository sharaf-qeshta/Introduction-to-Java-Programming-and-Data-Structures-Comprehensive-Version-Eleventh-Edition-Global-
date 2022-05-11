package chapter_five;

/**
 * **5.25 (Compute π) You can approximate p by using the following summation:
 *  π = 4 * (1 - 1/3 + 1/5 - 1/7 + 1/9 - 1/11 + ... + [(-1^i+1) / (2i -1)]
 *
 * @author Sharaf Qeshta
 * *  */

public class Problem$25
{
    public static void main(String[] args)
    {
        double pi10000 = 0, pi20000 = 0, pi30000 = 0, pi40000 = 0, pi50000 = 0;
        double pi60000 = 0, pi70000 = 0, pi80000 = 0, pi90000 = 0, pi100000 = 0;

        double total = 0;

        for (int i = 1; i < 100001;i++)
        {
            total += Math.pow(-1, i+1) / ((2.0*i) - 1.0);

            if (i < 50001)
            {
                if (i == 10000)
                    pi10000 = 4 * total;
                else if (i == 20000)
                    pi20000 = 4 * total;
                else if (i == 30000)
                    pi30000 = 4 * total;
                else if (i == 40000)
                    pi40000 = 4 * total;
                else if (i == 50000)
                    pi50000 = 4 * total;
            }
            else
            {
                if (i == 60000)
                    pi60000 = 4 * total;
                else if (i == 70000)
                    pi70000 = 4 * total;
                else if (i == 80000)
                    pi80000 = 4 * total;
                else if (i == 90000)
                    pi90000 = 4 * total;
                else if (i == 100000)
                    pi100000 = 4 * total;
            }
        }

        // larger values of n leads to more accurate π
        System.out.println("pi 10000: " + pi10000);
        System.out.println("pi 20000: " + pi20000);
        System.out.println("pi 30000: " + pi30000);
        System.out.println("pi 40000: " + pi40000);
        System.out.println("pi 50000: " + pi50000);
        System.out.println("pi 60000: " + pi60000);
        System.out.println("pi 70000: " + pi70000);
        System.out.println("pi 80000: " + pi80000);
        System.out.println("pi 90000: " + pi90000);
        System.out.println("pi 100000: " + pi100000);
    }
}

