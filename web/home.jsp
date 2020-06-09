<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
    <center>
        <%
            String username = (String)session.getAttribute("username");
            if(username==null || username.trim().equals("")){
                 response.sendRedirect("index.html");
            }
        %>
        
        <h1>Welcome <%=username%>!</h1>
        <h2>Login Successfull</h2>
        <a href="update.jsp" />Update </a></br><br>
        <a href="logout.jsp">Sign out</a>
        
    </center>
    </body>
</html>
