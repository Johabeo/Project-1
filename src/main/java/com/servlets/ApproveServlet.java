package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DaoFactory;
import com.dao.TicketDao;
import com.dto.Ticket;
import com.util.AppUtils;

public class ApproveServlet extends HttpServlet {

	private static final long serialVersionUID = 5033235940810117413L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ServletException {
    	try {
	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	
	        int ticketId = Integer.parseInt(request.getParameter("ticketId"));
	
	        TicketDao ticketDao = DaoFactory.getTicketDao();
	        Ticket ticket = ticketDao.getTicketById(ticketId);
	        ticketDao.updateTicket("approved", ticket);
	
	        RequestDispatcher rd = request.getRequestDispatcher("view");
	        rd.forward(request, response);
	        out.println("<p>Ticket approved</p>");
    	}
		catch(Exception e) {
			e.printStackTrace();
			response.getWriter().append("Exception Occurred with details : ").append(AppUtils.getStackTrace(e));
		}
    }
}
