package chapter_thirty_seven;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * *37.2 (Multiplication table) Write a servlet to display a multiplication table, as shown in
 * Figure 37.25b.
 *
 * @author Sharaf Qeshta
 * */
public class Problem$02 extends HttpServlet
{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<table border=\"5\" width = 80% height = 50%>");
        for (int i = 1; i < 10; i++)
        {
            out.println("<tr>");
            if (i == 1)
                out.println("<td></td>");
            else
                out.println("<td>" + i + "</td>");
            for (int j = 1; j < 10; j++)
            {
                out.println("<td>" + i * j + "</td>");
            }
            out.println("</tr>");

            if (i == 1)
            {
                out.println("<tr><td>1</td>");
                for (int j = 1; j < 10; j++)
                    out.println("<td>" + j + "</td>");
                out.println("</tr>");
            }
        }
        out.println("</table>");
    }
}
