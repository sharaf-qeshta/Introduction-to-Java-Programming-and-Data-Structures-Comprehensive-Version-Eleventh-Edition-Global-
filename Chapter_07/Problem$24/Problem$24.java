package chapter_seven;

/**
 * **7.24 (Simulation: coupon collector’s problem) Coupon collector is a classic statistics
 * problem with many practical applications. The problem is to repeatedly pick
 * objects from a set of objects and find out how many picks are needed for all the
 * objects to be picked at least once. A variation of the problem is to pick cards from
 * a shuffled deck of 52 cards repeatedly, and find out how many picks are needed
 * before you see one of each suit. Assume a picked card is placed back in the deck
 * before picking another. Write a program to simulate the number of picks needed
 * to get four cards from each suit and display the four cards picked (it is possible a
 * card may be picked twice). Here is a sample run of the program:
 *
 *      Queen of Spades
 *      5 of Clubs
 *      Queen of Hearts
 *      4 of Diamonds
 *      Number of picks: 12
 *
 * @author Sharaf Qeshta
 * */


public class Problem$24
{
    public static void main(String[] args)
    {
        int[] deck = new int[52];
        int[] picks = new int[4];

        // Initialize the cards
        for (int i = 0; i < deck.length; i++)
            deck[i] = i;

        // Shuffle the cards
        shuffleCards(deck);

        int count = 0; // number of picks
        do
        {
            pickCards(deck, picks);
            count++;
        } while (!isOneOFEachSuit(picks));

        // Display the four cards picked
        print(picks);

        // Display the number of picks needed to get four cards from each suit
        System.out.println("Number of picks: " + count);
    }

    public static void shuffleCards(int[] deck)
    {
        for (int i = 0; i < deck.length; i++) {
            // Generate an index randomly
            int index = pickCards(deck);
            int temp = deck[i];
            deck[i] = deck[index];
            deck[index] = temp;
        }
    }

    public static void pickCards(int[] deck, int[] picks)
    {
        for (int i = 0; i < picks.length; i++)
            picks[i] = deck[pickCards(deck)];
    }

    public static int pickCards(int[] deck)
    {
        return (int)(Math.random() * deck.length);
    }

    public static boolean isOneOFEachSuit(int[] picks)
    {
        for (int i = 0; i < picks.length; i++)
        {
            for (int j = 0; j < picks.length; j++)
            {
                if (i != j && (picks[i] / 13 == picks[j] / 13))
                    return false;
            }
        }
        return true;
    }

    public static void print(int[] picks)
    {
        String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9",
                "10", "Jack", "Queen", "King"};

        for (int pick : picks)
            System.out.println(ranks[pick % 13] + " of " + suits[pick / 13]);
    }
}
