package chapter_twenty_nine;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * **29.6 (Weighted 4 * 4 16 tails model) The weighted nine tails problem in the text
 * uses a 3 * 3 matrix. Assume that you have 16 coins placed in a 4 * 4 matrix.
 * Create a new model class named WeightedTailModel16. Create an instance
 * of the model and save the object into a file named WeightedTailModel16.dat.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$06
{
    private static final String FILE_PATH = "src/chapter_twenty_nine/WeightedTailModel16.dat";

    public static void main(String[] args)
    {
        WeightedTailModel16 model16 = new WeightedTailModel16();


        try (ObjectOutputStream stream = new ObjectOutputStream
                (new FileOutputStream(new File(FILE_PATH))))
        {
            stream.writeObject(model16);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
