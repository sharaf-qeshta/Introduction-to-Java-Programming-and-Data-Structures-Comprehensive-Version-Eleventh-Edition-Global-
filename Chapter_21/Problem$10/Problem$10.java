package chapter_twenty_one;

import java.io.File;
import java.util.*;

/**
 * *21.10 (Count the occurrences of each keyword) Rewrite Listing 21.7, CountKeywords.
 * java to read in a Java source-code file and count the occurrence of each keyword
 * in the file, but don’t count the keyword if it is in a comment or in a string literal.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$10
{
    public static final String[] KEYWORDS = {"abstract", "assert", "boolean",
            "break", "byte", "case", "catch", "char", "class", "const",
            "continue", "default", "do", "double", "else", "enum",
            "extends", "for", "final", "finally", "float", "goto",
            "if", "implements", "import", "instanceof", "int",
            "interface", "long", "native", "new", "package", "private",
            "protected", "public", "return", "short", "static",
            "strictfp", "super", "switch", "synchronized", "this",
            "throw", "throws", "transient", "try", "void", "volatile",
            "while", "true", "false", "null"};

    public static void main(String[] args) throws Exception
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a Java source file: ");
        String filename = input.nextLine();

        File file = new File(filename);
        if (file.exists())
            countKeywords(file).forEach((keyword, occurrence) ->
                    System.out.println(String.format("%-15s", keyword) + occurrence));
        else
            System.out.println("File " + filename + " does not exist");
    }

    public static Map<String, Integer> countKeywords(File file) throws Exception
    {

        Map<String, Integer> keywordOccurrences = new HashMap<>();
        for (String key: KEYWORDS)
            keywordOccurrences.put(key, 0);

        Scanner input = new Scanner(file);
        while (input.hasNext())
        {
            String line = input.nextLine();
            if (line.startsWith("//") || line.startsWith("/*")
                    || line.startsWith("*") || line.startsWith("*/"))
                continue;

            // ignoring strings
            String ignore = line.substring(Math.max(line.indexOf("\""), 0),
                    Math.max(line.lastIndexOf("\""), 0));
            line = line.replace(ignore, "");

            String[] words = line.split(" ");
            for (String word: words)
                if (keywordOccurrences.containsKey(word))
                    keywordOccurrences.put(word, keywordOccurrences.get(word) + 1);
        }
        return keywordOccurrences;
    }
}
