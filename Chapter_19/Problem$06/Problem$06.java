package chapter_nineteen;

/**
 * 19.6 (Several types) Create an Association class that encapsulates two objects of different
 * types. Similar to Programming Exercise 19.5, create a Transition class that does the
 * same of Association class with three objects.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$06
{
    public static void main(String[] args)
    {
        Pair<String, Integer> pair = new Pair<>("Java", 1);
        System.out.println(pair.getO1()); // Java
        System.out.println(pair.getO2()); // 1

        Transition<String, Integer, Pair<String, Integer>> transition
                = new Transition<>("Java", 1, pair);
        System.out.println(transition.getO1()); // Java
        System.out.println(transition.getO2()); // 1
        System.out.println(transition.getO3().getO1()); // Java
    }
}
