package chapter_nine;

/**
 * 9.2 (The Stock class) Following the example of the Circle class in Section 9.2,
 * design a class named Stock that contains:
 * ■■ A string data field named symbol for the stock’s symbol.
 * ■■ A string data field named name for the stock’s name.
 * ■■ A double data field named previousClosingPrice that stores the stock
 * price for the previous day.
 * ■■ A double data field named currentPrice that stores the stock price for the
 * current time.
 * ■■ A constructor that creates a stock with the specified symbol and name.
 * ■■ A method named getChangePercent() that returns the percentage changed
 * from previousClosingPrice to currentPrice.
 * Draw the UML diagram for the class then implement the class. Write a test
 * program that creates a Stock object with the stock symbol ORCL, the name Oracle
 * Corporation, and the previous closing price of 34.5. Set a new current price to
 * 34.35 and display the price-change percentage.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$02
{
    public static void main(String[] args)
    {
        Stock stock = new Stock("ORCL", "Oracle Corporation");
        stock.setPreviousClosingPrice(34.5);
        stock.setCurrentPrice(34.35);
        System.out.println(stock.getChangePercent()); // 0.43572984749454924
    }
}
