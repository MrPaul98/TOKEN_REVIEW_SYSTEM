package com.TokenReviewSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TokenReviewSystem.model.UserData;
import com.TokenReviewSystem.model.UserloginData;
import com.TokenReviewSystem.services.UserServices;

@RestController
@RequestMapping("/TRS")
public class Usercontroller {

	
	
	@Autowired
	UserServices services;
	
	@RequestMapping("/getuserdata")
	public ResponseEntity<List<UserloginData>> alldata(){
		return services.getAlluaerdata();
	}

	@PostMapping("/AddUser")
	public ResponseEntity<UserloginData> userlog(@RequestBody UserloginData userlog) {
		
		return services.signinuser(userlog);
	}
	
	@GetMapping("/Login/{email}/{password}/{customertype}")
	public ResponseEntity<UserloginData> logindata(@PathVariable("email") String emailID,
			@PathVariable("password") String password,@PathVariable("customertype") String customertype){
	
		return services.login(emailID,password,customertype);
	}
	
	@PostMapping("/UpdateUserData/{email}/{fname}/{mname}/{lname}/{city}/{pincode}/{state}/{phonenumber}")
	public ResponseEntity<UserData> Updateuserdata(@PathVariable("email") String emailid,@PathVariable("fname") String firstname,
			@PathVariable("mname") String mname,@PathVariable("lname") String lname,
			@PathVariable("city") String city,@PathVariable("pincode") int pincode,
			@PathVariable("phonenumber") String phonenumber,@PathVariable("state") String state){
		
		return services.Updateuserdata(emailid,firstname,mname,lname,city,pincode,phonenumber,state);
	}
	
	@PostMapping("/forgotpassword/{email}/{prevpassword}/{newpassword}")
	public ResponseEntity updatepassword(@PathVariable("email") String email,
			@PathVariable("prevpassword") String prevpassword,@PathVariable("newpassword") String newpassword){
		return services.forgetpassword(email,prevpassword,newpassword);
	}
	//no need
//	@GetMapping("/getid/{email}")
//	public Optional<UserData> ff(@PathVariable("email") String email){
//		return services.UpdateData(email);
//	}

}
