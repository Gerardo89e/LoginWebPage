package anotherTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
 
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.mysql.jdbc.Statement;

import candy.DBConnection;
import candy.User;
import candy.UserDAO;

import org.easymock.EasyMock;

import donut.LoginDAO;
import donut.LoginServlet;

public class webJunit extends HttpServlet {
	@Test public void testGet() {
	    Connection con =DBConnection.createConnection();
	    System.out.println(con);
	}
	@Test
	public void testQuery() {
			Connection con=null;
			Statement st=null;
			ResultSet rs = null;
			try {
			    con =DBConnection.createConnection();
			    st.getConnection().createStatement();
			    String sql =  "select * from users";
			    rs=st.executeQuery(sql);
			    while(rs.next()) {
			    	String name = rs.getString("name");
			    	int id=rs.getInt("id");
			    	System.out.println(name+" "+id);
			    }
			}catch(Exception e) {
				System.out.println("Error");
			}
	}
	@Test
	public void testUpdate() {
		Connection con = null;
		Statement st = null;
			try {
			    con =DBConnection.createConnection();
			    st.getConnection().createStatement();
				String sql = "update users set name = SpongeBob Sqaure Pants where id = 6";
				int result = st.executeUpdate(sql);
				
				if(result >0) {
					System.out.println("update completed");
				}else {
					System.out.println("Update failed");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
	}


}

