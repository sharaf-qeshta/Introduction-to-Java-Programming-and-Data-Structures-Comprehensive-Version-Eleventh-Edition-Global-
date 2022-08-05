package chapter_twenty_two;

/**
 * ***22.22 (Game: recursive Sudoku) Write a recursive solution for the Sudoku problem.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$22
{
    public static void main(String[] args)
    {
        int[][] grid1 =
        {
                { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 }
        };

        /*
        * 3 1 6 5 7 8 4 9 2
        * 5 2 9 1 3 4 7 6 8
        * 4 8 7 6 2 9 5 3 1
        * 2 6 3 4 1 5 9 8 7
        * 9 7 4 8 6 3 1 2 5
        * 8 5 1 7 9 2 6 4 3
        * 1 3 8 9 4 7 2 5 6
        * 6 9 2 3 5 1 8 7 4
        * 7 4 5 2 8 6 3 1 9
        * */
        if (solve(grid1, 0, 0))
            print(grid1);
        else
            System.out.println("No Solution");


        int[][] grid2 =
                {
                        {1, 0, 4, 0, 0, 9, 7, 0, 8},
                        {0, 2, 0, 3, 0, 0, 6, 0, 0},
                        {6, 0, 3, 0, 0, 0, 0, 0, 1},
                        {2, 0, 5, 0, 0, 0, 0, 0, 0},
                        {2, 0, 0, 0, 0, 0, 3, 0, 0},
                        {0, 0, 0, 9, 0, 1, 0, 0, 0},
                        {3, 0, 0, 0, 5, 0, 0, 0, 9},
                        {0, 0, 0, 9, 0, 1, 0, 0, 0},
                        {0, 4, 0, 0, 0, 0, 0, 7, 0}
                };

        /*
        * No Solution
         */
        if (solve(grid2, 0, 0))
            print(grid2);
        else
            System.out.println("No Solution");
    }

    static boolean solve(int[][] grid, int row,
                               int column)
    {
        if (row == 8 && column == 9)
            return true;

        if (column == 9)
        {
            row++;
            column = 0;
        }

        if (grid[row][column] != 0)
            return solve(grid, row, column + 1);

        for (int num = 1; num < 10; num++)
        {
            if (isValid(grid, row, column, num))
            {
                grid[row][column] = num;
                if (solve(grid, row, column + 1))
                    return true;
            }
            grid[row][column] = 0;
        }
        return false;
    }


    static boolean isValid(int[][] grid, int row, int column,
                          int value)
    {
        for (int x = 0; x <= 8; x++)
            if (grid[row][x] == value)
                return false;


        for (int x = 0; x <= 8; x++)
            if (grid[x][column] == value)
                return false;


        int startRow = row - row % 3;
        int startCol = column - column % 3;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (grid[i + startRow][j + startCol] == value)
                    return false;

        return true;
    }


    static void print(int[][] grid)
    {
        for (int[] ints : grid)
        {
            for (int anInt : ints)
                System.out.print(anInt + " ");
            System.out.println();
        }
    }
}
