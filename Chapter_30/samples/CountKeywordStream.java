package chapter_thirty.samples;

import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.util.stream.Stream;

/**
 * Listing 30.12 CountKeywordStream.java
 * */
public class CountKeywordStream
{
    public static void main(String[] args) throws Exception
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a Java source file: ");
        String filename = input.nextLine();

        File file = new File(filename);
        if (file.exists())
        {
            System.out.println("The number of keywords in " + filename
                    + " is " + countKeywords(file));
        }
        else
        {
            System.out.println("File " + filename + " does not exist");
        }
    }

    public static long countKeywords(File file) throws Exception
    {
        // Array of all Java keywords + true, false and null
        String[] keywordString = {"abstract", "assert", "boolean",
                "break", "byte", "case", "catch", "char", "class", "const",
                "continue", "default", "do", "double", "else", "enum",
                "extends", "for", "final", "finally", "float", "goto",
                "if", "implements", "import", "instanceof", "int",
                "interface", "long", "native", "new", "package", "private",
                "protected", "public", "return", "short", "static",
                "strictfp", "super", "switch", "synchronized", "this",
                "throw", "throws", "transient", "try", "void", "volatile",
                "while", "true", "false", "null"};

        Set<String> keywordSet =
                new HashSet<>(Arrays.asList(keywordString));

        return Files.lines(file.toPath()).parallel().mapToLong(line ->
                Stream.of(line.split("[\\s++]")).
                        filter(word -> keywordSet.contains(word)).count()).sum();
    }
}
