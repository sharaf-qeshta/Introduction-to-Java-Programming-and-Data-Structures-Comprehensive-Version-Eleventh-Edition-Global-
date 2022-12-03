package chapter38;

import java.util.Arrays;
import java.util.HashSet;

/**
 * ***38.11 (Syntax highlighting) Rewrite Exercise 37.12 using JSP.
 *
 * @author Sharaf Qeshta
 * */
public class Problem$11
{
    // see Problem$11.jsp
    public static final String[] KEYWORDS_ARRAY = {"abstract", "assert", "boolean",
            "break", "byte", "case", "catch", "char", "class", "const",
            "continue", "default", "do", "double", "else", "enum",
            "extends", "for", "final", "finally", "float", "goto",
            "if", "implements", "import", "instanceof", "int",
            "interface", "long", "native", "new", "package", "private",
            "protected", "public", "return", "short", "static",
            "strictfp", "super", "switch", "synchronized", "this",
            "throw", "throws", "transient", "try", "void", "volatile",
            "while", "true", "false", "null"};

    public static final HashSet<String> KEYWORDS
            = new HashSet<>(Arrays.asList(KEYWORDS_ARRAY));
}
