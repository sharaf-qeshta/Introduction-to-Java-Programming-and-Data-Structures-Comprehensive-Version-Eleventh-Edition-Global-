package chapter_thirty_seven;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

/**
 * *37.10 (Store cookies) Write a servlet that stores the following cookies in a browser, and
 * set their max age for two days.
 * Cookie 1: name is “color” and value is red.
 * Cookie 2: name is “radius” and value is 5.5.
 * Cookie 3: name is “count” and value is 2.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$10 extends HttpServlet
{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Cookie color = new Cookie("color", "red");
        color.setMaxAge(172_800); // 2 days

        Cookie radius = new Cookie("radius", "5.5");
        radius.setMaxAge(172_800);

        Cookie count = new Cookie("count", "2");
        count.setMaxAge(172_800);

        response.addCookie(color);
        response.addCookie(radius);
        response.addCookie(count);

        out.println("cookies added");
    }
}
