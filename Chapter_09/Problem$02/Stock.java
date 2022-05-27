package chapter_nine;

public class Stock
{
    private String symbol;
    private String name;
    private double previousClosingPrice;
    private double currentPrice;

    public Stock(){}

    public Stock(String symbol, String name)
    {
        this.symbol = symbol;
        this.name = name;
    }

    public double getPreviousClosingPrice()
    {
        return previousClosingPrice;
    }

    public void setPreviousClosingPrice(double previousClosingPrice)
    {
        this.previousClosingPrice = previousClosingPrice;
    }

    public double getCurrentPrice()
    {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice)
    {
        this.currentPrice = currentPrice;
    }


    public double getChangePercent()
    {
        return (Math.abs(previousClosingPrice-currentPrice) /
                ((previousClosingPrice + currentPrice) / 2)) * 100;
    }
}
