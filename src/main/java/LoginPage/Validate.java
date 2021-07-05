package LoginPage;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import LoginPage.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
public class Validate {
	//	public static boolean checkUser(String email,String pass) old veresion
	public User checkUser(String email,String pass) {
		//boolean userFound = false;
	    User user=null;

		SessionFactory factory= new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(User.class)
				.buildSessionFactory();

		//create session
		try {

			Session session = factory.getCurrentSession();

	          //Transaction trns = null;
	          //trns=session.beginTransaction();

			    session.beginTransaction();
			    //from User use to UserLogin from the old user class name
			    List<User> result = session.createQuery("from User where email = :email AND pass=:password", User.class)
			    		.setParameter("email", email).setParameter("password", pass).getResultList();

			   /*Query query = (Query) session.createQuery("from userlogin where email = :email AND pass=:password")
			     .setParameter("email", email).setParameter("pass", pass).uniqueResult();
			    
				List <UserLogin> list = query.list();
				*/
				if ((result != null) && (result.size() > 0)) {
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

		}

		return user;
	}
}
