package manager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class ManagerDAO { 
		private String jdbcURL;
	    private String jdbcUsername;
	    private String jdbcPassword;
	    private Connection jdbcConnection;
	     
	    public ManagerDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
	        this.jdbcURL = jdbcURL;
	        this.jdbcUsername = jdbcUsername;
	        this.jdbcPassword = jdbcPassword;
	    }
	     
	    protected void connect() throws SQLException {
	        if (jdbcConnection == null || jdbcConnection.isClosed()) {
	            try {
	            	Class.forName("oracle.jdbc.driver.OracleDriver");

	            } catch (ClassNotFoundException e) {
	                throw new SQLException(e);
	            }
	            jdbcConnection = DriverManager.getConnection(
	                                        jdbcURL, jdbcUsername, jdbcPassword);
	        }
	    }
	     
	    protected void disconnect() throws SQLException {
	        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
	            jdbcConnection.close();
	        }
	    }
	     
	    public boolean insertUser(Manager book) throws SQLException {
	        //String sql = "INSERT INTO book (title, author, price) VALUES (?, ?, ?)";
	        String sql = "INSERT INTO users (email, name, country) VALUES (?, ?, ?)";

	        connect();
	         
	        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
	        statement.setString(1,book.getEmail());
	        statement.setString(2,book.getName());
	        statement.setString(3,book.getCountry());
	       

	        System.out.println(book.getEmail());
	        System.out.println(book.getName());
	        System.out.println(book.getCountry());
	        
	        /*
	        statement.setString(1, book.getTitle());
	        statement.setString(2, book.getAuthor());
	        statement.setFloat(3, book.getPrice());
	         */
	        boolean rowInserted = statement.executeUpdate() > 0;
	        statement.close();
	        disconnect();
	        return rowInserted;
	    }
	     
	    public List<Manager> listAllUsers() throws SQLException {
	        List<Manager> listBook = new ArrayList<>();
	         
	        String sql = "SELECT * FROM users";
	        System.out.println("456");

	        connect();
	         
	        Statement statement = jdbcConnection.createStatement();
	        ResultSet resultSet = statement.executeQuery(sql);
	         
	        while (resultSet.next()) {
	            //int id = resultSet.getInt("book_id");
	            int id = resultSet.getInt("id");

	            System.out.println("123");
	           /* String title = resultSet.getString("title");
	            String author = resultSet.getString("author");
	            float price = resultSet.getFloat("price");
	            */
	            String name = resultSet.getString("name");
	            String email = resultSet.getString("email");
	            String country = resultSet.getString("country");
	            int request = resultSet.getInt("request");
	           // User book = new User(id, title, author, price);
	            Manager book = new Manager(id, name, email, country,request);

	            listBook.add(book);
	        }
	         
	        resultSet.close();
	        statement.close();
	         
	        disconnect();
	         
	        return listBook;
	    }
	     
	    public boolean deleteUser(Manager book) throws SQLException {
	        //String sql = "DELETE FROM book where book_id = ?";
	        String sql = "DELETE FROM users where id = ?";

	        connect();
	         
	        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
	        statement.setInt(1, book.getId());
	         
	        boolean rowDeleted = statement.executeUpdate() > 0;
	        statement.close();
	        disconnect();
	        return rowDeleted;     
	    }
	     
	    public boolean updateUser(Manager book) throws SQLException {
	        //String sql = "UPDATE book SET title = ?, author = ?, price = ?";
	        //String sql = "UPDATE users SET name = ?, email = ?, country = ?";
	        String sql = "UPDATE users SET name = ?, email = ?, country = ?,request=?";
	        sql += " WHERE id = ?";
	        connect();
	         
	        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
	        statement.setString(1, book.getName());
	        statement.setString(2, book.getEmail());
	        statement.setString(3, book.getCountry());
	        statement.setInt(4, book.getRequest());
	        statement.setInt(5, book.getId());
	         /*
	        statement.setString(1, book.getTitle());
	        statement.setString(2, book.getAuthor());
	        statement.setFloat(3, book.getPrice());
	        statement.setInt(4, book.getId());
	        */
	        boolean rowUpdated = statement.executeUpdate() > 0;
	        statement.close();
	        disconnect();
	        return rowUpdated;     
	    }
	     
	    public Manager getUser(int id) throws SQLException {
	       // User book = null;
	    	Manager user= null;
	        //String sql = "SELECT * FROM book WHERE book_id = ?";
	        String sql = "SELECT * FROM users WHERE id = ?";
	         
	        connect();
	         
	        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
	        statement.setInt(1, id);
	         
	        ResultSet resultSet = statement.executeQuery();
	         
	        if (resultSet.next()) {
	        	 String name = resultSet.getString("name");
	             String email = resultSet.getString("email");
	             String country = resultSet.getString("country");
	             int request = resultSet.getInt("request");
	             user = new Manager(id, name, email, country,request);
	        	/*
	            String title = resultSet.getString("title");
	            String author = resultSet.getString("author");
	            float price = resultSet.getFloat("price");
	            //int request = resultSet.getInt("request");
	            book = new User(id, title, author, price);
	            */
	        }
	         
	        resultSet.close();
	        statement.close();
	         
	        return user;
	    }
	}
