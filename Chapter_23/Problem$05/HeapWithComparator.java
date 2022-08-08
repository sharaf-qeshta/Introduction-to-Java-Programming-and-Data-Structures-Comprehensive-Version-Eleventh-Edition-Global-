package chapter_twenty_three;

import java.util.ArrayList;
import java.util.Comparator;


public class HeapWithComparator<E>
{
    private final ArrayList<E> list = new ArrayList<>();
    private final Comparator<? super E> comparator; // For comparing elements

    public HeapWithComparator()
    {
        // Implement no−arg constructor by creating a comparator for natural order
        comparator = (Comparator<E>) (o1, o2) -> o1.hashCode() - o2.hashCode();
    }

    public HeapWithComparator(Comparator<? super E> comparator)
    {
        this.comparator = comparator;
    }

    // Implement all add, remove, and getSize method

    /**
     * Add a new object into the heap
     */
    public void add(E newObject)
    {
        list.add(newObject);
        int currentIndex = list.size() - 1;

        while (currentIndex > 0)
        {
            int parentIndex = (currentIndex - 1) / 2;
            if (comparator.compare(list.get(currentIndex), list.get(parentIndex)) > 0)
            {
                E temp = list.get(currentIndex);
                list.set(currentIndex, list.get(parentIndex));
                list.set(parentIndex, temp);
            }
            else
                break;
            currentIndex = parentIndex;
        }
    }

    /**
     * Remove the root from the heap
     */
    public E remove()
    {
        if (list.size() == 0) return null;

        E removedObject = list.get(0);
        list.set(0, list.get(list.size() - 1));
        list.remove(list.size() - 1);

        int currentIndex = 0;
        while (currentIndex < list.size())
        {
            int leftChildIndex = 2 * currentIndex + 1;
            int rightChildIndex = 2 * currentIndex + 2;

            if (leftChildIndex >= list.size())
                break;

            int maxIndex = leftChildIndex;
            if (rightChildIndex < list.size())
            {
                if (comparator.compare(list.get(maxIndex), list.get(rightChildIndex)) < 0)
                {
                    maxIndex = rightChildIndex;
                }
            }

            if (comparator.compare(list.get(currentIndex), list.get(maxIndex)) < 0)
            {
                E temp = list.get(maxIndex);
                list.set(maxIndex, list.get(currentIndex));
                list.set(currentIndex, temp);
                currentIndex = maxIndex;
            }
            else
                break;
        }

        return removedObject;
    }

    /**
     * Get the number of nodes in the tree
     */
    public int getSize()
    {
        return list.size();
    }
}
