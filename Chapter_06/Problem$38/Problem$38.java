package chapter_six;

/**
 * *6.38 (Generate random characters) Use the methods in RandomCharacter in Listing
 * 6.10 to print 200 uppercase letters and then 200 single digits, printing ten per line.
 *
 * @author Sharaf Qeshta
 * */


public class Problem$38
{
    public static void main(String[] args)
    {
        for (int i = 0; i < 400; i++)
        {
            if (i % 10 == 0)
                System.out.println();

            if (i > 199)
                System.out.print(getRandomDigitCharacter());
            else
                System.out.print(getRandomUpperCaseLetter());
        }
    }

    public static char getRandomCharacter(char ch1, char ch2)
    {
        return (char) (ch1 + Math.random() * (ch2 - ch1 + 1));
    }

    public static char getRandomLowerCaseLetter()
    {
        return getRandomCharacter('a', 'z');
    }


    public static char getRandomUpperCaseLetter()
    {
        return getRandomCharacter('A', 'Z');
    }

    public static char getRandomDigitCharacter()
    {
        return getRandomCharacter('0', '9');
    }

    public static char getRandomCharacter()
    {
        return getRandomCharacter('\u0000', '\uFFFF');
    }

}
