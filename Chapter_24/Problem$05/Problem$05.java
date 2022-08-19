package chapter_twenty_four;


/**
 * 24.5 (Implement GenericQueue using inheritance) In Section 24.5, Stacks and
 * Queues, GenericQueue is implemented using composition. Define a new queue
 * class that extends java.util.LinkedList.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$05
{
    public static void main(String[] args)
    {
        GenericQueue<String> queue = new GenericQueue<>();

        queue.enqueue("Tom");
        /* (1) Queue: [Tom] */
        System.out.println("(1) " + queue);

        queue.enqueue("Susan");
        /* (2) Queue: [Tom, Susan] */
        System.out.println("(2) " + queue);

        queue.enqueue("Kim");
        queue.enqueue("Michael");
        /* (3) Queue: [Tom, Susan, Kim, Michael] */
        System.out.println("(3) " + queue);

        /* (4) Tom */
        System.out.println("(4) " + queue.dequeue());
        /* (5) Susan */
        System.out.println("(5) " + queue.dequeue());
        /* (6) Queue: [Kim, Michael] */
        System.out.println("(6) " + queue);
    }
}
