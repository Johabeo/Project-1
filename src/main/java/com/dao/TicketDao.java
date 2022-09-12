package com.dao;


import java.util.List;

import com.dto.Ticket;

public interface TicketDao {

    public void addTicket(int expense, String reason, int id) throws Exception;

    public void updateTicket(String status, Ticket ticket) throws Exception;

    public List<Ticket> getTickets() throws Exception;
    
    public List<Ticket> getTicketsByEmployeeAndStatus(int id,String status) throws Exception;

    public List<Ticket> getTicketsByEmployee(int id) throws Exception;

    public List<Ticket> getTicketsByStatus(String status) throws Exception;

    public Ticket getTicketById(int id) throws Exception;
}
