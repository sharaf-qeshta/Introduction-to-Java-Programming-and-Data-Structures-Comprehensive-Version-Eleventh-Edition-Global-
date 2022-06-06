package chapter_twelve;

import java.util.Scanner;

/**
 * *12.6 (NumberFormatException) Listing 6.8 implements the hex2Dec(String
 * hexString) method, which converts a hex string into a decimal number.
 * Implement the hex2Dec method to throw a NumberFormatException if the
 * string is not a hex string.
 *
 * @author Sharaf Qeshta
 * */
public class Problem$06
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a hex number: ");
        String hex = input.nextLine();

        try
        {
            System.out.println("The decimal value for hex number "
                    + hex + " is " + hexToDecimal(hex.toUpperCase()));
        }
        catch (NumberFormatException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public static int hexToDecimal(String hex)
    {
        int decimalValue = 0;

        for (int i = 0; i < hex.length(); i++)
        {
            char hexChar = hex.charAt(i);
            /* 65 => 'A'; 71 => 'F'; */
            if (!Character.isDigit(hexChar)  && (hexChar < 65 || hexChar > 71))
                throw new NumberFormatException(hexChar + " is not a valid hex digit");

            decimalValue = decimalValue * 16 + hexCharToDecimal(hexChar);
        }
        return decimalValue;
    }


    public static int hexCharToDecimal(char ch)
    {
        if (ch >= 'A' && ch <= 'F')
            return 10 + ch - 'A';
        else // ch is '0', '1', ..., or '9'
            return ch - '0';
    }
}
