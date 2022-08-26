package chapter_twenty_four;


/**
 * **24.16 (Test MyLinkedList) Design and write a complete test program to test if the
 * MyLinkedList class in Listing 24.5 meets all requirements.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$16
{
    public static void main(String[] args) throws Exception
    {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        // test addFirst(E e)
        for (int i = 0; i < 1_000; i++)
            list.addFirst(i);
        if (list.get(0) == 999)
            System.out.println("pass addFirst(E e)");
        else
            throw new Exception("Error in addFirst(E e)");

        // test getFirst()
        if (list.getFirst() == 999)
            System.out.println("pass getFirst()");
        else
            throw new Exception("Error in getFirst()");

        // test addLast(E e)
        list.clear();
        for (int i = 0; i < 1_000; i++)
            list.addLast(i);
        if (list.get(999) == 999)
            System.out.println("pass addLast(E e)");
        else
            throw new Exception("Error in addLast(E e)");

        // test getLast()
        if (list.getLast() == 999)
            System.out.println("pass getLast()");
        else
            throw new Exception("Error in getLast()");


        // test add(int index, E e)
        list.clear();
        for (int i = 0; i < 1_000; i++)
            list.add(i, i);
        if (list.getFirst() == 0 && list.getLast() == 999)
            System.out.println("pass add(int index, E e)");
        else
            throw new Exception("Error in add(int index, E e)");


        // test removeFirst()
        for (int i = 0; i < 1_000; i++)
            if (list.removeFirst() != i)
                throw new Exception("Error in removeFirst()");
        System.out.println("pass removeFirst()");

        // test removeLast()
        for (int i = 0; i < 1_000; i++)
            list.addFirst(i);

        for (int i = 0; i < 1_000; i++)
            if (list.removeLast() != i)
                throw new Exception("Error in removeLast()");
        System.out.println("pass removeLast()");


        // test remove(int index)
        for (int i = 0; i < 1_000; i++)
            list.add(i, i);
        for (int i = 0; i < 1_000; i++)
            if (list.remove(0) != i)
                throw new Exception("Error in remove(int index)");
        System.out.println("pass remove(int index)");


        // test clear()
        for (int i = 0; i < 1_000; i++)
            list.addFirst(i);
        list.clear();
        if (list.size() == 0)
            System.out.println("pass clear()");
        else
            throw new Exception("Error in clear()");


        // test contains(Object e)
        for (int i = 0; i < 1_000; i++)
            list.add(i, i);
        for (int i = 0; i < 1_000; i++)
            if (!list.contains(i))
                throw new Exception("Error in contains(Object e)");
        System.out.println("pass contains(Object e)");


        // test get(int index)
        for (int i = 0; i < 1_000; i++)
            if (list.get(i) != i)
                throw new Exception("Error in get(int index)");
        System.out.println("pass get(int index)");


        // test indexOf(Object e)
        for (int i = 0; i < 1_000; i++)
            if (list.indexOf(i) != i)
                throw new Exception("Error in indexOf(Object e)");
        System.out.println("pass indexOf(Object e)");


        // test lastIndexOf(E e)
        for (int i = 0; i < 1_000; i++)
            if (list.lastIndexOf(i) != i)
                throw new Exception("Error in lastIndexOf(E e)");
        System.out.println("pass lastIndexOf(E e)");


        // test set(int index, E e)
        for (int i = 0; i < 1_000; i++)
        {
            list.set(i, i);
            if (list.get(i) != i)
                throw new Exception("Error in set(int index, E e)");
        }
        System.out.println("pass set(int index, E e)");


        // test size()
        if (list.size() == 1000)
            System.out.println("pass size()");
        else
            throw new Exception("Error in size()");

    }
}
