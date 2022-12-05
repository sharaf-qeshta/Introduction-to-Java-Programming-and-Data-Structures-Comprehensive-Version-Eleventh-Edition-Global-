<!-- DBLoginInitialization.jsp -->
<%@ page import="chapter38.DBBean" %>
<jsp:useBean id="dBBeanId" scope="session"
             class="chapter38.DBBean">
</jsp:useBean>
<jsp:setProperty name="dBBeanId" property="*"/>
<html>
<head>
    <title>DBLoginInitialization</title>
</head>
<body>

<%-- Connect to the database --%>
<% dBBeanId.initializeJdbc(); %>

<% if (dBBeanId.getConnection() == null) { %>
Error: Login failed. Try again.
<% } else {%>
<jsp:forward page="Table.jsp"/>
<% } %>
</body>
</html>
