package chapter_twenty_five;



import java.io.File;
import java.util.Scanner;

/**
 * ***25.18 (Compress a file) Write a program that compresses a source file into a target
 * file using the Huffman coding method. First, use ObjectOutputStream to
 * output the Huffman codes into the target file, then use BitOutputStream in
 * Programming Exercise 17.17 to output the encoded binary contents to the target
 * file. Pass the files from the command line using the following command:
 * java Exercise25_18 sourcefile targetfile
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$18
{
    /*
    * result =>
    * compressed a file of size 86 KB to 46 KB
    * */
    public static void main(String[] args)
    {
        if (args.length < 2)
            throw new IllegalArgumentException();

        // read from source
        String text = "";
        try(Scanner scanner = new Scanner(new File(args[0])))
        {
            while (scanner.hasNext())
                text += scanner.nextLine() + "\n";
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }

        int[] counts = getCharacterFrequency(text);
        Tree tree = getHuffmanTree(counts);
        assignCode(tree.root);
        String binary = getEncoded(text, tree);

        // write to target
        try(MyOutputStream stream = new MyOutputStream(new File(args[1])))
        {
            stream.writeObject(tree);
            stream.writeBinary(binary);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }


    public static String getEncoded(String text, Tree tree)
    {
        String encoded = "";
        for (int i = 0; i < text.length(); i++)
            encoded += tree.getCode(text.charAt(i));
        return encoded;
    }

    private static void assignCode(Node root)
    {
        if (root.left != null)
        {
            root.left.code = root.code + "0";
            assignCode(root.left);

            root.right.code = root.code + "1";
            assignCode(root.right);
        }
    }

    /**
     * Get a Huffman tree from the codes
     */
    public static Tree getHuffmanTree(int[] counts)
    {
        // Create a heap to hold trees
        Heap<Tree> heap = new Heap<>(); // Defined in Listing 23.9
        for (int i = 0; i < counts.length; i++)
        {
            if (counts[i] > 0)
                heap.add(new Tree(counts[i], (char) i)); // A leaf node tree
        }

        while (heap.getSize() > 1)
        {
            Tree t1 = heap.remove(); // Remove the smallest−weight tree
            Tree t2 = heap.remove(); // Remove the next smallest
            heap.add(new Tree(t1, t2)); // Combine two trees
        }

        return heap.remove(); // The final tree
    }

    /**
     * Get the frequency of the characters
     */
    public static int[] getCharacterFrequency(String text)
    {
        int[] counts = new int[256]; // 256 ASCII characters

        for (int i = 0; i < text.length(); i++)
            counts[(int) text.charAt(i)]++; // Count the characters in text

        return counts;
    }
}


class Test
{
    public static void main(String[] args)
    {
        Problem$18.main(new String[] {"src/chapter_twenty_five/source.txt", "src/chapter_twenty_five/target.txt"});
    }
}


