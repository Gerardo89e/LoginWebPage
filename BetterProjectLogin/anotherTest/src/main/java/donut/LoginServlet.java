package donut;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import candy.LoginDAO;
import candy.User;
import candy.Validate;
import candy.LoginBean;
import candy.ControllerServlet;

public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID =1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	    String userName = request.getParameter("username");
	    String password = request.getParameter("password");
	 
	    LoginBean loginBean = new LoginBean();
	 
	    loginBean.setEmail(userName);
	    loginBean.setPassword(password);
	 
	    LoginDAO loginDao = new LoginDAO();
	 
	    try
	    {
	        String userValidate = loginDao.authenticateUser(loginBean);
	 
	        if(userValidate.equals("Admin_Role"))
	        {
	            System.out.println("Admin's Home");
	 
	            HttpSession session = request.getSession(); //Creating a session
	            session.setAttribute("Admin", userName); //setting session attribute
	            request.setAttribute("userName", userName);
	 
	            request.getRequestDispatcher("manager.jsp").forward(request, response);
	            //request.getRequestDispatcher("/ManagerServlet").forward(request, response);

	        }
	        else if(userValidate.equals("Employee_Role"))
	        {
	            System.out.println("Editor's Home");
	 
	            HttpSession session = request.getSession();
	            session.setAttribute("email", userName);
	            request.setAttribute("userName", userName);
	 // /ControllerServlet
	            request.getRequestDispatcher("/ControllerServlet").forward(request, response);
	            //request.getRequestDispatcher("Employee.jsp").forward(request, response);

	        }
	        else if(userValidate.equals("User_Role"))
	        {
	            System.out.println("User's Home");
	 
	            HttpSession session = request.getSession();
	            session.setMaxInactiveInterval(10*60);
	            session.setAttribute("User", userName);
	            request.setAttribute("userName", userName);
	 
	            request.getRequestDispatcher("User.jsp").forward(request, response);
	        }
	        else
	        {
	            System.out.println("Error message = "+userValidate);
	            request.setAttribute("errMessage", userValidate);
	 
	            request.getRequestDispatcher("login.jsp").forward(request, response);
	        }
	    }
	    catch (IOException e1)
	    {
	        e1.printStackTrace();
	    }
	    catch (Exception e2)
	    {
	        e2.printStackTrace();
	    }
	} //End of doPost()
}

