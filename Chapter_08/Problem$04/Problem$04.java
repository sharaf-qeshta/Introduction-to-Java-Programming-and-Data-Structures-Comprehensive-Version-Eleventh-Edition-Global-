package chapter_eight;

/**
 * **8.4 (Compute the weekly hours for each employee) Suppose the weekly hours
 * for all employees are stored in a two-dimensional array. Each row records an
 * employee’s seven-day work hours with seven columns. For example,
 * the following array stores the work hours for eight employees. Write a program that
 * displays employees and their total hours in increasing order of the total hours.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$04
{
    public static void main(String[] args)
    {
        int[][] hours =
        {
                {2, 4, 3, 4, 5, 8, 8},
                {7, 3, 4, 3, 3, 4, 4},
                {3, 3, 4, 3, 3, 2, 2},
                {9, 3, 4, 7, 3, 4, 1},
                {3, 5, 4, 3, 6, 3, 8},
                {3, 4, 4, 6, 3, 4, 4},
                {3, 7, 4, 8, 3, 8, 4},
                {6, 3, 5, 9, 2, 7, 9},
        };


        int[][] employee = new int[8][2];
        for (int i = 0; i < hours.length; i++)
        {
            int total = 0;
            for (int j = 0; j < hours[i].length; j++)
                total += hours[i][j];
            employee[i][0] = i;
            employee[i][1] = total;
        }

        bubbleSort(employee);

        for (int[] ints : employee)
            System.out.println("Student " + ints[0] + "'s correct count is " + ints[1]);
    }

    public static void bubbleSort(int[][] matrix)
    {
        boolean sorted = false;
        while (!sorted)
        {
            sorted = true;
            for (int i = 0; i < matrix.length-1;i++)
            {
                if (matrix[i][1] < matrix[i+1][1])
                {
                    int temp =  matrix[i][1];
                    matrix[i][1] = matrix[i+1][1];
                    matrix[i+1][1] = temp;
                    int temp_ = matrix[i][0];
                    matrix[i][0] = matrix[i+1][0];
                    matrix[i+1][0] = temp_;
                    sorted = false;
                }
            }
        }
    }
}
