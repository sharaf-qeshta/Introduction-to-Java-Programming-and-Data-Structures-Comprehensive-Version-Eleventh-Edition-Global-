package chapter_one;

/**
 * 1.10 (Average speed in miles) Assume that a runner runs 15 kilometers in 50 minutes
 * and 30 seconds. Write a program that displays the average speed in miles per hour.
 * (Note that 1 mile is 1.6 kilometers.)
 *
 * @author Sharaf Qeshta */

public class Problem$10
{
    public static void main(String[] args)
    {
        // divide kilometers on 50.5 to get answer how many kilometers
        // the runner run in 1 minute
        double kmPerMinute = 15 / 50.5;
        double kmPerHour = kmPerMinute * 60;
        double milesPerHour = kmPerHour / 1.6;
        System.out.println(milesPerHour);
    }
}
