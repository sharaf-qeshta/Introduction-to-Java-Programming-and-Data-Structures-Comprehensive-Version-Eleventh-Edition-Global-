package chapter_twenty_seven;


import java.util.HashSet;
import java.util.Set;

public class MyHashMap<K, V> implements MyMap<K, V>
{
    private static final int DEFAULT_INITIAL_CAPACITY = 6;

    private int size = 0;
    private int prime;
    private int capacity;
    private Entry<K, V>[] hashTable;


    public MyHashMap()
    {
        capacity = DEFAULT_INITIAL_CAPACITY;
        hashTable = new Entry[DEFAULT_INITIAL_CAPACITY];
        prime = getPrime();
    }

    private int hash1(K key)
    {
        int value = key.hashCode();
        value = value % capacity;
        if (value < 0)
            value += capacity;
        return value;
    }

    private int hash2(K key)
    {
        int value = key.hashCode();
        value = value % capacity;
        if (value < 0)
            value += capacity;
        return prime - value % prime;
    }

    public int getPrime()
    {
        for (int i = capacity - 1; i >= 1; i--)
        {
            int count = 0;
            for (int j = 2; j * j <= i; j++)
                if (i % j == 0)
                    count++;

            if (count == 0)
                return i;
        }
        return 3;
    }

    @Override
    public void clear()
    {
        size = 0;
        capacity = DEFAULT_INITIAL_CAPACITY;
        hashTable = new Entry[DEFAULT_INITIAL_CAPACITY];
        prime = getPrime();
    }

    @Override
    public boolean containsKey(K key)
    {
        int hash1 = hash1(key);
        int hash2 = hash2(key);

        while (hashTable[hash1] != null
                && !hashTable[hash1].getKey().equals(key))
        {
            hash1 += hash2;
            hash1 %= capacity;
        }

        return hashTable[hash1] != null;
    }

    @Override
    public boolean containsValue(V value)
    {
        for (Entry<K, V> entry: hashTable)
            if (entry != null)
                if (entry.getValue().equals(value))
                    return true;
        return false;
    }

    @Override
    public Set<Entry<K, V>> entrySet()
    {
        Set<Entry<K, V>> entries = new HashSet<>();
        for (Entry<K, V> entry: hashTable)
            if (entry != null)
                entries.add(entry);
        return entries;
    }

    @Override
    public V get(K key)
    {
        int hash1 = hash1(key);
        int hash2 = hash2(key);

        while (hashTable[hash1] != null
                && !hashTable[hash1].getKey().equals(key))
        {
            hash1 += hash2;
            hash1 %= capacity;
        }

        // key is not exist
        if (hashTable[hash1] == null)
            return null;

        // key exist
        return hashTable[hash1].value;
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
                keys.add(entry.getKey());
        return keys;
    }

    @Override
    public V put(K key, V value)
    {
        if (size == capacity)
        {
            capacity *= 2;
            Entry<K, V>[] temp = new Entry[capacity];
            prime = getPrime();
            Set<Entry<K, V>> entries = entrySet();
            for (Entry<K, V> entry: entries)
            {
                int hash1 = hash1(entry.getKey());
                int hash2 = hash2(entry.getKey());
                while (temp[hash1] != null)
                {
                    hash1 += hash2;
                    hash1 %= capacity;
                }

                temp[hash1] = new Entry<>(entry.getKey(), entry.getValue());
            }
            hashTable = temp;
        }

        int hash1 = hash1(key);
        int hash2 = hash2(key);
        while (hashTable[hash1] != null)
        {
            hash1 += hash2;
            hash1 %= capacity;

            // key is already exist
            if (hashTable[hash1] != null)
            {
                if (hashTable[hash1].getKey().equals(key))
                {
                    hashTable[hash1] = new Entry<>(key, value);
                    break;
                }
            }
        }


        if (hashTable[hash1] == null)
        {
            hashTable[hash1] = new Entry<>(key, value);
            size++;
        }
        return value;
    }

    @Override
    public void remove(K key)
    {
        int hash1 = hash1(key);
        int hash2 = hash2(key);
        while (hashTable[hash1] != null
                && !hashTable[hash1].getKey().equals(key))
        {
            hash1 += hash2;
            hash1 %= capacity;
        }

        // key exist
        if (hashTable[hash1] != null)
        {
            hashTable[hash1] = null;
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
                values.add(entry.getValue());
        return values;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder("[");

        for (Entry<K, V> entry: hashTable)
            if (entry != null)
                builder.append(entry);

        builder.append("]");
        return builder.toString();
    }
}
