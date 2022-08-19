package chapter_twenty_four;

import java.util.Comparator;

/**
 * *24.6 (Generic PriorityQueue using Comparator) Revise MyPriorityQueue
 * in Listing 24.8, using a generic parameter for comparing objects. Define a new
 * constructor with a Comparator as its argument as follows:
 * PriorityQueue(Comparator<? super E> comparator)
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$06
{
    public static void main(String[] args)
    {
        Patient patient1 = new Patient("John", 2);
        Patient patient2 = new Patient("Jim", 1);
        Patient patient3 = new Patient("Tim", 5);
        Patient patient4 = new Patient("Cindy", 7);

        MyPriorityQueue<Patient> priorityQueue
                = new MyPriorityQueue<>((o1, o2) -> o1.priority - o2.priority);

        priorityQueue.enqueue(patient1);
        priorityQueue.enqueue(patient2);
        priorityQueue.enqueue(patient3);
        priorityQueue.enqueue(patient4);

        /* Cindy(priority:7) Tim(priority:5) John(priority:2) Jim(priority:1) */
        while (priorityQueue.getSize() > 0)
            System.out.print(priorityQueue.dequeue() + " ");
    }

    static class Patient
    {
        String name;
        int priority;

        public Patient(String name, int priority)
        {
            this.name = name;
            this.priority = priority;
        }

        @Override
        public String toString()
        {
            return name + "(priority:" + priority + ")";
        }
    }
}
