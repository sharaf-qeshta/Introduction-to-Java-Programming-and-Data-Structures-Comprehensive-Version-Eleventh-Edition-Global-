package chapter_twelve;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * *12.31 (Baby name popularity ranking) The popularity ranking of baby names from
 * years 2001 to 2010 is downloaded from www.ssa.gov/oact/babynames and stored
 * in files named babynameranking2001.txt, babynameranking2002.txt,  .  .  .  ,
 * babynameranking2010.txt. You can download these files using the URL such
 * as http://liveexample.pearsoncmg.com/data/babynamesranking2001.txt. Each file
 * contains 1,000 lines. Each line contains a ranking, a boy’s name, number for the
 * boy’s name, a girl’s name, and number for the girl’s name. For example, the first
 * two lines in the file babynameranking2010.txt are as follows:
 * 1 Jacob 21,875 Isabella 22,731
 * 2 Ethan 17,866 Sophia 20,477
 * Therefore, the boy’s name Jacob and girl’s name Isabella are ranked #1 and the
 * boy’s name Ethan and girl’s name Sophia are ranked #2; 21,875 boys are named
 * Jacob, and 22,731 girls are named Isabella. Write a program that prompts the
 * user to enter the year, gender, followed by a name, and displays the ranking of
 * the name for the year. Here is a sample run:
 *
 *          Enter the year: 2010
 *          Enter the gender: M
 *          Enter the name: Javier
 *          Javier is ranked #190 in year 2010
 *
 *          Enter the year: 2010
 *          Enter the gender: F
 *          Enter the name: ABC
 *          The name ABC is not ranked in year 2010
 *
 * @author Sharaf Qeshta
 * */
public class Problem$31
{
    public static void main(String[] args)
            throws MalformedURLException
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the year: ");
        int year = scanner.nextInt();

        System.out.print("Enter the gender: ");
        char gender = scanner.next().charAt(0);

        System.out.print("Enter the name: ");
        String name = scanner.next();

        URL url = new URL("http://liveexample.pearsoncmg.com/data/babynamesranking"
                + year + ".txt");

        try (Scanner input = new Scanner(url.openStream()))
        {
            while (input.hasNext())
            {
                String line = input.nextLine();
                StringTokenizer tokenizer = new StringTokenizer(line);
                int rank = Integer.parseInt(tokenizer.nextToken());
                String boyName = tokenizer.nextToken();
                tokenizer.nextToken();

                if ( (tokenizer.nextToken().equals(name) && gender == 'F')
                        || (boyName.equals(name) && gender == 'M') )
                {
                    System.out.println(name + " is ranked #" + rank + " in year " + year);
                    System.exit(0);
                }
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }

        System.out.println("The name " + name +  " is not ranked in year " + year);
    }
}
