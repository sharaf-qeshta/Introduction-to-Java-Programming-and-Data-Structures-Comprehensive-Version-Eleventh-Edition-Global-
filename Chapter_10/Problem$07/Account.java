package chapter_ten;

import java.util.Date;

public class Account
{
    private int id = 0;
    private double balance = 0;
    private double annualInterestRate = 0;
    private final Date DATE_CREATED = new Date();

    public Account() { }


    public Account(int id, double balance)
    {
        this.id = id;
        this.balance = balance;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public double getBalance()
    {
        return balance;
    }

    public void setBalance(double balance)
    {
        this.balance = balance;
    }

    public double getAnnualInterestRate()
    {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate)
    {
        this.annualInterestRate = annualInterestRate;
    }

    public Date getDATE_CREATED()
    {
        return DATE_CREATED;
    }

    private double getMonthlyInterestRate()
    {
        return annualInterestRate / 12;
    }

    public double getMonthlyInterest()
    {
        return getMonthlyInterestRate() * balance;
    }

    public void withdraw(double amount)
    {
        balance -= amount;
    }

    public void deposit(double amount)
    {
        balance += amount;
    }
}
