<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Employee Portal</title>
     <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
     <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <style>
        .table {
   margin: auto;
   width: 60%
     
}
    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" style="text-align: center" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
    <div class="collapse navbar-collapse " id="navbarNavAltMarkup">
      <!-- ml-auto still works just fine-->
      <div class="navbar-nav ms-auto">
        
        <div style="text-align: right">
        <a href="<%=request.getContextPath()%>/LogoutServlet"  class="btn btn-outline-primary"role="button">Logout</a>
        </div>
      </div>
    </div>
  </div>
</nav>
    <center>
      
        <h2>
            <!--<a href="<%=request.getContextPath()%>/new">Add New Book</a>-->
            &nbsp;&nbsp;&nbsp;
            <a href="<%=request.getContextPath()%>/list">List All Books</a>
             
        </h2>
    </center>
    <div align="center">
     <caption><h2>Employee Portal</h2></caption>
        <table class="table table-bordered table-striped text-center" border="1" cellpadding="5">
           
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>email</th>
                <th>country</th>
                <th>request</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="book" items="${listBook}">
                <tr>
             
                     <td><c:out value="${book.id}" /></td>
                    <td><c:out value="${book.name}" /></td>
                    <td><c:out value="${book.email}" /></td>
                    <td><c:out value="${ book.country}" /></td>
                    <td><c:out value="${book.request}" /></td>
                    <td>
                        <a href="<%=request.getContextPath()%>/edit?id=<c:out value='${book.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                       <!-- <a href="<%=request.getContextPath()%>/delete?id=<c:out value='${book.id}' />">Delete</a>--> 
                   
                                          
                    </td>
                </tr>
            </c:forEach>
        </table>
        <!--<div style="text-align: right"><a href="<%=request.getContextPath()%>/LogoutServlet">Logout</a></div>-->
        
    </div>   
</body>
</html>