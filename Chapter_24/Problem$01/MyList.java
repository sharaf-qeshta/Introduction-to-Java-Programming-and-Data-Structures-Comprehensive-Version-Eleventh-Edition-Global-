package chapter_twenty_four;

import java.util.Collection;

public interface MyList<E> extends java.util.Collection<E>
{
    @Override
    default boolean addAll(Collection<? extends E> c)
    {
        for (E object: c)
            add(object);
        return true;
    }


    @Override
    default boolean removeAll(Collection<?> c)
    {
        for (Object object: c)
            remove(object);
        return true;
    }

    @Override
    default boolean retainAll(Collection<?> c)
    {
        for (E object: this)
            if (!c.contains(object))
                remove(object);
        return true;
    }

    @Override
    default Object[] toArray()
    {
        Object[] array = new Object[size()];
        int i = 0;
        for (E object: this)
            array[i++] = object;
        return array;
    }


    @Override
    default <T> T[] toArray(T[] a)
    {
        if (a.length >= size())
        {
            int i = 0;
            for (E object: this)
                a[i++] = (T) object;
            for (int j = i; j < a.length; j++)
                a[j] = null;
            return a;
        }
        Object[] array = new Object[size()];
        int i = 0;
        for (E object: this)
            array[i++] = object;
        return (T[]) array;
    }
}
