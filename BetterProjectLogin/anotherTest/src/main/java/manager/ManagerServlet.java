package manager;
import java.io.IOException;

import java.sql.SQLException;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import manager.Manager;
public class ManagerServlet {
		public class ControllerServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;
	    private ManagerDAO managerDAO;
	 
	    public void init() {
	        /*String jdbcURL = getServletContext().getInitParameter("jdbcURL");
	        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
	        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");*/
	        String jdbcURL = "jdbc:oracle:thin:@emplydb.crymgmzbnitj.us-east-1.rds.amazonaws.com:1521:EMPDB";
	        String jdbcUsername = "admin";
	        String jdbcPassword = "";
	      
	        managerDAO = new ManagerDAO(jdbcURL, jdbcUsername, jdbcPassword);
	 
	    }
	 
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        doGet(request, response);
	    }
	 
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        String action = request.getServletPath();
	 
	        try {
	            switch (action) {
	            case "/new":
	                showNewForm(request, response);
	                break;
	            case "/insert":
	                insertBook(request, response);
	                break;
	            case "/delete":
	                deleteBook(request, response);
	                break;
	            case "/edit":
	                showEditForm(request, response);
	                break;
	            case "/update":
	                updateBook(request, response);
	                break;
	            default:
	                listBook(request, response);
	                break;
	            }
	        } catch (SQLException ex) {
	            throw new ServletException(ex);
	        }
	    }
	    
	   
	    private void listBook(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException, ServletException {
	    	System.out.println("789");
	        List<Manager> listBook = managerDAO.listAllBooks();
	        request.setAttribute("listBook", listBook);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("BookList.jsp");
	        dispatcher.forward(request, response);
	    }
	 
	    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        RequestDispatcher dispatcher = request.getRequestDispatcher("BookForm.jsp");
	        dispatcher.forward(request, response);
	    }
	 
	    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, ServletException, IOException {
	        int id = Integer.parseInt(request.getParameter("id"));
	        Manager existingBook = managerDAO.getBook(id);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("BookForm.jsp");
	        request.setAttribute("book", existingBook);
	        dispatcher.forward(request, response);
	 
	    }
	 
	    private void insertBook(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException {
	       /* String title = request.getParameter("title");
	        String author = request.getParameter("author");
	        float price = Float.parseFloat(request.getParameter("price"));
	        */
	    	String name = request.getParameter("name");
	        String email = request.getParameter("email");
	        String country = request.getParameter("country");

	        //int request2 = Integer.parseInt(request.getParameter("request"));
	       /*
	        System.out.println(title);
	        System.out.println(author);
	        System.out.println(price);
	*/
	        System.out.println(name);
	        System.out.println(email);
	        System.out.println(country);
	        //System.out.println(request2);
	       // User newBook = new User(title, author, price);
	        Manager newBook = new Manager(name, email, country);
	        //User newBook = new User(name, email, country,request2);
	        managerDAO.insertBook(newBook);
	        response.sendRedirect("list");
	    }
	 
	    private void updateBook(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException {
	        int id = Integer.parseInt(request.getParameter("id"));
	        String name = request.getParameter("name");
	        String email = request.getParameter("email");
	        String country = request.getParameter("country");
	        int request2=Integer.parseInt(request.getParameter("request"));
	        System.out.println(request2);
	        /*
	        String title = request.getParameter("title");
	        String author = request.getParameter("author");
	        float price = Float.parseFloat(request.getParameter("price"));*/
	 
	        Manager book = new Manager(id, name, email, country,request2);
	       // User book = new User(id, title, author, price);
	        managerDAO.updateBook(book);
	        response.sendRedirect("list");
	    }
	 
	    private void deleteBook(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException {
	        int id = Integer.parseInt(request.getParameter("id"));
	 
	        Manager book = new Manager(id);
	        managerDAO.deleteBook(book);
	        response.sendRedirect("list");
	 
	    }
	}

}
