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

import com.TokenReviewSystem.model.UserloginData;
import com.TokenReviewSystem.services.RepositoryUserServices;

@RestController
@RequestMapping("/TRS")
public class Usercontroller {

	
	
	@Autowired
	RepositoryUserServices services;
	
	@RequestMapping("/getuserdata")
	public ResponseEntity<List<UserloginData>> alldata(){
		return services.getAlluaerdata();
	}

	@PostMapping("/AddUser")
	public ResponseEntity<UserloginData> userlog(@RequestBody UserloginData userlog) {
		
		return services.reguser(userlog);
	}
	
	@GetMapping("/Login/{email}/{password}/{customertype}")
	public ResponseEntity<UserloginData> logindata(@PathVariable("email") String emailID,
			@PathVariable("password") String password,@PathVariable("customertype") String customertype){
	
		return services.login(emailID,password,customertype);
	}
}
