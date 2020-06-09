package controller;

import dto.RegisterUser;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.RegisterModel;

public class Registration extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException 
    {
        response.sendRedirect("registration.html");
    }

    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        String name = request.getParameter("name");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        
        RegisterUser register = new RegisterUser();
        register.setName(name);
        register.setUsername(username);
        register.setPassword(password);
        register.setEmail(email);
        
        RegisterModel userModel = new RegisterModel();
        boolean isRegisterd = userModel.registered(register);
        
        if(isRegisterd){
            response.sendRedirect("index.html");
        }
        else{
            response.sendRedirect("registration.html");
        }
    }

}
