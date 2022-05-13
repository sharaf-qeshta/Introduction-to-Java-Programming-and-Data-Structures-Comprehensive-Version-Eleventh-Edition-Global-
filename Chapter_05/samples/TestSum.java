package chapter_five.samples;

/** Listing 5.8 TestSum.java */
public class TestSum
{
    public static void main(String[] args)
    {
        // Initialize sum
        float sum = 0;

        for (float i = 0.01f; i <= 1.0f; i = i + 0.01f)
            sum += i;

        // Display result
        System.out.println("The sum is " + sum);
    }
}
