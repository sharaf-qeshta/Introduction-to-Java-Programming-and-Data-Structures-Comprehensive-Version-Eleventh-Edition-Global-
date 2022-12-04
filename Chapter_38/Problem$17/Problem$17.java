package chapter38;

import java.util.Arrays;
import java.util.HashMap;

/**
 * **38.17 (Guess capitals) Write a JSP that prompts the user to enter a capital for a state, as
 * shown in Figure 38.16a. Upon receiving the user input, the program reports whether
 * the answer is correct, as shown in Figure 38.16b. You can click the Next button to
 * display another question. You can use a two-dimensional array to store the states
 * and capitals, as proposed in Exercise 9.22. Create a list from the array and apply the
 * shuffle method to reorder the list so the questions will appear in random order.
 *
 * @author Sharaf Qeshta
 * */
public class Problem$17
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

    public static void shuffle()
    {
        for (int i = 0; i < DATA.length; i++)
        {
            int randomIndex = (int) ((Math.random() * DATA.length * 2) % DATA.length);
            String[] temp = DATA[i];
            DATA[i] = DATA[randomIndex];
            DATA[randomIndex] = temp;
        }
    }
}
