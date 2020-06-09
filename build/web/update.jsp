<%@page import="dto.User"%>
<%@page import="model.RegisterModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Update User</title>
    </head>
    <body>
        <%
            String username = (String)session.getAttribute("username");
            User us = RegisterModel.getUser(username);
        %>
        <form action="UpdateChecker" method="POST" >
        <table border="0">
                <tr>
                    <td>Name</td>
                    <td><input type="text" name="username" value="<%=us.getUsername()%>" /></td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td><input type="text" name="name" value="<%=us.getName()%>" /></td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td><input type="email" name="email" value="<%=us.getEmail()%>" /></td>
                </tr>
                <tr>
                    <td></td>
                    <td><button type="submit" />Update </button>
                </tr>
        </table>
    </form>
        <h1>Update your information!</h1>
    </body>
</html>
