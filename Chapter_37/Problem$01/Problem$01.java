package chapter_thirty_seven;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * *37.1 (Factorial table) Write a servlet to display a table that contains factorials for the
 * numbers from 0 to 10, as shown in Figure 37.25.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$01 extends HttpServlet
{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<table border=\"5\">");
        out.println("<tr><th>Number</th><th>Factoial</th></tr>");

        for (int i = 0; i < 11; i++)
        {
            int factorial = getFactorial(i);
            out.println("<tr> <td> " + i + "</td> <td> " + factorial + "</td></tr>");
        }
        out.println("</table>");
    }


    public int getFactorial(int x)
    {
        int factorial = 1;
        for (int i = 1; i <= x; i++)
            factorial *= i;
        return factorial;
    }
}

