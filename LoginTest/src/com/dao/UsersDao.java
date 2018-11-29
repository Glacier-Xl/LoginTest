package com.dao;

import com.model.Users;

public interface UsersDao {
	//登录
	public Users findByUsername(String username);
}
