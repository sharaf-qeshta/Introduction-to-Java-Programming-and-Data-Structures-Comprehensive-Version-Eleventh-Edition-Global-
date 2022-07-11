package chapter_eighteen;


/**
 * *18.18 (Tower of Hanoi) Modify Listing 18.8, TowerOfHanoi.java, so the program finds
 * the number of moves needed to move n disks from tower A to tower B. (Hint:
 * Use a static variable and increment it every time the method is called.)
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$18
{
    private static int numberOfMoves = 0;

    public static void main(String[] args)
    {
        int n = 3;
        moveDisks(n, 'A', 'B', 'C');
        /* You need 7 Moves to move 3 disks from tower A to tower B */
        System.out.println("You need " + numberOfMoves + " Moves to move " + n
                + " disks from tower A to tower B");
    }

    public static void moveDisks(int n, char fromTower, char toTower, char auxTower)
    {
        if (n == 1)
            numberOfMoves++;
        else
        {
            moveDisks(n - 1, fromTower, auxTower, toTower);
            numberOfMoves++;
            moveDisks(n - 1, auxTower, toTower, fromTower);
        }
    }
}
