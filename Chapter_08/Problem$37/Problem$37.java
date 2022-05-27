package chapter_eight;

import java.util.Locale;
import java.util.Scanner;

/***
 * **8.37 (Guess the capitals) Write a program that repeatedly prompts the user to enter
 * a capital for a state. Upon receiving the user input, the program reports whether
 * the answer is correct. Assume that 50 states and their capitals are stored in a
 * two-dimensional array, as shown in Figure 8.10. The program prompts the user to
 * answer all states’ capitals and displays the total correct count. The user’s answer
 * is not case-sensitive.
 * Here is a sample run:
 *
 *          What is the capital of Alabama? Montogomery
 *          The correct answer should be Montgomery
 *          What is the capital of Alaska? Juneau
 *          Your answer is correct
 *          What is the capital of Arizona? ...
 *          ...
 *          The correct count is 35
 *
 * @author Sharaf Qeshta
 * */

public class Problem$37
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        int correctAnswers = 0;

        String[][] d =
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

        for (String[] state : d)
        {
            System.out.print("What is the capital of " + state[0] + "? ");
            String answer = scanner.nextLine();

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
}
