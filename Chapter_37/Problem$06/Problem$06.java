package chapter_thirty_seven;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.util.Scanner;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * **37.6 (Find scores from text files) Write a servlet that displays the student name and the
 * current score, given the SSN and class ID. For each class, a text file is used to store
 * the student name, SSN, and current score. The file is named after the class ID with
 * .txt extension. For instance, if the class ID were csci1301, the file name would be
 * csci1301.txt. Suppose each line consists of student name, SSN, and score. These
 * three items are separated by the # sign. Create an HTML form that enables the user
 * to enter the SSN and class ID, as shown in Figure 37.29a. Upon clicking the Submit
 * button, the result is displayed, as shown in Figure 37.29b. If the SSN or the class
 * ID does not match, report an error. Assume three courses are available: CSCI1301,
 * CSCI1302, and CSCI3720.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$06 extends HttpServlet
{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String ssn = request.getParameter("ssn");
        String course = request.getParameter("course");

        // search for
        String grade = "";
        String name = "";

        try (Scanner scanner = new Scanner(new File("D:\\Problem$06\\" + course + ".txt")))
        {
            while (scanner.hasNext())
            {
                String line = scanner.nextLine();
                String[] data = line.split(" ");
                if (data[1].equals(ssn))
                {
                    grade = data[2];
                    name = data[0];
                    break;
                }
            }
        }
        catch(Exception ignored)
        {
            // ignored
        }

        if (grade.isEmpty())
        {
            out.println("<h1> No data Found </h1>");
        }
        else
        {
            out.println(name + " : " + grade);
        }
    }
}

