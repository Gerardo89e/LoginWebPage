package candy;

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

public class Login extends HttpServlet{
	private static final long serialVersionUID =1L;

	public Login() {
		super();
	}

	protected void doGet(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException, IOException{
		response.sendRedirect("login.jsp");


		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException, IOException{

		String password=request.getParameter("pass");
		String email=request.getParameter("email");
		System.out.println(email+password);
		LoginBean loginBean = new LoginBean();
		loginBean.setEmail(email);
		loginBean.setPassword(password);
		//Validate validate = new Validate(); 
		//User user = new User();
			//User user = validate.checkUser(email, password);
			LoginDAO loginDao = new LoginDAO();
			
			String userValidate= loginDao.authenticateUser(loginBean);
         
			if(userValidate.equals("admin")) {
				System.out.println("Admin home");
				HttpSession session =request.getSession();
				
				session.setAttribute("admin",email);
				request.setAttribute("email", email);
				RequestDispatcher dispatcher =request.getRequestDispatcher("manager.jsp");
				dispatcher.forward(request, response);
			}       
			else if(userValidate.equals("Employee"))
	        {
	            System.out.println("Editor's Home");
	 
	            HttpSession session = request.getSession();
	            session.setAttribute("employee", email);
	            request.setAttribute("email", email);
	 
	            request.getRequestDispatcher("Employee.jsp").forward(request, response);
	        }
	        else if(userValidate.equals("User_Role"))
	        {
	            System.out.println("User's Home");
	 
	            HttpSession session = request.getSession();
	            session.setMaxInactiveInterval(10*60);
	            session.setAttribute("User", email);
	            request.setAttribute("email", email);
	 
	            request.getRequestDispatcher("/JSP/User.jsp").forward(request, response);
	        }
	        else
	        {
	            System.out.println("Error message = "+userValidate);
	            request.setAttribute("errMessage", userValidate);
	 
	            request.getRequestDispatcher("login.jsp").forward(request, response);
	        }
	    

			/*
			if(user !=null) {
				//if(Validate.checkUser(email,password)) {
				HttpSession session =request.getSession();
				session.setAttribute("user",user);
				//destPage="home.jsp";
				RequestDispatcher dispatcher =request.getRequestDispatcher("/ControllerServlet");
				dispatcher.forward(request, response);
			}else {
				
				System.out.println("Login not successful");

				RequestDispatcher dispatcher =request.getRequestDispatcher("login.jsp");
				dispatcher.forward(request, response);
				
				
			}*/
			
	
		/*
		 * RequestDispatcher dispatcher =request.getRequestDispatcher("LoginSuccess.html");
			dispatcher.forward(request, response);
		 */
	}
}

