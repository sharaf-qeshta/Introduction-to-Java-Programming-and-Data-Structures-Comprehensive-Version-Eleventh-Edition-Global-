package chapter_eight;

import java.util.Locale;
import java.util.Scanner;

/**
 * ***8.20 (Game: connect four) Connect four is a two-player board game in which the
 * players alternately drop colored disks into a seven-column, six-row vertically
 * suspended grid, as shown below.
 * The objective of the game is to connect four same-colored disks in a row, a
 * column, or a diagonal before your opponent can do likewise. The program prompts
 * two players to drop a red or yellow disk alternately. In the preceding figure, the
 * red disk is shown in a dark color and the yellow in a light color. Whenever a disk
 * is dropped, the program redisplays the board on the console and determines the
 * status of the game (win, draw, or continue). Here is a sample run:
 *
 *                  | | | | | | | |
 *                  | | | | | | | |
 *                  | | | | | | | |
 *                  | | | | | | | |
 *                  | | | | | | | |
 *                  | | | | | | | |
 *
 *                  Drop a red disk at column (0–6): 0
 *                  | | | | | | | |
 *                  | | | | | | | |
 *                  | | | | | | | |
 *                  | | | | | | | |
 *                  | | | | | | | |
 *                  |R| | | | | | |
 *
 *                  Drop a yellow disk at column (0–6): 3
 *                  | | | | | | | |
 *                  | | | | | | | |
 *                  | | | | | | | |
 *                  | | | | | | | |
 *                  | | | | | | | |
 *                  |R| | |Y| | | |
 *
 *                  . . .
 *                  . . .
 *                  . . .
 *
 *                  Drop a yellow disk at column (0–6): 6
 *                  | | | | | | | |
 *                  | | | | | | | |
 *                  | | | |R| | | |
 *                  | | | |Y|R|Y| |
 *                  | | |R|Y|Y|Y|Y|
 *                  |R|Y|R|Y|R|R|R|
 *
 *                  The yellow player won
 *
 * @author Sharaf Qeshta
 * */


public class Problem$20
{
    public static int[] dropIndex = new int[7];

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        char[][] board = new char[6][7];

        setDefault();
        String player;
        int turn = 1;
        char symbol;
        while(true)
        {
            display(board);

            if (turn == 1)
            {
                player = "red";
                turn = 2;
                symbol = 'R';
            }
            else
            {
                player = "yellow";
                turn = 1;
                symbol = 'Y';
            }

            System.out.print("Drop a " +  player +  " disk at column (0–6): ");
            int column = scanner.nextInt();
            board[dropIndex[column]][column] = symbol;
            dropIndex[column]--;


            int rowsStatus = checkRows(board);
            int columnsStatus = checkColumns(board);
            int diagonalStatus = checkDiagonals(board);
            int winner = 0;

            if (isDraw(board))
            {
                System.out.println("it`s a draw");
                break;
            }

            if ( rowsStatus > 0)
                winner = rowsStatus;
            else if ( columnsStatus > 0 )
                winner = columnsStatus;
            else if ( diagonalStatus > 0 )
                winner = diagonalStatus;

            if (winner == 1)
            {
                display(board);
                System.out.println("The red player won");
                break;
            }
            else if (winner == 2)
            {
                display(board);
                System.out.println("The yellow player won");
                break;
            }
        }
    }

    public static void setDefault()
    {
        for (int i = 0; i < 7;i++)
            dropIndex[i] = 5;
    }

    public static int checkRows(char[][] board)
    {
        for (char[] ints : board)
        {
            int repeated = 0, element = ints[0];
            for (int j = 0; j < board[0].length; j++)
            {
                if (element == ints[j]  & element != 0)
                {
                    if (++repeated == 4)
                    {
                        if (element == 'R')
                            return 1;
                        else if (element == 'Y')
                            return 2;
                    }
                }
                else
                {
                    element = ints[j];
                    repeated = 0;
                }
            }
        }
        return 0;
    }


    public static int checkColumns(char[][] board)
    {
        for (int i = 0; i < board[0].length;i++) {
            int repeated = 1, element = board[0][i];
            for (int j = 0; j < board.length; j++) {
                if (element == board[j][i] & element != 0) {
                    repeated++;
                    if (repeated == 4){
                        if (element == 'R')
                            return 1;
                        else if (element == 'Y')
                            return 2;
                    }
                }else {
                    element = board[j][i];
                    repeated = 1;
                }
            }
        }
        return 0;
    }



    public static int checkDiagonals(char[][] matrix)
    {
        for (int i = 0; i < matrix.length-1;i++)
        {
            int row = i, column = 0, repeated = 1, element = matrix[i][0];
            while (row < matrix.length && column < matrix[i].length)
            {
                if (matrix[row][column] == element & matrix[row][column] != 0){
                    repeated++;
                    if (repeated == 4){
                        if (element == 'R')
                            return 1;
                        else if (element == 'Y')
                            return 2;
                    }
                }
                else {
                    element = matrix[row][column];
                    repeated = 1;
                }
                row++;column++;
            }
        }

        for (int i = 0; i < matrix.length-1;i++)
        {
            int row = i, column = matrix[0].length-1, repeated = 1, element = matrix[i][0];
            while (row < matrix.length && column > -1)
            {
                if (matrix[row][column] == element & matrix[row][column] != 0){
                    repeated++;
                    if (repeated == 4){
                        if (element == 'R')
                            return 1;
                        else if (element == 'Y')
                            return 2;
                    }
                }else {
                    element = matrix[row][column];
                    repeated = 1;
                }
                row++;column--;
            }
        }
        return 0;
    }


    public static void display(char[][] board)
    {
        for (int i = 0; i < board.length;i++){
            for (int j = 0; j< board[i].length;j++)
            {
                if (board[i][j] == 0)
                    System.out.print("| ");
                else
                    System.out.print("|" + board[i][j]);
            }
            System.out.print("|");
            System.out.println();
        }
    }


    public static boolean isDraw(char[][] board)
    {
        for (char[] chars : board)
            for (int j = 0; j < chars.length; j++)
            {
                if (chars[j] == 0)
                    return false;
            }
        return true;
    }
}
