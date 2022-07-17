package chapter_nineteen;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 19.8 (Shuffle ArrayList) Write the following method that shuffles an ArrayList:
 * public static <E> void shuffle(ArrayList<E> list)
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$08
{
    public static void main(String[] args)
    {
        ArrayList<String> strings = new ArrayList<>
                (
                        Arrays.asList("London", "Liverpool", "Manchester", "Bristol"
                                , "Birmingham", "Glasgow", "Plymouth")
                );

        /* [London, Liverpool, Manchester, Bristol, Birmingham, Glasgow, Plymouth] */
        System.out.println(strings);

        shuffle(strings);
        /* [Bristol, Plymouth, Manchester, Glasgow, Liverpool, Birmingham, London] */
        System.out.println(strings);

        shuffle(strings);
        /* [Liverpool, Bristol, Manchester, London, Glasgow, Plymouth, Birmingham] */
        System.out.println(strings);
    }

    public static <E> void shuffle(ArrayList<E> list)
    {
        for (int i = 0; i < list.size(); i++)
        {
            int index1 = (int) ((Math.random() * list.size() * 2) % list.size());
            E temp = list.get(index1);
            list.set(index1, list.get(i));
            list.set(i, temp);
        }
    }
}
