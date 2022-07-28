package chapter_twenty_one;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * **21.9 (Guess the capitals using maps) Rewrite Programming Exercise 8.37 to store
 * pairs of each state and its capital in a map. Your program should prompt the user
 * to enter a state, and should display the capital for the state
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$09
{
    public static String[][] DATA = {
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
            {"Wyoming", "Cheyenne"}};

    public static void main(String[] args)
    {
        // add data to a map
        Map<String, String> states = new HashMap<>();
        for (String[] state: DATA)
            states.put(state[0], state[1]);

        Scanner scanner = new Scanner(System.in);
        while (true)
        {
            System.out.println("Enter Q to Quit!");
            System.out.print("Enter State Name: ");
            String stateName = scanner.next();

            if (stateName.equalsIgnoreCase("q"))
                System.exit(0);

            if (states.containsKey(stateName))
                System.out.println("\nThe Capital of " + stateName + " is " + states.get(stateName));
            else
                System.out.println("Invalid State Name " + stateName);
        }
    }
}
