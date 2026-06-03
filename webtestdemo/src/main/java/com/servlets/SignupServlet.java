package com.servlets;

import java.io.IOException;

import com.model.User;
import com.service.UserService;
import com.service.UserServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.getRequestDispatcher("Signup.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse resposne)
			throws ServletException, IOException {

		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String un = request.getParameter("username");
		String pass = request.getParameter("password");

		// send data to database
		User u = new User();
		u.setFname(fname);
		u.setLname(lname);
		u.setUsername(un);
		u.setPassword(pass);
		
		UserService service = new UserServiceImpl();
		service.userSignup(u);
		
		// redirect to login page
		request.getRequestDispatcher("LoginForm.jsp").forward(request, resposne);
	}
}
