package chapter_twenty_seven;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class MyHashSet<E> implements Collection<E>
{
    private MyHashMap<E, E> map = new MyHashMap<>();

    @Override
    public int size()
    {
        return map.size();
    }

    @Override
    public boolean isEmpty()
    {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o)
    {
        return map.containsKey((E) o);
    }

    @Override
    public Iterator<E> iterator()
    {
        return new SetIterator();
    }

    private class SetIterator implements Iterator<E>
    {
        private int currentIndex;
        private E[] values;

        public SetIterator()
        {
            currentIndex = 0;
            values = (E[]) toArray();
        }

        @Override
        public boolean hasNext()
        {
            return currentIndex < values.length;
        }

        @Override
        public E next()
        {
            return values[currentIndex++];
        }
    }

    @Override
    public Object[] toArray()
    {
        Object[] array = new Object[size()];
        Set<E> keys = map.keySet();
        int i = 0;
        for (E key: keys)
            array[i++] = key;
        return array;
    }

    @Override
    public <T> T[] toArray(T[] a)
    {
        return null;
    }

    @Override
    public boolean add(E e)
    {
        if (map.containsKey(e))
            return false;
        map.put(e, e);
        return true;
    }

    @Override
    public boolean remove(Object o)
    {
        if (!contains(o))
            return false;
        map.remove((E) o);
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c)
    {
        for (Object object: c)
            if (!contains(object))
                return false;
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c)
    {
        for (Object object: c)
            add((E) object);
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c)
    {
        for (Object object: c)
            remove(object);
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c)
    {
        Set<E> values = map.keySet();
        for (E value: values)
            if (!c.contains(value))
                map.remove(value);
        return true;
    }

    @Override
    public void clear()
    {
        map.clear();
    }

    public String toString()
    {
        String out = "[";
        E[] values = (E[]) toArray();
        for (int i = 0; i < values.length-1; i++)
            out += values[i] + ", ";
        out += values[values.length-1];
        out += "]";
        return out;
    }
}
