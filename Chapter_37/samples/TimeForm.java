package chapter_thirty_seven.samples;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.text.*;

/**
 * Listing 37.5 TimeForm.java
 * */
public class TimeForm extends HttpServlet
{
    private static final String CONTENT_TYPE = "text/html";
    private Locale[] allLocale = Locale.getAvailableLocales();
    private String[] allTimeZone = TimeZone.getAvailableIDs();

    /**
     * Process the HTTP Get request
     */
    public void doGet(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException
    {
        response.setContentType(CONTENT_TYPE);
        PrintWriter out = response.getWriter();
        out.println("<h3>Choose locale and time zone</h3>");
        out.println("<form method=\"post\" action=" +
                "TimeForm>");
        out.println("Locale <select size=\"1\" name=\"locale\">");

        // Fill in all locales
        for (int i = 0; i < allLocale.length; i++)
        {
            out.println("<option value=\"" + i + "\">" +
                    allLocale[i].getDisplayName() + "</option>");
        }
        out.println("</select>");

        // Fill in all time zones
        out.println("<p>Time Zone<select size=\"1\" name=\"timezone\">");
        for (int i = 0; i < allTimeZone.length; i++)
        {
            out.println("<option value=\"" + allTimeZone[i] + "\">" +
                    allTimeZone[i] + "</option>");
        }
        out.println("</select>");

        out.println("<p><input type=\"submit\" value=\"Submit\" >");
        out.println("<input type=\"reset\" value=\"Reset\"></p>");
        out.println("</form>");
        out.close(); // Close stream
    }

    /**
     * Process the HTTP Post request
     */
    public void doPost(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException
    {
        response.setContentType(CONTENT_TYPE);
        PrintWriter out = response.getWriter();
        out.println("<html>");
        int localeIndex = Integer.parseInt(
                request.getParameter("locale"));
        String timeZoneID = request.getParameter("timezone");
        out.println("<head><title>Current Time</title></head>");
        out.println("<body>");
        Calendar calendar =
                new GregorianCalendar(allLocale[localeIndex]);
        TimeZone timeZone = TimeZone.getTimeZone(timeZoneID);
        DateFormat dateFormat = DateFormat.getDateTimeInstance(
                DateFormat.FULL, DateFormat.FULL, allLocale[localeIndex]);
        dateFormat.setTimeZone(timeZone);
        out.println("Current time is " +
                dateFormat.format(calendar.getTime()) + "</p>");
        out.println("</body></html>");
        out.close(); // Close stream
    }
}

