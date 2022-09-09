package chapter_twenty_seven;

import java.util.HashSet;
import java.util.Set;

public class MyHashMap<K, V> implements MyMap<K, V>
{
    private static final int DEFAULT_INITIAL_CAPACITY = 6;

    private int size = 0;
    MyMap.Entry<K, V>[] hashTable;
    private int capacity;

    public MyHashMap()
    {
        hashTable = new Entry[DEFAULT_INITIAL_CAPACITY];
        capacity = DEFAULT_INITIAL_CAPACITY;
    }

    @Override
    public void clear()
    {
        size = 0;
        hashTable = new Entry[DEFAULT_INITIAL_CAPACITY];
        capacity = DEFAULT_INITIAL_CAPACITY;
    }

    @Override
    public boolean containsKey(K key)
    {
        int j = 0;
        int hashCode = Math.abs(key.hashCode());
        Entry<K, V> entry = hashTable[hashCode % capacity];

        try
        {
            while (!entry.getKey().equals(key) || entry.marked)
                entry = hashTable[(hashCode + ++j * j) % capacity];
            return true;
        }
        catch (NullPointerException exception)
        {
            // key is not exist
            return false;
        }
    }

    @Override
    public boolean containsValue(V value)
    {
        for (Entry<K, V> entry : hashTable)
        {
            if (entry != null)
                if (!entry.marked)
                    if (entry.value.equals(value))
                        return true;
        }
        return false;
    }

    @Override
    public Set<Entry<K, V>> entrySet()
    {
        Set<Entry<K, V>> entries = new HashSet<>();
        for (Entry<K, V> entry : hashTable)
        {
            if (entry != null)
                if (!entry.marked)
                    entries.add(entry);
        }
        return entries;
    }

    @Override
    public V get(K key)
    {
        int j = 0;
        int hashCode = Math.abs(key.hashCode());
        Entry<K, V> entry = hashTable[hashCode % capacity];

        try
        {
            while (!entry.getKey().equals(key) || entry.marked)
                entry = hashTable[(hashCode + ++j * j) % capacity];
            return entry.getValue();
        }
        catch (NullPointerException exception)
        {
            // key is not exist
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
        for (Entry<K, V> entry : hashTable)
        {
            if (entry != null)
                if (!entry.marked)
                    keys.add(entry.getKey());
        }
        return keys;
    }

    @Override
    public V put(K key, V value)
    {
        if (size+1 >= capacity)
        {
            capacity *= 2;
            Entry<K, V>[] temp = new Entry[capacity];
            Set<Entry<K, V>> entries = entrySet();

            for (Entry<K, V> entry: entries)
            {
                int j = 0;
                int hashCode = Math.abs(entry.getKey().hashCode());
                Entry<K, V> current = temp[hashCode % capacity];
                while (current != null)
                    current = temp[(hashCode + ++j * j) % capacity];
                temp[(hashCode + j * j) % capacity] = new Entry<>(entry.getKey(), entry.getValue());
            }
            hashTable = temp;
        }

        int j = 0;
        int hashCode = Math.abs(key.hashCode());
        Entry<K, V> entry = hashTable[hashCode % capacity];
        int j_ = 0;
        boolean markedFound = false;
        try
        {
            while (!entry.getKey().equals(key))
            {
                entry = hashTable[(hashCode + ++j * j) % capacity];
                if (entry.marked)
                {
                    j_ = j;
                    markedFound = true;
                }
            }

            hashTable[(hashCode + j * j) % capacity] = new Entry<>(key, value);
            return value;
        }
        catch (NullPointerException exception)
        {
            if (markedFound)
                hashTable[(hashCode + j_ * j_) % capacity] = new Entry<>(key, value);
            else
                hashTable[(hashCode + j * j) % capacity] = new Entry<>(key, value);
            size++;
            return value;
        }
    }

    @Override
    public void remove(K key)
    {
        int j = 0;
        int hashCode = Math.abs(key.hashCode());
        Entry<K, V> entry = hashTable[hashCode % capacity];

        try
        {
            while (!entry.getKey().equals(key) || entry.marked)
                entry = hashTable[(hashCode + ++j * j) % capacity];
            hashTable[(hashCode + j * j) % capacity].marked = true;
            size--;
        }
        catch (NullPointerException exception)
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
        for (Entry<K, V> entry : hashTable)
        {
            if (entry != null)
                if (!entry.marked)
                    values.add(entry.getValue());
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
