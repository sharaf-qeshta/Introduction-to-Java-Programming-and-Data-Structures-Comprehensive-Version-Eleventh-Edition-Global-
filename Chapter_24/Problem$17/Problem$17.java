package chapter_twenty_four;

import java.util.Comparator;

/**
 * **24.17 (Revise MyPriorityQueue) Listing 24.8 uses a heap to implement the priority
 * queue. Revise the implementation using a sorted array list to store the elements
 * and name the new class PriorityUsingSortedArrayList. The elements in
 * the array list are sorted in increasing order of their priority with the last element
 * having the highest priority. Write a test program that generates 5 million integers
 * and enqueues them to the priority and dequeues from the queue. Use the same
 * numbers for MyPriorityQueue and PriorityUsingSortedArrayList and
 * display their execution times.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$17
{
    public static void main(String[] args)
    {
        /*
        * Time taken by heap priority queue to enqueue and dequeue 5 million integers is 4015 MS
        * Time taken by sorted list priority queue to enqueue and dequeue 5 million integers is 224 MS
        * */
        MyPriorityQueue<Integer> heapQueue = new MyPriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityUsingSortedArrayList<Integer> sortedListQueue = new PriorityUsingSortedArrayList<>();

        long start = System.currentTimeMillis();
        for (int i = 0; i < 5_000_000; i++)
            heapQueue.enqueue(i);
        for (int i = 0; i < 5_000_000; i++)
            heapQueue.dequeue();
        long end = System.currentTimeMillis();

        System.out.println("Time taken by heap priority queue " +
                "to enqueue and dequeue 5 million integers is " + (end - start) + " MS");

        start = System.currentTimeMillis();
        for (int i = 0; i < 5_000_000; i++)
            sortedListQueue.enqueue(i);
        for (int i = 0; i < 5_000_000; i++)
            sortedListQueue.dequeue();
        end = System.currentTimeMillis();

        System.out.println("Time taken by sorted list priority queue " +
                "to enqueue and dequeue 5 million integers is " + (end - start) + " MS");
    }
}
