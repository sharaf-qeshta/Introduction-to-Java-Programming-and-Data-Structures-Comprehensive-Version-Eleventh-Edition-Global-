package chapter_eleven;

public class CheckingAccount extends Account
{
    private double overdraftLimit;


    public CheckingAccount(double overdraftLimit)
    {
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount)
    {
        if (this.getBalance() < overdraftLimit & amount < overdraftLimit)
            super.withdraw(amount);
    }


    @Override
    public String toString()
    {
        return "CheckingAccount{" +
                "overdraftLimit=" + overdraftLimit +
                '}';
    }
}
