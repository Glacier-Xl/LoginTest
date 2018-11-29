package com.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.UsersDao;
import com.model.Users;
import com.service.UsersService;
@Service
@Transactional//事务
public class UsersServiceImpl implements UsersService {
	@Resource
	private UsersDao UsersDao;
	
	public void setUsersDao(UsersDao usersDao) {
		UsersDao = usersDao;
	}

	@Override
	public Users loginValidate(String username) {
		// TODO Auto-generated method stub
		
		return this.UsersDao.findByUsername(username);
	}

}
