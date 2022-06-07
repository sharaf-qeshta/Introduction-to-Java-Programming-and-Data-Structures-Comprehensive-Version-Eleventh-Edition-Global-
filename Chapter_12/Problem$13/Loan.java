package chapter_twelve;

public class Loan
{
    private double annualInterestRate;
    private int numberOfYears;
    private double loanAmount;
    private java.util.Date loanDate;

    /** No-arg constructor */
    public Loan()
    {
        this(2.5, 1, 1000);
    }

    /** Construct a loan with specified annual interest rate,
     number of years, and loan amount
     */
    public Loan(double annualInterestRate, int numberOfYears,
                double loanAmount)
    {
        if (loanAmount <= 0 || numberOfYears <= 0 || annualInterestRate <= 0)
            throw new IllegalArgumentException();
        this.annualInterestRate = annualInterestRate;
        this.numberOfYears = numberOfYears;
        this.loanAmount = loanAmount;
        loanDate = new java.util.Date();
    }

    /** Return annualInterestRate */
    public double getAnnualInterestRate()
    {
        return annualInterestRate;
    }

    /** Set a new annualInterestRate */
    public void setAnnualInterestRate(double annualInterestRate)
    {
        if (annualInterestRate <= 0)
            throw new IllegalArgumentException();
        this.annualInterestRate = annualInterestRate;
    }

    /** Return numberOfYears */
    public int getNumberOfYears()
    {
        return numberOfYears;
    }

    /** Set a new numberOfYears */
    public void setNumberOfYears(int numberOfYears)
    {
        if (numberOfYears <= 0)
            throw new IllegalArgumentException();
        this.numberOfYears = numberOfYears;
    }

    /** Return loanAmount */
    public double getLoanAmount()
    {
        return loanAmount;
    }

    /** Set a newloanAmount */
    public void setLoanAmount(double loanAmount)
    {
        if (loanAmount <= 0)
            throw new IllegalArgumentException();
        this.loanAmount = loanAmount;
    }

    /** Find monthly payment */
    public double getMonthlyPayment()
    {
        double monthlyInterestRate = annualInterestRate / 1200;
        double monthlyPayment = loanAmount * monthlyInterestRate / (1 -
                (1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12)));
        return monthlyPayment;
    }

    /** Find total payment */
    public double getTotalPayment()
    {
        double totalPayment = getMonthlyPayment() * numberOfYears * 12;
        return totalPayment;
    }

    /** Return loan date */
    public java.util.Date getLoanDate()
    {
        return loanDate;
    }
}
