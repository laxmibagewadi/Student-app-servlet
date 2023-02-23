package com.servlets.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlets.dao.StudentDao;
import com.servlets.dto.Student;

@WebServlet("/login")
public class LoginServlets extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	String email=req.getParameter("semail");
	String password=req.getParameter("spassword");
	StudentDao sd=new StudentDao();
	Student s=new Student();
	
	if(s!=null){
		
		RequestDispatcher dispatcher=req.getRequestDispatcher("homepage.html");
		
		dispatcher.forward(req, resp);
	}
	else{
		PrintWriter out=resp.getWriter();
		System.out.println("<html><body><h1>invalid Details</body></html>");
		RequestDispatcher dispatcher=req.getRequestDispatcher("login.html");
		
		dispatcher.include(req, resp);
		
	}
	}

}
