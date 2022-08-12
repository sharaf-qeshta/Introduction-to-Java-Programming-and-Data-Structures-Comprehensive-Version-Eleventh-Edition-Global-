package chapter_twenty_three;

import java.io.*;

public class ExternalSort
{
    public static final int MAX_ARRAY_SIZE = 100000;
    public static final int BUFFER_SIZE = 100000;

    /**
     * Sort data in source file and into target file
     */
    public static void sort(String sourceFile, String targetFile)
            throws Exception
    {
        int numberOfSegments =
                initializeSegments(MAX_ARRAY_SIZE, sourceFile, "f1.dat");

        merge(numberOfSegments, MAX_ARRAY_SIZE,
                "f1.dat", "f2.dat", "f3.dat", targetFile);
    }

    /**
     * Sort original file into sorted segments
     */
    private static int initializeSegments(int segmentSize, String originalFile, String f1)
            throws Exception
    {
        int[] list = new int[segmentSize];
        DataInputStream input = new DataInputStream(
                new BufferedInputStream(new FileInputStream(originalFile)));
        DataOutputStream output = new DataOutputStream(
                new BufferedOutputStream(new FileOutputStream(f1)));

        int numberOfSegments = 0;
        while (input.available() > 0)
        {
            numberOfSegments++;
            int i = 0;
            for (; input.available() > 0 && i < segmentSize; i++)
                list[i] = input.readInt();

            java.util.Arrays.sort(list, 0, i);

            for (int j = 0; j < i; j++)
                output.writeInt(list[j]);
        }

        input.close();
        output.close();
        return numberOfSegments;
    }

    private static void merge(int numberOfSegments, int segmentSize,
                              String f1, String f2, String f3, String targetFile)
            throws Exception
    {
        if (numberOfSegments > 1)
        {
            mergeOneStep(numberOfSegments, segmentSize, f1, f2, f3);
            merge((numberOfSegments + 1) / 2, segmentSize * 2,
                    f3, f1, f2, targetFile);
        }
        else
        {
            File sortedFile = new File(targetFile);
            if (sortedFile.exists())
                sortedFile.delete();

            new File(f1).renameTo(sortedFile);
        }
    }

    private static void mergeOneStep(int numberOfSegments,
                                     int segmentSize, String f1, String f2, String f3)
            throws Exception
    {
        DataInputStream f1Input = new DataInputStream(
                new BufferedInputStream(new FileInputStream(f1), BUFFER_SIZE));
        DataOutputStream f2Output = new DataOutputStream(
                new BufferedOutputStream(new FileOutputStream(f2), BUFFER_SIZE));

        copyHalfToF2(numberOfSegments, segmentSize, f1Input, f2Output);
        f2Output.close();

        DataInputStream f2Input = new DataInputStream(
                new BufferedInputStream(new FileInputStream(f2), BUFFER_SIZE));
        DataOutputStream f3Output = new DataOutputStream(
                new BufferedOutputStream(new FileOutputStream(f3), BUFFER_SIZE));

        mergeSegments(numberOfSegments / 2,
                segmentSize, f1Input, f2Input, f3Output);

        f1Input.close();
        f2Input.close();
        f3Output.close();
    }

    /**
     * Copy first half number of segments from f1.dat to f2.dat
     */
    private static void copyHalfToF2(int numberOfSegments,
                                     int segmentSize, DataInputStream f1, DataOutputStream f2)
            throws Exception
    {
        for (int i = 0; i < (numberOfSegments / 2) * segmentSize; i++)
            f2.writeInt(f1.readInt());
    }

    /**
     * Merge all segments
     */
    private static void mergeSegments(int numberOfSegments,
                                      int segmentSize, DataInputStream f1, DataInputStream f2,
                                      DataOutputStream f3) throws Exception
    {
        for (int i = 0; i < numberOfSegments; i++)
            mergeTwoSegments(segmentSize, f1, f2, f3);

        while (f1.available() > 0)
            f3.writeInt(f1.readInt());
    }

    /**
     * Merges two segments
     */
    private static void mergeTwoSegments(int segmentSize,
                                         DataInputStream f1, DataInputStream f2,
                                         DataOutputStream f3) throws Exception
    {
        int intFromF1 = f1.readInt();
        int intFromF2 = f2.readInt();
        int f1Count = 1;
        int f2Count = 1;

        while (true)
        {
            if (intFromF1 < intFromF2)
            {
                f3.writeInt(intFromF1);
                if (f1.available() == 0 || f1Count++ >= segmentSize)
                {
                    f3.writeInt(intFromF2);
                    break;
                }
                else
                    intFromF1 = f1.readInt();

            }
            else
            {
                f3.writeInt(intFromF2);
                if (f2.available() == 0 || f2Count++ >= segmentSize)
                {
                    f3.writeInt(intFromF1);
                    break;
                }
                else
                    intFromF2 = f2.readInt();
            }
        }

        while (f1.available() > 0 && f1Count++ < segmentSize)
        {
            f3.writeInt(f1.readInt());
        }

        while (f2.available() > 0 && f2Count++ < segmentSize)
        {
            f3.writeInt(f2.readInt());
        }
    }
}
