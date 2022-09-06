package chapter_twenty_seven;


/**
 * **27.1 (Implement MyMap using open addressing with linear probing) Create a new
 * concrete class that implements MyMap using open addressing with linear probing.
 * For simplicity, use f(key) = key % size as the hash function, where size is
 * the hash-table size. Initially, the hash-table size is 6. The table size is doubled
 * whenever the load factor exceeds the threshold (0.5).
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$01
{
    public static void main(String[] args)
    {
        /*
         * Entries in map: [[Dortmund, 589600][Berlin, 3862038][Frankfurt, 777156][München, 1538302][Hamburg, 1789954][Stuttgart, 632692][Bonn, 320194]]
         * is Berlin exist: true
         * is Nurenberg exist: false
         * Population of berlin : 3862038
         * Entries in map: [[Berlin, 3862038][Frankfurt, 777156][München, 1538302][Hamburg, 1789954][Stuttgart, 632692][Bonn, 320194]]
         * Entries in map: [[Berlin, 3862038][Frankfurt, 777156][München, 1538302][Stuttgart, 632692][Bonn, 320194]]
         * Entries in map: []
         * */

        MyMap<String, Integer> map = new MyHashMap<>();
        map.put("Berlin", 3_562_038);
        map.put("Hamburg", 1_789_954);
        map.put("München", 1_538_302);
        map.put("Frankfurt", 777_156);
        map.put("Stuttgart", 632_692);
        map.put("Dortmund", 589_600);
        map.put("Bonn", 320_194);
        map.put("Berlin", 3_862_038);

        System.out.println("Entries in map: " + map);
        System.out.println("is Berlin exist: " + map.containsKey("Berlin"));
        System.out.println("is Nurenberg exist: " + map.containsKey("Nurenberg"));

        System.out.println("Population of berlin : " + map.get("Berlin"));

        map.remove("Dortmund");
        System.out.println("Entries in map: " + map);

        map.remove("Hamburg");
        System.out.println("Entries in map: " + map);

        map.clear();
        System.out.println("Entries in map: " + map);
    }
}
