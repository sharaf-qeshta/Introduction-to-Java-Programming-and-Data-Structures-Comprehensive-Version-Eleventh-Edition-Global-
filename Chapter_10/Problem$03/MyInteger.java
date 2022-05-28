package chapter_ten;

public class MyInteger
{
    private int value;

    public MyInteger(int value)
    {
        this.value = value;
    }

    public int getValue()
    {
        return value;
    }

    public boolean isOdd()
    {
        return value % 2 == 1;
    }

    public static boolean isOdd(int number)
    {
        return number % 2 == 1;
    }

    public static boolean isOdd(MyInteger number)
    {
        return number.getValue() % 2 == 1;
    }

    public boolean isEven()
    {
        return value % 2 == 0;
    }

    public static boolean isEven(int number)
    {
        return number % 2 == 0;
    }

    public static boolean isEven(MyInteger number)
    {
        return number.getValue() % 2 == 0;
    }


    public boolean isPrime()
    {
        for (int i = 2; i < (value/2)+1;i++)
            if (value % i == 0)
                return false;
        return true;
    }


    public static boolean isPrime(int number)
    {
        for (int i = 2; i < (number/2)+1;i++)
            if (number % i == 0)
                return false;
        return true;
    }

    public static boolean isPrime(MyInteger number)
    {
        for (int i = 2; i < (number.getValue()/2)+1;i++)
            if (number.getValue() % i == 0)
                return false;
        return true;
    }

    public boolean equals(int otherValue)
    {
        return otherValue == value;
    }

    public boolean equals(MyInteger otherValue)
    {
        return otherValue.getValue() == value;
    }

    public static int parseInt(char[] array)
    {
        return Integer.parseInt(new String(array));
    }

    public static int parseInt(String string)
    {
        return Integer.parseInt(string);
    }
}
