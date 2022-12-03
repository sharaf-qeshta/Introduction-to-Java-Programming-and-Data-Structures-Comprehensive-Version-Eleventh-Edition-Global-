<%--
  Created by IntelliJ IDEA.
  User: Sharaf Qeshta
  Date: 12/3/2022
  Time: 11:16 AM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="chapter38.Problem$11" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Arrays" %>
<html>
<head>
    <title>Problem$11</title>
</head>
<body>
    <%
        StringBuilder sourceCode = new StringBuilder(request.getParameter("sourceCode"));
        int location = (new String(sourceCode)).indexOf('\n');
        while(location > 0)
        {
            sourceCode.replace(location, location+1, "<br>");
            location = (new String(sourceCode)).indexOf('\n');
        }

        ArrayList<String> lines =
                new ArrayList<>(Arrays.asList(sourceCode.toString().split("<br>")));

        for (String line: lines)
        {
            if (line.trim().startsWith("//") || line.trim().startsWith("*")
                    || line.trim().startsWith("/*"))
                out.println("<h1 style='color: green'>" + line + "</h1>");
            else
            {
                String[] words = line.split(" ");
                out.println("<div style='display:flex; flex-direction: row;'>");
                for (String word: words)
                {
                    if (Problem$11.KEYWORDS.contains(word))
                        out.println("<h1 style='color: #000080'>" + word + "&nbsp;" + "</h1> ");
                    else
                        out.println("<h1 style='color: blue'>" + word + "&nbsp;" + "</h1> ");
                }
                out.println("</div>");
            }
        }
    %>
</body>
</html>
