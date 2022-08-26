package chapter_twenty_four.samples;

/**
 * Listing 24.9 TestPriorityQueue.java
 * */
public class TestPriorityQueue
{
    public static void main(String[] args)
    {
        Patient patient1 = new Patient("John", 2);
        Patient patient2 = new Patient("Jim", 1);
        Patient patient3 = new Patient("Tim", 5);
        Patient patient4 = new Patient("Cindy", 7);

        MyPriorityQueue<Patient> priorityQueue
                = new MyPriorityQueue<>();
        priorityQueue.enqueue(patient1);
        priorityQueue.enqueue(patient2);
        priorityQueue.enqueue(patient3);
        priorityQueue.enqueue(patient4);

        while (priorityQueue.getSize() > 0)
            System.out.print(priorityQueue.dequeue() + " ");
    }

    static class Patient implements Comparable<Patient>
    {
        private String name;
        private int priority;

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

        @Override
        public int compareTo(Patient patient)
        {
            return this.priority - patient.priority;
        }
    }
}
