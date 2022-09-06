package chapter_twenty_seven;

import java.util.HashSet;
import java.util.Set;

public class MyHashMap<K, V> implements MyMap<K, V>
{
    private static final int DEFAULT_INITIAL_CAPACITY = 6;
    private static final int MAXIMUM_CAPACITY = 1 << 30; // 2^30
    private static final float DEFAULT_MAX_LOAD_FACTOR = 0.75f;

    private int size = 0;
    private MyMap.Entry<K, V>[] hashTable;

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
        if (entry == null)
            return false;
        try
        {
            while (entry.key != key)
                entry = hashTable[++hashCode % hashTable.length];
            return true;
        }
        catch (Exception exception)
        {
            return false;
        }
    }

    @Override
    public boolean containsValue(V value)
    {
        for (Entry<K, V> entry: hashTable)
        {
            if (entry != null)
            {
                if (entry.value == value)
                    return true;
            }
        }
        return false;
    }

    @Override
    public Set<Entry<K, V>> entrySet()
    {
        Set<Entry<K, V>> entries = new HashSet<>();
        for (Entry<K, V> entry: hashTable)
        {
            if (entry != null)
                entries.add(entry);
        }
        return entries;
    }

    @Override
    public V get(K key)
    {
        int keyHashCode = Math.abs(key.hashCode());
        MyMap.Entry<K, V> entry = hashTable[keyHashCode % hashTable.length];

        // key is not exist
        if (entry == null)
            return null;

        while (entry.key != key)
            entry = hashTable[++keyHashCode % hashTable.length];
        return entry.value;
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
        for (Entry<K, V> entry: hashTable)
            if (entry != null)
                keys.add(entry.key);
        return keys;
    }

    @Override
    public V put(K key, V value)
    {
        if (size+1 >= MAXIMUM_CAPACITY)
            throw new RuntimeException("Exceeding maximum capacity");

        if (size+1 >= hashTable.length)
        {
           int newSize = (int) (hashTable.length * DEFAULT_MAX_LOAD_FACTOR + hashTable.length);
           MyMap.Entry<K, V>[] temp = new Entry[newSize];

           Set<MyMap.Entry<K, V>> set = entrySet();
           for (MyMap.Entry<K, V> entry: set)
           {
               if (entry != null)
               {
                   int entryKeyHashCode = Math.abs(entry.key.hashCode());
                   MyMap.Entry<K, V> entry1 = temp[entryKeyHashCode % temp.length];
                   while (entry1 != null)
                       entry1 = temp[++entryKeyHashCode % temp.length];
                   temp[entryKeyHashCode % temp.length] = new Entry<>(entry.key, entry.value);
               }
           }

           hashTable = temp;
        }
        int keyHashCode = Math.abs(key.hashCode());
        MyMap.Entry<K, V> entry = hashTable[keyHashCode % hashTable.length];
        if (containsKey(key))
        {
            while (entry.key != key)
                entry = hashTable[++keyHashCode % hashTable.length];
        }
        else
        {
            while (entry != null)
                entry = hashTable[++keyHashCode % hashTable.length];
            size++;
        }
        hashTable[keyHashCode % hashTable.length] = new Entry<>(key, value);

        return value;
    }

    @Override
    public void remove(K key)
    {
        int keyHashCode = Math.abs(key.hashCode());
        MyMap.Entry<K, V> entry = hashTable[keyHashCode % hashTable.length];

        // key exist
        if (entry != null)
        {
            while (entry.key != key)
                entry = hashTable[++keyHashCode % hashTable.length];

            hashTable[keyHashCode % hashTable.length] = null;
            size--;
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
        for (Entry<K, V> entry: hashTable)
            if (entry != null)
                values.add(entry.value);
        return values;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder("[");

        for (Entry<K, V> entry: hashTable)
        {
            if (entry != null)
                builder.append(entry);
        }
        builder.append("]");
        return builder.toString();
    }
}
