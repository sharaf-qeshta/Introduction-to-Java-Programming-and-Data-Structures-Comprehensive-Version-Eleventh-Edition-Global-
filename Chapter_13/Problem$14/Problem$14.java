package chapter_thirteen;

/**
 * *13.14 (Demonstrate the benefits of encapsulation) Rewrite the Rational class
 * in Listing  13.13 using a new internal representation for the numerator and
 * denominator. Create an array of two integers as follows:
 * private long[] r = new long[2];
 *  Use r[0] to represent the numerator and r[1] to represent the denominator.
 * The signatures of the methods in the Rational class are not changed, so a client
 * application that uses the previous Rational class can continue to use this new
 * Rational class without being recompiled.
 *
 * @author Sharaf Qeshta
 * */
public class Problem$14
{
    public static void main(String[] args)
    {
        Rational r1 = new Rational(1, 123456789);
        Rational r2 = new Rational(1, 123456789);
        Rational r3 = new Rational(1, 123456789);

        /* r1 * r2 * r3 is -1/2204193661661244627 */
        System.out.println("r1 * r2 * r3 is " +
                r1.multiply(r2.multiply(r3)));
    }
}