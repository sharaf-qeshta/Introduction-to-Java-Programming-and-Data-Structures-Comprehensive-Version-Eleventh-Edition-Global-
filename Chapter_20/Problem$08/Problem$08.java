package chapter_twenty;

import java.util.*;

/**
 * **20.8 (Game: lottery) Revise Programming Exercise 3.15 to add an additional $2,000
 * award if two digits from the user input are in the lottery number. (Hint: Sort
 * the three digits in the lottery number and three digits in the user input into two
 * lists, and use the Collection’s containsAll method to check whether the
 * two digits in the user input are in the lottery number.)
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$08
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        List<Integer> lotteryNumber = new ArrayList<>();
        lotteryNumber.add((int) (Math.random() * 9));
        lotteryNumber.add((int) (Math.random() * 9));
        lotteryNumber.add((int) (Math.random() * 9));

        List<Integer> userGuess = new ArrayList<>();

        System.out.print("Enter your guess: ");
        int guess = scanner.nextInt();

        userGuess.add(guess % 10);
        guess /= 10;
        userGuess.add(guess % 10);
        userGuess.add(guess / 10);


        if (userGuess.equals(lotteryNumber))
            System.out.println("Exact match: you win $12,000");
        else if (lotteryNumber.containsAll(userGuess))
            System.out.println("All digits match: you win $5,000");
        else
        {
            Collections.sort(lotteryNumber);
            Collections.sort(userGuess);

            List<Integer> list1 = Arrays.asList(userGuess.get(0), userGuess.get(1));
            List<Integer> list2 = Arrays.asList(userGuess.get(1), userGuess.get(2));
            List<Integer> list3 = Arrays.asList(userGuess.get(2), userGuess.get(0));

            if (lotteryNumber.containsAll(list1)
                    || lotteryNumber.containsAll(list2)
                    || lotteryNumber.containsAll(list3))
                System.out.println("Two digits match: you win $3,000");
            else
                System.out.println("There`s no match");
        }

        System.out.println();
        System.out.print("The lottery Number is ");
        lotteryNumber.forEach(System.out::print);
    }
}
