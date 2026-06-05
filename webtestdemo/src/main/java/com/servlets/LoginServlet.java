package com.servlets;

import java.io.IOException;

import com.service.UserService;
import com.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{
	
	// doGet : used only to forward to the LoginForm.jsp page when the link jumps to /LoginServlet address
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws SecurityException, IOException, ServletException {
		request.getRequestDispatcher("LoginForm.jsp").forward(request, response);
	}
	
	// doPost
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resposne) throws ServletException, IOException {
		String un = request.getParameter("username");
		String pass = request.getParameter("password");

		UserService service = new UserServiceImpl();
		
		if(service.userLogin(un, pass)) {
			request.setAttribute("username", un);
			request.setAttribute("password", pass);
			request.getRequestDispatcher("Home.jsp").forward(request, resposne);
		} else {
			request.setAttribute("message", "Username not found!");
			request.getRequestDispatcher("LoginForm.jsp").forward(request, resposne);
		}
	}
}
