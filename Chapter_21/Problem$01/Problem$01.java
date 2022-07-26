package chapter_twenty_one;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 21.1 (Perform set operations on hash sets) Given two stacks of textbooks of the following
 * subjects {"Chemistry", "Mathematics", "Biology", "English"}
 * and {"Biology", "English", "Geography", "Physics"} respectively, find
 * the subjects that are (1) only present in the first stack; (2) only present in the
 * second stack; (3) present in both stacks. (You may clone the sets to preserve the
 * original sets from being changed by set methods.)
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$01
{
    public static void main(String[] args)
    {
        HashSet<String> set1 = new HashSet<>(Arrays.asList("Chemistry", "Mathematics", "Biology", "English"));
        HashSet<String> set2 = new HashSet<>(Arrays.asList("Biology", "English", "Geography", "Physics"));

        // (1) only present in the first stack;
        HashSet<String> firstStack = new HashSet<>(set1);
        firstStack.removeAll(set2);
        System.out.println(firstStack); // [Chemistry, Mathematics]

        // (2) only present in the second stack
        HashSet<String> secondStack = new HashSet<>(set2);
        secondStack.removeAll(set1);
        System.out.println(secondStack); // [Geography, Physics]

        // (3) present in both stacks
        set1.retainAll(set2);
        System.out.println(set1); // [English, Biology]
    }
}
