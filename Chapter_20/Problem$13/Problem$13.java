package chapter_twenty;

import java.util.Scanner;
import java.util.Stack;

/**
 * **20.13 (Postfix notation) Postfix notation is a way of writing expressions without
 * using parentheses. For example, the expression (1 + 2) * 3 would be
 * written as 1 2 + 3 *. A postfix expression is evaluated using a stack. Scan
 * a postfix expression from left to right. A variable or constant is pushed into
 * the stack. When an operator is encountered, apply the operator with the top
 * two operands in the stack and replace the two operands with the result. The
 * following diagram shows how to evaluate 1 2 + 3 *.
 *
 * Write a program to evaluate postfix expressions. Pass the expression as a
 * command-line argument in one string.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$13
{
    public static void main(String[] args)
    {
        System.out.println(evaluate(args[0]));
    }

    public static int evaluate(String expression)
    {
        Stack<Integer> stack = new Stack<>();
        Scanner scanner = new Scanner(expression);
        while (scanner.hasNext())
        {
            try
            {
                int number = scanner.nextInt();
                stack.push(number);
            }
            catch (Exception exception)
            {
                String operator = scanner.next();
                switch (operator)
                {
                    case "+" ->
                    {
                        int result = stack.get(0) + stack.get(1);
                        stack.clear();
                        stack.push(result);
                    }
                    case "-" ->
                    {
                        int result = stack.get(0) - stack.get(1);
                        stack.clear();
                        stack.push(result);
                    }
                    case "*" ->
                    {
                        int result = stack.get(0) * stack.get(1);
                        stack.clear();
                        stack.push(result);
                    }
                    case "/" ->
                    {
                        int result = stack.get(0) / stack.get(1);
                        stack.clear();
                        stack.push(result);
                    }
                }
            }
        }

        return stack.get(0);
    }
}

class Drive
{
    public static void main(String[] args)
    {
        Problem$13.main(new String[] {"1 2 + 3 *"}); // 9
        Problem$13.main(new String[] {"5 2 * 1 +"}); // 11
        Problem$13.main(new String[] {"8 2 / 5 *"}); // 20
        Problem$13.main(new String[] {"8 2 / 5 * 2 +"}); // 22
        Problem$13.main(new String[] {"25 5 / 5 * 2 +"}); // 27
        Problem$13.main(new String[] {"144 12 / 5 * 2 +"}); // 62
        Problem$13.main(new String[] {"144 12 / 12 * 2 +"}); // 146
    }
}
