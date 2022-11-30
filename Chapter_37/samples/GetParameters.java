package chapter_thirty_seven.samples;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class GetParameters extends HttpServlet
{
    /**
     * Process the HTTP Post request
     */
    public void doGet(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Obtain parameters from the client
        String lastName = request.getParameter("lastName");
        String firstName = request.getParameter("firstName");
        String mi = request.getParameter("mi");
        String gender = request.getParameter("gender");
        String major = request.getParameter("major");
        String[] minors = request.getParameterValues("minor");
        String tennis = request.getParameter("tennis");
        String golf = request.getParameter("golf");
        String pingPong = request.getParameter("pingPong");
        String remarks = request.getParameter("remarks");

        out.println("Last Name: <b>" + lastName + "</b> First Name: <b>"
                + firstName + "</b> MI: <b>" + mi + "</b><br>");
        out.println("Gender: <b>" + gender + "</b><br>");
        out.println("Major: <b>" + major + "</b> Minor: <b>");

        if (minors != null)
            for (int i = 0; i < minors.length; i++)
                out.println(minors[i] + " ");

        out.println("</b><br> Tennis: <b>" + tennis + "</b> Golf: <b>" +
                golf + "</b> PingPong: <b>" + pingPong + "</b><br>");
        out.println("Remarks: <b>" + remarks + "</b>");
        out.close(); // Close stream
    }
}
