package chapter_eleven;


/**
 * 11.3 (Subclasses of Account) In Programming Exercise 9.7, the Account class was
 * defined to model a bank account. An account has the properties account number,
 * balance, annual interest rate, and date created, and methods to deposit and withdraw
 * funds. Create two subclasses for checking and saving accounts. A checking
 * account has an overdraft limit, but a savings account cannot be overdrawn.
 * Draw the UML diagram for the classes and implement them. Write a test program
 * that creates objects of Account, SavingsAccount, and CheckingAccount and
 * invokes their toString() methods.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$03
{
    public static void main(String[] args)
    {
        Account account = new Account();
        CheckingAccount checkingAccount = new CheckingAccount(500);
        SavingsAccount savingsAccount = new SavingsAccount();

        /* Account{id=0} */
        System.out.println(account);

        /* SavingsAccount{} */
        System.out.println(savingsAccount);

        /* CheckingAccount{overdraftLimit=500.0} */
        System.out.println(checkingAccount);
    }
}
