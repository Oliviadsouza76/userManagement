package com.superus.usermanagement.service;

import java.util.List;

import com.superus.usermanagement.entities.UserMaster;

public interface UserMasterService {

	 UserMaster addUser(UserMaster um);//Add User Service
	
	 List<UserMaster> getUserId(String user_id);//Get User List as per User Id
	
	 UserMaster updateUserData(UserMaster user_id);//Update User Details
	
	 UserMaster getUserDeleteById(String user_id);//Delete User By Id
	
	 List<UserMaster> getAllUsers();
	 
	 UserMaster getUserById(String user_id);
}
