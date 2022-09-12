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
import com.dao.TicketDao;
import com.util.AppUtils;

public class MakeTransactionServlet extends HttpServlet {
	private static final long serialVersionUID = -6780325161898560743L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ServletException {
    	try {
	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        HttpSession session = request.getSession(false);
	        int id = (Integer) session.getAttribute("id");
	
	        int expense = Integer.parseInt(request.getParameter("expense"));
	        String reason = request.getParameter("reason");
	
	        TicketDao ticketDao = DaoFactory.getTicketDao();
	        ticketDao.addTicket(expense, reason, id);
	
	        RequestDispatcher rd = request.getRequestDispatcher("/view");
	        rd.include(request, response);
    	}
		catch(Exception e) {
			e.printStackTrace();
			response.getWriter().append("Exception Occured with details : ").append(AppUtils.getStackTrace(e));
		}
    }
}
