package chapter_thirty_seven;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * *37.4 (Calculate tax) Write an HTML form to prompt the user to enter taxable income
 * and filing status, as shown in Figure 37.27a. Clicking the Compute Tax button
 * invokes a servlet to compute and display the tax, as shown in Figure 37.27b.
 * Use the computeTax method introduced in Listing 3.7, ComputingTax.java, to
 * compute tax.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$04 extends HttpServlet
{
    private HashMap<String, Double[]> map;
    private final double[] rates = {0.1, 0.12, 0.22, 0.24, 0.32, 0.35, 0.37};

    @Override
    public void init()
    {
        // 2022
        map = new HashMap<>();

        Double[] singleAndMarriedJointly = {10_275.0, 41_775.0, 89_075.0, 170_050.0,
                215_950.0, 539_900.0, 539_901.0};
        map.put("Single",singleAndMarriedJointly);
        map.put("Married Filing Jointly", singleAndMarriedJointly);

        Double[] marriedSeperatleyAndHeadOfHouseHold = {10_275.0, 41_775.0, 89_075.0, 170_050.0,
                215_950.0, 323_925.0, 323_926.0};
        map.put("Married Filing Separately", marriedSeperatleyAndHeadOfHouseHold);
        map.put("Head of Household", marriedSeperatleyAndHeadOfHouseHold);
        map.put("Qualifying Widow(er)", marriedSeperatleyAndHeadOfHouseHold);
    }


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        double income = Double.parseDouble(request.getParameter("income").trim());
        String status = request.getParameter("status");

        int fillingStatus = 0;
        double tax = 0;
        Double[] ranges = map.get(status);


        for (int i = 0; i < 5; i++)
        {
            if (income <= ranges[i])
            {
                tax = rates[i] * income;
                fillingStatus = i;
                break;
            }
        }

        if (income >= ranges[5])
        {
            tax = rates[5] * income;
            fillingStatus = 5;
        }

        out.println("Taxable Income: " + income + "<br>");
        out.println("Filling Status: " + fillingStatus + "<br>");
        out.println("Tax: " + tax);
    }
}
