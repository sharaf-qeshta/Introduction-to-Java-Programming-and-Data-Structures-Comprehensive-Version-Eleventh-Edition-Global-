package chapter_seven;

/**
 * ***7.36 (Game: Eight Queens) The classic Eight Queens puzzle is to place eight queens
 * on a chessboard such that no two queens can attack each other (i.e., no two queens
 * are on the same row, same column, or same diagonal). There are many possible
 * solutions. Write a program that displays one such solution. A sample output is
 * shown below:
 *
 * @author Sharaf Qeshta
 * */

public class Problem$36
{
    public static void main(String[] args)
    {
        boolean[] matrix = new boolean[64];

        int progress = 0;

        for (int i = 0; i < matrix.length;i++)
        {
            if (checkColumn(i, matrix) &
                    checkRow(i, matrix) &
                    checkDiagonal(i, matrix)){
                progress++;
                matrix[i] = true;
                if (progress == 8)
                    break;
            }
        }

        for (int i = 0; i < matrix.length;i++)
        {
            if (matrix[i])
                System.out.print("|Q");
            else
                System.out.print("| ");

            if ((i+1) % 8 == 0)
                System.out.println();
        }
    }

    public static boolean checkDiagonal(int index, boolean[] matrix)
    {
        int increase = index, decrease = index;

        while (increase < 64)
        {
            if (index % 8 == 7)
                break;
            if (matrix[increase])
                return false;
            increase += 9;
        }

        while (decrease > -1)
        {
            if (index % 8 == 0)
                break;
            if (matrix[decrease])
                return false;
            decrease -= 9;
        }
        return true;
    }

    public static boolean checkRow(int index, boolean[] matrix)
    {
        int increase = index, decrease = index;
        while (increase % 8 != 0)
        {
            if (matrix[increase])
                return false;
            increase += 1;
        }

        while (decrease % 8 != 0)
        {
            decrease -= 1;
            if (matrix[decrease])
                return false;
        }
        return true;
    }


    public static boolean checkColumn(int index, boolean[] matrix)
    {
        int increase = index, decrease = index;

        while (increase < 64)
        {
            if (matrix[increase])
                return false;
            increase += 8;
        }

        while (decrease > -1)
        {
            if (matrix[decrease])
                return false;
            decrease -= 8;
        }
        return true;
    }
}
