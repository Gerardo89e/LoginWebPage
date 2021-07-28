# Expense Reimbursement System (ERS) - Core

## Project Description

This is a project that creates a login page that sends either Manager or employee to be redirected to their appropriate page. The Manager will be able to see every employee and can update,add,delete, and accept or deny the employee ticket request for reimburstements. The Employee page will only show the employee details and can update their information and send request for reimbursement.

## Technologies Used

* Java - version 8.0
* JSP - version 2.3.1
* JavaScript
* Bootstrap - version 3.0
* OracleSQL - version 3.0
* jstl - version 1.2
* Junit - version 4.11.0
* JDBC - version 21.0.0
* AWS RDS
* TomCat Server -version 9.0.48

## Features

List of features ready and TODOs for future development
* Login has been completed.
* Login determines if its employee or manager.
* crud table is created for the manager to use in the manager.
* a table is created to display and update the employee records in the employee page.
* Logout is succesfully created.
* Button for approve or deny employee reimbursement is created in the manager table.

To-do list:
* intergrate the button with the manager table to retrieve the row into a json and pass the info into a js funciton.
* Create a button to let the employee to send a reimbursement request.

## Getting Started
   
(include git clone command)
*To get started with the project use the command git clone into your cmd window termianl or your git bash terminal.
*then you start the aws rds server
*make sure to include the correct the aws url and password to access the rds database.
*Make sure the ports for aws allow allow traffic incoming and leaving from the database.
*Run TomCat for the project and go to the localhost port it gives you to a web browser
*From there you can include the credentials for either employee or manager.
(include all environment setup steps)

> Be sure to include BOTH Windows and Unix command
*For linux, all you have to do is just call the command git clone to your terminal
*run the AWS RDS servers and allow the ports to allow all incoming and outcoming traffic
*Run TomCat Server by right clicking on the Maven project and run as Tomcat Server.
*Wait for Tomcat to start and once it is finished, a port will be given to the localhost where the server is running
*Copy the url and paste it into a web browser.
*The page will load the login page and give the credentials of either employee or manager.
> Be sure to mention if the commands only work on a specific platform (eg. AWS, GCP)

- All the `code` required to get started
- Images of what it should look like

## Usage
> This project is mostly used to demonstrate how the project can redirect the person to the proper page depending from the user login credentials and allow the users to read data from the database and just update their information and send a reimbursement ticket request.Employee is limited to what they can do with the database because of restriction of having all the records of the employees. The manager has full access of the data of employees and can alter it. The manager can also accept and deny any reimbursement from the employee.
