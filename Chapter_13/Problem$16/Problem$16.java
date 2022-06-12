package chapter_thirteen;

import java.math.BigInteger;

/**
 * *13.16 (Create a rational-number calculator)  Write a program similar to Listing 7.9,
 * Calculator.java. Instead of using integers, use rationals, as shown in Figure 13.10.
 * You will need to use the split method in the String class, introduced in
 * Section 10.10.3, Replacing and Splitting Strings, to retrieve the numerator string
 * and denominator string, and convert strings into integers using the Integer
 * .parseInt method.
 *
 * @author Sharaf Qeshta
 * */
public class Problem$16
{
    public static void main(String[] args)
    {
        String[] content = args[0].split(" ");

        try
        {
            String[] firstNumber = content[0].split("/");
            String[] secondNumber = content[2].split("/");

            Rational r1 = new Rational(new BigInteger(firstNumber[0]),
                    new BigInteger(firstNumber[1]));
            Rational r2 = new Rational(new BigInteger(secondNumber[0]),
                    new BigInteger(secondNumber[1]));

            Rational result = switch (content[1])
            {
                case "+" -> r1.add(r2);
                case "-" -> r1.subtract(r2);
                case "/" -> r1.divide(r2);
                case "*" -> r1.multiply(r2);
                default -> throw new IllegalStateException("Unexpected value: " + content[1]);
            };

            System.out.println(args[0] + " = " + result);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}


class Drive
{
    public static void main(String[] args)
    {
        /* 3/4 + 1/5 = 19/20 */
        Problem$16.main(new String[] {"3/4 + 1/5"});

        /* 3/4 - 1/5 = 11/20 */
        Problem$16.main(new String[] {"3/4 - 1/5"});

        /* 3/4 * 1/5 = 3/20 */
        Problem$16.main(new String[] {"3/4 * 1/5"});
    }
}