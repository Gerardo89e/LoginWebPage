package candy;
import java.util.List;

import candy.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
public class Validate {
	//	public static boolean checkUser(String email,String pass) old veresion
	public User checkUser(String email,String pass) {
		//boolean userFound = false;
		User user = null;

		try {

			   
			    Class.forName("oracle.jdbc.driver.OracleDriver");
				String jdbcURL = "jdbc:oracle:thin:@emplydb.crymgmzbnitj.us-east-1.rds.amazonaws.com:1521:EMPDB";
		        String dbUser = "admin";
		        String dbPassword = "";
		 
		        Class.forName("com.mysql.jdbc.Driver");
		        Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
		        String sql = "SELECT * FROM users WHERE email = ? and pass = ?";
		        //String sql = "SELECT * FROM users WHERE email = ? and pass = ?";
		        
		        PreparedStatement statement = connection.prepareStatement(sql);
		        statement.setString(1, email);
		        statement.setString(2, pass);
		       
		 
		        ResultSet result = statement.executeQuery();

		        int x=0;
		        
 //------------------------------------------------
        if (result.next()) {
            user = new User();
            user.setEmail(result.getString("email"));
            user.setPass(result.getString("pass"));
            
		
			connection.close();
        }
		}catch(Exception e) {
			System.out.println("Error");
		}
        return user;
			
		
		}
}
