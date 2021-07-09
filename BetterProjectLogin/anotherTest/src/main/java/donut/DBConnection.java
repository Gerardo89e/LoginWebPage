package donut;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
public class DBConnection {
	  public static Connection createConnection()
	    {
	    Connection con = null;
	    String url = "jdbc:oracle:thin:@emplydb.crymgmzbnitj.us-east-1.rds.amazonaws.com:1521:EMPDB";
	    String username = "admin";
	    String password = "";
	 
	    try
	    {
	        try
	        {
	            Class.forName("oracle.jdbc.driver.OracleDriver");
	        }
	        catch (ClassNotFoundException e)
	        {
	            e.printStackTrace();
	        }
	        con = DriverManager.getConnection(url, username, password);
	        System.out.println("Post establishing a DB connection - "+con);
	    }
	    catch (SQLException e)
	        {
	           System.out.println("An error occurred. Maybe user/password is invalid");
	         e.printStackTrace();
	       }
	    return con;
	    }
}
