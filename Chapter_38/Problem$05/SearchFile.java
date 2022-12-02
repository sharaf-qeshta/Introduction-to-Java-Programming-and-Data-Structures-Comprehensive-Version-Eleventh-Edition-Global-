package chapter38;

import java.io.File;
import java.util.Scanner;

public class SearchFile
{
    private static final String FOLDER_PATH = "src/main/java/chapter38/";
    private String course;
    private String ssn;

    private String grade, name;

    public SearchFile(String course, String ssn)
    {
        this.ssn = ssn.trim();
        this.course = course;
        search();
    }

    public void search()
    {
        try (Scanner scanner = new Scanner(new File(FOLDER_PATH + course + ".txt")))
        {
            while (scanner.hasNext())
            {
                String line = scanner.nextLine();
                String[] data = line.split(" ");
                if (data[1].equals(ssn))
                {
                    grade = data[2];
                    name = data[0];
                    break;
                }
            }
        }
        catch(Exception exception)
        {
            grade = "not found";
            name = "not found";
        }
    }

    public String getGrade()
    {
        return grade;
    }

    public String getName()
    {
        return name;
    }
}
