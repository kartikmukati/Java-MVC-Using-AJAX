
package controller;

import dto.Userdto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.LoginAuthenticator;

public class LoginChecker extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        response.sendRedirect("index.html");
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        PrintWriter out = response.getWriter();
        Userdto user = new Userdto();
        user.setUsername(username);
        user.setPassword(password);
        
        LoginAuthenticator authenticate = new LoginAuthenticator();
        boolean login = authenticate.isLogin(user);
        
        if(login){
            
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            out.write("Success");
            //response.sendRedirect("home.jsp");
        }
        else{
            response.sendRedirect("index.html");
        }
        
    }

}
