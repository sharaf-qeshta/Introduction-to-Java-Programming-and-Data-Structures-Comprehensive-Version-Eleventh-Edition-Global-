package chapter_twelve;


import java.util.Scanner;

/**
 * *12.8 (HexFormatException) Programming Exercise 12.6 implements the hex2Dec
 * method to throw a NumberFormatException if the string is not a hex string.
 * Define a custom exception called HexFormatException. Implement the hex2Dec
 * method to throw a HexFormatException if the string is not a hex string
 * */
public class Problem$08
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a hex number: ");
        String hex = scanner.nextLine();

        try
        {
            System.out.println("The decimal value for hex number "
                    + hex + " is " + hexToDecimal(hex.toUpperCase()));
        }
        catch (HexFormatException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public static int hexToDecimal(String hex) throws HexFormatException
    {
        int decimalValue = 0;

        for (int i = 0; i < hex.length(); i++)
        {
            char hexChar = hex.charAt(i);
            /* 65 => 'A'; 71 => 'F'; */
            if (!Character.isDigit(hexChar)  && (hexChar < 65 || hexChar > 71))
                throw new HexFormatException(hexChar + " is not a valid hex digit");

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
