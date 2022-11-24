package chapter_thirty_seven;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * *37.5 (Calculate loan) Write an HTML form that prompts the user to enter
 * loan amount,
 * interest rate, and number of years, as shown in Figure 37.28a. Clicking the Compute
 * Loan Payment button invokes a servlet to compute and display the monthly and
 * total loan payments, as shown in Figure 37.28b. Use the Loan class given in
 * Listing 10.2, Loan.java, to compute the monthly and total payments.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$05 extends HttpServlet
{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        double totalAmount = Double.parseDouble(request.getParameter("loanAmount"));
        double annualInterestRate = Double.parseDouble(request.getParameter("annualInterestRate"));
        double years = Double.parseDouble(request.getParameter("numberOfYears"));

        double monthlyInterestRate = annualInterestRate / 1200;
        double monthlyPayment = totalAmount * monthlyInterestRate / (1
                - 1 / Math.pow(1 + monthlyInterestRate, years * 12));
        double total = monthlyPayment * 12 * years;


        out.println("Loan Amount: " + totalAmount + "<br>");
        out.println("Annual Interest Rate: " + annualInterestRate + "<br>");
        out.println("Number of Years: " + years + "<br>");
        out.println("Monthly Payment: " + monthlyPayment + "<br>");
        out.println("Total Payment: " + total);
    }
}
