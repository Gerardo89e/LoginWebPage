<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Manager Portal</title>
   
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
      <style>
        .body-bg {
            background-color: #9921e8;
            background-image: linear-gradient(315deg, #9921e8 0%, #5f72be 74%);
        }
    </style>
	<script type="text/javascript">
	//key value
	/*document.addEventListener("DOMContentLoaded", function(event) { 
	console.log("data ready");
	const button=document.querySelector(".insertbtn"); 
	button.addEventListener('click', function (event) { 
		console.log(event.target.value);
	    var data = "&listBook=" + JSON.stringify((listBook));
		var data = new FormData();
		const xhr = new XMLHttpRequest();
		const url = 'http://localhost:8081/anotherTest/LoginServlet/post';

		xhr.open('GET', url);
		xhr.onreadystatechange = someHandler;
		xhr.send();
		
		(async () => {
			  const rawResponse = await fetch('http://localhost:8081/anotherTest/LoginServlet/post', {
			    method: 'POST',
			    headers: {
			      'Accept': 'application/json',
			      'Content-Type': 'application/json'
			    },
			    body: JSON.stringify({a: 1, b: 'Textual content'})

			  });
			  const content = await rawResponse.json();

			  console.log(content);
			})();
		
		
		
		﻿fetch("http://localhost:8081/anotherTest/LoginServlet/post",{
			method:"POST",
		    dataType: 'JSON',
			body:  data
		})
		.then(function(response){
			return response.json();
		})
		.then(function(data){
			alert(JSON.stringify(data) )
		})
	});
}); */

	
	
	$(document).ready( function handleButton(){
		console.log("it is ready");
		$('.insertbtn').click( function(){
			console.log(this);	
	        var id = $(this).closest(".tr").find(".id").text();
	        var email = $(this).closest(".tr").find(".email").text();
	        var name = $(this).closest(".tr").find(".name").text();
	        var country = $(this).closest(".tr").find(".country").text();
	        var req = $(this).closest(".tr").find(".req").text();
			console.log(id);
			console.log(name);
			console.log(email);
			console.log(country);
			console.log(req);
			const postValue = {
					"id" : id,
					"name": name,
					"emai": email,
					"country":country,
					"requestId":req
				}
			console.log(postValue);
			handleJson(postValue);
		})
		return false;
    });
    
	function handleJson(postValue){
		//e.preventDefault();
		console.log("login");
		//var id=$(this).attr('#id');
        //var age= $('#age').val();
		console.log("it is a duck");
		/*const postValue = {
			"requestId" : id,
			"name": name
		}*/
		
		console.log(postValue+"its me");
		$.ajax({
			method: "post",
			url: "http://localhost:8081/anotherTest/LoginServlet/post",
			data:  JSON.stringify(postValue),
			dataType: "json",
			success: function(data){
				console.log(data)
			},
			error: function(data){
				console.log(data);
			}
		});
	}
	
	/*
	function updateFunction(anyname){
		///$('.insertbtn').click(function (e) {
			e.preventDefault();
			 console.log("it is a duck");
			const postValue = {
				"requestId" : anyname
			}
			$.ajax({
				method: "post",
				url: "http://localhost:8081/anotherTest/LoginServlet/post",
				data:  JSON.stringify(postValue),
				dataType: "json",
				success: function(data){
					console.log(data)
				},
				error: function(data){
					console.log(data);
				}
		});
			console.log("ajax finish");
	});*/
	</script>
</head>
<body>
    <center>
        <h1>Manager Portal</h1>
        <h2>
            <a href="<%=request.getContextPath()%>/new1">Add New User</a>
            &nbsp;&nbsp;&nbsp;
          <a href="<%=request.getContextPath()%>/listManager">List All User</a>
             
        </h2>
    </center>
    <div align="center">
        <table id="employeeDataTable" border="1" cellpadding="5">
            <caption><h2>List of Users</h2></caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>email</th>
                <th>country</th>
                <th>request</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="book" items="${listBook}">
                <tr class="tr">
             
                     <td class="id"><c:out value="${book.id}" /></td>
                    <td class="name"><c:out value="${book.name}" /></td>
                    <td class="email"><c:out value="${book.email}" /></td>
                    <td class="country"><c:out value="${ book.country}" /></td>
                    <td class="req"><c:out value="${book.request}" /></td>
                    <td>
                        <a href="<%=request.getContextPath()%>/edit2?id=<c:out value='${book.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="<%=request.getContextPath()%>/delete6?id=<c:out value='${book.id}' />">Delete</a> 
                    	<button class="insertbtn" onclick='handleButton()'>Accept</button>
                    	<!--<button class="insertbtn" value="edit">Accept</button>-->       
                    	               
                    	<!-- <button class="insertbtn" value='${book.id}'  >Accept</button>-->              
                    	
                    </td>
                </tr>
            </c:forEach>
        </table>
        <div style="text-align: right"><a href="<%=request.getContextPath()%>/LogoutServlet">Logout</a></div>
        
    </div>   
</body>
</html>