package chapter_eight;


/**
 * *8.22 (Even number of 1s) Write a program that generates a 6-by-6 two-dimensional
 * matrix filled with 0s and 1s, displays the matrix, and checks if every row and
 * every column have an even number of 1s
 *
 * @author Sharaf Qeshta
 * */


public class Problem$22
{
    public static void main(String[] args)
    {
        int[][] matrix = new int[6][6];
        generate01Matrix(matrix);

        // display matrix
        for (int[] row : matrix)
        {
            for (int element : row)
                System.out.print(element + " ");
            System.out.println();
        }

        System.out.println(checkRowsEven1s(matrix) & checkColumnsEven1s(matrix));
    }

    public static void generate01Matrix(int[][] matrix)
    {
        for (int[] row: matrix)
        {
            for (int i = 0; i < row.length;i++)
            {
                int random = (int) ((Math.random() * 10) % 2);
                row[i] = random;
            }
        }
    }

    public static boolean checkRowsEven1s(int[][] matrix)
    {
        for (int[] row: matrix)
        {
            int numberOf1s = 0;
            for (int element : row)
                if (element == 1)
                    numberOf1s++;

            if (numberOf1s % 2 == 1)
                return false;
        }
        return true;
    }


    public static boolean checkColumnsEven1s(int[][] matrix)
    {

        for (int i = 0; i < matrix[0].length;i++)
        {
            int numberOf1s = 0;
            for (int[] row : matrix)
                if (row[i] == 1)
                    numberOf1s++;

            if (numberOf1s % 2 == 1)
                return false;
        }
        return true;
    }
}
