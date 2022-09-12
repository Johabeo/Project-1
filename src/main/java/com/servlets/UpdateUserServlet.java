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

public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        
	        HttpSession session = request.getSession(false);
	        int id = (Integer) session.getAttribute("id");
	        
	        String username = request.getParameter("username");
	        String password = request.getParameter("password");
	
	        UserDao userDao = DaoFactory.getUserDao();
	        userDao.updateUser(username, password, id);
	        User user = (User) session.getAttribute("user");
	        user.setUsername(username);
	        user.setPassword(password);
	        session.setAttribute("user", user);
	
	        RequestDispatcher rd = request.getRequestDispatcher("employeewelcome.html");
	        rd.forward(request, response);
	        out.println("<p>Ticket approved</p>");
    	}
		catch(Exception e) {
			e.printStackTrace();
			response.getWriter().append("Exception Occurred with details : ").append(AppUtils.getStackTrace(e));
		}
	}

}
