package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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

public class ShowAllUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	
	        HttpSession session = request.getSession(false);
	        String userType = (String)session.getAttribute("type");
	
	        UserDao userDao = DaoFactory.getUserDao();
	        List<User> users = userDao.getUsers();
	        session.setAttribute("users", users);
	        RequestDispatcher rd = request.getRequestDispatcher("/showAllUsers.jsp");
	        rd.include(request, response);
		}
		catch(Exception e) {
			e.printStackTrace();
			response.getWriter().append("Exception Occured with details : ").append(AppUtils.getStackTrace(e));
		}
	}

}
