package com.dao;

import java.util.List;

import com.dto.User;

public interface UserDao {
	
	public void updateUser(String username,String password,int id) throws Exception;
    public List<User> getUsers() throws Exception;

    public List<User> getUsersByType(String type) throws Exception;

    public User checkUser(String username, String password) throws Exception;

}
