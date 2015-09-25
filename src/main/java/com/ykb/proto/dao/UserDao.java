package com.ykb.proto.dao;

import java.util.List;

import com.ykb.proto.pojo.User;

public interface UserDao {

	public void insert(User user);
	
	public User findByName(String name);
	
	public List<User> findAll();
	
	public void Update(User user);
	
	public void deleteById(long id);
	
	public void deleteAll();
	
}
