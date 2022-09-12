package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dto.Ticket;
import com.dto.User;
import com.util.ConnectionManager;

public class UserDaoImpl implements UserDao {
	
	public void updateUser(String username,String password,int id) throws Exception{
    	Connection conn = null;
    	PreparedStatement pst = null;
    	
    	try {
    		conn = ConnectionManager.getConnection();
    		String sql = "update user set username = ?, password = ? "
    				+ "where id = ?";
			pst = conn.prepareStatement(sql);
			int count = 1;
			pst.setString(count++, username);
			pst.setString(count++, password);
			pst.setInt(count++, id);
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
	
    public List<User> getUsers() throws Exception {
    	List<User> users = null;
    	Connection conn = null;
    	PreparedStatement pst = null;
    	try {
    		conn = ConnectionManager.getConnection();
    		String sql = "select * from user";
    		pst = conn.prepareStatement(sql);
    		ResultSet rs = pst.executeQuery();
    		users = getUserFromResultSet(rs);
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
		return users;
    }

    public List<User> getUsersByType(String type) throws Exception {
    	List<User> users = null;
    	Connection conn = null;
    	PreparedStatement pst = null;
    	try {
    		conn = ConnectionManager.getConnection();
    		String sql = "select * from user where userType = ?";
    		pst = conn.prepareStatement(sql);
    		pst.setString(1, type);
    		ResultSet rs = pst.executeQuery();
    		users = getUserFromResultSet(rs);
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
		return users;
    }

    public User checkUser(String username, String password) throws Exception {
    	User user = null;
    	Connection conn = null;
    	PreparedStatement pst = null;
    	try {
    		conn = ConnectionManager.getConnection();
    		String sql = "select * from user where username = ? and password = ?";
    		pst = conn.prepareStatement(sql);
    		pst.setString(1, username);
    		pst.setString(2, password);
    		ResultSet rs = pst.executeQuery();
    		List<User> users = getUserFromResultSet(rs);
    		if(users != null && users.size() > 0) {
    			user = users.get(0);
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
        return user;
    }
    
    private List<User> getUserFromResultSet(ResultSet rs) throws SQLException
    {
    	List<User> users = new ArrayList<User>();
    	while (rs.next()) {
			User u = new User(rs.getInt("id"), rs.getString("userType"), rs.getString("username"),
					rs.getString("password"));
			users.add(u);
		}
    	return users;
    }
}
