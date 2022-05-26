package chapter_eight;

import java.util.Locale;
import java.util.Scanner;

/**
 * *8.21 (Central city) Given a set of cities, the central city is the city that has the shortest
 * total distance to all other cities. Write a program that prompts the user to enter
 * the number of cities and the locations of the cities (coordinates), and finds the
 * central city and its total distance to all other cities.
 *
 *          Enter the number of cities: 5
 *          Enter the coordinates of the cities:
 *          2.5 5 5.1 3 1 9 5.4 54 5.5 2.1
 *          The central city is at (2.5, 5.0)
 *          The total distance to all other cities is 60.81
 *
 * @author Sharaf Qeshta
 * */


public class Problem$21
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter the number of cities: ");
        int numberOfCities = scanner.nextInt();

        System.out.println("Enter the coordinates of the cities: ");
        double[][] cities = new double[numberOfCities][2];

        for (int i = 0; i < cities.length;i++)
        {
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            cities[i][0] = x;cities[i][1] = y;
        }


        double[] centralCity = getCentralCity(cities);
        System.out.println("The central city is at (" +  centralCity[0]+ ", "
                + centralCity[1] + ")");

        System.out.println("The total distance to all other cities is " + centralCity[2]);
    }

    public static double[] getCentralCity(double[][] cities)
    {
        double[] centralCity = {cities[0][0], cities[0][1],
                getTotalDistances(cities[0], cities)};
        for (double[] city : cities)
        {
            double totalDistance = getTotalDistances(city, cities);
            if (totalDistance < centralCity[2])
            {
                centralCity[0] = city[0];
                centralCity[1] = city[1];
                centralCity[2] = totalDistance;
            }
        }

        return centralCity;
    }


    public static double getTotalDistances(double[] city, double[][] cities)
    {
        double totalDistances = 0;

        for (double[] doubles : cities)
            totalDistances += getDistance(city[0], city[1],
                    doubles[0], doubles[1]);
        return totalDistances;
    }


    public static double getDistance(double x1, double y1,
                                     double x2, double y2)
    {
        return Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
    }
}
