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

		/*    User user=null;

		SessionFactory factory= new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(User.class)
				.buildSessionFactory();
*/
		//create session
		try {
/*
			Session session = factory.getCurrentSession();

	          //Transaction trns = null;
	          //trns=session.beginTransaction();

			    session.beginTransaction();
			    //from User use to UserLogin from the old user class name
			    List<User> result = session.createQuery("from User where email = :email AND pass=:password", User.class)
			    		.setParameter("email", email).setParameter("password", pass).getResultList();
			    */
			   /*Query query = (Query) session.createQuery("from userlogin where email = :email AND pass=:password")
			     .setParameter("email", email).setParameter("pass", pass).uniqueResult();
			    
				List <UserLogin> list = query.list();
				*/
			   
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
		       

				//Session session = factory.getCurrentSession();
		        /*
				 *  if ((rs.getString("uname").equals(name)) && rs.getString("upass").equals(pass)) {

	                        String stp = rs.getString("utype");

	                        if (stp.equals("admin")) {

	                            x = 1;

	                            break;

	                        } else {

	                            x = 2;

	                            break;

	                        }

	                    }

	                }

	                if (x == 2) {

	                    response.sendRedirect("student.jsp");

	                } else if (x == 1) {

	                    response.sendRedirect("admin.jsp");

	                } else {

	                    out.println("Either you enter Invalid UserName or Password! Please Try Again");
				 */
		        int x=0;
		        
 //------------------------------------------------
        if (result.next()) {
            user = new User();
            user.setEmail(result.getString("email"));
            user.setPass(result.getString("pass"));
           if(result.getString("email").equals(email) &&result.getString("pass").equals(pass)) {
        	   String stp = result.getString("utype");

               if (stp.equals("admin")) {
                   x = 1;
               } else {
                   x = 2;
               }
           }
           user.setUtype(result.getInt(x));
           
        }
 
		
			connection.close();
		
		}catch(Exception e) {
			System.out.println("Error");
		}
        return user;
				

		          //Transaction trns = null;
		          //trns=session.beginTransaction();
				/*if ((result != null) && (result.size() > 0)) {
					//userFound= true;
					user = new User();
					user.setEmail(email);
					user.setPassword(pass);
				}
			    session.getTransaction().commit();
			    session.close();
				System.out.println("Done");
		}finally {
			factory.close();

		}*/

		//return user;
		
		}
}
