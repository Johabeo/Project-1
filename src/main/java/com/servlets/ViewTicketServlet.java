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
import com.dao.TicketDao;
import com.dto.Ticket;
import com.util.AppUtils;

public class ViewTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	
	        HttpSession session = request.getSession(false);
	        String userType = (String)session.getAttribute("type");
	
	        TicketDao ticketDao = DaoFactory.getTicketDao();
	        List<Ticket> tickets;
	        RequestDispatcher rd;
	        if(userType.equals("employee")) {
	            int id = (Integer) session.getAttribute("id");
	            tickets = ticketDao.getTicketsByEmployee(id);
	            session.setAttribute("tickets", tickets);
	            rd = request.getRequestDispatcher("/employeetable.jsp");
	        } else {
	            tickets = ticketDao.getTickets();
	            session.setAttribute("tickets", tickets);
	            rd = request.getRequestDispatcher("/managertable.jsp");
	        }
	
	        
	        rd.include(request, response);
		}
		catch(Exception e) {
			e.printStackTrace();
			response.getWriter().append("Exception Occured with details : ").append(AppUtils.getStackTrace(e));
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setContentType("text/html");
	        PrintWriter out = response.getWriter();

	        HttpSession session = request.getSession(false);
	        String userType = (String)session.getAttribute("type");
	        String employeeId = request.getParameter("employeeId");
	        String status = request.getParameter("status");

	        TicketDao ticketDao = DaoFactory.getTicketDao();
	        List<Ticket> tickets;
	        RequestDispatcher rd;
	        if(userType.equals("employee")) {
	            int id = (Integer) session.getAttribute("id");
	            tickets = ticketDao.getTicketsByEmployee(id);
	            rd = request.getRequestDispatcher("/employeetable.jsp");
	        }
	        else if(employeeId == null && status == null) {
	            tickets = ticketDao.getTickets();
	            rd = request.getRequestDispatcher("/managertable.jsp");
	        }
	        else if(employeeId != null && employeeId.length() > 0 && status != null && status.length() > 0) {
	            tickets = ticketDao.getTicketsByEmployeeAndStatus(Integer.parseInt(employeeId),status);
	            rd = request.getRequestDispatcher("/managertable.jsp");
	        } 
	        else if(employeeId != null && employeeId.length() > 0) {
	            tickets = ticketDao.getTicketsByEmployee(Integer.parseInt(employeeId));
	            rd = request.getRequestDispatcher("/managertable.jsp");
	        }
	        else {
	        	tickets = ticketDao.getTicketsByStatus(status);
	            rd = request.getRequestDispatcher("/managertable.jsp");
	        }

	        session = request.getSession();
	        session.setAttribute("tickets", tickets);
	        rd.include(request, response);
		}
		catch(Exception e) {
			e.printStackTrace();
			response.getWriter().append("Exception Occurred with details : ").append(AppUtils.getStackTrace(e));
		}
	}

}
