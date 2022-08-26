package chapter_twenty_four;

/**
 * **24.15 (Test MyArrayList) Design and write a complete test program to test if the
 * MyArrayList class in Listing 24.2 meets all requirements.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$15
{
    public static void main(String[] args) throws Exception
    {
        /*
        * pass add(value)
        * pass add(index, value)
        * pass contains(e)
        * true
        * pass size()
        * pass get(index)
        * pass indexOf(e)
        * pass lastIndexOf(e)
        * pass set(index, e)
        * pass remove(index)
        * true
        * pass clear()
        * * */
        MyArrayList<Integer> list1 = new MyArrayList<>();
        // test add(value)
        for (int i = 0; i < 1_000; i++)
            list1.add(i);
        System.out.println("pass add(value)");

        list1.clear();

        // test add(index, value)
        for (int i = 0; i < 1_000; i++)
            list1.add(i, i);
        System.out.println("pass add(index, value)");

        // test contains(e)
        for (int i = 0; i < 1_000; i++)
            if (!list1.contains(i))
                throw new Exception("Error at " + i);
        System.out.println("pass contains(e)");

        // test size()
        System.out.println(1_000 == list1.size()); // true
        System.out.println("pass size()");

        // test get(index)
        for (int i = 0; i < 1_000; i++)
            if (list1.get(i) != i)
                throw new Exception("Error at " + i);
        System.out.println("pass get(index)");

        // test indexOf(e)
        for (int i = 0; i < 1_000; i++)
            if (list1.indexOf(i) != i)
                throw new Exception("Error at " + i);
        System.out.println("pass indexOf(e)");

        // test lastIndexOf(e)
        for (int i = 0; i < 1_000; i++)
            if (list1.indexOf(i) != i)
                throw new Exception("Error at " + i);
        System.out.println("pass lastIndexOf(e)");

        // test set(index, e)
        for (int i = 0; i < 1_000; i++)
        {
            list1.set(i, i);
            if (list1.get(i) != i)
                throw new Exception("Error at " + i);
        }
        System.out.println("pass set(index, e)");

        // test remove(index)
        for (int i = 0; i < 1_000; i++)
            if (list1.remove(0) != i)
                throw new Exception("Error at " + i);
        System.out.println("pass remove(index)");

        // test clear()
        list1.clear();
        System.out.println(list1.size() == 0); // true
        System.out.println("pass clear()");
    }
}
