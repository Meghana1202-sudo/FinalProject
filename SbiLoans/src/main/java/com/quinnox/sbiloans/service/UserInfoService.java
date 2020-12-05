package com.quinnox.sbiloans.service;

import com.quinnox.sbiloans.dto.UserInfo;

public interface UserInfoService {
	
	public boolean registerUser(UserInfo user);

	public UserInfo loginUser(String email, String password);

	public boolean changePassword(String email,String password,String newPassword);

	
	public boolean deleteUser(int id);

}

