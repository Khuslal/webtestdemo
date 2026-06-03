package com.servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/HomePage")
public class LoginServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resposne) throws ServletException, IOException {
		String un = request.getParameter("username");
		String pass = request.getParameter("password");
		String contact = request.getParameter("contact");
		
		if(un.equals("hari") && pass.equals("password")) {
			request.setAttribute("uname", un);
			request.setAttribute("pwd", pass);
			request.getRequestDispatcher("Home.jsp").forward(request, resposne);
		} else {
			request.setAttribute("message", "Username not found!");
			request.getRequestDispatcher("LoginForm.jsp").forward(request, resposne);
		}
	}
}
