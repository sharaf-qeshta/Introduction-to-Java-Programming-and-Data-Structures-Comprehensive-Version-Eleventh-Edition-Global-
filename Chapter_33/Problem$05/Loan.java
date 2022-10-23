package chapter_thirty_three;

import java.io.Serializable;

public class Loan implements Serializable
{
    private double interestRate;
    private int years;
    private double amount;

    public Loan(double interestRate, int years,
                double amount)
    {
        this.interestRate = interestRate;
        this.years = years;
        this.amount = amount;
    }

    public double getInterestRate()
    {
        return interestRate;
    }

    public int getYears()
    {
        return years;
    }

    public double getAmount()
    {
        return amount;
    }
}
