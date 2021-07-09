package candy;
import candy.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Statement;
import candy.DBConnection;
import candy.Validate;
public class LoginDAO {
	public String authenticateUser(LoginBean loginBean)
	{
	    String userEmail = loginBean.getEmail();
	    String password = loginBean.getPassword();
	 System.out.println(userEmail+password);
	    Connection con = null;
	    Statement statement = null;
	    ResultSet resultSet = null;
	 
	    String userEmailDB = "";
	    String passwordDB = "";
	    String utype = "";
	 
	    try
	    {
	        con = DBConnection.createConnection();
	        statement = con.createStatement();
	        resultSet = statement.executeQuery("select email,pass,utype from users");
	 
	        while(resultSet.next())
	        {
	            userEmailDB = resultSet.getString("email");
	            passwordDB = resultSet.getString("pass");
	            utype = resultSet.getString("utype");
	 
	            if(userEmail.equals(userEmailDB) && password.equals(passwordDB) && utype.equals("admin"))
	            return "Admin_Role";
	            else if(userEmail.equals(userEmailDB) && password.equals(passwordDB) && utype.equals("employee"))
	            return "Employee_Role";
	            else if(userEmail.equals(userEmailDB) && password.equals(passwordDB) && utype.equals("User"))
	            return "User_Role";
	        }
	    }
	    catch(SQLException e)
	    {
	        e.printStackTrace();
	    }
	    return "Invalid user credentials";
	}
	
}
