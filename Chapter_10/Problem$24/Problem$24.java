package chapter_ten;

/**
 * 10.24 (Implement the Character class) The Character class is provided in the Java
 * library. Provide your own implementation for this class. Name the new class
 * MyCharacter.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$24
{
    public static void main(String[] args)
    {
        Character c1 = 'A';
        MyCharacter c2 = new MyCharacter('A');

        System.out.println(c2.charValue()); // A
        System.out.println(c1.charValue()); // A

        System.out.println(c1.compareTo('a')); // -32
        System.out.println(c2.compareTo('a')); // -32

        System.out.println(MyCharacter.isLetter('a')); // true
        System.out.println(MyCharacter.isLetter('d')); // true
        System.out.println(MyCharacter.isLetter('Q')); // true
        System.out.println(MyCharacter.isLetter('3')); // false

        System.out.println(MyCharacter.isDigit('1')); // true
        System.out.println(MyCharacter.isDigit('5')); // true
        System.out.println(MyCharacter.isDigit('0')); // true
        System.out.println(MyCharacter.isDigit('A')); // false

        System.out.println(MyCharacter.toUpperCase('a')); // A
        System.out.println(MyCharacter.toUpperCase('b')); // B
        System.out.println(MyCharacter.toUpperCase('c')); // C
        System.out.println(MyCharacter.toUpperCase('A')); // A

        System.out.println(MyCharacter.toLowerCase('A')); // a
        System.out.println(MyCharacter.toLowerCase('B')); // b
        System.out.println(MyCharacter.toLowerCase('C')); // c
        System.out.println(MyCharacter.toLowerCase('a')); // a
    }
}

