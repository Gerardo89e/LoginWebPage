package candy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
public class UserDAO {
	private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
     
    public UserDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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
    //Where all the logical query functions are executed and called back to the ManagerServlet

    public boolean insertUser(User book) throws SQLException {
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
        
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }

     
    public List<User> listAllUsers() throws SQLException {
        List<User> listBook = new ArrayList<>();
         
        String sql = "SELECT * FROM users";
        System.out.println("456");

        connect();
         
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            //int id = resultSet.getInt("book_id");
            int id = resultSet.getInt("id");

            System.out.println("123");
          
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            String country = resultSet.getString("country");
            int request = resultSet.getInt("request");
           
            User book = new User(id, name, email, country,request);

            listBook.add(book);
        }
         
        resultSet.close();
        statement.close();
         
        disconnect();
         
        return listBook;
    }
     
    public boolean deleteUser(User book) throws SQLException {
      
        String sql = "DELETE FROM users where id = ?";

        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, book.getId());
         
        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;     
    }
     
    public boolean updateBook(User book) throws SQLException {
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
        
        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;     
    }
     
    public User getUser(int id) throws SQLException {
       
    	User user= null;
      
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
             user = new User(id, name, email, country,request);
        	
        }
         
        resultSet.close();
        statement.close();
         
        return user;
    }
}
