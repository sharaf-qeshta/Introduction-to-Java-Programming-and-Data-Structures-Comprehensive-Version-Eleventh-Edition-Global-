package chapter_twelve.samples;

/**
 * Listing 12.14 WriteDataWithAutoClose.java
 * */
public class WriteDataWithAutoClose
{
    public static void main(String[] args) throws java.io.FileNotFoundException
    {
        java.io.File file = new java.io.File("scores.txt");
        if (file.exists())
        {
            System.out.println("File already exists");
            System.exit(0);
        }

        try (
                // Create a file
                java.io.PrintWriter output = new java.io.PrintWriter(file);
            )
        {
            // Write formatted output to the file
            output.print("John T Smith ");
            output.println(90);
            output.print("Eric K Jones ");
            output.println(85);
        }
    }
}
