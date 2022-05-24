package chapter_eight;

/**
 * *8.3 (Sort students on grades) Rewrite Listing 8.2, GradeExam.java, to display students
 * in decreasing order of the number of correct answers.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$03
{
    public static void main(String[] args)
    {
        char[][] answers =
        {
                {'A', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
                {'D', 'B', 'A', 'B', 'C', 'A', 'E', 'E', 'A', 'D'},
                {'E', 'D', 'D', 'A', 'C', 'B', 'E', 'E', 'A', 'D'},
                {'C', 'B', 'A', 'E', 'D', 'C', 'E', 'E', 'A', 'D'},
                {'A', 'B', 'D', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
                {'B', 'B', 'E', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
                {'B', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
                {'E', 'B', 'E', 'C', 'C', 'D', 'E', 'E', 'A', 'D'}
        };

        int[][] students = new int[8][2];

        char[] keys = {'D', 'B', 'D', 'C', 'C', 'D', 'A', 'E', 'A', 'D'};
        for (int i = 0; i < answers.length; i++)
        {
            int correctCount = 0;
            for (int j = 0; j < answers[i].length; j++)
            {
                if (answers[i][j] == keys[j])
                    correctCount++;
            }
            students[i][0] = i;
            students[i][1] = correctCount;
        }

        bubbleSort(students);

        for (int[] student : students)
            System.out.println("Student " + student[0] + "'s correct count is " + student[1]);
    }

    public static void bubbleSort(int[][] matrix)
    {
        boolean sorted = false;
        while (!sorted)
        {
            sorted = true;
            for (int i = 0; i < matrix.length-1;i++)
            {
                if (matrix[i][1] < matrix[i+1][1])
                {
                    int temp =  matrix[i][1];
                    matrix[i][1] = matrix[i+1][1];
                    matrix[i+1][1] = temp;
                    int temp_ = matrix[i][0];
                    matrix[i][0] = matrix[i+1][0];
                    matrix[i+1][0] = temp_;
                    sorted = false;
                }
            }
        }
    }
}
