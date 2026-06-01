package com.servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse resposne)
			throws ServletException, IOException {
		String un = request.getParameter("username");
		String pass = request.getParameter("password");
		String contact = request.getParameter("contact");
		
		if(un != "" && pass != "") {
			request.setAttribute("uname", un);
			request.setAttribute("pwd", pass);
			request.setAttribute("contact", contact);
			request.getRequestDispatcher("Home.jsp").forward(request, resposne);

		}else {
			request.setAttribute("message", "Username and password must be assigned.");
			request.getRequestDispatcher("Signup.jsp").forward(request, resposne);
		}
	}
}
