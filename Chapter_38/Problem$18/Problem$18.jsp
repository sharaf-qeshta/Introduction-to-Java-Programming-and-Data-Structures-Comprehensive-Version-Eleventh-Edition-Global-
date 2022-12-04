<%--
  Created by IntelliJ IDEA.
  User: Sharaf Qeshta
  Date: 12/4/2022
  Time: 12:44 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="chapter38.Problem_18" %>
<jsp:useBean id="problem_18ID"
             class="chapter38.Problem_18" scope="page">
</jsp:useBean>
<jsp:setProperty name="problem_18ID" property="*"/>
<html>
<head>
    <title>Problem$18</title>
</head>
<body>

<h3>Compute Factorial Using a Bean</h3>
<form method="post">
    Enter new value: <input name="number"/><br/><br/>
    <input type="submit" name="Submit"
           value="Compute Factorial"/>
    <input type="reset" value="Reset"/><br/><br/>
    Factorial of
    <jsp:getProperty name="problem_18ID"
                     property="number"/>
    is
    <%= problem_18ID.getFactorial().toString() %>
</form>
</body>
</html>
