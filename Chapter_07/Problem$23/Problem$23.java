package chapter_seven;

/**
 * **7.23 (Game: locker puzzle) A school has 100 lockers and 100 students. All lockers are
 * closed on the first day of school. As the students enter, the first student, denoted
 * as S1, opens every locker. Then the second student, S2, begins with the second
 * locker, denoted as L2, and closes every other locker. Student S3 begins with the
 * third locker and changes every third locker (closes it if it was open and opens it if
 * it was closed). Student S4 begins with locker L4 and changes every fourth locker.
 * Student S5 starts with L5 and changes every fifth locker, and so on, until student
 * S100 changes L100.
 * After all the students have passed through the building and changed the lockers,
 * which lockers are open? Write a program to find your answer and display all open
 * locker numbers separated by exactly one space.
 * (Hint: Use an array of 100 Boolean elements, each of which indicates whether a
 * locker is open (true) or closed (false). Initially, all lockers are closed.)
 *
 * @author Sharaf Qeshta
 * */


public class Problem$23
{
    public static void main(String[] args)
    {
        boolean[] lockers = new boolean[100]; // all closed

        for (int i = 0; i < 100; i++)
        {
            for (int j = i; j < 100; j++)
                lockers[j] = !lockers[j];  // change the status
        }


        for (int i = 0; i < 100; i++)
        {
            if(lockers[i])
                System.out.print("L" + (i+1) + " ");
        }
    }
}
