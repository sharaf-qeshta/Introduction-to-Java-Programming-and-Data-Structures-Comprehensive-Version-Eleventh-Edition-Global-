package chapter_seventeen;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class BitOutputStream implements AutoCloseable
{
    FileOutputStream out;
    int bits;
    int bitPos;

    public BitOutputStream(File file) throws IOException
    {
        out = new FileOutputStream(file);
    }


    public void writeBit(char bit) throws IOException
    {
        bits = bits << 1;

        if (bit == '1')
            bits = bits | 1;

        if (++bitPos == 8)
        {
            out.write(bits);
            bitPos = 0;
        }
    }


    public void writeBit(String bit) throws IOException
    {
        for (int i = 0; i < bit.length(); i++)
            writeBit(bit.charAt(i));
    }

    public void close() throws IOException
    {
        if (bitPos > 0)
        {
            bits = bits << 8 - bitPos;
            out.write(bits);
        }
        out.close();
    }
}