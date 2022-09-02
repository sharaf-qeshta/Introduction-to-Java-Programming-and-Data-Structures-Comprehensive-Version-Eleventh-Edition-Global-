package chapter_twenty_five;

import java.io.*;


public class MyOutputStream extends ObjectOutputStream
{
    public MyOutputStream(File file) throws IOException
    {
        super(new FileOutputStream(file));
    }

    public void writeBinary(String binary) throws IOException
    {
        int i;
        writeInt(binary.length() / 8);
        for (i = 0; i < binary.length(); i += 8)
        {
            try
            {
                String subBinary = binary.substring(i, i+8);
                byte decimal = (byte) bin2Dec(subBinary);
                writeByte(decimal);
            }
            catch (IndexOutOfBoundsException | IOException exception)
            {
                break;
            }
        }
        if (i < binary.length())
            writeUTF(binary.substring(i));
    }

    public static int bin2Dec(String binaryString)
    {
        if (binaryString.length() == 0)
            return 0;

        int digit = Integer.parseInt(binaryString.charAt(0) + "");
        int value = (int) (digit * (Math.pow(2, binaryString.length() - 1)));
        return bin2Dec(binaryString.substring(1)) + value;
    }
}