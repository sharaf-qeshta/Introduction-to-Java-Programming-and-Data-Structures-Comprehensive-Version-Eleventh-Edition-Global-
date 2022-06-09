package chapter_twelve;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * *12.24 (Create large dataset) Create a data file with 1,000 lines. Each line in the file
 * consists of a faculty member’s first name, last name, rank, and salary. The
 * faculty member’s first name and last name for the ith line are FirstNamei and
 * LastNamei. The rank is randomly generated as assistant, associate, and full.
 * The salary is randomly generated as a number with two digits after the decimal
 * point. The salary for an assistant professor should be in the range from 50,000
 * to 80,000, for associate professor from 60,000 to 110,000, and for full professor
 * from 75,000 to 130,000. Save the file in Salary.txt. Here are some sample data:
 * FirstName1 LastName1 assistant 60055.95
 * FirstName2 LastName2 associate 81112.45
 * . . .
 * FirstName1000 LastName1000 full 92255.21
 *
 * @author Sharaf Qeshta
 * */
public class Problem$24
{
    public static String[] positions = { "assistant", "associate", "full" };
    public static double[][] positionsSalary =
    {
            {50000, 80000},
            {60000, 110000},
            {75000, 130000}
    };
    public static final String FILE_PATH = "src/chapter_twelve/data.txt";

    public static void main(String[] args)
    {
        List<String> data = generateRandomData(1000);
        writeIn(new File(FILE_PATH), data);
    }

    public static List<String> generateRandomData(int size)
    {
        List<String> data = new ArrayList<>();

        for (int i = 1; i < size+1;i++)
        {
            int randomIndex = (int) ((Math.random() * 10) % 3);

            double randomSalary =((Math.random() * 200000) %
                    (positionsSalary[randomIndex][1] - positionsSalary[randomIndex][0]))
                    + positionsSalary[randomIndex][0];

            String formattedSalary = String.format("%,.2f", randomSalary);

            // aligning text in the file
            String firstName = String.format("%-30s", "FirstName" + i);
            String lastName = String.format("%-30s", " LastName" + i + " ");
            String position = String.format("%-30s", positions[randomIndex] + " ");

            String line =  firstName +  lastName +
                     position + formattedSalary;

            data.add(line);
        }
        return data;
    }


    public static void writeIn(File file, List<String> data)
    {
        try (PrintWriter writer = new PrintWriter(file))
        {
            for (String line: data)
                writer.println(line);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
