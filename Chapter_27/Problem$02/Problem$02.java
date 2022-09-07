package chapter_twenty_seven;

/**
 * **27.2 (Implement MyMap using open addressing with quadratic probing) Create a new
 * concrete class that implements MyMap using open addressing with quadratic probing.
 * For simplicity, use f(key) = key % size as the hash function, where size
 * is the hash-table size. Initially, the hash-table size is 6. The table size is doubled
 * whenever the load factor exceeds the threshold (0.5).
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$02
{
    public static void main(String[] args)
    {
        MyHashMap<String, String> map = new MyHashMap<>();
        map.put("Texas", "Austin");
        map.put("California", "Sacramento");
        map.put("Florida", "Tallahassee");
        map.put("Pennsylvania", "Harrisburg");
        map.put("Massachusetts", "Boston");
        map.put("Colorado", "Denver");
        map.put("Georgia", "Atlanta");
        map.put("New York", "New York");
        map.put("New York", "Albany");

        /*
        * [[California, Sacramento][Texas, Austin][Pennsylvania, Harrisburg][Colorado, Denver][Massachusetts, Boston][Georgia, Atlanta][Florida, Tallahassee][New York, Albany]]
        * */
        System.out.println(map);

        System.out.println(map.get("Texas")); // Austin
        System.out.println(map.get("Nevada")); // null
        System.out.println(map.get("Massachusetts")); // Boston

        map.remove("Florida");
        /*
        * [[California, Sacramento][Texas, Austin][Pennsylvania, Harrisburg][Colorado, Denver][Massachusetts, Boston][Georgia, Atlanta][New York, Albany]]
        * */
        System.out.println(map);

        map.remove("Colorado");
        /*
        * [[California, Sacramento][Texas, Austin][Pennsylvania, Harrisburg][Massachusetts, Boston][Georgia, Atlanta][New York, Albany]]
        * */
        System.out.println(map);

        map.remove("Arizona");
        /*
        * [[California, Sacramento][Texas, Austin][Pennsylvania, Harrisburg][Massachusetts, Boston][Georgia, Atlanta][New York, Albany]]
        * */
        System.out.println(map);


        /*
        * [Sacramento, Atlanta, Harrisburg, Austin, Boston, Albany]
        * */
        System.out.println(map.values());
        /*
        * [New York, Texas, Massachusetts, California, Georgia, Pennsylvania]
        * */
        System.out.println(map.keySet());

        map.clear();
        System.out.println(map); // []
    }
}
