package chapter_nineteen;

/**
 * 19.5 (Inheritance between generic classes) Create a Triplet class that encapsulates
 * three objects of the same data type in a given instance of Triplet
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$05
{
    public static void main(String[] args)
    {
        Triplet<Integer> triplet = new Triplet<>(10, 11, 12);
        System.out.println(triplet.getO1()); // 10
        System.out.println(triplet.getO2()); // 11
        System.out.println(triplet.getO3()); // 12
    }
}
