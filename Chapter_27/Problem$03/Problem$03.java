package chapter_twenty_seven;

/**
 * **27.3 (Implement MyMap using open addressing with double hashing) Create a new
 * concrete class that implements MyMap using open addressing with double hashing.
 * For simplicity, use f(key) = key % size as the hash function, where size
 * is the hash-table size. Initially, the hash-table size is 6. The table size is doubled
 * whenever the load factor exceeds the threshold (0.5).
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$03
{
    public static void main(String[] args)
    {
        MyHashMap<String, String> map = new MyHashMap<>();
        map.put("Edinburgh", "Scotland");
        map.put("Glasgow", "Scotland");
        map.put("London", "England");
        map.put("Manchester", "England");
        map.put("Birmingham", "England");
        map.put("Cardiff", "Wales");
        map.put("Belfast", "Northern Ireland");
        map.put("York", "Scotland");
        map.put("York", "England");

        /*
        * [[Edinburgh, Scotland][York, England][Manchester, England][Birmingham, England][Belfast, Northern Ireland][London, England][Cardiff, Wales][Glasgow, Scotland]]
        * */
        System.out.println(map);

        System.out.println(map.containsKey("Birmingham")); // true

        System.out.println(map.containsValue("Wales")); // true
        System.out.println(map.containsValue("Ireland")); // false

        System.out.println(map.size()); // 8

        /*
        * [Wales, England, Scotland, Northern Ireland]
        * */
        System.out.println(map.values());

        /*
        * [Belfast, Cardiff, York, Manchester, London, Edinburgh, Glasgow, Birmingham]
        * */
        System.out.println(map.keySet());

        map.remove("Edinburgh");
        /*
        * [[York, England][Manchester, England][Birmingham, England][Belfast, Northern Ireland][London, England][Cardiff, Wales][Glasgow, Scotland]]
        * */
        System.out.println(map);

        map.remove("London");
        /*
        * [[York, England][Manchester, England][Birmingham, England][Belfast, Northern Ireland][Cardiff, Wales][Glasgow, Scotland]]
        * */
        System.out.println(map);

        map.remove("Cardiff");
        /*
        * [[York, England][Manchester, England][Birmingham, England][Belfast, Northern Ireland][Glasgow, Scotland]]
        * */
        System.out.println(map);

        map.clear();
        System.out.println(map); // []
    }
}
