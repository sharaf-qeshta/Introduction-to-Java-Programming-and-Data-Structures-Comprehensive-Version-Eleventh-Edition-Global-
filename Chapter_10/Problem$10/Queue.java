package chapter_ten;

public class Queue
{
    private int size = 8;
    private int[] elements = new int[size];
    private int nextIndex = 0;


    public Queue()
    {
        size = 8;
    }

    public void enqueue(int v)
    {
        if (nextIndex >= elements.length)
        {
            int[] tempArray = new int[elements.length*2];
            System.arraycopy(elements, 0, tempArray, 0, elements.length);
            elements = tempArray;
        }
        elements[nextIndex++] = v;
    }


    public int dequeue(int element)
    {
        boolean reach = false;
        for (int i = 0; i < elements.length;i++)
        {
            if (!reach)
                if (elements[i] == element)
                    reach = true;
            if (reach & i < elements.length-1)
                elements[i] = elements[i+1];
        }
        if (reach)
            return element;
        else
            return -1;
    }


    public boolean empty()
    {
        return nextIndex == 0;
    }

    public int getSize()
    {
        return size;
    }
}
