package model;

import db.DBConnector;
import dto.Userdto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginAuthenticator 
{
    public boolean isLogin(Userdto user){
        
        try 
        {
            
            Connection con = DBConnector.getConnection();
            String sql = "select * from registeruser where username = ? and password = ?";
            ResultSet rs = null;    
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            rs = ps.executeQuery();
            if(rs.next())
            {
                return true;
            }
        }
        catch (SQLException ex) 
        {
            Logger.getLogger(LoginAuthenticator.class.getName()).log(Level.SEVERE, null, ex);
        }
       return false;    
    }
}
