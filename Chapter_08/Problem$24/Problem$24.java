package chapter_eight;


import java.util.Scanner;

/**
 * *8.24 (Check Sudoku solution) Listing 8.4 checks whether a solution is valid by
 * checking whether every number is valid in the board. Rewrite the program by checking
 * whether every row, every column, and every small box has the numbers 1 to 9.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$24
{
    public static void main(String[] args)
    {
        int[][] grid = readASolution();

        System.out.println(isValid(grid) ? "Valid solution" :
                "Invalid solution");
    }

    private static boolean isValid(int[][] grid)
    {
        return checkBlocks(grid) && checkRow(grid) && checkCol(grid);
    }

    public static int[][] readASolution()
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a Sudoku puzzle solution:");
        int[][] grid = new int[9][9];
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                grid[i][j] = input.nextInt();

        return grid;
    }

    public static boolean checkBlocks(int[][] n)
    {
        for (int i = 0; i < n.length; i+=3)
            for (int j = 0; j < n[i].length; j+=3)
                if (!checkBlock(i,j,n))
                    return false;
        return true;
    }


    public static boolean checkBlock(int row, int col, int[][] n)
    {
        int[] seq = new int[9];
        for (int i = 0; i < seq.length; i++)
            seq[i] = n[i/3][i%3];
        return checkSeq(seq);
    }

    public static boolean checkRow(int[][]  n)
    {
        int[] seq = new int[9];
        for (int[] ints : n)
        {
            System.arraycopy(ints, 0, seq, 0, n.length);
            if (!checkSeq(seq))
                return false;
        }
        return true;
    }
    public static boolean checkCol(int[][] n)
    {
        int[] seq = new int[9];
        for (int i = 0; i < n.length; i++)
        {
            for (int j = 0; j < n.length; j++)
                seq[j] = n[j][i];
            if(!checkSeq(seq))
                return false;
        }
        return true;
    }

    public static boolean checkSeq(int[] n)
    {
        boolean[] tray = new boolean [n.length];
        boolean result =true;

        for (int i = 0; i < tray.length; i++)
            tray[n[i]-1] = true;

        for (boolean b : tray)
            result &= b;

        return result;
    }
}
