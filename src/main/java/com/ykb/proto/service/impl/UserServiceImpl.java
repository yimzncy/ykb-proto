package com.ykb.proto.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ykb.proto.dao.impl.UserDaoImpl;
import com.ykb.proto.pojo.User;
import com.ykb.proto.service.UserService;

@Service
public class UserServiceImpl implements UserService {

//	@Autowired
	UserDaoImpl userDaoImpl;

	@Override
	public boolean register(User user) {
		userDaoImpl.insert(user);
		return true;
	}

}
