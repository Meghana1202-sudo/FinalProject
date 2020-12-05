package com.quinnox.sbiloans.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quinnox.sbiloans.dao.UserInfoDao;
import com.quinnox.sbiloans.dto.UserInfo;

@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoDao dao;
	
	
	@Override
	public boolean registerUser(UserInfo user) {
		
		return dao.registerUser(user);
	}

	@Override
	public UserInfo loginUser(String email, String password) {
		
		return dao.loginUser(email, password);
	}

	@Override
	public boolean deleteUser(int id) {
	
		return dao.deleteUser(id);
	}

	@Override
	public boolean changePassword(String email, String password, String newPassword) {
		
		return dao.changePassword(email, password, newPassword);
	}

}

