package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dto.Ticket;
import com.util.ConnectionManager;

public class TicketDaoImpl implements TicketDao {
	
    public void addTicket(int expense, String reason,int emplId) throws Exception {
    	Connection conn = null;
    	PreparedStatement pst = null;
    	
    	try {
    		conn = ConnectionManager.getConnection();
	    	String sql = "insert into ticket(employeeId, expense, reason, status) "
					+ "values (?,?,?,?)";
			pst = conn.prepareStatement(sql);
			int count = 1;
			pst.setInt(count++, emplId);
			pst.setInt(count++, expense);
			pst.setString(count++, reason);
			pst.setString(count++, "Pending");
			pst.executeUpdate();
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    		throw e;
    	}
    	finally {
    		if(pst != null && !pst.isClosed()) {
    			pst.close();
    		}
    		if(conn != null && !conn.isClosed()) {
    			conn.close();
    		}
    	}
    }

    public void updateTicket(String status, Ticket ticket) throws Exception{
    	Connection conn = null;
    	PreparedStatement pst = null;
    	
    	try {
    		conn = ConnectionManager.getConnection();
    		String sql = "update ticket set expense = ?, reason = ?, "
    				+ "status = ? where id = ?";
			pst = conn.prepareStatement(sql);
			int count = 1;
			pst.setInt(count++, ticket.getExpense());
			pst.setString(count++, ticket.getReason());
			pst.setString(count++, status);
			pst.setInt(count++, ticket.getId());
			pst.executeUpdate();
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    		throw e;
    	}
    	finally {
    		if(pst != null && !pst.isClosed()) {
    			pst.close();
    		}
    		if(conn != null && !conn.isClosed()) {
    			conn.close();
    		}
    	}
    }

    public List<Ticket> getTickets() throws Exception {
    	List<Ticket> tickets = null;
    	Connection conn = null;
    	PreparedStatement pst = null;
    	try {
    		conn = ConnectionManager.getConnection();
    		String sql = "Select t.*,u.username,u.userType from ticket t\n" + 
    				"Inner Join user u On u.id = t.employeeId";
    		pst = conn.prepareStatement(sql);
    		ResultSet rs = pst.executeQuery();
    		tickets = getTicketFromResultSet(rs);
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    		throw e;
    	}
    	finally {
    		if(pst != null && !pst.isClosed()) {
    			pst.close();
    		}
    		if(conn != null && !conn.isClosed()) {
    			conn.close();
    		}
    	}
		return tickets;
    }
    
    public List<Ticket> getTicketsByEmployeeAndStatus(int emplId,String status) throws Exception {
    	List<Ticket> tickets = null;
    	Connection conn = null;
    	PreparedStatement pst = null;
    	try {
    		conn = ConnectionManager.getConnection();
    		String sql = "Select t.*,u.username,u.userType from ticket t\n" + 
    				"Inner Join user u On u.id = t.employeeId where t.employeeId = ? and LOWER(t.status) = LOWER(?)";
    		pst = conn.prepareStatement(sql);
    		pst.setInt(1, emplId);
    		pst.setString(2, status);
    		ResultSet rs = pst.executeQuery();
    		tickets = getTicketFromResultSet(rs);
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    		throw e;
    	}
    	finally {
    		if(pst != null && !pst.isClosed()) {
    			pst.close();
    		}
    		if(conn != null && !conn.isClosed()) {
    			conn.close();
    		}
    	}
		return tickets;
    }

    public List<Ticket> getTicketsByEmployee(int emplId) throws Exception {
    	List<Ticket> tickets = null;
    	Connection conn = null;
    	PreparedStatement pst = null;
    	try {
    		conn = ConnectionManager.getConnection();
    		String sql = "Select t.*,u.username,u.userType from ticket t\n" + 
    				"Inner Join user u On u.id = t.employeeId where t.employeeId = ?";
    		pst = conn.prepareStatement(sql);
    		pst.setInt(1, emplId);
    		ResultSet rs = pst.executeQuery();
    		tickets = getTicketFromResultSet(rs);
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    		throw e;
    	}
    	finally {
    		if(pst != null && !pst.isClosed()) {
    			pst.close();
    		}
    		if(conn != null && !conn.isClosed()) {
    			conn.close();
    		}
    	}
		return tickets;
    }

    public List<Ticket> getTicketsByStatus(String status) throws Exception {
    	List<Ticket> tickets = null;
    	Connection conn = null;
    	PreparedStatement pst = null;
    	try {
    		conn = ConnectionManager.getConnection();
    		String sql = "Select t.*,u.username,u.userType from ticket t\n" + 
    				"Inner Join user u On u.id = t.employeeId where t.status = ?";
    		pst = conn.prepareStatement(sql);
    		pst.setString(1, status);
    		ResultSet rs = pst.executeQuery();
    		tickets = getTicketFromResultSet(rs);
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    		throw e;
    	}
    	finally {
    		if(pst != null && !pst.isClosed()) {
    			pst.close();
    		}
    		if(conn != null && !conn.isClosed()) {
    			conn.close();
    		}
    	}
		return tickets;
    }

    public Ticket getTicketById(int id) throws Exception {
    	Ticket ticket = null;
    	Connection conn = null;
    	PreparedStatement pst = null;
    	try {
    		conn = ConnectionManager.getConnection();
    		String sql = "Select t.*,u.username,u.userType from ticket t\n" + 
    				"Inner Join user u On u.id = t.employeeId where t.id = ?";
    		pst = conn.prepareStatement(sql);
    		pst.setInt(1, id);
    		ResultSet rs = pst.executeQuery();
    		List<Ticket> tickets = getTicketFromResultSet(rs);
    		if(tickets != null && tickets.size() > 0) {
    			ticket = tickets.get(0);
    		}
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    		throw e;
    	}
    	finally {
    		if(pst != null && !pst.isClosed()) {
    			pst.close();
    		}
    		if(conn != null && !conn.isClosed()) {
    			conn.close();
    		}
    	}
		return ticket;
    }
    
    private List<Ticket> getTicketFromResultSet(ResultSet rs) throws SQLException
    {
    	List<Ticket> tickets = new ArrayList<Ticket>();
    	while (rs.next()) {
    		Ticket t = new Ticket(rs.getInt("id"), rs.getInt("expense"), rs.getInt("employeeId"),rs.getString("username"),rs.getString("userType"),
					rs.getString("status"),rs.getString("reason"));
    		tickets.add(t);
		}
    	return tickets;
    }
}
