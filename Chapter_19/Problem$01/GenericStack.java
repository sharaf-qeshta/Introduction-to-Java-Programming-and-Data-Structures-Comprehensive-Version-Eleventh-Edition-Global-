package chapter_nineteen;


public class GenericStack<E>
{
    private static final int INITIAL_CAPACITY = 16;
    private static final double SCALE_FACTOR = 1.75;
    private Object[] stack = new Object[INITIAL_CAPACITY];
    private int currentIndex = -1;

    public int getSize()
    {
        return currentIndex+1;
    }

    public E peek()
    {
        return (currentIndex == -1)? null : (E) stack[currentIndex];
    }

    public void push(E o)
    {
        if (currentIndex+1 > stack.length-1)
        {
            Object[] tempStack = new Object[(int) (SCALE_FACTOR * stack.length)];
            System.arraycopy(stack, 0, tempStack, 0, stack.length);
            stack = tempStack;
        }
        stack[++currentIndex] = o;
    }

    public E pop()
    {
        E o = (E) stack[currentIndex];
        stack[currentIndex] = null;
        currentIndex--;
        return o;
    }

    public boolean isEmpty()
    {
        return currentIndex == -1;
    }

    @Override
    public String toString()
    {
        String out = "Stack: {";
        for (int i = 0; i < stack.length && stack[i] != null; i++)
            out += stack[i] + ", ";
        return out + "}";
    }
}
