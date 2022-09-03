package chapter_twenty_five;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.PrintWriter;

/**
 * ***25.19 (Decompress a file) The preceding exercise compresses a file. The compressed
 * file contains the Huffman codes and the compressed contents. Write a program
 * that decompresses a source file into a target file using the following command:
 * java Exercise25_19 sourcefile targetfile
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$19
{
    public static void main(String[] args)
    {
        if (args.length < 2)
            throw new IllegalArgumentException();

        // read from source (the compressed file)
        Tree tree = null;
        String encodedText = "";

        try(ObjectInputStream stream
                    = new ObjectInputStream(new FileInputStream(new File(args[0]))))
        {
            tree = (Tree) stream.readObject();
            int bound = stream.readInt();
            for (int i = 0; i < bound; i++)
                encodedText += dec2Bin(stream.readByte());

            encodedText += stream.readUTF();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            System.exit(-1);
        }

        // write to target
        try (PrintWriter writer = new PrintWriter(new File(args[1])))
        {
            writer.write(tree.decode(encodedText));
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    private static String dec2Bin(int value)
    {
        StringBuilder bits = new StringBuilder();

        for (int i = 0; i < 8; i++)
        {
            bits.insert(0, (value & 1));

            value >>= 1;
        }

        return bits.toString();
    }
}

class Test
{
    public static void main(String[] args)
    {
        Problem$19.main(new String[] {"src/chapter_twenty_five/source.txt", "src/chapter_twenty_five/target.txt"});
    }
}



