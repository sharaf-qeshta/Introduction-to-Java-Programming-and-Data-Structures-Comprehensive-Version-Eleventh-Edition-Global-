<!-- FactorialBean.jsp -->
<%@ page import="chapter38.FactorialBean" %>
<jsp:useBean id="factorialBeanId"
             class="chapter38.FactorialBean" scope="page">
</jsp:useBean>
<jsp:setProperty name="factorialBeanId" property="*"/>
<html>
<head>
    <title>
        FactorialBean
    </title>
</head>
<body>
<h3>Compute Factorial Using a Bean</h3>
<form method="post">
    Enter new value: <input name="number"/><br/><br/>
    <input type="submit" name="Submit"
           value="Compute Factorial"/>
    <input type="reset" value="Reset"/><br/><br/>
    Factorial of
    <jsp:getProperty name="factorialBeanId"
                     property="number"/>
    is
    <%@ page import="java.text.*" %>
    <% NumberFormat format = NumberFormat.getNumberInstance(); %>
    <%= format.format(factorialBeanId.getFactorial()) %>
</form>
</body>
</html>
