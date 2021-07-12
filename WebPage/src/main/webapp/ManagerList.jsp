<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Manager Portal</title>
      <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
         <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
      <style>
        .table {
   margin: auto;
   width: 60%
     
}
    </style>
	<script type="text/javascript">
	//key value
	document.addEventListener("DOMContentLoaded", function(event) { 
	console.log("data ready");
	const button=document.querySelector(".insertbtn"); 
	button.addEventListener('click', function (event) { 
		console.log(event.target.value);
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
		/*
		(async () => {
			  const rawResponse = await fetch('http://localhost:8081/anotherTest/LoginServlet/post', {
			    method: 'POST',
			    headers: {
			      'Accept': 'application/json',
			      'Content-Type': 'application/json'
			    },
			    body: JSON.stringify({postValue})

			  });
			  const content = await rawResponse.json();

			  console.log(content);
			})();
		*/
		
		
		﻿fetch("http://localhost:8081/anotherTest/LoginServlet/post",{
			method:"POST",
			headers: {
			      'Accept': 'application/json',
			      'Content-Type': 'application/json'
			    },
		    dataType: 'JSON',
			body:  JSON.stringify(postValue)
		})
		.then(function(response){
			return response.json();
		})
		.then(function(data){
			alert(JSON.stringify(data) )
		})
	});
}); 
//----------------------------------------------------------------------
	
	/*
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
			async function postData(url = 'http://localhost:8081/anotherTest/LoginServlet/post', data = {postValue}) {
				  // Default options are marked with *
				
			
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
		const postValue = {
			"requestId" : id,
			"name": name
		}
		
		
		
		
		
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
	}*/
	//-----------------------------------------------------------------
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
	<style>
           
	</style>
</head>
<body >
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
        <h1>Manager Portal</h1>
        <h2>
            <a href="<%=request.getContextPath()%>/new1">Add New User</a>
            &nbsp;&nbsp;&nbsp;
          <a href="<%=request.getContextPath()%>/listManager">List All User</a>
             
        </h2>
    </center>
    <div align="center" >
                <caption><h2>List of Users</h2></caption>
    
        <table class="table table-bordered table-striped text-center" border="1" cellpadding="3">
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Name</th>
                <th scope="col">email</th>
                <th scope="col">country</th>
                <th scope="col">request</th>
                <th scope="col">Actions</th>
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
                        &nbsp;
                        <a href="<%=request.getContextPath()%>/delete6?id=<c:out value='${book.id}' />">Delete</a> 
                    	&nbsp;
                    	<button class="insertbtn" onclick='handleButton()'>Accept</button>
                    	 &nbsp;&nbsp;
                    	<button class="insertbtn" onclick='handleButton()'>Deny</button>
                    	
                    	<!--<button class="insertbtn" value="edit">Accept</button>-->       
                    	               
                    	<!-- <button class="insertbtn" value='${book.id}'  >Accept</button>-->              
                    	
                    </td>
                </tr>
            </c:forEach>
        </table>
        
        
    </div>   
</body>
</html>