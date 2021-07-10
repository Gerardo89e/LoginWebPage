<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Books Store Application</title>
</head>
<body>
    <center>
        <h1>Books Management</h1>
        <h2>
            <a href="/new1">Add New Users</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/list3">List All Users</a>
             
        </h2>
    </center>
    <div align="center">
        <c:if test="${book != null}">
            <form action="update4" method="post">
        </c:if>
        <c:if test="${book == null}">
            <form action="insert5" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${book != null}">
                        Edit Book
                    </c:if>
                    <c:if test="${book == null}">
                        Add New Book
                    </c:if>
                </h2>
            </caption>
             <c:if test="${book != null}">
                    <input type="hidden" name="id" value="<c:out value='${book.id}' />" />
                </c:if>           
            <tr>
                <th>Name: </th>
                <td>
                    <input type="text" name="name" size="45"
                            value="<c:out value='${book.name}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>Email: </th>
                <td>
                    <input type="text" name="email" size="45"
                            value="<c:out value='${book.email}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Country: </th>
                <td>
                    <input type="text" name="country" size="5"
                            value="<c:out value='${book.country}' />"
                    />
                </td>
            </tr>
            
            <tr>
              <tr>
                <th>Request: </th>
                <td>
                    <input type="text" name="request" size="5"
                            value="<c:out value='${book.request}' />"
                    />
                </td>
            </tr>
            <tr>
           
                <td colspan="2" align="center">
                    <input type="submit" value="Save" />
                </td>
            </tr>
           
        </table>
        </form>
    </div>   
</body>
</html>