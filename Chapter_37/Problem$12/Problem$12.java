package chapter_thirty_seven;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.*;

/**
 * ***37.12 (Syntax highlighting) Create an HTML form that prompts the user to enter a Java
 * program in a text area, as shown in Figure 37.33a. The form invokes a servlet that
 * displays the Java source code in a syntax-highlighted HTML format, as shown
 * in Figure 37.33b. The keywords, comments, and literals are displayed in bold
 * navy, green, and blue, respectively.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$12 extends HttpServlet
{
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


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        StringBuilder sourceCode = new StringBuilder(request.getParameter("sourceCode"));
        int location = (new String(sourceCode)).indexOf('\n');
        while(location > 0)
        {
            sourceCode.replace(location, location+1, "<br>");
            location = (new String(sourceCode)).indexOf('\n');
        }

        ArrayList<String> lines =
                new ArrayList<>(Arrays.asList(sourceCode.toString().split("<br>")));

        for (String line: lines)
        {
            if (line.trim().startsWith("//") || line.trim().startsWith("*")
                    || line.trim().startsWith("/*"))
                out.println("<h1 style='color: green'>" + line + "</h1>");
            else
            {
                String[] words = line.split(" ");
                out.println("<div style='display:flex; flex-direction: row;'>");
                for (String word: words)
                {
                    if (KEYWORDS.contains(word))
                        out.println("<h1 style='color: #000080'>" + word + "&nbsp;" + "</h1> ");
                    else
                        out.println("<h1 style='color: blue'>" + word + "&nbsp;" + "</h1> ");
                }
                out.println("</div>");
            }
        }

        out.close();
    }
}