package chapter_three;

/**
 * **3.24 (Game: pick a card) Write a program that simulates picking a card from a deck
 * of 52 cards. Your program should display the rank (Ace, 2, 3, 4, 5, 6, 7, 8, 9, 10,
 * Jack, Queen, King) and suit (Clubs, Diamonds, Hearts, Spades) of the card.
 * Here is a sample run of the program:
 *          The card you picked is Jack of Hearts
 *
 * @author Sharaf Qeshta
 * */

public class Problem$24
{
    public static String getCardName(int cardNumber)
    {
        return switch (cardNumber)
        {
            case 1 -> "Ace";
            case 11 -> "Jack";
            case 12 -> "Queen";
            case 13 -> "King";
            default -> "" + cardNumber;
        };
    }

    public static String getSuit(int index)
    {
        return switch (index)
        {
             case 0 -> "Clubs";
             case 1 -> "Diamonds";
             case 2 -> "Hearts";
             case 3 -> "Spades";
             default -> "None";
        };
    }

    public static void main(String[] args)
    {
        int randomNumber = (int) (((Math.random() * 20) %  13) + 1);
        int randomSuit = (int) ((Math.random() * 20) %  4);
        System.out.println("The card you picked is " + getCardName(randomNumber) + " of " + getSuit(randomSuit));
    }
}
