package com.ykb.proto.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ykb.proto.dao.UserDao;
import com.ykb.proto.pojo.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void insert(User user) {
		String sql = "insert into "
				+ "user(id,name,password,capital,"
				+ "defaultCommission,defaultStampTax,"
				+ "stockPositions) "
				+ "values(?,?,?,?,?,?,?)";
		Object[] args = new Object[]
				{user.getId(), user.getName(), user.getPassword(), user.getCapital(), 
				user.getDefaultCommission(),  user.getDefaultStampTax(), 
				user.getStockPositions()};
		jdbcTemplate.update(sql, args);
	}

	@Override
	public User findByName(String name) {
		String sql = "select * from user where name = ?";
		return jdbcTemplate.queryForObject(sql, User.class);
	}

	@Override
	public List<User> findAll() {
		String sql = "select * from user";
		return jdbcTemplate.queryForList(sql, User.class);
	}

	@Override
	public void Update(User user) {
		// TODO Auto-generated method stub
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
	}

}
