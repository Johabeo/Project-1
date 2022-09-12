package com.dao;

import java.sql.Connection;

import com.util.ConnectionManager;

public class DaoFactory {
    private static TicketDao ticketDao;
    private static UserDao userDao;

    private DaoFactory(){}

    public static TicketDao getTicketDao(){
        if(ticketDao == null){
            ticketDao = new TicketDaoImpl();
        }
        return ticketDao;
    }

    public static UserDao getUserDao(){
        if(userDao == null){
            userDao = new UserDaoImpl();
        }
        return userDao;
    }

}
