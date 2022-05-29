package chapter_ten;


import java.util.Locale;
import java.util.Scanner;

/**
 * **10.7 (Game: ATM machine) Use the Account class created in Programming Exercise
 * 9.7 to simulate an ATM machine. Create 10 accounts in an array with id 0,
 * 1, . . . , 9, and an initial balance of $100. The system prompts the user to enter
 * an id. If the id is entered incorrectly, ask the user to enter a correct id. Once an
 * id is accepted, the main menu is displayed as shown in the sample run. You can
 * enter choice 1 for viewing the current balance, 2 for withdrawing money, 3 for
 * depositing money, and 4 for exiting the main menu. Once you exit, the system
 * will prompt for an id again. Thus, once the system starts, it will not stop.
 *
 *
 *              Enter an id: 4
 *              Main menu
 *              1: check balance
 *              2: withdraw
 *              3: deposit
 *              4: exit
 *              Enter a choice: 1
 *              The balance is 100.0
 *              Main menu
 *              1: check balance
 *              2: withdraw
 *              3: deposit
 *              4: exit
 *              Enter a choice: 2
 *              Enter an amount to withdraw: 3
 *              Main menu
 *              1: check balance
 *              2: withdraw
 *              3: deposit
 *              4: exit
 *              Enter a choice: 1
 *              The balance is 97.0
 *              Main menu
 *              1: check balance
 *              2: withdraw
 *              3: deposit
 *              4: exit
 *              Enter a choice: 3
 *              Enter an amount to deposit: 10
 *              Main menu
 *              1: check balance
 *              2: withdraw
 *              3: deposit
 *              4: exit
 *              Enter a choice: 1
 *              The balance is 107.0
 *              Main menu
 *              1: check balance
 *              2: withdraw
 *              3: deposit
 *              4: exit
 *              Enter a choice: 4
 *              Enter an id:
 *
 * @author Sharaf Qeshta
 * */

public class Problem$07
{
    public static Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

    public static void main(String[] args)
    {
        Account[] accounts = new Account[10];
        accounts[0] = new Account(0, 0);
        accounts[1] = new Account(1, 0);
        accounts[2] = new Account(2, 0);
        accounts[3] = new Account(3, 0);
        accounts[4] = new Account(4, 0);
        accounts[5] = new Account(5, 0);
        accounts[6] = new Account(6, 0);
        accounts[7] = new Account(7, 0);
        accounts[8] = new Account(8, 0);
        accounts[9] = new Account(9, 0);

        while (true)
        {
            System.out.print("Enter an id: ");
            int id = scanner.nextInt();

            if (isValidAccount(id))
            {
                while (true)
                {
                    System.out.println("Main menu\n" +
                            "1: check balance\n" +
                            "2: withdraw\n" +
                            "3: deposit\n" +
                            "4: exit");
                    System.out.print("Enter a choice: ");
                    int choice = scanner.nextInt();
                    start(accounts[id], choice);
                    if (choice == 4)
                        break;
                }
            }
            else
                System.out.println("Invalid Id!!");
        }
    }


    public static boolean isValidAccount(int id)
    {
        return id > -1 & id < 10;
    }


    public static void start(Account account, int choice)
    {
        if (choice == 1)
            System.out.println("The balance is " + account.getBalance());
        else if (choice == 2)
        {
            System.out.print("Enter an amount to withdraw: ");
            double amount = scanner.nextDouble();
            account.withdraw(amount);
        }
        else if (choice == 3)
        {
            System.out.print("Enter an amount to deposit: ");
            double amount = scanner.nextDouble();
            account.deposit(amount);
        }
        else if (choice == 4)
            return;
        else
            System.out.println("Wrong Choice");
    }
}
