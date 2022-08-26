package chapter_twenty_four;

import java.util.ArrayList;

public class PriorityUsingSortedArrayList<E extends Comparable<E>>
{
    public ArrayList<E> list = new ArrayList<>();

    public void enqueue(E newObject)
    {
        if (list.size() == 0 || list.get(list.size()-1).compareTo(newObject) < 0)
            list.add(newObject);
        else
        {
            for (int i = 0; i < list.size(); i++)
                if(list.get(i).compareTo(newObject) > 0)
                {
                    list.add(i, newObject);
                    break;
                }
        }
    }

    public E dequeue()
    {
        return list.remove(list.size()-1);
    }

    public int getSize()
    {
        return list.size();
    }
}
