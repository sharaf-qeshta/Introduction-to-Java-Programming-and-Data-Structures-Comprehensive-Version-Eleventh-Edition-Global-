package chapter_twelve;

public class CalculatorException {
    public static void main(String[] args)
    {
        evaluate(args[0]);
    }

    public static void evaluate(String expression)
    {
        expression = expression.trim();
        int n1 = 1, n2 = 1;
        try
        {
            n1 = Integer.parseInt(expression.charAt(0) + "");
        }
        catch (NumberFormatException exception)
        {
            System.out.println("Invalid Number " + expression.charAt(0));
            System.exit(-1);
        }

        try
        {
            n2 = Integer.parseInt(expression.charAt(expression.length()-1) + "");
        }
        catch (NumberFormatException exception)
        {
            System.out.println("Invalid Number " + expression.charAt(expression.length()-1));
            System.exit(-1);
        }

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
