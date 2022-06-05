package chapter_twelve;

public class CalculatorWithoutException {
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
