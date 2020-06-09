package model;

import db.DBConnector;
import dto.RegisterUser;
import dto.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterModel 
{
    public boolean registered(RegisterUser user){
    Connection con = DBConnector.getConnection();
    String sql = "insert into registeruser values (?,?,?,?)";
    try
    {
       PreparedStatement ps  = con.prepareStatement(sql);
        ps.setString(1, user.getName());
        ps.setString(2, user.getUsername());
        ps.setString(3, user.getPassword());
        ps.setString(4, user.getEmail());
        
        int i = ps.executeUpdate();
        if(i > 0){
            return true;
        }
    }
    catch(SQLException ex)
    {
    
    }
    return false;
  }
    public static User getUser(String username){
        Connection con = DBConnector.getConnection();
        String sql = "select * from registeruser where username = ?";
        ResultSet rs = null;
        User obj = null;
        try{
            PreparedStatement ps  = con.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if(rs.next()){
                obj = new User();
                obj.setName(rs.getString(1));
                obj.setUsername(rs.getString(2));
                obj.setEmail(rs.getString(4));
                return obj;
            }
            
        }
        catch(SQLException ex){
            
        }
        return null;
    }
    public boolean updateUser(User us){
        Connection con = DBConnector.getConnection();
        String sql = "update registeruser set name = ?,email = ? where username = ?";
    try
    {
        PreparedStatement ps  = con.prepareStatement(sql);
        ps.setString(1, us.getName());
        ps.setString(2, us.getEmail());
        ps.setString(3, us.getUsername());
        int i = ps.executeUpdate();
        if(i > 0){
            return true;
        }
    }
    catch(SQLException ex)
    {
    
    }
    return false;
    }
}
