package chapter_eleven;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * **11.8 (New Account class) An Account class was specified in Programming Exercise 9.7.
 * Design a new Account class as follows:
 * ■■ Add a new data field name of the String type to store the name of the
 * customer.
 * ■■ Add a new constructor that constructs an account with the specified name, id,
 * and balance.
 * ■■ Add a new data field named transactions whose type is ArrayList that
 * stores the transaction for the accounts. Each transaction is an instance of the
 * Transaction class, which is defined as shown in Figure 11.6.
 * ■ Modify the withdraw and deposit methods to add a transaction to the
 * transactions array list.
 * ■■ All other properties and methods are the same as in Programming Exercise 9.7.
 * Write a test program that creates an Account with annual interest rate 1.5%,
 * balance 1000, id 1122, and name George. Deposit $30, $40, and $50 to the
 * account and withdraw $5, $4, and $2 from the account. Print an account summary
 * that shows the account holder name, interest rate, balance, and all transactions.
 *
 * @author Sharaf Qeshta
 * */
public class Problem$08
{
    public static void main(String[] args)
    {
        Account account = new Account(1122, 1000, "George");
        account.deposit(30);
        account.deposit(40);
        account.deposit(50);

        account.withdraw(5);
        account.withdraw(4);
        account.withdraw(2);

        /*
        * Account{id=1122, balance=1109.0, annualInterestRate=0.0, name='George',
        * transactions=[Transaction{date=Fri Jun 03 09:27:00 PDT 2022, type=d, amount=30.0, Description='George deposit 30.0'},
        *  Transaction{date=Fri Jun 03 09:27:01 PDT 2022, type=d, amount=40.0, Description='George deposit 40.0'},
        *  Transaction{date=Fri Jun 03 09:27:01 PDT 2022, type=d, amount=50.0, Description='George deposit 50.0'},
        *  Transaction{date=Fri Jun 03 09:27:01 PDT 2022, type=w, amount=5.0, Description='George withdraw 5.0'},
        *  Transaction{date=Fri Jun 03 09:27:01 PDT 2022, type=w, amount=4.0, Description='George withdraw 4.0'},
        *  Transaction{date=Fri Jun 03 09:27:01 PDT 2022, type=w, amount=2.0, Description='George withdraw 2.0'}]}
        * */
        System.out.println(account);
    }
}
