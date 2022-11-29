package chapter_thirty_seven;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

/**
 * *37.11 (Retrieve cookies) Write a servlet that displays all the cookies on the client. The
 * client types the URL of the servlet from the browser to display all the cookies stored
 * on the browser. (see Figure 37.32.)
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$11 extends HttpServlet
{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Cookie[] cookies = request.getCookies();
        out.println("<h1> here are the cookies from your browser");
        for (Cookie cookie : cookies)
        {
            switch (cookie.getName())
            {
                case "color" -> out.println("<h2>color`s value is " + cookie.getValue() + "</h2><br>");
                case "radius" -> out.println("<h2>radius`s value is " + cookie.getValue() + "</h2><br>");
                case "count" -> out.println("<h2>count`s value is " + cookie.getValue() + "</h2><br>");
                case "JSESSIONID" -> out.println("<h2>JSESSIONID`s value is " + cookie.getValue() + "</h2>");
            }
        }
        out.close();
    }
}
