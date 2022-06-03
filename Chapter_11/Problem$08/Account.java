package chapter_eleven;

import java.util.ArrayList;
import java.util.Date;

public class Account
{
    private int id = 0;
    private double balance = 0;
    private double annualInterestRate = 0;
    private final Date DATE_CREATED = new Date();
    private String name;
    private ArrayList<Transaction> transactions = new ArrayList<>();

    public Account() { }


    public Account(int id, double balance)
    {
        this.id = id;
        this.balance = balance;
    }


    public Account(int id, double balance, String name)
    {
        this.id = id;
        this.balance = balance;
        this.name = name;
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
        Date date = new Date();
        transactions.add(new Transaction(date, 'w', amount,  name + " withdraw " + amount));
        balance -= amount;
    }

    public void deposit(double amount)
    {
        Date date = new Date();
        transactions.add(new Transaction(date, 'd', amount,  name + " deposit " + amount));
        balance += amount;
    }


    @Override
    public String toString()
    {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                ", annualInterestRate=" + annualInterestRate +
                ", name='" + name + '\'' +
                ", transactions=" + transactions +
                '}';
    }
}
