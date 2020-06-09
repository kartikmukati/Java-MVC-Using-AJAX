package controller;

import dto.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.RegisterModel;

public class UpdateChecker extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        response.sendRedirect("index.html");
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
             String username = request.getParameter("username");
             String name = request.getParameter("name");
             String email = request.getParameter("email");
             PrintWriter out = response.getWriter();
             User us = new User();
             us.setUsername(username);
             us.setName(name);
             us.setEmail(email);
             
             RegisterModel rs = new RegisterModel();
             boolean updatedUser = rs.updateUser(us);
             if(updatedUser){
                 response.sendRedirect("home.jsp");
             }
             else{
                 out.println("Failed to updated");
             }
             //response.sendRedirect("update.jsp");
    }


}
