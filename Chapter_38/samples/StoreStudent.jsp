<!-- StoreStudent.jsp -->
<%@ page import="chapter37.Address" %>
<jsp:useBean id="addressId" class="chapter37.Address"
             scope="session"></jsp:useBean>
<jsp:useBean id="storeDataId" class="chapter38.StoreData"
             scope="application"></jsp:useBean>
<html>
<body>
<%
    storeDataId.storeStudent(addressId);

    out.println(addressId.getFirstName() + " " +
            addressId.getLastName() +
            " is now registered in the database");
    out.close(); // Close stream
%>
</body>
</html>

