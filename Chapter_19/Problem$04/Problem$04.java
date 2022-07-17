package chapter_nineteen;

/**
 * 19.4 (Using wildcards) Write a generic static method that returns the smallest value in an
 * instance of Pair from Programming Exercise 19.3.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$04
{
    public static void main(String[] args)
    {
        Pair<Integer> pair = new Pair<>(20, 15);
        System.out.println(Pair.getSmallest(pair)); // 15
    }
}
