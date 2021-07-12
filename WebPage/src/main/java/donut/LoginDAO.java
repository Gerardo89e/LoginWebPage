package donut;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
import donut.LoginBean;
import donut.DBConnection;
 
public class LoginDAO {
 
public String authenticateUser(LoginBean loginBean)
{
    String userName = loginBean.getEmail();
    String password = loginBean.getPassword();
 
    Connection con = null;
    Statement statement = null;
    ResultSet resultSet = null;
 
    String userNameDB = "";
    String passwordDB = "";
    String roleDB = "";
 
    try
    {
    	//calling the DBConnection function to create a connection
        con = DBConnection.createConnection();
        statement = con.createStatement();
        resultSet = statement.executeQuery("select email,pass,utype from users");
        //This is where the login determines if the user is admin or employee
        while(resultSet.next())
        {
        	//we get the resulset from the loginServlet and test them in the If statement
            userNameDB = resultSet.getString("email");
            passwordDB = resultSet.getString("pass");
            roleDB = resultSet.getString("utype");
            //We return the string depending of the employee role in the users table
            if(userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("admin"))
            return "Admin_Role";
            else if(userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("employee"))
            return "Employee_Role";
            else if(userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("User"))
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
