# Employee Management System Documentaiton

This project involves developing a console-based application in Java, focusing on Object-Oriented Programming (OOP) principles. The application will serve as an Employee Management System, enabling users to manage employee data for a company.

# Key functionalities
### Add Employee -
This function adds a new Employee to the Database.
### Fire Employee - 
This fires an Employee with the given Id, passed as an argument to the function and saves the date the Employee is fired.
### Edit Employee - 
This function changes the Name, Department, Role and the Salary of the given Employee
### List -
Lists all Employees that are currently Employed
### Search - 
Searches the database with given argument for **name**, **id** or **department** and **what** department would it be. Lists every person, if found
### Exit - 
Saves and Exits the application.

# Class and Interface Specifications
### Class - Employee
The main Class, used to create the Employees and help store their information more easily
### Class - Service
Does most of the work, by reading and writing the needed information in the csv file, used as a database. 
### Class - Manager
Helps the User choose and correctly initiate commands. Also call the needed functions of the Service class
### Class - DatabaseReader
Reads the csv File
### Class - DatabaseWriter
Writes new information in the csv File
### Interface - Read
Contains function read used in DatabaseReader
### Interface - Write
Contains function write used in DatabaseWriter

# Workflow
The course of action is used via ArrayLists, for easier manipulation of the data, through the getters and setters, and easier **I/O** the csv File