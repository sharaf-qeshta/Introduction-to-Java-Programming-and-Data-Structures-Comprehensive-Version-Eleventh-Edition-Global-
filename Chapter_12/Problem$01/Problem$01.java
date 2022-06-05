package chapter_twelve;
/**
 * *12.1 (NumberFormatException) Listing 7.9, Calculator.java, is a simple command-line
 * calculator. Note the program terminates if any operand is nonnumeric.
 * Write a program with an exception handler that deals with nonnumeric operands;
 * then write another program without using an exception handler to achieve the
 * same objective. Your program should display a message that informs the user of
 * the wrong operand type before exiting (see Figure 12.12).
 *
 * @author Sharaf Qeshta
 * */

public class Problem$01
{
    public static void main(String[] args)
    {
        CalculatorWithoutException.main(new String[]{"5 + 5x"});
        CalculatorException.main(new String[]{"1 + 5x"});
    }
}
