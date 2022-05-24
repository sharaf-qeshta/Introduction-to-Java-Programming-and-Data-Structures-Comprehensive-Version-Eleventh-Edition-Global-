package chapter_eight;

/**
 * *8.10 (Largest row and column) Write a program that randomly fills in 0s and 1s into
 * a 5-by-5 matrix, prints the matrix, and finds the first row and column with the
 * most 1s. Here is a sample run of the program:
 *
 *          01101
 *          01011
 *          10010
 *          11111
 *          00101
 *          The largest row index: 3
 *          The largest column index: 4
 *
 * @author Sharaf Qeshta
 * */

public class Problem$10
{
    public static void main(String[] args)
    {
        int[][] matrix = new int[5][5];

        for (int i = 0;i < matrix.length;i++)
        {
            for (int j = 0; j < matrix[i].length; j++)
            {
                int random = (int) ((Math.random() * 10) % 2);
                matrix[i][j] = random;
                System.out.print(random);
            }
            System.out.println();
        }
        System.out.println("The largest row index: " + getLargestRow(matrix));
        System.out.println("The largest column index: " + getLargestColumn(matrix));
    }

    public static int getLargestColumn(int[][] matrix)
    {
        int maxColumn = 0;
        int maxValue = 0;

        for (int i = 0;i < matrix[0].length;i++)
        {
            int total = 0;
            for (int[] ints : matrix)
                total += ints[i];

            if (total > maxValue)
            {
                maxValue = total;
                maxColumn = i;
            }
        }
        return maxColumn;
    }

    public static int getLargestRow(int[][] matrix)
    {
        int maxRow = 0;
        int maxValue = 0;

        for (int i = 0;i < matrix.length;i++)
        {
            int total = 0;
            for (int j = 0; j < matrix[i].length;j++)
                total += matrix[i][j];

            if (total > maxValue)
            {
                maxValue = total;
                maxRow = i;
            }
        }
        return maxRow;
    }

}
