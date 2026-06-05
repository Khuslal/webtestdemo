package com.servlets;

import java.io.IOException;

import com.model.User;
import com.service.UserService;
import com.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	// doGet : used only to forward to the LoginForm.jsp page when the link jumps to /SignupServlet address
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.getRequestDispatcher("Signup.jsp").forward(request, response);
	}

	// doPost
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
