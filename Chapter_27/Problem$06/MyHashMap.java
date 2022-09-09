package chapter_twenty_seven;

import java.util.HashSet;
import java.util.Set;

public class MyHashMap<K, V> implements MyMap<K, V>
{
    private static final int DEFAULT_INITIAL_CAPACITY = 6;
    private static final float DEFAULT_MAX_LOAD_FACTOR = 1.75f;

    int size = 0;
    MyMap.Entry<K, V>[] hashTable;

    public MyHashMap()
    {
        hashTable = new Entry[DEFAULT_INITIAL_CAPACITY];
    }


    @Override
    public void clear()
    {
        size = 0;
        hashTable = new Entry[DEFAULT_INITIAL_CAPACITY];
    }

    @Override
    public boolean containsKey(K key)
    {
        int hashCode = Math.abs(key.hashCode());
        MyMap.Entry<K, V> entry = hashTable[hashCode % hashTable.length];
        try
        {
            while (!entry.getKey().equals(key) || entry.marked)
                entry = hashTable[++hashCode % hashTable.length];
            return true;
        }
        catch (NullPointerException exception)
        {
            return false;
        }
    }

    @Override
    public boolean containsValue(V value)
    {
        for (MyMap.Entry<K, V> entry: hashTable)
        {
            if (entry != null)
            {
                if (!entry.marked)
                {
                    if (entry.getValue().equals(value))
                        return true;
                }
            }
        }
        return false;
    }

    @Override
    public Set<Entry<K, V>> entrySet()
    {
        Set<MyMap.Entry<K, V>> entries = new HashSet<>();
        for (MyMap.Entry<K, V> entry: hashTable)
        {
            if (entry != null)
            {
                if (!entry.marked)
                    entries.add(entry);
            }
        }
        return entries;
    }

    @Override
    public V get(K key)
    {
        int hashCode = Math.abs(key.hashCode());
        MyMap.Entry<K, V> entry = hashTable[hashCode % hashTable.length];
        try
        {
            while (!entry.getKey().equals(key) || entry.marked)
                entry = hashTable[++hashCode % hashTable.length];

            return entry.getValue();
        }
        catch (NullPointerException exception)
        {
            return null;
        }
    }

    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }

    @Override
    public Set<K> keySet()
    {
        Set<K> keys = new HashSet<>();
        for (MyMap.Entry<K, V> entry: hashTable)
        {
            if (entry != null)
            {
                if (!entry.marked)
                    keys.add(entry.getKey());
            }
        }
        return keys;
    }

    @Override
    public V put(K key, V value)
    {
        if (size+1 >= hashTable.length)
        {
            int newSize = (int) (DEFAULT_MAX_LOAD_FACTOR * hashTable.length);
            MyMap.Entry<K, V>[] temp = new Entry[newSize];
            Set<MyMap.Entry<K, V>> entries = entrySet();

            for (MyMap.Entry<K, V> entry: entries)
            {
                int hashCode = Math.abs(entry.getKey().hashCode());
                MyMap.Entry<K, V> current = temp[hashCode % newSize];
                try
                {
                    while (!current.getKey().equals(entry.getKey()))
                        current = temp[++hashCode % newSize];
                    temp[hashCode % newSize] = new Entry<>(entry.getKey(), entry.getValue());
                }
                catch (NullPointerException exception)
                {
                    temp[hashCode % newSize] = new Entry<>(entry.getKey(), entry.getValue());
                }
            }
            hashTable = temp;
        }

        int hashCode = Math.abs(key.hashCode());
        MyMap.Entry<K, V> entry = hashTable[hashCode % hashTable.length];
        try
        {
            while (!entry.getKey().equals(key))
            {
                if (entry.marked)
                    break;
                entry = hashTable[++hashCode % hashTable.length];
            }

            hashTable[hashCode % hashTable.length] = new Entry<>(key, value);
        }
        catch (NullPointerException exception)
        {
            hashTable[hashCode % hashTable.length] = new Entry<>(key, value);
            size++;
        }
        return null;
    }

    @Override
    public void remove(K key)
    {
        int hashCode = Math.abs(key.hashCode());
        MyMap.Entry<K, V> entry = hashTable[hashCode % hashTable.length];

        try
        {
            while (!entry.getKey().equals(key) || entry.marked)
                entry = hashTable[++hashCode % hashTable.length];
            hashTable[hashCode % hashTable.length].marked = true;
            size--;
        }
        catch (Exception exception)
        {
            // key is not exist
        }
    }

    @Override
    public int size()
    {
        return size;
    }

    @Override
    public Set<V> values()
    {
        Set<V> values = new HashSet<>();
        for (MyMap.Entry<K, V> entry: hashTable)
        {
            if (entry != null)
            {
                if (!entry.marked)
                    values.add(entry.getValue());
            }
        }
        return values;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder("[");

        for (Entry<K, V> entry: hashTable)
        {
            if (entry != null)
            {
                if (!entry.marked)
                    builder.append(entry);
            }
        }
        builder.append("]");
        return builder.toString();
    }
}
