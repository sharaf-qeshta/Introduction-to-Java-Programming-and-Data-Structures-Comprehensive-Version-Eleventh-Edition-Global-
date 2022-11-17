package chapter_thirty_six;

import java.io.PrintWriter;

public class Problem$11Writer
{
    public static final String FILE_PATH = "src/chapter_thirty_six/Problem$11.gb";
    public static final String ENCODING = "GB18030";
    public static void main(String[] args)
    {
        try(PrintWriter printWriter = new PrintWriter(FILE_PATH, ENCODING))
        {
            char currentChar = '\u0E00';
            for (int i = 0; i < 1307; i++)
            {
                for (int j = 0; j < 16; j++)
                {
                    printWriter.write(currentChar + " ");
                    currentChar++;
                }
                printWriter.write("\n");
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
