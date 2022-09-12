package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DaoFactory;
import com.dao.UserDao;
import com.dto.User;
import com.util.AppUtils;

/**
 * Servlet implementation class Appservlet
 */

public class AppServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setContentType("text/html");
	        PrintWriter out = response.getWriter();

	        String username = request.getParameter("username");
	        String password = request.getParameter("password");

	        UserDao userDao = DaoFactory.getUserDao();
	        User user = userDao.checkUser(username, password);


	        if(user == null) {
	            RequestDispatcher rd = request.getRequestDispatcher("/login.html");
	            rd.include(request, response);
	            out.println("<p>Sorry, invalid username or password </p>");
	        } else {
	            HttpSession session = request.getSession();
	            session.setAttribute("user", user);
	            session.setAttribute("id", user.getId());
	            session.setAttribute("type", user.getUserType());
	            RequestDispatcher rd;
	            if(user.getUserType().equals("employee")) {
	                rd = request.getRequestDispatcher("/employeewelcome.html");
	            } else {
	                rd = request.getRequestDispatcher("/managerwelcome.html");
	            }
	            rd.forward(request, response);
	        }
		}
		catch(Exception e) {
			e.printStackTrace();
			response.getWriter().append("Exception Occured with details : ").append(AppUtils.getStackTrace(e));
		}
		
	}

}
