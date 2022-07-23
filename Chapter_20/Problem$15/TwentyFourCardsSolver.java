package chapter_twenty;

import java.util.*;

public class TwentyFourCardsSolver
{
    private static final ArrayList<String[]> NUMBERS_PERMUTATION = new ArrayList<>();
    private static final ArrayList<String[]> OPERATORS_PERMUTATION = new ArrayList<>();
    private static final ArrayList<String> SOLUTIONS = new ArrayList<>();
    private static final String[] OPERATORS = {"+", "-", "*", "/"};

    public static String getSolution(String[] numbers)
    {
        NUMBERS_PERMUTATION.clear();
        OPERATORS_PERMUTATION.clear();
        SOLUTIONS.clear();

        addPermutation(numbers, 0, NUMBERS_PERMUTATION);
        addPermutation(OPERATORS,0, OPERATORS_PERMUTATION);
        addSolutions();
        if (SOLUTIONS.isEmpty())
            return "No Solution";
        return translate(SOLUTIONS.get(0));
    }

    private static String translate(String postfix)
    {
        Scanner scanner = new Scanner(postfix);
        Stack<String> infix = new Stack<>();
        while (scanner.hasNext())
        {
            try
            {
                int operand = scanner.nextInt();
                infix.push(operand + "");
            }
            catch (Exception exception)
            {
                String operand1 = infix.pop();
                String operand2 = infix.pop();
                infix.push("(" + operand2 + scanner.next() + operand1 + ")");
            }
        }
        return infix.pop();
    }


    private static void addSolutions()
    {
        for (String[] numbers: NUMBERS_PERMUTATION)
        {
            for (String[] operators: OPERATORS_PERMUTATION)
            {
                String expression = numbers[0] + " " + numbers[1]
                        + " " + operators[0] + " " + numbers[2]
                        + " " + operators[1] + " " + numbers[3]
                        + " " + operators[2];
                if (evaluate(expression) == 24)
                    SOLUTIONS.add(expression);
            }
        }
    }

    private static void addPermutation(String[] array, int index,
                                      List<String[]> container)
    {
        for(int i = index; i < array.length; i++)
        {
            String temp = array[i];
            array[i] = array[index];
            array[index] = temp;

            addPermutation(array, index+1, container);

            temp = array[i];
            array[i] = array[index];
            array[index] = temp;
        }
        if (index == array.length - 1)
            container.add(array.clone());
    }


    private static int evaluate(String expression)
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
