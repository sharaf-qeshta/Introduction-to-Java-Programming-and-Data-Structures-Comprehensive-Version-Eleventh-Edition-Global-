package chapter_ten;

/**
 * *10.26 (Calculator) Revise Listing 7.9, Calculator.java, to accept an expression as a
 * string in which the operands and operator are separated by zero or more spaces.
 * For example, 3+4 and 3 + 4 are acceptable expressions. Here is a sample run:
 *
 *          "4+5"
 *           4 + 5 = 9
 *
 *           "4 + 5"
 *           4 + 5 = 9
 *
 *           "4 +    5"
 *           4 + 5 = 9
 *
 *           "4 *  5"
 *           4 * 5 = 20
 *
 * @author Sharaf Qeshta
 * */

public class Problem$26
{
    public static void main(String[] args)
    {
        evaluate(args[0]);
    }

    public static void evaluate(String expression)
    {
        expression = expression.trim();
        int n1 = Integer.parseInt(expression.charAt(0) + "");
        int n2 = Integer.parseInt(expression.charAt(expression.length()-1) + "");

        if (expression.contains("+"))
            System.out.println(n1 + " + " + n2 + " = " + (n1 + n2));
        else if (expression.contains("*"))
            System.out.println(n1 + " * " + n2 + " = " + (n1 * n2));
        else if (expression.contains("/"))
            System.out.println(n1 + " / " + n2 + " = " + (n1 / n2));
        else
            System.out.println(n1 + " - " + n2 + " = " + (n1 - n2));
    }
}


class Test
{
    public static void main(String[] args)
    {
        Problem$26.main(new String[] {"5 + 5 "}); // 5 + 5 = 10
        Problem$26.main(new String[] {"5 *2 "}); // 5 * 2 = 10
        Problem$26.main(new String[] {"5 -5 "}); // 5 - 5 = 0
        Problem$26.main(new String[] {"5 /   5 "}); // 5 / 5 = 1
        Problem$26.main(new String[] {" 5+12 "}); // 5 + 2 = 7
        Problem$26.main(new String[] {"8+    7 "}); // 8 + 7 = 15
    }
}

