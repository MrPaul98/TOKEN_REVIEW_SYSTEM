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

import com.TokenReviewSystem.model.LawyerTokenData;
import com.TokenReviewSystem.model.UserData;
import com.TokenReviewSystem.services.LawyerTokenServices;

@RestController
@RequestMapping("/LTRS")
public class LawyerTokenController {

	@Autowired
	LawyerTokenServices lawservices;

	@PostMapping("/AddLawtoken")
	public ResponseEntity<LawyerTokenData> addLawyerToken(@RequestBody LawyerTokenData lawyerTokenData) {
		
		return lawservices.addtoken(lawyerTokenData);
	}
	
	@GetMapping("/getLawtoken")
	public ResponseEntity<List<LawyerTokenData>> Getalltoken(){
		
		return lawservices.getalltoken();
	}
	
	@GetMapping("/getpatientdata/{email}")
	public ResponseEntity<UserData> getpatientdata(@PathVariable("email") String email){
		
		return lawservices.findpatientdata(email);
		
	}
}
