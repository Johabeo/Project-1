package com.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.util.AppUtils;

public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 3738347514374152211L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ServletException {
    	try {
	        response.setContentType("text/html");
	
	        HttpSession session = request.getSession(false);
	        session.removeAttribute("id");
	
	        RequestDispatcher rd = request.getRequestDispatcher("/login.html");
	        rd.forward(request, response);
    	}
		catch(Exception e) {
			e.printStackTrace();
			response.getWriter().append("Exception Occured with details : ").append(AppUtils.getStackTrace(e));
		}
    }

}
