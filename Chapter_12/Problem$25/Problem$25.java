package chapter_twelve;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * *12.25 (Process large dataset) A university posts its employees’ salaries at http://
 * liveexample.pearsoncmg.com/data/Salary.txt. Each line in the file consists of
 * a faculty member’s first name, last name, rank, and salary (see Programming
 * Exercise 12.24). Write a program to display the total salary for assistant professors,
 * associate professors, full professors, and faculty, respectively, and display
 * the average salary for assistant professors, associate professors, full professors,
 * and faculty, respectively.
 *
 * @author Sharaf Qeshta
 * */
public class Problem$25
{
    public static final String LINK = "http://liveexample.pearsoncmg.com/data/Salary.txt";
    public static void main(String[] args)
            throws MalformedURLException
    {
        URL url = new URL(LINK);

        List<String> content = getAllContent(url);
        List<ArrayList<Double>> lists = getAllInfo(content);

        /*
        * sum: 3.567805140999998E7, average: 102229.37366762172
        * sum: 2.8844146580000006E7, average: 83849.2633139535
        * sum: 2.024651191000001E7, average: 65949.55019543978
        * */
        for (ArrayList<Double> list: lists)
        {
            double sum = 0;
            for (double value: list)
                sum += value;
            System.out.println("sum: " + sum  + ", average: " + (sum/list.size()));
        }
    }

    public static List<String> getAllContent(URL url)
    {
        List<String> elements = new ArrayList<>();
        try (Scanner scanner = new Scanner(url.openStream()))
        {
            while (scanner.hasNext())
                elements.add(scanner.nextLine());
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        return elements;
    }

    public static ArrayList<ArrayList<Double>> getAllInfo(List<String> content)
    {
        ArrayList<ArrayList<Double>> lists = new ArrayList<>();

        ArrayList<Double> fullSalaries = new ArrayList<>();
        ArrayList<Double> associateSalaries = new ArrayList<>();
        ArrayList<Double> assistantSalaries = new ArrayList<>();

        for (String x: content){
            String[] row = x.split(" ");
            double salary = Double.parseDouble(row[3]);

            if (x.contains("full"))
                fullSalaries.add(salary);
            else if (x.contains("associate"))
                associateSalaries.add(salary);
            else
                assistantSalaries.add(salary);
        }
        lists.add(fullSalaries); lists.add(associateSalaries); lists.add(assistantSalaries);
        return lists;
    }
}
