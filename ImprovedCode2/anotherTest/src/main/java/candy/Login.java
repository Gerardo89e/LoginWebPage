package candy;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import candy.User;
import candy.Validate;

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
		Validate validate = new Validate(); 
		
			User user = validate.checkUser(email, password);
			String destPage="login.jsp";
			
			
			//----------------------------------------------------------------------
	/*
	 * 
	 *  if (x == 2) {

	                    response.sendRedirect("student.jsp");

	                } else if (x == 1) {

	                    response.sendRedirect("admin.jsp");

	                } else {

	                    out.println("Either you enter Invalid UserName or Password! Please Try Again");
	 */
         
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
				
				
			}
			
	
		/*
		 * RequestDispatcher dispatcher =request.getRequestDispatcher("LoginSuccess.html");
			dispatcher.forward(request, response);
		 */
	}
}

