package com.superus.usermanagement.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "USER_MASTER")
@NamedQuery(name = "UserMaster.findByuser_Id", query = "SELECT p FROM USER_MASTER p WHERE p.user_Id = ?1")
public class UserMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String user_Id;
	private String name;
	private String email_address;
	private long contact_number;
	private String address;
	private String city;
	private String state;
	public Object getSize() {
		// TODO Auto-generated method stub
		return 1;
	}
}
