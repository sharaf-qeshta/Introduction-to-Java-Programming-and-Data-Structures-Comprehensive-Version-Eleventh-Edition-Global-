package chapter_twelve;

/**
 * *12.4 (IllegalArgumentException) Modify the Loan class in Listing 10.2 to
 * throw IllegalArgumentException if the loan amount, interest rate, or
 * number of years is less than or equal to zero.
 *
 * @author Sharaf Qeshta
 * */
public class Problem$04
{
    public static void main(String[] args)
    {
        /* will throw IllegalArgumentException */
        Loan loan = new Loan(-1, -1, -1);
    }
}
