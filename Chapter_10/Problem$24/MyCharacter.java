package chapter_ten;

public class MyCharacter
{
    private char value;
    public static final char MIN_VALUE = '\u0000';
    public static final char MAX_VALUE = '\uFFFF';

    public MyCharacter(char value)
    {
        this.value = value;
    }

    public char charValue()
    {
        return value;
    }

    public int compareTo(char otherChar)
    {
        return value - otherChar;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof Character)
            return value == (Character) obj;
        return false;
    }

    public int hashCode()
    {
        return value;
    }

    public String toString()
    {
        return String.valueOf(value);
    }

    public static boolean isLetter(char x)
    {
        return (x < 91 && x > 64) || (x > 96 && x < 123);
    }

    public static boolean isDigit(char x)
    {
        return x > 47 && x < 58;
    }

    public static char toUpperCase(char x)
    {
        if (x > 96 && x < 123)
            return (char) (x - 32);
        return x;
    }

    public static char toLowerCase(char x)
    {
        if (x < 91 && x > 64)
            return (char) (x + 32);
        return x;
    }
}
