package chapter_eight;

import java.util.Locale;
import java.util.Scanner;

/**
 * ***8.9 (Game: play a tic-tac-toe game) In a game of tic-tac-toe, two players take turns
 * marking an available cell in a 3 * 3 grid with their respective tokens (either X
 * or O). When one player has placed three tokens in a horizontal, vertical, or
 * diagonal row on the grid, the game is over and that player has won. A draw (no winner)
 * occurs when all the cells on the grid have been filled with tokens and neither
 * player has achieved a win. Create a program for playing a tic-tac-toe game.
 * The program prompts two players to alternately enter an X token and O token.
 * Whenever a token is entered, the program redisplays the board on the console and
 * determines the status of the game (win, draw, or continue). Here is a sample run:
 *
 *
 *
 *              | | | |
 *
 *              | | | |
 *
 *              | | | |
 *
 *              Enter a row (0, 1, or 2) for player X: 1
 *              Enter a column (0, 1, or 2) for player X: 1
 *
 *              | | | |
 *
 *              | | X | |
 *
 *              | | | |
 *
 *              Enter a row (0, 1, or 2) for player O: 1
 *              Enter a column (0, 1, or 2) for player O: 2
 *
 *              | | | |
 *
 *              | | X | O |
 *
 *              | | | |
 *
 *              Enter a row (0, 1, or 2) for player X:
 *              . . .
 *
 *              | X | | |
 *
 *              | O | X | O |
 *
 *              | |   | X |
 *
 *              X player won
 *
 *
 * @author Sharaf Qeshta
 * */

public class Problem$09
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        char[][] board = new char[3][3];
        boolean player = true; // for player x '1'
        while(true)
        {
            drawBoard(board);
            char turn;
            if (player)
            {
                turn = 'X';
                player = false;
            }
            else
            {
                turn = 'O';
                player = true;
            }

            System.out.print("Enter a row (0, 1, or 2) for player " + turn + ": ");
            int row = scanner.nextByte();
            System.out.print("Enter a column (0, 1, or 2) for player " + turn + ": ");
            int column = scanner.nextByte();

            if (!insert(row, column, board, turn))
                player = !player;

            int[] status = checkStatus(board);

            if (status[0] == 1)
            {
                System.out.println("its draw");
                drawBoard(board);
                break;
            }
            else if (status[0] == 0)
            {
                String winner;
                if (status[1] == 1)
                    winner = "X";
                else
                    winner = "O";
                drawBoard(board);
                System.out.println( winner + " player won");
                break;
            }
        }
    }

    public static int[] checkStatus(char[][] board)
    {
        int[] out = {-1, 1}; //  -1 no one win 0 there`s a winner 1 draw
        if (checkDraw(board))
            out[0] = 1;

        else if (checkEqual(board[0][0], board[1][0], board[2][0]))
        {
            out[1] = checkInput(board[0][0]);
            out[0] = 0;
        }

        else if (checkEqual(board[0][1], board[1][1], board[2][1]))
        {
            out[1] = checkInput(board[0][1]);
            out[0] = 0;
        }

        else if (checkEqual(board[0][2], board[1][2], board[2][2]))
        {
            out[1] = checkInput(board[0][2]);
            out[0] = 0;
        }

        else if (checkEqual(board[0][0], board[0][1], board[0][2]))
        {
            out[1] = checkInput(board[0][0]);
            out[0] = 0;
        }

        else if (checkEqual(board[1][0], board[1][1], board[1][2]))
        {
            out[1] = checkInput(board[1][0]);
            out[0] = 0;
        }

        else if (checkEqual(board[2][0], board[2][1], board[2][2]))
        {
            out[1] = checkInput(board[2][0]);
            out[0] = 0;
        }

        if (checkEqual(board[0][0], board[1][1], board[2][2]))
        {
            out[1] = checkInput(board[0][0]);
            out[0] = 0;
        }

        if (checkEqual(board[0][2], board[1][1], board[2][0]))
        {
            out[1] = checkInput(board[0][2]);
            out[0] = 0;
        }
        return out;
    }

    public static boolean checkDraw(char[][] board)
    {
        for (char[] row: board)
        {
            for (char element: row)
                if ((int) element == 0) // if it empty
                    return false;
        }
        return true;
    }

    public static boolean checkEqual(int... numbers)
    {
        if (numbers[0] == numbers[1] & numbers[0] != 0)
            return numbers[0] == numbers[2];
        return false;
    }


    public static int checkInput(char x)
    {
        if (x == 'X')
            return 1; // player 1
        return 2; // player 2
    }


    public static void drawBoard(char[][] board)
    {
        System.out.println("----------");
        for (char[] row: board)
        {
            for (char element: row)
            {
                String x = element + "";
                if (element == 0)
                    x = "  ";
                System.out.print("|" + x);

            }
            System.out.print("|");

            System.out.println("\n----------");
        }
    }


    public static boolean insert(int i, int j, char[][] board, char value)
    {
        if (board[i][j] == 0)
        {
            board[i][j] = value;
            return true;
        }
        return false;
    }

}
