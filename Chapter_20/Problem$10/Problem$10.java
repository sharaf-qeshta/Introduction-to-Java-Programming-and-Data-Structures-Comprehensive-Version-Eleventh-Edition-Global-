package chapter_twenty;

import java.util.PriorityQueue;

/**
 * 20.10 (Perform set operations on priority queues) Given two stacks of textbooks
 * of the following subjects {“Chemistry”, “Mathematics”, “Biology”,
 * “English”} and {“Biology”, “English”, “Geography”, “Physics”},
 * find the subjects that are (1) only present in the first stack; (2) only present in
 * the second stack; (3) present in both stacks.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$10
{
    public static void main(String[] args)
    {
        PriorityQueue<String> queue1 = new PriorityQueue<>();
        queue1.offer("Chemistry");
        queue1.offer("Mathematics");
        queue1.offer("Biology");
        queue1.offer("English");

        PriorityQueue<String> queue2 = new PriorityQueue<>();
        queue2.offer("Biology");
        queue2.offer("English");
        queue2.offer("Geography");
        queue2.offer("Physics");


        // (1) only present in the first stack
        PriorityQueue<String> x = new PriorityQueue<>(queue1);
        PriorityQueue<String> y = new PriorityQueue<>(queue2);
        x.removeAll(y);
        System.out.println(x); // [Chemistry, Mathematics]

        // (2) only present in the second stack
        x = new PriorityQueue<>(queue1);
        y = new PriorityQueue<>(queue2);
        y.removeAll(x);
        System.out.println(y); // [Geography, Physics]

        // (3) present in both stacks
        x = new PriorityQueue<>(queue1);
        y = new PriorityQueue<>(queue2);
        x.retainAll(y);
        System.out.println(x); // [Biology, English]
    }
}
