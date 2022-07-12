package chapter_eighteen;


/**
 * *18.24 Chess is played on a board with 64 squares arranged in a 8 * 8grid. The knight,
 * a piece in this game, can move only in an L-shaped pattern, that is, two squares
 * sideways and then one up or two squares up and one sideways. Can a knight access
 * every square of the chessboard from any other square using this pattern? Write a
 * recursive program that is able to show this.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$24
{
    public static void main(String[] args)
    {
        // using the pattern mentioned in the question you cannot access all squares
        boolean[] board = new boolean[64];
        board[63] = true;
        access(board, 63);
    }


    public static void access(boolean[] board, int currentIndex)
    {
        if (accessedAll(board))
            System.out.println("you can access all the squares using " +
                    "\ntwo squares sideways and then one up or two squares up and one sideways");
        else
        {
            // two left and one up
            int index = currentIndex - 2 - 8;
            if (validIndex(currentIndex - 2)
                 && validIndex(index))
            {
                boolean[] board_ = board.clone();
                board_[index] = true;
                access(board_, index);
            }
            // two right and one up
            index = currentIndex + 2 - 8;
            if (validIndex(currentIndex + 2)
                && validIndex(index))
            {
                boolean[] board_ = board.clone();
                board_[index] = true;
                access(board_, index);
            }
            // two up and one left
            index = currentIndex - 16 - 1;
            if (validIndex(currentIndex - 16)
                && validIndex(index))
            {
                boolean[] board_ = board.clone();
                board_[index] = true;
                access(board_, index);
            }
            // two up and one right
            index = currentIndex - 16 + 1;
            if (validIndex(currentIndex - 16)
                && validIndex(index))
            {
                boolean[] board_ = board.clone();
                board_[index] = true;
                access(board_, index);
            }
        }
    }

    private static boolean accessedAll(boolean[] board)
    {
        for (boolean x : board)
            if (!x)
                return false;
        return true;
    }

    private static boolean validIndex(int index)
    {
        return index > -1 && index < 64;
    }
}
