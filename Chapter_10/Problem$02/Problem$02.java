package chapter_ten;

/**
 * 10.2 (The BMI class) Add the following new constructor in the BMI class:
 *
 *      Construct a BMI with the specified name, age, weight,
 *      feet, and inches
 *      public BMI(String name,int age,double weight,double feet,
 *           double inches)
 *
 * @author Sharaf Qeshta
 * */

public class Problem$02
{
    public static void main(String[] args)
    {
        BMI bmi = new BMI("John Smith", 21, 165.347, 6, 0.003);
        /* Normal */
        System.out.println(bmi.getStatus());
    }
}
