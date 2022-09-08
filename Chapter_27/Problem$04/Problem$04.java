package chapter_twenty_seven;

/**
 * **27.4 (Modify MyHashMap with duplicate keys) Modify MyHashMap to allow duplicate
 * keys for entries. You need to modify the implementation for the put(key,
 * value) method. Also add a new method named getAll(key) that returns a set
 * of values that match the key in the map.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$04
{
    public static void main(String[] args)
    {
        MyHashMap<String, String> map = new MyHashMap<>();
        map.put("USA", "Houston");
        map.put("USA", "Dallas");
        map.put("USA", "Austin");
        map.put("USA", "Los Angelos");
        map.put("USA", "San Francisco");
        map.put("USA", "Sacramento");
        map.put("USA", "Chicago");
        map.put("USA", "New York");
        map.put("USA", "Washington");
        map.put("USA", "Miami");

        map.put("UK", "London");
        map.put("UK", "Edinburgh");
        map.put("UK", "Manchester");
        map.put("UK", "Birmingham");
        map.put("UK", "Bristol");

        map.put("Germany", "Berlin");
        map.put("Germany", "Munich");
        map.put("Germany", "Hamburg");
        map.put("Germany", "Frankfurt");
        map.put("Germany", "Stuttgart");

        map.put("China", "Beijing");
        map.put("China", "Shanghai");
        map.put("China", "Guangzhou");
        map.put("China", "Shenzhen");
        map.put("China", "Hong Kong");

        map.put("Canada", "Vancouver");
        map.put("Canada", "Toronto");
        map.put("Canada", "Montreal");

        /*
        * [Los Angelos, San Francisco, New York, Sacramento, Chicago, Austin, Dallas, Washington, Houston, Miami]
        * */
        System.out.println(map.get("USA"));

        /*
        * [Munich, Frankfurt, Berlin, Stuttgart, Hamburg]
        * */
        System.out.println(map.get("Germany"));

        /*
        * [Beijing, Hong Kong, Shanghai, Guangzhou, Shenzhen]
        * */
        System.out.println(map.get("China"));

        /*
        * null
        * */
        System.out.println(map.get("France"));


        System.out.println(map.containsValue("Miami")); // true
        System.out.println(map.containsValue("London")); // true
        System.out.println(map.containsValue("Bern")); // false

        System.out.println(map.containsKey("UK")); // true
        System.out.println(map.containsKey("Switzerland")); // false

        System.out.println(map.size()); // 5

        /*
        * [[UK, [Bristol, London, Manchester, Edinburgh, Birmingham]]
        * [China, [Beijing, Hong Kong, Shanghai, Guangzhou, Shenzhen]]
        * [Germany, [Munich, Frankfurt, Berlin, Stuttgart, Hamburg]]
        * [Canada, [Vancouver, Montreal, Toronto]]
        * [USA, [Los Angelos, San Francisco, New York, Sacramento, Chicago, Austin, Dallas, Washington, Houston, Miami]]]
        * */
        System.out.println(map);

        map.remove("USA");
        /*
        * [[UK, [Bristol, London, Manchester, Edinburgh, Birmingham]]
        * [China, [Beijing, Hong Kong, Shanghai, Guangzhou, Shenzhen]]
        * [Germany, [Munich, Frankfurt, Berlin, Stuttgart, Hamburg]]
        * [Canada, [Vancouver, Montreal, Toronto]]]
        * */
        System.out.println(map);

        map.remove("China");
        /*
        * [[UK, [Bristol, London, Manchester, Edinburgh, Birmingham]]
        * [Germany, [Munich, Frankfurt, Berlin, Stuttgart, Hamburg]]
        * [Canada, [Vancouver, Montreal, Toronto]]]
        * */
        System.out.println(map);

        map.remove("UK");
        /*
        * [[Germany, [Munich, Frankfurt, Berlin, Stuttgart, Hamburg]]
        * [Canada, [Vancouver, Montreal, Toronto]]]
        * */
        System.out.println(map);

        map.clear();
        /*
        * []
        * */
        System.out.println(map);
    }
}
