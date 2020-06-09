package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DBConnector 
{
    static Connection con = null;
    public static Connection getConnection()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loaded");
              
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wappgo","root","root");
            System.out.println("Connection Established");
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return con;
    }
}
