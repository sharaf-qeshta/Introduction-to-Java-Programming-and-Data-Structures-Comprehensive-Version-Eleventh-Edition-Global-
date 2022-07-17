package chapter_nineteen;

/**
 * 19.7 (Sum of an association) Knowing that any object of type java.lang.Number can
 * be evaluated as a double with its doubleValue() method, write a method that
 * computes and returns the sum of the three numbers in an instance of Transition
 * as defined in Programming Exercise 19.6.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$07
{
    public static void main(String[] args)
    {
        int x = 1;
        double y = 0;
        long z = 10L;
        Transition<Integer, Double, Long> transition
                = new Transition<>(x, y, z);
        System.out.println(Transition.sum(transition)); // 11.0
    }
}
