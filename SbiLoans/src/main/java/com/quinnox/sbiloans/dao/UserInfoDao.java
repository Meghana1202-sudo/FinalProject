package com.quinnox.sbiloans.dao;

import com.quinnox.sbiloans.dto.UserInfo;

public interface UserInfoDao {
	public boolean registerUser(UserInfo user);

	public UserInfo loginUser(String email, String password);
	
	public boolean changePassword(String email,String password,String newPassword);
	
	public boolean deleteUser(int id);

}



