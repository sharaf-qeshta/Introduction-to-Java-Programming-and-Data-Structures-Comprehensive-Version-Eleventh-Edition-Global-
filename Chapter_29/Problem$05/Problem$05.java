package chapter_twenty_nine;

/**
 * *29.5 (Prove or disprove) The conjecture is that both NineTailModel and
 * WeightedNineTailModel result in the same shortest path. Write a program
 * to prove or disprove it. (Hint: Let tree1 and tree2 denote the trees rooted at
 * node 511 obtained from NineTailModel and WeightedNineTailModel,
 * respectively. If the depth of a node u is the same in tree1 and in tree2, the
 * length of the path from u to the target is the same.)
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$05
{
    public static void main(String[] args)
    {
        // Proved

        UnweightedGraph<Integer>.SearchTree tree1 = new NineTailModel().tree;
        UnweightedGraph<Integer>.SearchTree tree2 = new WeightedNineTailModel().tree;

        for (int i = 0; i < 512; i++)
        {
            if (tree1.getPath(i).size() != tree2.getPath(i).size())
            {
                System.out.println("disproved!");
                System.exit(0);
            }
        }
        System.out.println("Proved");
    }
}
