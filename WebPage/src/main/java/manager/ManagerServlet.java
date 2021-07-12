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
public class ManagerServlet extends HttpServlet {
	
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
	        //here is where depending of the path it would execute the functions
	        try {
	            switch (action) {
	            case "/new1":
	                showNewForm(request, response);
	                break;
	            case "/insert5":
	                insertUser(request, response);
	                break;
	            case "/delete6":
	                deleteUser(request, response);
	                break;
	            case "/edit2":
	                showEditForm(request, response);
	                break;
	            case "/update4":
	                updateUser(request, response);
	                break;
	            default:
	                listUser(request, response);
	                break;
	            }
	        } catch (SQLException ex) {
	            throw new ServletException(ex);
	        }
	    }
	    
	   // most of these function call back to the ManagerDAO and pass the values to in their appropriate function call
	    private void listUser(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException, ServletException {
	    	System.out.println("789");
	        List<Manager> listUserMan = managerDAO.listAllUsers();
	        request.setAttribute("listBook", listUserMan);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("ManagerList.jsp");
	        dispatcher.forward(request, response);
	    }
	 
	    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        RequestDispatcher dispatcher = request.getRequestDispatcher("ManagerForm.jsp");
	        dispatcher.forward(request, response);
	    }
	 
	    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, ServletException, IOException {
	        int id = Integer.parseInt(request.getParameter("id"));
	        Manager existingUser = managerDAO.getUser(id);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("ManagerForm.jsp");
	        request.setAttribute("book", existingUser);
	        dispatcher.forward(request, response);
	 
	    }
	 
	    private void insertUser(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException {
	       /* String title = request.getParameter("title");
	        String author = request.getParameter("author");
	        float price = Float.parseFloat(request.getParameter("price"));
	        */
	    	String name = request.getParameter("name");
	        String email = request.getParameter("email");
	        String country = request.getParameter("country");

	       // int request2 = Integer.parseInt(request.getParameter("request"));
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
	        Manager newUser = new Manager(name, email, country);
	        //User newBook = new User(name, email, country,request2);
	        managerDAO.insertUser(newUser);
	        response.sendRedirect("listManager");
	    }
	 
	    private void updateUser(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException {
	        int id = Integer.parseInt(request.getParameter("id"));
	        String name = request.getParameter("name");
	        String email = request.getParameter("email");
	        String country = request.getParameter("country");
	        int request2=Integer.parseInt(request.getParameter("request"));
	        System.out.println(request2);
	      
	 
	        Manager managerUser = new Manager(id, name, email, country,request2);
	      
	        managerDAO.updateUser(managerUser);
	        response.sendRedirect("listManager");
	    }
	 
	    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException {
	        int id = Integer.parseInt(request.getParameter("id"));
	 
	        Manager managerUser = new Manager(id);
	        managerDAO.deleteUser(managerUser);
	        response.sendRedirect("listManager");
	 
	    }
	}
