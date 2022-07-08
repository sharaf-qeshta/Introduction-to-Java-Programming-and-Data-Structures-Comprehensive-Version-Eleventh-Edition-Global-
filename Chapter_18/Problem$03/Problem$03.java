package chapter_eighteen;

/**
 * *18.3 Write a recursive method public static void dec2b(double x,int b,
 * int n) that displays x, where 0 ≤ x < 1 in base b with at most n digits after
 * the decimal point. For instance, dec2b(0.625,2,10) should return 0.101, and
 * dec2b(0.625,3,10) should return 0.1212121212.
 *
 *
 * @author Sharaf Qeshta
 */
public class Problem$03
{
    public static StringBuilder number = new StringBuilder("0.");

    public static void main(String[] args)
    {
        System.out.println(dec2b(0.625, 2, 10)); // 0.101
        number = new StringBuilder("0.");
        System.out.println(dec2b(0.625, 3, 10)); // 0.1212121212
    }


    public static String dec2b(double x, int b, int n)
    {
        if (n == 0 || x == 0.0)
            return number.toString();

        int decimalPart = (int) Math.floor(x * b);
        double fractionalPart = getFractionPart(x * b);
        number.append(decimalPart);
        return dec2b(fractionalPart, b, n - 1);
    }

    public static double getFractionPart(double x)
    {
        String xString = x + "";
        xString = 0 + xString.substring(xString.indexOf("."));
        return Double.parseDouble(xString);
    }
}
