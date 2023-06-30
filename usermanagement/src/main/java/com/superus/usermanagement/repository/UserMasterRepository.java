package com.superus.usermanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.superus.usermanagement.entities.UserMaster;

@Repository
public interface UserMasterRepository extends JpaRepository<UserMaster,Integer>{
	
	@Query(name = "UserMaster.findByuser_Id", nativeQuery = true)
	public UserMaster findByuser_Id(String user_Id);

	@Modifying
	@Query(value = "delete from user_master b where b.user_id=:user_id", nativeQuery = true)
	UserMaster DeleteUserData(String user_id);
	
	@Query(value="SELECT user_id,name,city,contact_number,email_address,state FROM user_master where user_id=':user_id'", nativeQuery=true)
	List<UserMaster> getUserById(String user_id);
}
