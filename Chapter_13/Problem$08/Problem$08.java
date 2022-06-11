package chapter_thirteen;

/**
 * *13.8 (Revise the MyStack class) Rewrite the MyStack class in Listing 11.10 to perform
 * a deep copy of the list field.
 *
 * @author Sharaf Qeshta
 * */
public class Problem$08
{
    public static void main(String[] args)
    {
        MyStack myStack1 = new MyStack();
        myStack1.add(1);
        myStack1.add(2);
        myStack1.add(3);
        myStack1.add(4);
        myStack1.add(5);

        MyStack myStack2 = new MyStack(myStack1);

        myStack1.remove(0);
        myStack1.remove(1);

        /* stack: [2, 4, 5] */
        System.out.println(myStack1);

        /* stack: [1, 2, 3, 4, 5] */
        System.out.println(myStack2);
    }
}
