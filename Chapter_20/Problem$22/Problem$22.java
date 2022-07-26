package chapter_twenty;

import java.util.Stack;

/**
 * *20.22 (Nonrecursive Tower of Hanoi) Implement the moveDisks method in
 * Listing 18.8 using a stack instead of using recursion.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$22
{
    public static void main(String[] args)
    {
        /*
        * Move disk 1 from A to B
        * Move disk 2 from A to C
        * Move disk 1 from B to C
        * Move disk 3 from A to B
        * Move disk 1 from C to A
        * Move disk 2 from C to B
        * Move disk 1 from A to B
        * */
        moveDisks(3, 'A', 'B', 'C');
    }

    public static void moveDisks(int n, char fromTower, char toTower, char auxTower)
    {
        Stack<Stage> stages = new Stack<>();
        while (n >= 1 || !stages.isEmpty())
        {
            while (n >= 1)
            {
                Stage currentStage = new Stage();
                currentStage.source = fromTower;
                currentStage.auxiliary = auxTower;
                currentStage.destination = toTower;
                currentStage.n = n;
                stages.push(currentStage);
                char temp = toTower;
                toTower = auxTower;
                auxTower = temp;
                n--;
            }
            Stage currentStage = stages.pop();

            System.out.println("Move disk " + currentStage.n + " from " +
                    currentStage.source + " to " + currentStage.destination);

            fromTower = currentStage.auxiliary;
            auxTower = currentStage.source;
            toTower = currentStage.destination;
            n = currentStage.n - 1;
        }
    }

    static class Stage
    {
        int n;
        char source, auxiliary, destination;
    }
}
