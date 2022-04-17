package chapter_one;

/**
 * 1.12 (Average speed in kilometers) Assume that a runner runs 24 miles in 1 hour, 40
 * minutes, and 35 seconds. Write a program that displays the average speed in
 * kilometers per hour. (Note 1 mile is equal to 1.6 kilometers.)
 *
 * @author Sharaf Qeshta */

public class Problem$12
{
    public static void main(String[] args)
    {
        // divide miles on 100.35 (time) to get answer to how many miles
        // the runner run in 1 minute
        double milesPerMinute = 24 / 100.35;
        double milesPerHour = milesPerMinute * 60;
        double kmPerHour = milesPerHour * 1.6;
        System.out.println(kmPerHour);
    }
}
