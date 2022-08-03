package chapter_twenty_two;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * ***22.20 (Game: multiple Sudoku solutions) The complete solution for the Sudoku
 * problem is given in Supplement VI.A. A Sudoku problem may have multiple
 * solutions. Modify Sudoku.java in Supplement VI.A to display the total number
 * of solutions. Display two solutions if multiple solutions exist.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$20
{
    public static void main(String[] args)
    {
        int[][] grid = readAPuzzle();
        if (!isValid(grid))
            System.out.println("Invalid input");
        else
        {
            ArrayList<String> result = search(grid);
            if (result.size() != 0)
            {
                System.out.println("\nFound " + result.size() + " solution" + (result.size() == 1? "": "s") + ":\n");
                for (int i = 0; i < 2; i++)
                {
                    System.out.println("Solution " + (i + 1) + ":");
                    System.out.println(result.get(i));
                }
            }
            else
                System.out.println("No solution");
        }
    }


    /** Obtain a list of free cells from the puzzle */
    public static int[][] getFreeCellList(int[][] grid)
    {
        int numberOfFreeCells = 0;
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                if (grid[i][j] == 0)
                    numberOfFreeCells++;

        int[][] freeCellList = new int[numberOfFreeCells][2];
        int count = 0;
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                if (grid[i][j] == 0)
                {
                    freeCellList[count][0] = i;
                    freeCellList[count++][1] = j;
                }
        return freeCellList;
    }


    /** Search for a solution */
    public static ArrayList<String> search(int[][] grid)
    {
        ArrayList<String> result = new ArrayList<>();
        int[][] freeCellList = getFreeCellList(grid);

        if (freeCellList.length == 0)
        {
            result.add(gridToString(grid));
            return result;
        }

        int k = 0;
        while (true)
        {
            int i = freeCellList[k][0];
            int j = freeCellList[k][1];
            if (grid[i][j] == 0)
                grid[i][j] = 1;

            boolean valid = false;
            if (isValid(i, j, grid))
            {
                valid = true;
                if (k + 1 == freeCellList.length)
                {
                    result.add(gridToString(grid));
                    valid = false;
                }
                else
                    k++;
            }
            if (!valid)
            {
                if (grid[i][j] >= 9)
                {
                    while (grid[i][j] == 9)
                    {
                        if (k == 0)
                            return result;

                        grid[i][j] = 0;
                        k--;
                        i = freeCellList[k][0];
                        j = freeCellList[k][1];
                    }
                }
                grid[i][j] = grid[i][j] + 1;
            }
        }
    }

    /** Check whether grid[i][j] is valid in the grid */
    public static boolean isValid(int i, int j, int[][] grid)
    {
        for (int column = 0; column < 9; column++)
            if (column != j && grid[i][column] == grid[i][j])
                return false;

        for (int row = 0; row < 9; row++)
            if (row != i && grid[row][j] == grid[i][j])
                return false;

        for (int row = (i / 3) * 3; row < (i / 3) * 3 + 3; row++)
            for (int col = (j / 3) * 3; col < (j / 3) * 3 + 3; col++)
                if (row != i && col != j && grid[row][col] == grid[i][j])
                    return false;

        return true;
    }


    /** Print the values in the grid */
    public static String gridToString(int[][] grid)
    {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                result.append(grid[i][j]).append(" ");
            }
            result.append('\n');
        }
        return result.toString();
    }

    /** Read a Sudoku puzzle from the keyboard */
    public static int[][] readAPuzzle()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a Sudoku puzzle:");
        int[][] grid = new int[9][9];
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                grid[i][j] = input.nextInt();
        return grid;
    }


    public static boolean isValid(int[][] grid)
    {
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                if (grid[i][j] < 0 || grid[i][j] > 9
                        || (grid[i][j] != 0 && !isValid(i, j, grid)))
                    return false;
        return true;
    }
}
