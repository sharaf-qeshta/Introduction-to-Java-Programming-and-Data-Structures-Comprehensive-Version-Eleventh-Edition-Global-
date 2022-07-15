package chapter_eighteen;


public class KnightTourSolver
{
    private static final int[] POSSIBLE_X_MOVES = { 2, 1, -1, -2, -2, -1, 1, 2 };
    private static final int[] POSSIBLE_Y_MOVES = { 1, 2, 2, 1, -1, -2, -2, -1 };
    private static int[][] solution;
    private static int count = 0;

    private static boolean valid(int i, int j, int n, int[][] Board)
    {
        return i >= 0 && j >= 0 && i < n && j < n && Board[i][j] == 0;
    }

    private static void solve(int[][] chessBoard, int x, int y, int visited)
    {

        chessBoard[x][y] = visited;

        if (count >= 1)
            return;

        if (visited == chessBoard.length * chessBoard.length)
        {
            if (++count == 1)
                solution = clone(chessBoard);
            chessBoard[x][y] = 0;
            return;
        }

        for (int i = 0; i < 8; i++)
        {
            int newX = x + POSSIBLE_X_MOVES[i];
            int newY = y + POSSIBLE_Y_MOVES[i];

            if (valid(newX, newY, chessBoard.length, chessBoard)
                    && chessBoard[newX][newY] == 0)
                solve(chessBoard.clone(), newX, newY,
                        visited + 1);
        }
        chessBoard[x][y] = 0;
    }


    private static int[][] clone(int[][] board)
    {
        int[][] out = new int[board.length][board.length];
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[i].length; j++)
                out[i][j] = board[i][j];
        return out;
    }

    public static int[][] getSolutions(int rows, int columns,
                                                  int startX, int startY)
    {
        int[][] chessBoard = new int[rows][columns];
        solve(chessBoard, startX, startY, 1);
        return solution;
    }
}
