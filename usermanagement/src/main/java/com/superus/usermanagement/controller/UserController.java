package com.superus.usermanagement.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.superus.usermanagement.entities.UserMaster;
import com.superus.usermanagement.service.UserMasterService;
import com.superus.usermanagement.util.Generator;
import com.superus.usermanagement.util.HttpRequest;

/**
 * 
 * @author SuperUs here will be managing the user
 */
@RestController
public class UserController {

	@Autowired
	private Generator generatorClass;

	@Autowired
	private UserMasterService userMasterService;

	// creating an api here to share Role name and ID as per the user
	@RequestMapping("/saveUserData")
	@CrossOrigin(origins = "" + "*", allowedHeaders = "*")
	@Transactional
	public ResponseEntity<?> saveUserData(HttpServletRequest request) throws Exception {
		JSONObject json = HttpRequest.httprequest(request);
		JSONObject usermaster = json.getJSONObject("userMaster");
		System.out.println("Data we are receving for the saving user data >> " + json.toString());
		return ResponseEntity.ok("{\"Success\"}");
	}

	// Method Used to Add User Data
	@PostMapping("/addUser")
	@CrossOrigin(origins = "" + "*", allowedHeaders = "*")
	public ResponseEntity<?> addUserData(HttpServletRequest request) throws Exception {

		try {
			JSONObject json = HttpRequest.httprequest(request);
			String generatedUserId = generatorClass.generateor(json.getString("name"));
			UserMaster userMaster = new UserMaster();
			userMaster.setUser_Id(generatedUserId);
			userMaster.setName(json.getString("name"));
			userMaster.setEmail_address(json.getString("email"));
			userMaster.setContact_number(json.getLong("contact"));
			userMaster.setCity(json.getString("city"));
			userMaster.setState(json.getString("state"));
			userMaster.setAddress(json.getString("address"));
			userMasterService.addUser(userMaster);
			return ResponseEntity.ok("User Details Added Successfully");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
		}

	}

	// To derive User List
	@GetMapping("/getUsersList")
	@CrossOrigin(origins = "" + "*", allowedHeaders = "*")
	public String getUserData(HttpServletRequest request) throws Exception {
		JSONObject json = HttpRequest.httprequest(request);
		JSONArray array = new JSONArray();
		List<UserMaster> cmmaster = userMasterService.getAllUsers();
			
		try {
//			json=new JSONObject();
			for(UserMaster userMaster:cmmaster) {
				System.out.println("Data inside CMASTER>>>>>>>>>"+userMaster);
			json.put("name", userMaster.getName());
			json.put("email", userMaster.getEmail_address());
			json.put("contact", userMaster.getContact_number());
			json.put("city", userMaster.getCity());
			json.put("state", userMaster.getState());
			json.put("address", userMaster.getAddress());
			array.put(json);
			}
		} catch (Exception e) {
			return "Sorry List cannot be derived";
		}
		return array.toString();
	}
	
	// To Derive User List By Id
		@GetMapping("/getUsersList/{user_id}")
		@CrossOrigin(origins = "" + "*", allowedHeaders = "*")
		public String getUserDataByUser_ID(HttpServletRequest request, @PathVariable(value = "user_id") String user_id)
				throws Exception {
			JSONObject json = HttpRequest.httprequest(request);
			List<UserMaster> userMasterData =userMasterService.getUserId(user_id);
			try {
				for(UserMaster userMaster:userMasterData) {
				json.put("name", userMaster.getName());
				json.put("email", userMaster.getEmail_address());
				json.put("contact", userMaster.getContact_number());
				json.put("city", userMaster.getCity());
				json.put("state", userMaster.getState());
				json.put("address", userMaster.getAddress());
				}
			} catch (Exception e) {
				return "Sorry List cannot be derived";
			}
			return json.toString();
		}


		// Method Used to Update User Data
		@PutMapping("/updateUserDetails/{user_id}")
		@CrossOrigin(origins = "" + "*", allowedHeaders = "*")
		public ResponseEntity<?> updateUserDetails(HttpServletRequest request,
				@PathVariable(value = "user_id") String user_id) throws IOException {

			UserMaster userMaster =userMasterService.getUserById(user_id);
			try {
				JSONObject json = HttpRequest.httprequest(request);
				userMaster.setName(json.getString("name"));
				userMaster.setEmail_address(json.getString("email"));
				userMaster.setContact_number(json.getLong("contact"));
				userMaster.setCity(json.getString("city"));
				userMaster.setState(json.getString("state"));
				userMaster.setAddress(json.getString("address"));
				return ResponseEntity.ok(userMasterService.updateUserData(userMaster));
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
			}
			
		}

		// Method to Delete Single User By Id
		@DeleteMapping("/deleteUserById/{user_id}")
		@CrossOrigin(origins = "" + "*", allowedHeaders = "*")
		public ResponseEntity<?> deleteUserById(HttpServletRequest request,
				@PathVariable(value = "user_id") String user_id) {
			try {
				JSONObject json = HttpRequest.httprequest(request);
				return ResponseEntity.ok(userMasterService.getUserDeleteById(user_id));
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
			}
			
		}


}
