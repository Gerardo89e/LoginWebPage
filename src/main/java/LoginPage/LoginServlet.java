package LoginPage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID =1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException, IOException{
		response.sendRedirect("/login.html");


		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException, IOException{

		String password=request.getParameter("pass");
		String email=request.getParameter("email");
		Validate validate = new Validate(); 
		
			User user = validate.checkUser(email, password);
			String destPage="login.html";
			if(user !=null) {
				//if(Validate.checkUser(email,password)) {
				HttpSession session =request.getSession();
				session.setAttribute("user",user);
				//destPage="home.jsp";
				RequestDispatcher dispatcher =request.getRequestDispatcher("LoginSuccess.html");
				dispatcher.forward(request, response);
			}else {
				
				System.out.println("Login not successful");

				RequestDispatcher dispatcher =request.getRequestDispatcher("login.html");
				dispatcher.forward(request, response);
				
			}
			
	
		/*
		 * RequestDispatcher dispatcher =request.getRequestDispatcher("LoginSuccess.html");
			dispatcher.forward(request, response);
		 */
	}
}
