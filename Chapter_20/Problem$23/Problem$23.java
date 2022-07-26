package chapter_twenty;

import java.util.Scanner;
import java.util.Stack;

/**
 * 20.23 (Evaluate expression) Modify Listing 20.12, EvaluateExpression class to make
 * all operators (+−/*) have equal precedence.For example,4+3 − 2*10
 * is 50.Write a test program that prompts the user to enter an expression and
 * displays the result.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$23
{
    public static void main(String[] args)
    {
        System.out.println(evaluateEqualPrecedence("4 + 3 - 2 * 10")); // 50
        System.out.println(evaluateEqualPrecedence("5 + 8 - 1 / 12")); // 1
        System.out.println(evaluateEqualPrecedence("3 * 5 / 5 + 1")); // 4
        System.out.println(evaluateEqualPrecedence("12 * 5 + 4 / 2")); // 32
        System.out.println(evaluateEqualPrecedence("20 / 5 + 1 / 5")); // 1
    }

    public static int evaluateEqualPrecedence(String expression)
    {
        Scanner scanner = new Scanner(expression);
        Stack<Integer> stack = new Stack<>();

        while (scanner.hasNext())
        {
            try
            {
                int value = scanner.nextInt();
                stack.push(value);
            }
            catch (Exception exception)
            {
                String operator = scanner.next();
                int operand1 = stack.pop();
                int operand2 = scanner.nextInt();
                switch (operator)
                {
                    case "+" -> stack.push(operand1 + operand2);
                    case "-" -> stack.push(operand1 - operand2);
                    case "*" -> stack.push(operand1 * operand2);
                    case "/" -> stack.push(operand1 / operand2);
                }
            }
        }
        return stack.pop();
    }
}
