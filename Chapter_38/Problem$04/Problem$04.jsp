<%@ page import="chapter38.Tax" %><%--
  Created by IntelliJ IDEA.
  User: Sharaf Qeshta
  Date: 12/1/2022
  Time: 12:56 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Problem$04</title>
</head>
<body>
    <%
        Tax tax = new Tax(request.getParameter("status"),
                Double.parseDouble(request.getParameter("income").trim()));

    %>
    TaxableIncome: <%= tax.getIncome() %> <br>
    Filling Status: <%= tax.getFillingStatus() %> <br>
    Tax: <%= tax.getTax() %>
</body>
</html>
