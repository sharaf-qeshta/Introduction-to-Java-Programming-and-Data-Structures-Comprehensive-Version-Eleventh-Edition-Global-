package chapter_thirty_two;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * *32.18 (Parallel Eight Queens) Revise Listing 22.11, EightQueens.java, to develop a
 * parallel algorithm that finds all solutions for the Eight Queens problem. (Hint:
 * Launch eight subtasks, each of which places the queen in a different column in the
 * first row.)
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$18
{
    public static final ArrayList<Integer[]> SOLUTIONS = new ArrayList<>();

    public static void main(String[] args)
    {
        parallelSearch();
        SOLUTIONS.forEach(e -> System.out.println(Arrays.toString(e)));
        System.out.println(SOLUTIONS.size()); // 92
    }

    private static void parallelSearch()
    {
        SOLUTIONS.clear();
        Integer[] queens = {-1, -1, -1, -1, -1, -1, -1, -1};
        SearchRow searchRow = new SearchRow(0, queens);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(searchRow);
    }

    private static class SearchRow extends RecursiveAction
    {
        int k;
        Integer[] queens;

        public SearchRow(int k, Integer[] queens)
        {
            this.k = k;
            this.queens = queens;
        }

        @Override
        protected void compute()
        {
            if (k == 8)
            {
                boolean valid = true;
                for (int i = 0; i < 8; i++)
                {
                    if (!isValid(i, queens[i]))
                    {
                        valid = false;
                        break;
                    }
                }

                if (valid)
                    SOLUTIONS.add(queens);
            }
            else
            {
                SearchRow[] actions = new SearchRow[8];
                for (int i = 0; i < 8; i++)
                {
                    Integer[] clonedQueens = queens.clone();
                    clonedQueens[k] = i;
                    actions[i] = new SearchRow(k+1, clonedQueens);
                }
                invokeAll(actions);
            }
        }

        public boolean isValid(int row, int column)
        {
            for (int i = 1; i <= row; i++)
                if (queens[row - i] == column
                        || queens[row - i] == column - i
                        || queens[row - i] == column + i)
                    return false;
            return true;
        }
    }
}
