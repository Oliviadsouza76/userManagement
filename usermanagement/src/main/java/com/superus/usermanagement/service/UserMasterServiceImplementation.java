package com.superus.usermanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.superus.usermanagement.entities.UserMaster;
import com.superus.usermanagement.repository.UserMasterRepository;


@Service
public class UserMasterServiceImplementation implements UserMasterService {
	
	@Autowired
	UserMasterRepository userMasterRepository;

	@Override
	public UserMaster addUser(UserMaster um) {
		// TODO Auto-generated method stub
		return userMasterRepository.save(um);
	}

	@Override
	public List<UserMaster> getUserId(String user_id) {
		// TODO Auto-generated method stub
		return userMasterRepository.getUserById(user_id);
	}



	public UserMaster getUserDeleteById(String user_id) {
		// TODO Auto-generated method stub
		return userMasterRepository.DeleteUserData(user_id);
	}

	@Override
	public List<UserMaster> getAllUsers() {
		// TODO Auto-generated method stub
		return userMasterRepository.findAll();
	}

	@Override
	public UserMaster updateUserData(UserMaster user_id) {
		// TODO Auto-generated method stub
		return userMasterRepository.save(user_id);
	}

	@Override
	public UserMaster getUserById(String user_id) {
		// TODO Auto-generated method stub
		return userMasterRepository.findByuser_Id(user_id);
	}

	
}

