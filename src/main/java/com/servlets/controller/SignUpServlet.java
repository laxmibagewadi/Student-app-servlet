package com.servlets.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlets.dao.StudentDao;
import com.servlets.dto.Student;

@WebServlet("/signup")
public class SignUpServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name=req.getParameter("sname");
	long phone=	Long.parseLong(req.getParameter("sphone"));
		String address=req.getParameter("saddress");
		String email=req.getParameter("semail");
		String password=req.getParameter("spassword");
		
	   Student s=new Student();
	   s.setName(name);
	   s.setPhone(phone);
	   s.setAddress(address);
		s.setEmail(email);
		s.setPassword(password);
		
		StudentDao.savestudent(s);
		
		String html="<html><body><h1>Registered successfully</h1></body></html>";
		
		RequestDispatcher rd=req.getRequestDispatcher("login.html");
		rd.forward(req, resp);
		
		
		
	}

}
