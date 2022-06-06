package chapter_twelve;


/**
 * *12.7 (Checked Exception) In preparation for a class Fraction, create a class
 * NullDenominatorException that must be a checked exception whose
 * instances are thrown if the denominator of an object of class Fraction is 0.
 *
 * @author Sharaf Qeshta
 * */
public class Problem$07
{
    public static void main(String[] args)
    {
        try
        {
            Fraction fraction = new Fraction(0, 1);
        }
        catch (NullDenominatorException exception)
        {
            System.out.println("Denominator cannot be zero");
        }
    }
}
