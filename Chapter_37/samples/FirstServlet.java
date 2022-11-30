package chapter_thirty_seven.samples;

import javax.servlet.*;
import javax.servlet.http.*;

/**
 * Listing 37.1 FirstServlet.java
 * */
public class FirstServlet extends HttpServlet
{
    /**
     * Handle the HTTP GET method.
     *
     * @param request  servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, java.io.IOException
    {
        response.setContentType("text/html");
        java.io.PrintWriter out = response.getWriter();
        // output your page here
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("Hello, Java Servlets");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
