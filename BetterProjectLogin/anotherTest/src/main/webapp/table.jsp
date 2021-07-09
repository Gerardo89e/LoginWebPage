<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<%
String id = request.getParameter("userId");
String driverName = "oracle.jdbc.driver.OracleDriver";
String connectionUrl = "jdbc:oracle:thin:@emplydb.crymgmzbnitj.us-east-1.rds.amazonaws.com:1521:EMPDB";
String dbName = "book";
String userId = "admin";
String password = "";

try {
Class.forName(driverName);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}

Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<h2 align="center"><font><strong>Retrieve data from database in jsp</strong></font></h2>
<table align="center" cellpadding="5" cellspacing="5" border="1">
<tr>

</tr>
<tr bgcolor="#A52A2A">
<td><b>id</b></td>
<td><b>title</b></td>
<td><b>author</b></td>
<td><b>price</b></td>
</tr>
<%
try{ 
connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
statement=connection.createStatement();
String sql ="SELECT * FROM record";

resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<tr bgcolor="#DEB887">

<td><%=resultSet.getString("boo_id") %></td>
<td><%=resultSet.getString("title") %></td>
<td><%=resultSet.getString("author") %></td>
<td><%=resultSet.getString("price") %></td>

</tr>

<% 
}

} catch (Exception e) {
e.printStackTrace();
}
%>
</table>