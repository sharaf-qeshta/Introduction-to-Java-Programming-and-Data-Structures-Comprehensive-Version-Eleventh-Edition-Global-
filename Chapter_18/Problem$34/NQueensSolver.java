package chapter_eighteen;

import java.util.ArrayList;

public class NQueensSolver
{
    private static final ArrayList<int[]> solutions = new ArrayList<>();

    public static ArrayList<int[]> solve(int numberOfQueens)
    {
        solutions.clear();
        nQueens(numberOfQueens);
        return solutions;
    }

    private static void nQueens(int numberOfQueens)
    {
        int [] board = new int[numberOfQueens];
        placeQueen(board, 0, numberOfQueens);
    }

    private static void placeQueen(int[] board, int current, int numberOfQueens)
    {
        if (current == numberOfQueens)
        {
            solutions.add(clone(board));
            return;
        }

        for (int i = 0; i < numberOfQueens; i++)
        {
            board[current] = i;
            if (valid(board, current))
                placeQueen(board, current + 1, numberOfQueens);
        }
    }

    private static boolean valid(int[] board, int currentColumnOfQueen)
    {
        for (int i = 0; i < currentColumnOfQueen; i++)
        {
            // same row
            if (board[i] == board[currentColumnOfQueen])
                return false;

            // Diagonal
            if ((currentColumnOfQueen - i)
                    == Math.abs(board[currentColumnOfQueen] - board[i]))
                return false;
        }
        return true;
    }

    private static int[] clone(int[] board)
    {
        int[] out = new int[board.length];
        System.arraycopy(board, 0, out, 0, board.length);
        return out;
    }
}
