package LoginPage;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVesionUID = 1L;

	public LogoutServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		HttpSession session=request.getSession(false);
		if(session !=null) {
			session.removeAttribute("user");
		
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.html");
			dispatcher.forward(request,response);
		}
	}
}
