package chapter_twenty;

import java.util.Locale;
import java.util.Scanner;

/**
 * *20.3 (Guessing the capitals) Rewrite Programming Exercise 8.37 to store the pairs
 * of states and capitals so that the questions are displayed randomly
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$03
{
    public static final String[][] data =
            {
                    {"Alabama", "Montgomery"}, {"Alaska", "Juneau"}, {"Arizona", "Phoenix"},
                    {"Arkansas", "Little Rock"}, {"California", "Sacramento"},
                    {"Colorado", "Denver"}, {"Connecticut", "Hartford"},
                    {"Delaware", "Dover"}, {"Florida", "Tallahassee"},
                    {"Georgia", "Atlanta"},{"Hawaii", "Honolulu"}, {"Idaho", "Boise"},
                    {"Illinois", "Springfield"}, {"Indiana", "Indianapolis"},
                    {"Iowa Des", "Moines"}, {"Kansas", "Topeka"}, {"Kentucky","Frankfort"},
                    {"Louisiana", "Baton Rouge"}, {"Maine", "Augusta"},
                    {"Maryland", "Annapolis"}, {"Massachusetts", "Boston"},
                    {"Michigan", "Lansing"}, {"Minnesota", "Saint Paul"},
                    {"Mississippi", "Jackson"}, {"Missouri", "Jefferson City"},
                    {"Montana", "Helena"}, {"Nebraska", "Lincoln"},
                    {"Nevada", "Carson City"}, {"New Hampshire", "Concord"},
                    {"New Jersey", "Trenton"}, {"New Mexico", "Santa Fe"},
                    {"New York", "Albany"}, {"North Carolina", "Raleigh"},
                    {"North Dakota", "Bismarck"},{"Ohio", "Columbus"},
                    {"Oklahoma", "Oklahoma City"}, {"Oregon", "Salem"},
                    {"Pennsylvania", "Harrisburg"}, {"Rhode Island", "Providence"},
                    {"South Carolina", "Columbia"}, {"South Dakota", "Pierre"},
                    {"Tennessee", "Nashville"}, {"Texas", "Austin"},
                    {"Utah", "Salt Lake City"}, {"Vermont", "Montpelier"},
                    {"Virginia", "Richmond"}, {"Washington", "Olympia"},
                    {"West Virginia", "Charleston"}, {"Wisconsin", "Madison"},
                    {"Wyoming", "Cheyenne"}
            };

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        int correctAnswers = 0;

        shuffle();

        for (String[] state : data)
        {
            System.out.print("What is the capital of " + state[0] + "? ");
            String answer = scanner.next();

            if (answer.equals(state[1]))
            {
                System.out.println("Your answer is correct");
                correctAnswers++;
            }
            else
                System.out.println("The correct answer should be " + state[1]);
        }

        System.out.println("The correct count is " + correctAnswers);
    }

    private static void shuffle()
    {
        for (int i = 0; i < data.length; i++)
        {
            int index1 = (int) ((Math.random() * data.length * 2) % data.length);
            String[] temp = data[index1];
            Problem$03.data[index1] = data[i];
            Problem$03.data[i] = temp;
        }
    }
}
